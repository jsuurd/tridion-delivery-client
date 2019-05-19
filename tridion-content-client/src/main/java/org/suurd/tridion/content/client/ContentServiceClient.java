package org.suurd.tridion.content.client;

import java.time.LocalDateTime;
import java.util.List;
import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.BinaryContent;
import org.suurd.tridion.content.client.model.Component;
import org.suurd.tridion.content.client.model.ComponentPresentation;
import org.suurd.tridion.content.client.model.CustomMeta;
import org.suurd.tridion.content.client.model.Keyword;
import org.suurd.tridion.content.client.model.Page;
import org.suurd.tridion.content.client.model.PageContent;

/**
 * Interface providing methods to retrieve content from the SDL Content Service.
 * 
 * @author jsuurd
 */
public interface ContentServiceClient {

	/**
	  Gets a binary for the specified publication ID and binary ID.
	 * 
	 * @param publicationId the publication ID
	 * @param binaryId the binary ID
	 * @return the binary
	 */
	Binary getBinary(int publicationId, int binaryId);
	
	/**
	 * Gets a binary content for the specified publication ID, binary ID and variant ID.
	 * 
	 * @param publicationId the publication ID
	 * @param binaryId the binary ID
	 * @param variantId the variant ID
	 * @return the binary content
	 */
	BinaryContent getBinaryContent(int publicationId, int binaryId, String variantId);

	/**
	 * Gets a component for the specified publication ID and component ID.
	 * 
	 * @param publicationId the publication ID
	 * @param componentId the component ID
	 * @return the component
	 */
	Component getComponent(int publicationId, int componentId);

	/**
	 * Gets a component presentation for the specified publication ID, component ID and template ID.
	 * 
	 * @param publicationId the publication ID
	 * @param componentId the component ID
	 * @param templateId the template ID
	 * @return the component presentation
	 */
	ComponentPresentation getComponentPresentation(int publicationId, int componentId, int templateId);

	/**
	 * Gets a list of custom metas for the specified publication ID and item ID.
	 * 
	 * @param publicationId the publication ID
	 * @param itemId the item ID
	 * @return list of custom metas
	 */
	List<CustomMeta> getCustomMetas(int publicationId, int itemId);

	/**
	 * Gets a list of custom metas for the specified publication ID, key name and string value.
	 * 
	 * @param publicationId the publication ID
	 * @param keyName the key name
	 * @param stringValue the string value
	 * @return list of custom metas
	 */
	List<CustomMeta> getCustomMetas(int publicationId, String keyName, String stringValue);

	/**
	 * Gets a list of custom metas for the specified publication ID, key name and float value.
	 * 
	 * @param publicationId the publication ID
	 * @param keyName the key name
	 * @param floatValue the float value
	 * @return list of custom metas
	 */
	List<CustomMeta> getCustomMetas(int publicationId, String keyName, float floatValue);

	/**
	 * Gets a list of custom metas for the specified publication ID, key name and date value.
	 * 
	 * @param publicationId the publication ID
	 * @param keyName the key name
	 * @param dateValue the date value
	 * @return list of custom metas
	 */
	List<CustomMeta> getCustomMetas(int publicationId, String keyName, LocalDateTime dateValue);

	/**
	 * Gets a keyword for the specified publication ID, taxonomy ID and keyword ID.
	 * 
	 * @param publicationId the publication ID
	 * @param taxonomyId the taxonomy ID
	 * @param keywordId the keyword ID
	 * @return the keyword
	 */
	Keyword getKeyword(int publicationId, int taxonomyId, int keywordId);

	/**
	 * Gets a list of keywords for the specified publication ID and taxonomy ID.
	 *
	 * @param publicationId the publication ID
	 * @param taxonomyId the taxonomy ID
	 * @return the list of keywords
	 */
	List<Keyword> getKeywords(int publicationId, int taxonomyId);

	/**
	 * Gets a page for the specified publication ID and page ID.
	 *
	 * @param publicationId the publication ID
	 * @param pageId the page ID
	 * @return the page
	 */
	Page getPage(int publicationId, int pageId);

	/**
	 * Gets a page content for the specified publication ID and page ID.
	 *
	 * @param publicationId the publication ID
	 * @param pageId the page ID
	 * @return the page content
	 */
	PageContent getPageContent(int publicationId, int pageId);

}
