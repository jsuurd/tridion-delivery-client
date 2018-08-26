package org.suurd.tridion.content.client;

import org.suurd.tridion.content.client.model.Page;

import com.tridion.util.TCMURI;

/**
 * Interface providing methods to retrieve content from the SDL Content Service.
 * 
 * @author jsuurd
 */
public interface ContentServiceClient {

	/**
	 * Gets a page object for the specified page uri.
	 *
	 * @param pageUri the page uri
	 * @return the page
	 */
	Page getPage(TCMURI pageUri);

}
