# Sisense WAT Examples - C#

This project demonstrates the process of generating and encoding a Sisense Web Access Token in NodeJS.

Note that the project utilizes hard-coded JSON values for the payload for simplicity, but you will most likely generate these objects dynamically based on the desired access and settings you wish to grant the user.

## Content

| File               | Content                                                   |
|--------------------|-----------------------------------------------------------|
| `Configuration.cs` | Contains static configuration required to run this sample |
| `WatSample.py`     | Contains example of Sisense web access token generation   |

## Dependencies

 - [`BouncyCastle/1.8.9`](https://www.nuget.org/packages/BouncyCastle/)
 - [`jose-jwt/3.2.0`](https://www.nuget.org/packages/jose-jwt/)
 - [`Newtonsoft.Json/13.0.1`](https://www.nuget.org/packages/Newtonsoft.Json/)

## Instructions

### Prerequisites

 - A running Sisense deployment with the Web Access Token feature enabled (Sisense L2021.10 or higher)
 - A public key created in Sisense Token Configuration (See [Web Access Token Documentation](https://documentation.sisense.com/latest/administration/sisense-security/securing-users/web-access-token.htm))
 - A .NET development environment with .NET 5.0 and NuGet

### Configuration

Edit `Configuration.cs`:

- Copy `kid` value from the Token configuration screen to the `TokenHeader` property
- Copy `Public key` from the Token configuration screen to the `PublicKey` property
- Change static member `TokenPayload` according to your needs, and the IDs of resources on your Sisense environment

### Run

1. Install dependencies with NuGet
1. Build and run `WatSample.cs`
1. Check console output for the token value
1. The resulting token can be used as part of Sisense URL to access the specified dashboard with the settings that were set in the configuration
