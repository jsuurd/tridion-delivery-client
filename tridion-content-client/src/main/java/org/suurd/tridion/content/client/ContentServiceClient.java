package org.suurd.tridion.content.client;

import java.time.LocalDateTime;
import java.util.List;

import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.ComponentPresentation;
import org.suurd.tridion.content.client.model.CustomMeta;
import org.suurd.tridion.content.client.model.Keyword;
import org.suurd.tridion.content.client.model.Page;
import org.suurd.tridion.content.client.model.PageContent;

import com.tridion.util.TCMURI;

/**
 * Interface providing methods to retrieve content from the SDL Content Service.
 * 
 * @author jsuurd
 */
public interface ContentServiceClient {

	/**
	 * Gets a binary for the specified binary ID.
	 * 
	 * @param binaryId the binary ID
	 * @return the binary
	 */
	Binary getBinary(TCMURI binaryId);

	/**
	 * Gets a component presentation for the specified component ID and template ID.
	 * 
	 * @param componentId the component ID
	 * @param templateid the template ID
	 * @return the component presentation
	 */
	ComponentPresentation getComponentPresentation(TCMURI componentId, TCMURI templateId);

	/**
	 * Gets a list of custom metas for the specified item ID.
	 * 
	 * @param itemId the item ID
	 * @return list of custom metas
	 */
	List<CustomMeta> getCustomMetas(TCMURI itemId);

	/**
	 * Gets a list of custom metas for the specified publication ID, key name and string value.
	 * 
	 * @param publicationId the publication ID
	 * @param keyName the key name
	 * @param stringValue the string value
	 * @return list of custom metas
	 */
	List<CustomMeta> getCustomMetas(TCMURI publicationId, String keyName, String stringValue);

	/**
	 * Gets a list of custom metas for the specified publication ID, key name and float value.
	 * 
	 * @param publicationId the publication ID
	 * @param keyName the key name
	 * @param stringValue the float value
	 * @return list of custom metas
	 */
	List<CustomMeta> getCustomMetas(TCMURI publicationId, String keyName, float floatValue);

	/**
	 * Gets a list of custom metas for the specified publication ID, key name and date value.
	 * 
	 * @param publicationId the publication ID
	 * @param keyName the key name
	 * @param dateTime the date value
	 * @return list of custom metas
	 */
	List<CustomMeta> getCustomMetas(TCMURI publicationId, String keyName, LocalDateTime dateValue);

	/**
	 * Gets a keyword for the specified keyword ID and taxonomy ID.
	 *
	 * @param keywordId the keyword ID
	 * @param taxonomyId the taxonomy ID
	 * @return the keyword
	 */
	Keyword getKeyword(TCMURI keywordId, TCMURI taxonomyId);

	/**
	 * Gets a list of keywords for the specified taxonomy ID.
	 *
	 * @param keywordId the keyword ID
	 * @param taxonomyId the taxonomy ID
	 * @return the list of keywords
	 */
	List<Keyword> getKeywords(TCMURI taxonomyId);

	/**
	 * Gets a page for the specified page ID.
	 *
	 * @param pageId the page ID
	 * @return the page
	 */
	Page getPage(TCMURI pageId);

	/**
	 * Gets a page content for the specified page ID.
	 *
	 * @param pageId the page ID
	 * @return the page content
	 */
	PageContent getPageContent(TCMURI pageId);

}
