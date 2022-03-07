const jose = require('node-jose');
const conf = require('./configuration');

/**
 * Generate token by the specified conf.
 * @returns Promise<string>
 */
async function getToken() {
    // Creating keystore to store Public Key info (node-jose specific API).
    const keystore = jose.JWK.createKeyStore();

    // Adding existing Public Key to keystore object (node-jose specific API).
    const key = await keystore.add(conf.public_key, 'pem', {
        kid: conf.kid,
    });

    // Building token based on conf claims set and other configs.
    const token = await jose.JWE.createEncrypt({
        format: 'compact',
        contentAlg: 'A128GCM',
        zip: true,
        fields: {
            alg: 'RSA-OAEP-256',
            typ: 'JWT'
        },
    }, key)
    .update(JSON.stringify(conf.token_payload))
    .final();

    // Resolving promise.
    return token;
}

// Running getToken and consoling the result.
getToken().then((token) => {console.log(token)});
