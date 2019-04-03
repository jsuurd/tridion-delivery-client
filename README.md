# Tridion Content Delivery Client for Java

Java client for the SDL Web/Tridion Content Delivery micro-services.

## Description

The Tridion Content Delivery architecture consists out of a collection of micro-services. This project provides a generic client implementation for several of the micro-services. The implementation can be used as-is or serve as an example how to implement such clients.

Currently clients are provided for the following micro-services:

* Discovery Service - Service to retrieve environment capabilities
* Content Service - Service to retrieve published content

## Dependencies

* SDL Web 8.1.0 

This project depends on proprietary libraries that are not publicly available. Use the install local dependencies script to install these dependencies to the local Maven repository.

Windows:

	.\Install-LocalDependencies.ps1 -Path <path-to-tridion-jars>
	
Linux:
	
	./install_local_dependencies.sh <path_to_tridion_jars> 
