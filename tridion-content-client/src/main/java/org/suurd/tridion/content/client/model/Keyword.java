package org.suurd.tridion.content.client.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model representing a Tridion keyword.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Keyword {

	private int id;

	private int taxonomyId;

	private int publicationId;

	private int itemType;

	private String key;

	private String title;

	private String description;

	private boolean isAbstract;

	private boolean isNavigable;

	private boolean isUsedForIdentification;

	private boolean isHasChildren;

	private int left;

	private int right;

	private int depth;

	private int totalRelatedItems;

}
