# Tridion Content Delivery Client for Java

Java client for the SDL Tridion Content Delivery micro-services.

## Description

The SDL Tridion Content Delivery architecture consists out of a collection of micro-services. This project provides a generic client implementation for several of the micro-services. The implementation can be used as-is or serve as an example how to implement such clients.

Currently clients are provided for the following micro-services:

* Discovery Service - Service to retrieve environment capabilities
* Content Service - Service to retrieve published content

## Dependencies

This project depends on proprietary SDL Tridion libraries that are not publicly available. Use the `Install-LocalDependencies.ps1` script to install these dependencies to the local Maven repository.

	.\Install-LocalDependencies.ps1 -Path <path-to-tridion-jars> 
