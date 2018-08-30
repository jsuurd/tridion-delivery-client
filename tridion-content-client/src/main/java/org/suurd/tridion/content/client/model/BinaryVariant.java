package org.suurd.tridion.content.client.model;

/**
 * Model representing a Tridion binary variant.
 * 
 * @author jsuurd
 *
 */
public class BinaryVariant extends AbstractModel {

	private String variantId;

	private String path;

	private String url;

	/**
	 * @return the variant id
	 */
	public String getVariantId() {
		return variantId;
	}

	/**
	 * @param variantId the variant id to set
	 */
	public void setVariantId(String variantId) {
		this.variantId = variantId;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
