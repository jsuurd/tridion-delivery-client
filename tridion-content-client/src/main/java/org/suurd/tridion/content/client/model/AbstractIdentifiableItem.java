package org.suurd.tridion.content.client.model;

import com.tridion.util.TCMURI;

/**
 * Abstract model representing an identifiable Tridion item.
 * 
 * @author jsuurd
 *
 */
public abstract class AbstractIdentifiableItem extends AbstractModel {

	private TCMURI id;

	/**
	 * Gets the item ID.
	 * 
	 * @return the ID
	 */
	public TCMURI getId() {
		return id;
	}

	/**
	 * Set the item ID.
	 * 
	 * @param id the ID to set
	 */
	public void setId(TCMURI id) {
		this.id = id;
	}

}
