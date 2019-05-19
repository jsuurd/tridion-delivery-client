package org.suurd.tridion.content.client.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model representing a Tridion page content.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageContent {

	private int pageId;

	private int publicationId;

	private String content;

	private String charSet;

}
