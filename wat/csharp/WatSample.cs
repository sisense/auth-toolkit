using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using Jose;
using Newtonsoft.Json;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Security;

namespace sisense_wat_generator
{
    class WatSample
    {
        private static readonly Dictionary <string, object> FixedHeaderPart = new Dictionary<string, object>()
        {
            {"typ", "JWT" },
        };

        // Web access token is part of the URL.
        // Taking into account URL length limitation, we should keep payload as short as possible
        // That is sample function that removes all unnecessary characters from the payload string
        private static string CleanupJsonString(string jsonString)
        {
            return jsonString.Replace(" ", "").Replace("\\r", "").Replace("\\n", "");
        }
        
        // Function that shows how Web Access token can be generated
        private static string GenerateWat(IDictionary<string, object> tokenHeader, Object tokenPayload, string publicKey)
        {
            // Create RSA public key object
            var pr = new PemReader(new StringReader(publicKey));
            var rsaPublicKey = (AsymmetricKeyParameter)pr.ReadObject();
            var rsaParams = DotNetUtilities.ToRSAParameters((RsaKeyParameters)rsaPublicKey);
            var key = RSA.Create(rsaParams);
            
            // Build the token header out of fixed part and the user defined part 
            var fullHeader = FixedHeaderPart.Union(tokenHeader).ToDictionary(s => s.Key, s => s.Value);
            
            // Create the textual representation of the payload
            var payload = CleanupJsonString(JsonConvert.SerializeObject(tokenPayload, Formatting.None));
            
            // Build, encrypt and sign the token
            var token = JWT.Encode(payload, key, JweAlgorithm.RSA_OAEP_256, JweEncryption.A128GCM, JweCompression.DEF, fullHeader);
            return token;
        }
        
        private static void Main(string[] args)
        {
            var wat = GenerateWat(Configuration.TokenHeader, Configuration.TokenPayload, Configuration.PublicKey);
            Console.WriteLine("Web access token : " + wat);
        }
    }
}
