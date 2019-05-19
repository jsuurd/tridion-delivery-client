package org.suurd.tridion.content.client.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model representing Tridion custom metadata.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomMeta {

	private int id;

	private int publicationId;

	private int itemId;

	private int itemType;

	private String keyName;

	private ZonedDateTime dateValue;

	private BigDecimal floatValue;

	private String stringValue;

}
