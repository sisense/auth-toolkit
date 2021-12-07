# Sisense Web Access Token Examples

In this directory you can find code samples for generating Sisense Web Access Tokens (WAT) in various languages:

 - [NodeJS Examples](./nodejs/)
 - [Python Examples](./python/)
 - [Java Examples](./java/)
 - [C# Examples](./csharp/)

> **Read more about WAT in the [Web Access Token Documentation](https://documentation.sisense.com/latest/administration/sisense-security/securing-users/web-access-token.htm)**

## What is included

In order to dynamically generate a WAT, you will need to:

1. Specify a JSON payload containing the intended permissions and settings
1. Encrypt this payload using a shared secret ("public key") generated in Sisense

Each code sample is presented as a standalone project containing the bare minimum required to generate a valid WAT.

You will find a similar structure in each project that includes:

**1. Readme**

A `readme.md` file with the specific instructions for setting up and running the sample.

**2. Dependencies**

A dependencies file, in the most common package management format for that language, containing the dependencies required to correctly encrypt the payload.

Generally this is an implementation of [JOSE (JSON Object Signing and Encryption)](https://datatracker.ietf.org/wg/jose/about/).

| Language | Package Manager | File               |
|----------|-----------------|--------------------|
| NodeJS   | NPM             | `package.json`     |
| Python   | PIP             | `requirements.txt` |
| Java     | Maven           | `pom.xml`          |
| C#       | Nuget           | the `.csproj` file |

**3. JSON Payload Example**

A separate configuration file containing the public key, the token header, and a _static example_ of an appropriate JSON payload.

You will probably want to generate these dynamically in a real world use-case.

Note that the included sample payloads include a bare minimum set of claims - refer to the [Web Access Token Documentation](https://documentation.sisense.com/latest/administration/sisense-security/securing-users/web-access-token.htm) for more information about the available claims that may be included in a WAT.

| Language | File                     |
|----------|--------------------------|
| NodeJS   | `configuration.js`       |
| Python   | `configuration.py`       |
| Java     | `src/Configuration.java` |
| C#       | `Configuration.cs`       |

**4. Code Example**

The simplest implementation of code that will correctly encrypt the payload and output it to console.

| Language | File                 |
|----------|----------------------|
| NodeJS   | `wat_sample.js`      |
| Python   | `wat_sample.py`      |
| Java     | `src/WatSample.java` |
| C#       | `WatSample.cs`       |
