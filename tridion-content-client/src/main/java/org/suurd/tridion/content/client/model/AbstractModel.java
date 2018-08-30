package org.suurd.tridion.content.client.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Abstract model class.
 * 
 * @author jsuurd
 *
 */
public abstract class AbstractModel {

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

}
