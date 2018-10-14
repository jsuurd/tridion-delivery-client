package org.suurd.tridion.content.client.model;

import java.util.List;

import com.tridion.util.TCMURI;

/**
 * Model representing a Tridion binary.
 * 
 * @author jsuurd
 *
 */
public class Binary extends Item {

	private TCMURI binaryId;

	private String type;

	private List<BinaryVariant> binaryVariants;

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
	 * Gets the binary variants.
	 * 
	 * @return the binaryVariants
	 */
	public List<BinaryVariant> getBinaryVariants() {
		return binaryVariants;
	}

	/**
	 * Sets the binary variants.
	 * 
	 * @param binaryVariants the binary variants to set
	 */
	public void setBinaryVariants(List<BinaryVariant> binaryVariants) {
		this.binaryVariants = binaryVariants;
	}

}
