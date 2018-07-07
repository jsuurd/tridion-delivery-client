package org.suurd.tridion.discovery.client;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ConfigurationDiscoveryServiceClientTests {

	private DiscoveryServiceClient discoveryServiceClient;

	@Before
	public void setUp() {
		discoveryServiceClient = new ConfigurationDiscoveryServiceClient();
	};

	@Test
	public void getContentServiceEndpoint_ShouldReturnEndpoint() {
		String contentServiceEndpoint = discoveryServiceClient.getContentServiceEndpoint();
		
		assertNotNull(contentServiceEndpoint);
	}

	@Test
	public void getDeployerServiceEndpoint_ShouldReturnEndpoint() {
		String deployerServiceEndpoint = discoveryServiceClient.getDeployerServiceEndpoint();
		
		assertNotNull(deployerServiceEndpoint);
	}

	@Test
	public void getPreviewWebServiceEndpoint_ShouldReturnEndpoint() {
		String previewWebServiceEndpoint = discoveryServiceClient.getPreviewWebServiceEndpoint();
		
		assertNotNull(previewWebServiceEndpoint);
	}

	@Test
	@Ignore("Integration Test")
	public void getWebApplicationBaseUrls_WithValidPublicationId_ShouldReturnBaseUrls() {
		List<String> baseUrls = discoveryServiceClient.getWebApplicationBaseUrls(33);
		
		assertTrue(baseUrls.size() > 0);
	}

	@Test
	@Ignore("Integration Test")
	public void getWebApplicationExtensionProperties_WithExtensionProperties_ShouldReturnExtensionPropertiesMap() {
		Map<String, String> extensionProperties = discoveryServiceClient.getWebApplicationExtensionProperties(109);
		
		assertTrue(extensionProperties.size() > 0);
	}

	@Test
	@Ignore("Integration Test")
	public void getWebApplicationExtensionProperties_WithoutExtensionProperties_ShouldReturnsEmptyExtensionPropertiesMap() {
		Map<String, String> extensionProperties = discoveryServiceClient.getWebApplicationExtensionProperties(33);
		
		assertTrue(extensionProperties.size() == 0);
	}
}
