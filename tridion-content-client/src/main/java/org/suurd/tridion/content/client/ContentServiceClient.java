package org.suurd.tridion.content.client;

import org.suurd.tridion.content.client.model.Page;

import com.tridion.util.TCMURI;

public interface ContentServiceClient {

	Page getPage(TCMURI pageUri);

}
