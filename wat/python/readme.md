# Sisense WAT Examples - Python

This project demonstrates the process of generating and encoding a Sisense Web Access Token in NodeJS.

Note that the project utilizes hard-coded JSON values for the payload for simplicity, but you will most likely generate these objects dynamically based on the desired access and settings you wish to grant the user.

## Content

| File               | Content                                                   |
|--------------------|-----------------------------------------------------------|
| `requirements.txt` | Contains PIP dependencies                                 |
| `conf.py`          | Contains static configuration required to run this sample |
| `wat_sample.py`    | Contains example of Sisense web access token generation   |

## Dependencies

 - [`authlib`](https://pypi.org/project/Authlib/)


## Instructions

### Prerequisites

 - A running Sisense deployment with the Web Access Token feature enabled (Sisense L2021.10 or higher)
 - A public key created in Sisense Token Configuration (See [Web Access Token Documentation](https://documentation.sisense.com/latest/administration/sisense-security/securing-users/web-access-token.htm))
 - A Python 3 development environment with PIP3

### Configuration

Edit `configuration.py`:

- Copy `kid` value from the Token configuration screen to the `token_header` object
- Copy `Public key` from the Token configuration screen to the `public_key` object
- Change static object `token_payload` according to your needs, and the IDs of resources on your Sisense environment

### Run

1. Install dependencies with PIP3 by running `pip3 install -r requirements.txt`
1. Execute `python3 wat_sample.py`
1. Check console output for the token value
1. The resulting token can be used as part of Sisense URL to access the specified dashboard with the settings that were set in the configuration
