package org.suurd.tridion.content.client.model;

import java.time.ZonedDateTime;

import com.tridion.util.TCMURI;

/**
 * Model representing a Tridion page.
 * 
 * @author jsuurd
 *
 */
public class Page extends WebResourceItem {

	private TCMURI itemId;

	private TCMURI templateId;

	private String title;

	private String author;

	private ZonedDateTime creationDate;

	private ZonedDateTime modificationDate;

	private ZonedDateTime initialPublishDate;

	private ZonedDateTime lastPublishDate;

	private String pagePath;

	private TCMURI owningPublication;

	private int majorVersion;

	private int minorVersion;

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
	 * Gets the template ID.
	 * 
	 * @return the templateId
	 */
	public TCMURI getTemplateId() {
		return templateId;
	}

	/**
	 * Sets the template ID.
	 * 
	 * @param templateId the template ID to set
	 */
	public void setTemplateId(TCMURI templateId) {
		this.templateId = templateId;
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
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 * 
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the creation date.
	 * 
	 * @return the creationDate
	 */
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 * 
	 * @param creationDate the creation date to set
	 */
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the modification date.
	 * 
	 * @return the modificationDate
	 */
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	/**
	 * Sets the modification date.
	 * 
	 * @param modificationDate the modification date to set
	 */
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * Gets the initial publish date.
	 * 
	 * @return the initialPublishDate
	 */
	public ZonedDateTime getInitialPublishDate() {
		return initialPublishDate;
	}

	/**
	 * Sets the initial publish date.
	 * 
	 * @param initialPublishDate the initial publish date to set
	 */
	public void setInitialPublishDate(ZonedDateTime initialPublishDate) {
		this.initialPublishDate = initialPublishDate;
	}

	/**
	 * Gets the last publish date.
	 * 
	 * @return the lastPublishDate
	 */
	public ZonedDateTime getLastPublishDate() {
		return lastPublishDate;
	}

	/**
	 * Sets the last publish date.
	 * 
	 * @param lastPublishDate the last publish date to set
	 */
	public void setLastPublishDate(ZonedDateTime lastPublishDate) {
		this.lastPublishDate = lastPublishDate;
	}

	/**
	 * Gets the page path.
	 * 
	 * @return the pagePath
	 */
	public String getPagePath() {
		return pagePath;
	}

	/**
	 * Sets the page path.
	 * 
	 * @param pagePath the page path to set
	 */
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	/**
	 * Gets the owning publication.
	 * 
	 * @return the owningPublication
	 */
	public TCMURI getOwningPublication() {
		return owningPublication;
	}

	/**
	 * Sets the owning publication.
	 * 
	 * @param owningPublication the owning publication to set
	 */
	public void setOwningPublication(TCMURI owningPublication) {
		this.owningPublication = owningPublication;
	}

	/**
	 * Gets the major version.
	 * 
	 * @return the majorVersion
	 */
	public int getMajorVersion() {
		return majorVersion;
	}

	/**
	 * Sets the major version.
	 * 
	 * @param majorVersion the major version to set
	 */
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	/**
	 * Gets the minor version.
	 * 
	 * @return the minorVersion
	 */
	public int getMinorVersion() {
		return minorVersion;
	}

	/**
	 * Sets the minor version.
	 * 
	 * @param minorVersion the minor version to set
	 */
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

}
