package org.suurd.tridion.discovery.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.delivery.configuration.Configuration;
import com.sdl.delivery.configuration.ConfigurationException;
import com.sdl.delivery.configuration.ConfigurationProvider;
import com.sdl.delivery.configuration.Value;
import com.sdl.web.discovery.delivery.configuration.CachingConfigurationProvider;
import com.sdl.web.discovery.delivery.configuration.ODataConfigurationProvider;
import com.sdl.web.discovery.delivery.configuration.ODataResourceDescriptor;

public class ConfigurationDiscoveryServiceClient implements DiscoveryServiceClient {

	private static final Logger LOG = LoggerFactory.getLogger(ConfigurationDiscoveryServiceClient.class);

	private static final String STORAGE_CONFIG_FILE_NAME = "cd_storage_conf.xml";

	private static final String CONTENT_SERVICE_RESOURCE_NAME = "ContentService";

	private static final String DEPLOYER_SERVICE_RESOURCE_NAME = "Deployer";

	private static final String PREVIEW_WEB_SERVICE_RESOURCE_NAME = "PreviewWebService";

	private static final String WEB_RESOURCE_NAME = "Web";

	private ConfigurationProvider<ODataResourceDescriptor> configurationProvider;

	@SuppressWarnings("unchecked")
	public ConfigurationDiscoveryServiceClient() {
		super();
		this.configurationProvider = new CachingConfigurationProvider(new ODataConfigurationProvider());
	}

	public String getContentServiceEndpoint() {
		String contentServiceEndpoint = null;
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieving Content Service endpoint");
		}
		
		try {
			Configuration contentServiceConfiguration = getConfiguration(CONTENT_SERVICE_RESOURCE_NAME);
			Value uri = contentServiceConfiguration.getValue("URI");
			if (!uri.isNull()) {
				contentServiceEndpoint = uri.asString();
			}
			
		} catch (ConfigurationException e) {
			String message = "Error processing configuration resource";
			LOG.error(message, e);
			throw new DiscoveryServiceClientException(message, e);
		}
		
