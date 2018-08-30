package org.suurd.tridion.content.client.model;

import java.util.List;

/**
 * Model representing a Tridion binary.
 * 
 * @author jsuurd
 *
 */
public class Binary extends AbstractIdentifiableItem {

	private List<BinaryVariant> binaryVariants;

	private String type;

	/**
	 * @return the binaryVariants
	 */
	public List<BinaryVariant> getBinaryVariants() {
		return binaryVariants;
	}

	/**
	 * @param binaryVariants the binaryVariants to set
	 */
	public void setBinaryVariants(List<BinaryVariant> binaryVariants) {
		this.binaryVariants = binaryVariants;
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

}
