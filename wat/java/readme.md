# Sisense WAT Examples - Java

This project demonstrates the process of generating and encoding a Sisense Web Access Token in NodeJS.

Note that the project utilizes hard-coded JSON values for the payload for simplicity, but you will most likely generate these objects dynamically based on the desired access and settings you wish to grant the user.

## Content

| File                 | Content                                                   |
|----------------------|-----------------------------------------------------------|
| `pom.xml`            | Contains Maven dependencies                               |
| `Configuration.java` | Contains static configuration required to run this sample |
| `WatSample.java`     | Contains example of Sisense web access token generation   |
 
## Dependencies

- [`nimbus-jose-jwt`](https://mvnrepository.com/artifact/com.nimbusds/nimbus-jose-jwt)
- [`jose4j`](https://mvnrepository.com/artifact/org.bitbucket.b_c/jose4j)
- [`json`](https://mvnrepository.com/artifact/org.json/json)
- [`bcpkix-jdk15on`](https://mvnrepository.com/artifact/org.bouncycastle/bcpkix-jdk15on)

## Instructions

### Prerequisites

 - A running Sisense deployment with the Web Access Token feature enabled (Sisense L2021.10 or higher)
 - A public key created in Sisense Token Configuration (See [Web Access Token Documentation](https://documentation.sisense.com/latest/administration/sisense-security/securing-users/web-access-token.htm))
 - A Java development environment with Java 1.8+ and Maven 

### Configuration

Edit `Configuration.java`:

- Copy `kid` value from the Token configuration screen to the `tokenHeader` object
- Copy `Public key` from the Token configuration screen to the `publicKey` object
- Change static object `tokenPayload` according to your needs, and the IDs of resources on your Sisense environment

### Run

1. Install dependencies with Maven by running `mvn install`
1. Build and run `WatSample.java`
1. Check console output for the token value
1. The resulting token can be used as part of Sisense URL to access the specified dashboard with the settings that were set in the configuration
