# Sisense Authentication Toolkit

This repository contains code samples in multiple popular languages for various methods of authentication to Sisense, such as SSO and WAT.

Each topic can be found in its own folder, and within the samples are separated into sub-folders by programming language.  
Within each folder, you will find a `readme.md` file with instructions and information applicable to that specific example.

## Web Access Token

Web Access Tokens (WAT) are a way to grant temporary permissions to Sisense resources without creating a persistent User and access permissions within Sisense.

They are useful for large scale, frequently changing permissions, and anonymous access.

> **Read more about WAT in the [Web Access Token Documentation](https://documentation.sisense.com/latest/administration/sisense-security/securing-users/web-access-token.htm)**

A general overview of how the WAT examples are built can be found in [./wat/readme.md](./wat/readme.md)

Currently available code samples:

- [NodeJS Examples](./wat/nodejs/)
- [Python Examples](./wat/python/)
- [Java Examples](./wat/java/)
- [C# Examples](./wat/csharp/)
