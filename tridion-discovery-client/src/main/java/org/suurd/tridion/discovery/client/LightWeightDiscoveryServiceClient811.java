package org.suurd.tridion.discovery.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.web.client.CapabilityProvider;
import com.sdl.web.client.configuration.XMLConfigurationHolder;
import com.sdl.web.client.configuration.XMLConfigurationReaderImpl;
import com.sdl.web.client.configuration.api.ConfigurationException;
import com.sdl.web.client.configuration.api.ConfigurationHolder;
import com.sdl.web.client.configuration.api.XMLConfigurationReader;
import com.sdl.web.client.impl.CapabilityProviderFactory;
import com.sdl.web.discovery.datalayer.model.BaseURL;
import com.sdl.web.discovery.datalayer.model.ContentServiceCapability;
import com.sdl.web.discovery.datalayer.model.DeployerCapability;
import com.sdl.web.discovery.datalayer.model.PreviewWebServiceCapability;
import com.sdl.web.discovery.datalayer.model.PublicationMapping;
import com.sdl.web.discovery.datalayer.model.WebApplication;
import com.sdl.web.discovery.datalayer.model.WebCapability;

public class LightWeightDiscoveryServiceClient811 implements DiscoveryServiceClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(LightWeightDiscoveryServiceClient811.class);
	
	private CapabilityProvider capabilityProvider;
	
	public LightWeightDiscoveryServiceClient811()	{
		super();
		initialize();
	}
	
	public void initialize() {
		try {
			XMLConfigurationReader<XMLConfigurationHolder> configurationReader = new XMLConfigurationReaderImpl();
			ConfigurationHolder configurationHolder = configurationReader.readConfiguration("cd_client_conf.xml");

			/* SDL Web 8.1.1 implementation
			Map<String, String> configValues = configurationHolder.getValues();
			configValues.putAll(configurationHolder.getConfiguration("DiscoveryService").getValues());
			configValues.putAll(configurationHolder.getConfiguration("TokenService").getValues());

			CacheSecurityAwareClientPropertiesBuilder builder = new CacheSecurityAwareClientPropertiesBuilder(configValues);
			*/

			Properties configValues = new Properties();
			configValues.putAll(configurationHolder.getValues());
			configValues.putAll(configurationHolder.getConfiguration("DiscoveryService").getValues());
			configValues.putAll(configurationHolder.getConfiguration("TokenService").getValues());

			capabilityProvider = CapabilityProviderFactory.getCachingSecuredCapabilityProvider(configValues);

		} catch (ConfigurationException e) {
			LOG.error(e.getMessage(), e);
			//TODO: Throw Exception
		}
	}

	public String getContentServiceEndpoint() {
		String contentServiceEndpoint = null;

		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieving Content Service endpoint");
		}

		Optional<ContentServiceCapability> capability = capabilityProvider.getCapability(ContentServiceCapability.class);
		if (capability.isPresent()) {
			contentServiceEndpoint = capability.get().getUri();
		}

		if (contentServiceEndpoint == null) {
			LOG.warn("Content Service endpoint not found");
		} else if (LOG.isDebugEnabled()) {
			LOG.debug(MessageFormat.format("Retrieved Content Service endpoint [uri={0}]", contentServiceEndpoint));
		}

		return contentServiceEndpoint;
	}
	
	public String getDeployerServiceEndpoint() {
		String deployerServiceEndpoint = null;

		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieving Deployer Service endpoint");
		}

		Optional<DeployerCapability> capability = capabilityProvider.getCapability(DeployerCapability.class);
		if (capability.isPresent()) {
			deployerServiceEndpoint = capability.get().getUri();
		}

		if (deployerServiceEndpoint == null) {
			LOG.warn("Deployer endpoint not found");
		} else if (LOG.isDebugEnabled()) {
			LOG.debug(MessageFormat.format("Retrieved Deployer Service endpoint [uri={0}]", deployerServiceEndpoint));
		}

		return deployerServiceEndpoint;
	}

	public String getPreviewWebServiceEndpoint() {
		String previewWebServiceEndpoint = null;

		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieving Preview Web Service endpoint");
		}

		Optional<PreviewWebServiceCapability> capability = capabilityProvider.getCapability(PreviewWebServiceCapability.class);
		if (capability.isPresent()) {
			previewWebServiceEndpoint = capability.get().getUri();
		}

		if (previewWebServiceEndpoint == null) {
			LOG.warn("Content Service endpoint not found");
		} else if (LOG.isDebugEnabled()) {
			LOG.debug(MessageFormat.format("Retrieved Preview Web Service endpoint [uri={0}]", previewWebServiceEndpoint));
		}

		return previewWebServiceEndpoint;
	}

	public List<String> getWebApplicationBaseUrls(int publicationId) {
		List<String> baseUrls = new ArrayList<String>();

		if (LOG.isDebugEnabled()) {
			LOG.debug(MessageFormat.format("Retrieving Web Application [publicationId={0}] base URL's", publicationId));
		}

		try {
			Optional<WebCapability> capability = capabilityProvider.getCapability(WebCapability.class);
			if (capability.isPresent()) {
				WebCapability webCapability = capability.get();
				for (WebApplication webApplication : webCapability.getWebApplications()) {
					for (PublicationMapping publicationMapping : webApplication.getPublicationMappings()) {
						if (Integer.parseInt(publicationMapping.getId()) == publicationId) {
							for(BaseURL baseURL : webApplication.getBaseURLs()) {
								URI uri = new URI(baseURL.getProtocol(), null, baseURL.getHost(), baseURL.getPort(), null, null, null);
								baseUrls.add(uri.toString());
							}
						}
					}
				}
			}
		} catch (URISyntaxException e) {
			LOG.error(e.getMessage(), e);
			//TODO: Throw Exception
		}

		return baseUrls;
	}

	public Map<String, String> getWebApplicationExtensionProperties(int publicationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
