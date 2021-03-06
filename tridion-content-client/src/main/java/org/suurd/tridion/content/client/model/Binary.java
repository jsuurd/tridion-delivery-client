package org.suurd.tridion.content.client.model;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model representing a Tridion binary.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Binary {

	private int binaryId;

	private int publicationId;

	private String type;

	private List<BinaryVariant> binaryVariants;

}
