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
	 * @return the variantId
	 */
	public String getVariantId() {
		return variantId;
	}

	/**
	 * @param variantId the variantId to set
	 */
	public void setVariantId(String variantId) {
		this.variantId = variantId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the isComponent
	 */
	public boolean isComponent() {
		return isComponent;
	}

	/**
	 * @param isComponent the isComponent to set
	 */
	public void setComponent(boolean isComponent) {
		this.isComponent = isComponent;
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
	 * @return the binaryId
	 */
	public TCMURI getBinaryId() {
		return binaryId;
	}

	/**
	 * @param binaryId the binaryId to set
	 */
	public void setBinaryId(TCMURI binaryId) {
		this.binaryId = binaryId;
	}

	/**
	 * @return the structureGroupId
	 */
	public TCMURI getStructureGroupId() {
		return structureGroupId;
	}

	/**
	 * @param structureGroupId the structureGroupId to set
	 */
	public void setStructureGroupId(TCMURI structureGroupId) {
		this.structureGroupId = structureGroupId;
	}

}
