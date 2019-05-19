package org.suurd.tridion.content.client.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model representing a Tridion component presentation.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ComponentPresentation {

	private int publicationId;

	private int componentId;

	private int templateId;

	private String content;

	private String outputFormat;

	private String encoding;

	private int priority;

}
