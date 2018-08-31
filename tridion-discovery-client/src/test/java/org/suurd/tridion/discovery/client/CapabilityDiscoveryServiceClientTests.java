package org.suurd.tridion.discovery.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.suurd.tridion.discovery.client.DiscoveryServiceClient;
import org.suurd.tridion.discovery.client.CapabilityDiscoveryServiceClient;

public class CapabilityDiscoveryServiceClientTests {

	private DiscoveryServiceClient discoveryServiceClient;

	@Before
	public void setUp() {
		discoveryServiceClient = new CapabilityDiscoveryServiceClient();
	}

	@Test
	@Ignore("Integration Test")
	public void getContentServiceEndpoint_ShouldReturnEndpoint() {
		String contentServiceEndpoint = discoveryServiceClient.getContentServiceEndpoint();
		
		assertNotNull(contentServiceEndpoint);
	}

	@Test
	@Ignore("Integration Test")
	public void getDeployerServiceEndpoint_ShouldReturnEndpoint() {
		String deployerServiceEndpoint = discoveryServiceClient.getDeployerServiceEndpoint();
		
		assertNotNull(deployerServiceEndpoint);
	}

	@Test
	@Ignore("Integration Test")
	public void getPreviewWebServiceEndpoint_ShouldReturnEndpoint() {
		String previewWebServiceEndpoint = discoveryServiceClient.getPreviewWebServiceEndpoint();
		
		assertNotNull(previewWebServiceEndpoint);
	}

	@Test
	@Ignore("Integration Test")
	public void getWebApplicationBaseUrls_ShouldReturnEmptyBaseUrls() {
		List<String> baseUrls = discoveryServiceClient.getWebApplicationBaseUrls(5);
		
		assertNotNull(baseUrls);
		assertTrue(baseUrls.size() == 0);
	}

}
