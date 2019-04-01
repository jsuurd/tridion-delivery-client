package org.suurd.tridion.content.client.model;

import com.tridion.util.TCMURI;

/**
 * Model representing a Tridion page content.
 * 
 * @author jsuurd
 *
 */
public class PageContent extends Item {

	private TCMURI pageId;

	private String content;

	private String charSet;

	/**
	 * Gets the page ID.
	 * 
	 * @return the pageId
	 */
	public TCMURI getPageId() {
		return pageId;
	}

	/**
	 * Sets the page ID.
	 * 
	 * @param pageId the page ID to set
	 */
	public void setPageId(TCMURI pageId) {
		this.pageId = pageId;
	}

	/**
	 * Gets the content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 * 
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the char set.
	 * 
	 * @return the charSet
	 */
	public String getCharSet() {
		return charSet;
	}

	/**
	 * Sets the char set.
	 * 
	 * @param charSet the char set to set
	 */
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}

}
