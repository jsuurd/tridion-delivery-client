package org.suurd.tridion.content.client.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.tridion.util.TCMURI;

public class CustomMeta extends Item {

	private int id;

	private TCMURI publicationId;

	private String keyName;

	private BigDecimal floatValue;

	private String stringValue;

	private ZonedDateTime dateValue;

	private TCMURI itemId;

	private int itemType;

	/**
	 * Gets the ID.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the ID.
	 * 
	 * @param id the ID to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the publication ID.
	 * 
	 * @return the publicationId
	 */
	public TCMURI getPublicationId() {
		return publicationId;
	}

	/**
	 * Sets the publication ID.
	 * 
	 * @param publicationId the publication ID to set
	 */
	public void setPublicationId(TCMURI publicationId) {
		this.publicationId = publicationId;
	}

	/**
	 * Gets the key name.
	 * 
	 * @return the keyName
	 */
	public String getKeyName() {
		return keyName;
	}

	/**
	 * Sets the key name.
	 * 
	 * @param keyName the key name to set
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	/**
	 * Gets the float value.
	 * 
	 * @return the floatValue
	 */
	public BigDecimal getFloatValue() {
		return floatValue;
	}

	/**
	 * Sets the float value.
	 * 
	 * @param floatValue the float value to set
	 */
	public void setFloatValue(BigDecimal floatValue) {
		this.floatValue = floatValue;
	}

	/**
	 * Gets the string value.
	 * 
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * Sets the string value.
	 * 
	 * @param stringValue the string value to set
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	/**
	 * Gets the date value.
	 * 
	 * @return the dateValue
	 */
	public ZonedDateTime getDateValue() {
		return dateValue;
	}

	/**
	 * Sets the date value.
	 * 
	 * @param dateValue the date value to set
	 */
	public void setDateValue(ZonedDateTime dateValue) {
		this.dateValue = dateValue;
	}

	/**
	 * Gets the item ID.
	 * 
	 * @return the itemId
	 */
	public TCMURI getItemId() {
		return itemId;
	}

	/**
	 * Sets the item ID.
	 * 
	 * @param itemId the item ID to set
	 */
	public void setItemId(TCMURI itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the item type.
	 * 
	 * @return the itemType
	 */
	public int getItemType() {
		return itemType;
	}

	/**
	 * Sets the item type.
	 * 
	 * @param itemType the item type to set
	 */
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

}
