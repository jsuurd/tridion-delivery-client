package org.suurd.tridion.content.client.model;

/**
 * Model representing a Tridion page.
 * 
 * @author jsuurd
 *
 */
public class Page extends AbstractIdentifiableItem {

	private String title;

	private String url;

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

}
