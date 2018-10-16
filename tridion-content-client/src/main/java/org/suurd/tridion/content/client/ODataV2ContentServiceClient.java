package org.suurd.tridion.content.client;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.BinaryVariant;
import org.suurd.tridion.content.client.model.Page;

import com.sdl.odata.client.api.ODataClientQuery;
import com.sdl.web.content.client.ContentClient;
import com.sdl.web.content.client.ContentClientProvider;
import com.sdl.web.content.client.ODataV2ClientQuery;
import com.tridion.util.TCMURI;

/**
 * Implementation of the content service client leveraging the OData V2
 * {@link ContentClient}.
 * 
 * @author jsuurd
 */
public class ODataV2ContentServiceClient implements ContentServiceClient {

	private static final Logger LOG = LoggerFactory.getLogger(ODataV2ContentServiceClient.class);

	@Override
	public Binary getBinary(TCMURI binaryId) {
		Binary binary = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.BinaryMeta.class)
				.withEntityParameterMap("PublicationId", String.valueOf(binaryId.getPublicationId()))
				.withEntityParameterMap("BinaryId", String.valueOf(binaryId.getItemId()))
				.withExpandParameters("BinaryVariants")
				.build();
		
		ContentClient contentClient = ContentClientProvider.getInstance().getContentClient();
		com.sdl.web.content.client.odata.v2.edm.BinaryMeta binaryMetaEntity = (com.sdl.web.content.client.odata.v2.edm.BinaryMeta)contentClient.getEntity(com.sdl.web.content.client.odata.v2.edm.BinaryMeta.class.getName(), query);
		if (binaryMetaEntity != null) {
			binary = new Binary();
			binary.setBinaryId(new TCMURI(binaryMetaEntity.getPublicationId(), binaryMetaEntity.getBinaryId(), 16, 0));
			binary.setType(binaryMetaEntity.getType());
			List<BinaryVariant> bv = new ArrayList<BinaryVariant>();
			for (com.sdl.web.content.client.odata.v2.edm.BinaryVariant binaryVariant : binaryMetaEntity.getBinaryVariants()) {
				BinaryVariant b = new BinaryVariant();
				b.setVariantId(binaryVariant.getVariantId());
				b.setPath(binaryVariant.getPath());
				b.setUrl(binaryVariant.getUrlPath());
				bv.add(b);
			}
			binary.setBinaryVariants(bv);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved binary {}", binary);
		}
		
		return binary;
	}

	@Override
	public Page getPage(TCMURI pageId) {
		Page page = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.Page.class)
				.withEntityParameterMap("PublicationId", String.valueOf(pageId.getPublicationId()))
				.withEntityParameterMap("ItemId", String.valueOf(pageId.getItemId()))
				.build();
		
		ContentClient contentClient = ContentClientProvider.getInstance().getContentClient();
		com.sdl.web.content.client.odata.v2.edm.Page pageEntity = (com.sdl.web.content.client.odata.v2.edm.Page)contentClient.getEntity(com.sdl.web.content.client.odata.v2.edm.Page.class.getName(), query);
		if (pageEntity != null) {
			page = new Page();
			page.setItemId(new TCMURI(pageEntity.getPublicationId(), pageEntity.getItemId(), 64, pageEntity.getMinorVersion()));
			page.setTitle(pageEntity.getTitle());
			page.setUrl(pageEntity.getUrl());
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved page {}", page);
		}
		
		return page;
	}

}
