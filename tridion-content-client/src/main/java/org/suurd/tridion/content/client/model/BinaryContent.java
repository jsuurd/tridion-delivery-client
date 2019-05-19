package org.suurd.tridion.content.client.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model representing a Tridion binary content.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BinaryContent {

	private int binaryId;

	private int publicationId;

	private String variantId;

	private String binaryContentPath;

}
