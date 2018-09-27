package org.suurd.tridion.content.client.model;

/**
 * Abstract model representing a web resource Tridion item.
 * 
 * @author jsuurd
 *
 */
public abstract class WebResourceItem extends Item {

	private String url;

	/**
	 * Gets the item URL.
	 * 
	 * @return the URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the item URL.
	 * 
	 * @param id the URL to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
