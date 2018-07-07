package org.suurd.tridion.discovery.client;

import java.util.List;
import java.util.Map;

public interface DiscoveryServiceClient {

	String getContentServiceEndpoint();

	String getDeployerServiceEndpoint();

	String getPreviewWebServiceEndpoint();

	List<String> getWebApplicationBaseUrls(int publicationId);

	Map<String, String> getWebApplicationExtensionProperties(int publicationId);

}
