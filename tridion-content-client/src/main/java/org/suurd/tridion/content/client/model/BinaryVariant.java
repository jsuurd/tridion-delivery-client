package org.suurd.tridion.content.client.model;

import com.tridion.util.TCMURI;

/**
 * Model representing a Tridion binary variant.
 * 
 * @author jsuurd
 *
 */
public class BinaryVariant extends WebResourceItem {

	private TCMURI binaryId;

	private String variantId;

	private String description;

	private String type;

	private boolean isComponent;

	private String path;

	private TCMURI structureGroupId;

	/**
	 * Gets the binary ID.
	 * 
	 * @return the binaryId
	 */
	public TCMURI getBinaryId() {
		return binaryId;
	}

	/**
	 * Sets the binary ID.
	 * 
	 * @param binaryId the binary ID to set
	 */
	public void setBinaryId(TCMURI binaryId) {
		this.binaryId = binaryId;
	}

	/**
	 * Gets the variant ID.
	 * 
	 * @return the variantId
	 */
	public String getVariantId() {
		return variantId;
	}

	/**
	 * Sets the variant ID.
	 * 
	 * @param variantId the variant ID to set
	 */
	public void setVariantId(String variantId) {
		this.variantId = variantId;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets if is component.
	 * 
	 * @return the isComponent
	 */
	public boolean isComponent() {
		return isComponent;
	}

	/**
	 * Sets if is component.
	 * 
	 * @param isComponent the is component to set
	 */
	public void setComponent(boolean isComponent) {
		this.isComponent = isComponent;
	}

	/**
	 * Gets the path.
	 * 
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 * 
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Gets the structure group ID.
	 * 
	 * @return the structureGroupId
	 */
	public TCMURI getStructureGroupId() {
		return structureGroupId;
	}

	/**
	 * Sets the structure group ID.
	 * 
	 * @param structureGroupId the structure group ID to set
	 */
	public void setStructureGroupId(TCMURI structureGroupId) {
		this.structureGroupId = structureGroupId;
	}

}
