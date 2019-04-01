package org.suurd.tridion.content.client.model;

import java.util.List;

import com.tridion.util.TCMURI;

public class Keyword extends Item {

	private TCMURI id;

	private TCMURI taxonomyId;

	private TCMURI publicationId;

	private String key;

	private String title;

	private String description;

	private boolean isAbstract;

	private boolean isNavigable;

	private boolean isUsedForIdentification;

	private boolean hasChildren;

	private int itemType;

	private int left;

	private int right;

	private int depth;

	private int totalRelatedItems;

	private Keyword parent;

	private List<Keyword> children;

	/**
	 * Gets the ID.
	 * 
	 * @return the id
	 */
	public TCMURI getId() {
		return id;
	}

	/**
	 * Sets the ID.
	 * 
	 * @param id the id to set
	 */
	public void setId(TCMURI id) {
		this.id = id;
	}

	/**
	 * Gets the taxonomy ID.
	 * 
	 * @return the taxonomyId
	 */
	public TCMURI getTaxonomyId() {
		return taxonomyId;
	}

	/**
	 * Sets the taxonomy ID.
	 * 
	 * @param taxonomyId the taxonomy ID to set
	 */
	public void setTaxonomyId(TCMURI taxonomyId) {
		this.taxonomyId = taxonomyId;
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
	 * Gets the key.
	 * 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * Gets if is abstract.
	 * 
	 * @return if isAbstract
	 */
	public boolean isAbstract() {
		return isAbstract;
	}

	/**
	 * Sets if is abstract.
	 * 
	 * @param isAbstract if is abstract to set
	 */
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	/**
	 * Gets if is navigable.
	 * 
	 * @return the isNavigable
	 */
	public boolean isNavigable() {
		return isNavigable;
	}

	/**
	 * Sets if is navigable.
	 * 
	 * @param isNavigable if is navigable to set
	 */
	public void setNavigable(boolean isNavigable) {
		this.isNavigable = isNavigable;
	}

	/**
	 * Gets if is used for identification.
	 * 
	 * @return if isUsedForIdentification
	 */
	public boolean isUsedForIdentification() {
		return isUsedForIdentification;
	}

	/**
	 * Sets if is used for identification.
	 * 
	 * @param isUsedForIdentification if is used for identification to set
	 */
	public void setUsedForIdentification(boolean isUsedForIdentification) {
		this.isUsedForIdentification = isUsedForIdentification;
	}

	/**
	 * Gets if has children.
	 * 
	 * @return if hasChildren
	 */
	public boolean isHasChildren() {
		return hasChildren;
	}

	/**
	 * Sets if has children.
	 * 
	 * @param hasChildren  has children to set
	 */
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
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

	/**
	 * Gets the left keyword ID.
	 * 
	 * @return the left
	 */
	public int getLeft() {
		return left;
	}

	/**
	 * Sets the left keyword ID.
	 * 
	 * @param left the left keyword ID to set
	 */
	public void setLeft(int left) {
		this.left = left;
	}

	/**
	 * Gets the right keyword ID.
	 * 
	 * @return the right
	 */
	public int getRight() {
		return right;
	}

	/**
	 * Sets the right keyword ID.
	 * 
	 * @param right the right keyword ID to set
	 */
	public void setRight(int right) {
		this.right = right;
	}

	/**
	 * Gets the depth.
	 * 
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the depth.
	 * 
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Gets the total related items.
	 * 
	 * @return the totalRelatedItems
	 */
	public int getTotalRelatedItems() {
		return totalRelatedItems;
	}

	/**
	 * Sets the total related items.
	 * 
	 * @param totalRelatedItems the total related items to set
	 */
	public void setTotalRelatedItems(int totalRelatedItems) {
		this.totalRelatedItems = totalRelatedItems;
	}

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public Keyword getParent() {
		return parent;
	}

	/**
	 * Sets the parent keyword.
	 * 
	 * @param parent the parent to set
	 */
	public void setParent(Keyword parent) {
		this.parent = parent;
	}

	/**
	 * Gets the children.
	 * 
	 * @return the children
	 */
	public List<Keyword> getChildren() {
		return children;
	}

	/**
	 * Sets the children.
	 * 
	 * @param children the children to set
	 */
	public void setChildren(List<Keyword> children) {
		this.children = children;
	}

}
