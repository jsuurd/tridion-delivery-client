package org.suurd.tridion.discovery.client;

import java.util.List;
import java.util.Map;

/**
 * Interface providing methods to retrieve environment capabilities from the SDL
 * Discovery Service.
 * 
 * @author jsuurd
 */
public interface DiscoveryServiceClient {

	/**
	 * Gets the endpoint of the content service capability.
	 * 
	 * @return the endpoint
	 */
	String getContentServiceEndpoint();

	/**
	 * Gets the endpoint of the deployer service capability.
	 * 
	 * @return the endpoint
	 */
	String getDeployerServiceEndpoint();

	/**
	 * Gets the endpoint of the preview web service.
	 * 
	 * @return the endpoint
	 */
	String getPreviewWebServiceEndpoint();

	/**
	 * Gets the base URL's of a web application with the specified publication ID.
	 *  
	 * @param publicationId the publication ID
	 * @return the base URL's
	 */
	List<String> getWebApplicationBaseUrls(int publicationId);

	/**
	 * Get the extension properties of a web application with the specified publication ID.
	 * 
	 * @param publicationId the publication ID
	 * @return the extension properties
	 */
	Map<String, String> getWebApplicationExtensionProperties(int publicationId);

}
