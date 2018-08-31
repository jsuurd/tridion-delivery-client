package org.suurd.tridion.content.client;

import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.Page;

import com.tridion.util.TCMURI;

/**
 * Interface providing methods to retrieve content from the SDL Content Service.
 * 
 * @author jsuurd
 */
public interface ContentServiceClient {

	/**
	 * Gets a binary object for the specified binary ID.
	 * 
	 * @param binaryId the binary ID
	 * @return the binary
	 */
	Binary getBinary(TCMURI binaryId);

	/**
	 * Gets a page object for the specified page ID.
	 *
	 * @param pageId the page ID
	 * @return the page
	 */
	Page getPage(TCMURI pageId);

}
