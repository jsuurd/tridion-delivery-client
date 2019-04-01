package org.suurd.tridion.content.client.model;

import com.tridion.util.TCMURI;

/**
 * Model representing a Tridion component presentation.
 * 
 * @author jsuurd
 *
 */
public class ComponentPresentation extends Item {

	private TCMURI componentId;

	private TCMURI templateId;

	private String presentationContent;

	private String outputFormat;

	private String encoding;

	private int priority;

	/**
	 * Gets the component ID.
	 * 
	 * @return the componentId
	 */
	public TCMURI getComponentId() {
		return componentId;
	}

	/**
	 * Sets the component ID.
	 * 
	 * @param componentId the component ID to set
	 */
	public void setComponentId(TCMURI componentId) {
		this.componentId = componentId;
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
	 * Gets the presentation content.
	 * 
	 * @return the presentationContent
	 */
	public String getPresentationContent() {
		return presentationContent;
	}

	/**
	 * Sets the presentation content.
	 * 
	 * @param presentationContent the presentation content to set
	 */
	public void setPresentationContent(String presentationContent) {
		this.presentationContent = presentationContent;
	}

	/**
	 * Gets the output format.
	 * 
	 * @return the outputFormat
	 */
	public String getOutputFormat() {
		return outputFormat;
	}

	/**
	 * Sets the output format.
	 * 
	 * @param outputFormat the output format to set
	 */
	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	/**
	 * Gets the encoding.
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Sets the encoding.
	 * 
	 * @param encoding the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Gets the priority.
	 * 
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 * 
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

}
