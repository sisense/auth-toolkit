import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;
import org.jose4j.base64url.internal.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

public class WatSample {

    // Web access token is part of the URL.
    // Taking into account URL length limitation, we should keep payload as short as possible
    // That is sample function that removes all unnecessary characters from the payload string
    public static String cleanupJSONString(String jsonString){
        return jsonString.replace(" ","").replace("\\\"","\"").replace("\\n","");
    }

    // Function that shows how Web Access token can be generated
    public static String generateWat(JSONObject tokenHeader, JSONObject tokenPayload, String publicKey) throws Exception {

        // Clean up public key content
        String pemEncodedRSAPublicKey = publicKey
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll(System.lineSeparator(), "")
                .replace("-----END PUBLIC KEY-----", "");

        // Create RSA public key object
        java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        byte[] encodedPublic = Base64.decodeBase64(pemEncodedRSAPublicKey);
        X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(encodedPublic);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpecPublic);

        // Define params that will be used during the token generation
        // They will appear in the JWE token header
        JWEAlgorithm alg = JWEAlgorithm.RSA_OAEP_256;
        EncryptionMethod enc = EncryptionMethod.A128GCM;
        JOSEObjectType typ = JOSEObjectType.JWT;
        CompressionAlgorithm zip = CompressionAlgorithm.DEF;

        // Create token header object
        JWEHeader.Builder jweHeaderBuilder = new JWEHeader.Builder(alg, enc);
        jweHeaderBuilder.type(typ);
        jweHeaderBuilder.compressionAlgorithm(zip);
        jweHeaderBuilder.customParams(tokenHeader.toMap());

        // Create token payload object from the cleaned up payload string
        Payload payload = new Payload(cleanupJSONString(tokenPayload.toString()));

        // Build, encrypt and sign the token
        JWEObject jwe = new JWEObject(jweHeaderBuilder.build(), payload);
        jwe.encrypt(new RSAEncrypter(rsaPublicKey));
        return jwe.serialize();
    }

    public static void main(String[] args) throws Exception {
        String wat = generateWat(Configuration.tokenHeader, Configuration.tokenPayload, Configuration.publicKey);
        System.out.println("Web access token : " + wat);
    }
}
