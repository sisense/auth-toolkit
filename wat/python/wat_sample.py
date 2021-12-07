import configuration
import json
from authlib.jose import JsonWebEncryption, JsonWebKey

# Fixed part of the token header that needs to be added to all generated tokens to work with Sisense
# No changes is expected here
fixed_header_part = {
    'typ': "JWT",
    'alg': 'RSA-OAEP-256',
    'enc': 'A128GCM',
    'zip': 'DEF'
}

# Web access token is part of the URL.
# Taking into account URL length limitation, it is better to keep payload as short as possible
# That is the optional sample function that removes all unnecessary characters from the payload string
# Feel free to modify it in a way suitable for your implementation
def cleanup_json_string(json_string):
    return json_string.replace(" ", "").replace("\n", "").replace("\r", "")

# Function that shows how Web Access token can be generated
def generate_wat(token_header, token_payload, public_key):
    # Create public key object
    public_key = JsonWebKey.import_key(public_key, {'kty': 'RSA'})

    # Build the token header out of fixed part and the user defined part
    full_header = token_header | fixed_header_part

    # Create cleaned up token payload string from the payload object
    payload: str = cleanup_json_string(json.dumps(token_payload))

    # Build, encrypt and sign the token
    jwe = JsonWebEncryption()
    wat: bytes = jwe.serialize_compact(full_header, payload, public_key)
    return wat.decode("utf-8")


if __name__ == "__main__":
    wat = generate_wat(conf.token_header, conf.token_payload, conf.public_key)
    print("Generated Web access token : " + wat)