		if (contentServiceEndpoint == null) {
			LOG.warn("Content Service endpoint not found");
		} else if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved Content Service endpoint [uri={}]", contentServiceEndpoint);
		}
		
		return contentServiceEndpoint;
	}

	public String getDeployerServiceEndpoint() {
		String deployerServiceEndpoint = null;
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieving Deployer Service endpoint");
		}
		
		try {
			Configuration deployerServiceConfiguration = getConfiguration(DEPLOYER_SERVICE_RESOURCE_NAME);
			Value uri = deployerServiceConfiguration.getValue("URI");
			if (!uri.isNull()) {
				deployerServiceEndpoint = uri.asString();
			}
			
		} catch (ConfigurationException e) {
			String message = "Error processing configuration resource";
			LOG.error(message, e);
			throw new DiscoveryServiceClientException(message, e);
		}
		
		if (deployerServiceEndpoint == null) {
			LOG.warn("Deployer endpoint not found");
		} else if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved Deployer Service endpoint [uri={}]", deployerServiceEndpoint);
		}
		
		return deployerServiceEndpoint;
	}

	public String getPreviewWebServiceEndpoint() {
		String previewWebServiceEndpoint = null;
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieving Preview Web Service endpoint");
		}
		
		try {
			Configuration previewWebServiceConfiguration = getConfiguration(PREVIEW_WEB_SERVICE_RESOURCE_NAME);
			Value uri = previewWebServiceConfiguration.getValue("URI");
			if (!uri.isNull()) {
				previewWebServiceEndpoint = uri.asString();
			}
			
		} catch (ConfigurationException e) {
			String message = "Error processing configuration resource";
			LOG.error(message, e);
			throw new DiscoveryServiceClientException(message, e);
		}
		
		if (previewWebServiceEndpoint == null) {
			LOG.warn("Deployer endpoint not found");
		} else if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved Preview Web Service endpoint [uri={}]", previewWebServiceEndpoint);
		}
		
		return previewWebServiceEndpoint;
	}

	public List<String> getWebApplicationBaseUrls(int publicationId) {
		List<String> baseUrls = new ArrayList<String>();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(MessageFormat.format("Retrieving Web Application [publicationId={0}] base URLs", publicationId));
		}
		
		try {
			Configuration defaultWebConfiguration = getConfiguration(WEB_RESOURCE_NAME);
			for (Configuration webApplicationConfiguration : defaultWebConfiguration.getConfigurations()) {
				Configuration publicationMappingConfiguration = webApplicationConfiguration.getConfiguration("PublicationMappings");
				if (publicationMappingConfiguration != null) {
					Map<String, Value> publicationMappingValues = publicationMappingConfiguration.getValues();
					Value id = publicationMappingValues.get("id");
					if (!id.isNull() && id.asBigInteger().intValue() == publicationId) {
						for (Configuration configuration : webApplicationConfiguration.getConfigurations()) {
							if ("BaseURLs".equals(configuration.getName())) {
								Map<String, Value> baseUrlsValues = configuration.getValues();
								Value protocol = baseUrlsValues.get("Protocol");
								Value host = baseUrlsValues.get("Host");
								Value port = baseUrlsValues.get("Port");
								if (!protocol.isNull() && !host.isNull() && !port.isNull()) {
									URI uri = new URI(protocol.asString(), null, host.asString(), port.asBigInteger().intValue(), null, null, null);
									baseUrls.add(uri.toString());
								}
							}
						}
					}
				}
			}
			
		} catch (ConfigurationException e) {
			String message = "Error processing configuration resource";
			LOG.error(message, e);
			throw new DiscoveryServiceClientException(message, e);
		} catch (URISyntaxException e) {
			String message = "Error creating base URL";
			LOG.error(message, e);
			throw new DiscoveryServiceClientException(message, e);
		}
		
		if (LOG.isDebugEnabled()) {
			StringBuilder logMessage = new StringBuilder();
			logMessage.append("Retrieved Web Application [publicationId=");
			logMessage.append(publicationId);
			logMessage.append("] base URLs [baseUrls=");
			boolean multipleBaseUrls = false;
			for (String baseUrl : baseUrls) {
				if (multipleBaseUrls) {
					logMessage.append(", ");
				}
				logMessage.append(baseUrl);
				multipleBaseUrls = true;
			}
			logMessage.append("]");
			LOG.debug(logMessage.toString());
		}
		
		return baseUrls;
	}

	public Map<String, String> getWebApplicationExtensionProperties(int publicationId) {
		Map<String, String> extensionProperties = new HashMap<String, String>();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieving Web Application [publicationId={}] extension properties", publicationId);
		}
		
		try {
			Configuration defaultWebConfiguration = getConfiguration(WEB_RESOURCE_NAME);
			for (Configuration webApplicationConfiguration : defaultWebConfiguration.getConfigurations()) {
				Configuration publicationMappingConfiguration = webApplicationConfiguration.getConfiguration("PublicationMappings");
				if (publicationMappingConfiguration != null) {
					Map<String, Value> publicationMappingValues = publicationMappingConfiguration.getValues();
					Value id = publicationMappingValues.get("id");
					if (!id.isNull() && id.asBigInteger().intValue() == publicationId) {
						for (Configuration configuration : webApplicationConfiguration.getConfigurations()) {
							if ("ExtensionProperties".equals(configuration.getName())) {
								Map<String, Value> ExtensionPropertiesValues = configuration.getValues();
								Value key = ExtensionPropertiesValues.get("Key");
								Value value = ExtensionPropertiesValues.get("Value");
								if (!key.isNull() && !value.isNull()) {
									extensionProperties.put(key.asString(), value.asString());
								}
							}
						}
					}
				}
			}
			
		} catch (ConfigurationException e) {
			String message = "Error processing configuration resource";
			LOG.error(message, e);
			throw new DiscoveryServiceClientException(message, e);
		}
		
		if (LOG.isDebugEnabled()) {
			StringBuilder logMessage = new StringBuilder();
			logMessage.append("Retrieved web application [publicationId=");
			logMessage.append(publicationId);
			logMessage.append("] extension properties [");
			boolean multipleValues = false;
			Iterator<Entry<String, String>> it = extensionProperties.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> entry = (Entry<String, String>)it.next();
				if (multipleValues) {
					logMessage.append(", ");
				}
				logMessage.append("[key=");
				logMessage.append(entry.getKey());
				logMessage.append(", value=");
				logMessage.append(entry.getValue());
				logMessage.append("]");
				multipleValues = true;
			}
			logMessage.append("]");
			LOG.debug(logMessage.toString());
		}
		
		return extensionProperties;
	}

	protected Configuration getConfiguration(String resourceName) throws ConfigurationException {
		ODataResourceDescriptor oDataResourceDescriptor = new ODataResourceDescriptor(STORAGE_CONFIG_FILE_NAME, resourceName);
		return configurationProvider.provide(oDataResourceDescriptor).getConfiguration();
	}

}
