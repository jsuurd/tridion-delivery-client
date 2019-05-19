package org.suurd.tridion.content.client.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Abstract model representing a Tridion web resource.
 * 
 * @author jsuurd
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class WebResource {

	private String url;

}
