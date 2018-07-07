package org.suurd.tridion.content.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suurd.tridion.content.client.model.Page;

import com.sdl.odata.client.api.ODataClientQuery;
import com.sdl.web.content.client.ContentClient;
import com.sdl.web.content.client.ContentClientProvider;
import com.sdl.web.content.client.ODataV2ClientQuery;
import com.tridion.util.TCMURI;

public class ODataV2ContentServiceClient implements ContentServiceClient {

	private static final Logger LOG = LoggerFactory.getLogger(ODataV2ContentServiceClient.class);

	public Page getPage(TCMURI pageUri) {
		Page page = null;
		
		ContentClient contentClient = ContentClientProvider.getInstance().getContentClient();
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(Page.class)
				.withEntityParameterMap("PublicationId", String.valueOf(pageUri.getPublicationId()))
				.withEntityParameterMap("ItemId", String.valueOf(pageUri.getItemId()))
				.build();
		
		com.sdl.web.content.client.odata.v2.edm.Page pageEntity = (com.sdl.web.content.client.odata.v2.edm.Page)contentClient.getEntity(com.sdl.web.content.client.odata.v2.edm.Page.class.getName(), query);
		if (pageEntity != null) {
			page = new Page();
			page.setId(new TCMURI(pageEntity.getPublicationId(), pageEntity.getItemId(), 64, pageEntity.getMinorVersion()));
			page.setTitle(pageEntity.getTitle());
			page.setUrl(pageEntity.getUrl());
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved page [uri={}, title={}]", pageUri, page.getTitle());
		}
		
		return page;
	}

}
