# Sisense WAT Examples - NodeJS

This project demonstrates the process of generating and encoding a Sisense Web Access Token in NodeJS.

Note that the project utilizes hard-coded JSON values for the payload for simplicity, but you will most likely generate these objects dynamically based on the desired access and settings you wish to grant the user.

## Content

| File            | Content                                                   |
|-----------------|-----------------------------------------------------------|
| `package.json`  | Contains NPM dependencies                                 |
| `conf.js`       | Contains static configuration required to run this sample |
| `wat_sample.js` | Contains example of Sisense web access token generation   |

## Dependencies

 - [`node-jose`](https://www.npmjs.com/package/node-jose)

## Instructions

### Prerequisites

 - A running Sisense deployment with the Web Access Token feature enabled (Sisense L2021.10 or higher)
 - A public key created in Sisense Token Configuration (See [Web Access Token Documentation](https://documentation.sisense.com/latest/administration/sisense-security/securing-users/web-access-token.htm))
 - A Node.js development environment with NPM

### Configuration

Edit `configuration.js`:

- Copy `kid` value from the Token configuration screen to the `kid` constant
- Copy `Public key` from the Token configuration screen to the `public_key` constant
- Change the `token_payload` according to your needs, and the IDs of resources on your Sisense environment

### Run

1. Install dependencies with NPM by running `npm i`
1. Execute `npm run wat`
1. Check console output for the token value
1. The resulting token can be used as part of Sisense URL to access the specified dashboard with the settings that were set in the configuration
