package org.suurd.tridion.content.client.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.tridion.util.TCMURI;

/**
 * Model representing a Tridon page.
 * 
 * @author jsuurd
 *
 */
public class Page {

	private TCMURI id;

	private String title;

	private String url;

	/**
	 * Gets the page ID.
	 * 
	 * @return the ID
	 */
	public TCMURI getId() {
		return id;
	}

	/**
	 * Set the page ID.
	 * 
	 * @param ID the ID to set
	 */
	public void setId(TCMURI id) {
		this.id = id;
	}

	/**
	 * Get the page title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the page title.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the page URL.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the page URL.
	 * 
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

}
