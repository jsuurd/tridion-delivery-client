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

	private TCMURI owningPublication;

	private TCMURI templateId;

	private String title;

	private String author;

	private String pagePath;

	private ZonedDateTime creationDate;
	
	private ZonedDateTime modificationDate;

	private ZonedDateTime initialPublishDate;
	
	private ZonedDateTime lastPublishDate;

	private int majorVersion;

	private int minorVersion;

	/**
	 * @return the itemId
	 */
	public TCMURI getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(TCMURI itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the owningPublication
	 */
	public TCMURI getOwningPublication() {
		return owningPublication;
	}

	/**
	 * @param owningPublication the owningPublication to set
	 */
	public void setOwningPublication(TCMURI owningPublication) {
		this.owningPublication = owningPublication;
	}

	/**
	 * @return the templateId
	 */
	public TCMURI getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(TCMURI templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the pagePath
	 */
	public String getPagePath() {
		return pagePath;
	}

	/**
	 * @param pagePath the pagePath to set
	 */
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	/**
	 * @return the creationDate
	 */
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the modificationDate
	 */
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * @return the initialPublishDate
	 */
	public ZonedDateTime getInitialPublishDate() {
		return initialPublishDate;
	}

	/**
	 * @param initialPublishDate the initialPublishDate to set
	 */
	public void setInitialPublishDate(ZonedDateTime initialPublishDate) {
		this.initialPublishDate = initialPublishDate;
	}

	/**
	 * @return the lastPublishDate
	 */
	public ZonedDateTime getLastPublishDate() {
		return lastPublishDate;
	}

	/**
	 * @param lastPublishDate the lastPublishDate to set
	 */
	public void setLastPublishDate(ZonedDateTime lastPublishDate) {
		this.lastPublishDate = lastPublishDate;
	}

	/**
	 * @return the majorVersion
	 */
	public int getMajorVersion() {
		return majorVersion;
	}

	/**
	 * @param majorVersion the majorVersion to set
	 */
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	/**
	 * @return the minorVersion
	 */
	public int getMinorVersion() {
		return minorVersion;
	}

	/**
	 * @param minorVersion the minorVersion to set
	 */
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

}
