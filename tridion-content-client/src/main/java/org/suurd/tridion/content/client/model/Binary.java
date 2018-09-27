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

}
