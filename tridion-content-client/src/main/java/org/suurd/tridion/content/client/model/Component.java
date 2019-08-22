package org.suurd.tridion.content.client.model;

import java.time.ZonedDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model representing a Tridion component.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Component {

	private int itemId;

	private int publicationId;

	private int owningPublicationId;

	private int schemaId;

	private String title;

	private String author;

	private ZonedDateTime creationDate;

	private ZonedDateTime modificationDate;

	private ZonedDateTime initialPublishDate;

	private ZonedDateTime lastPublishDate;

	private int majorVersion;

	private int minorVersion;

	private boolean isMultimedia;

}
