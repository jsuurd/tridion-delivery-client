package org.suurd.tridion.content.client.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model representing a Tridion binary variant.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BinaryVariant extends WebResource {

	private int binaryId;

	private int publicationId;

	private String variantId;

	private String structureGroupId;

	private String description;

	private String type;

	private boolean isComponent;

	private String path;

}
