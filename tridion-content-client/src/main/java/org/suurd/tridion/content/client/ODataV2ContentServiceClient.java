package org.suurd.tridion.content.client;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.BinaryVariant;
import org.suurd.tridion.content.client.model.ComponentPresentation;
import org.suurd.tridion.content.client.model.CustomMeta;
import org.suurd.tridion.content.client.model.Keyword;
import org.suurd.tridion.content.client.model.Page;
import org.suurd.tridion.content.client.model.PageContent;

import com.sdl.odata.client.api.ODataClientQuery;
import com.sdl.web.content.client.ContentClient;
import com.sdl.web.content.client.ContentClientProvider;
import com.sdl.web.content.client.ODataV2ClientQuery;
import com.tridion.ItemTypes;
import com.tridion.util.TCMURI;

/**
 * Implementation of the content service client leveraging the OData V2
 * {@link ContentClient}.
 * 
 * @author jsuurd
 */
public class ODataV2ContentServiceClient implements ContentServiceClient {

	private static final Logger LOG = LoggerFactory.getLogger(ODataV2ContentServiceClient.class);
	
	private static final int TCMURI_VERSION_NULL = -1;
	
	private ContentClient contentClient;

	public ODataV2ContentServiceClient() {
		super();
		this.contentClient = ContentClientProvider.getInstance().getContentClient();
	}

	@Override
	public Binary getBinary(TCMURI binaryId) {
		Binary binary = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.BinaryMeta.class)
				.withEntityParameterMap("PublicationId", String.valueOf(binaryId.getPublicationId()))
				.withEntityParameterMap("BinaryId", String.valueOf(binaryId.getItemId()))
				.withExpandParameters("BinaryVariants")
				.build();
		
		com.sdl.web.content.client.odata.v2.edm.BinaryMeta binaryMetaEntity = getEntity(com.sdl.web.content.client.odata.v2.edm.BinaryMeta.class, query);
		if (binaryMetaEntity != null) {
			binary = parseEntity(binaryMetaEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved binary {}", binary);
		}
		
		return binary;
	}

	@Override
	public ComponentPresentation getComponentPresentation(TCMURI componentId, TCMURI templateId) {
		ComponentPresentation componentPresentation = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.ComponentPresentation.class)
				.withEntityParameterMap("PublicationId", String.valueOf(componentId.getPublicationId()))
				.withEntityParameterMap("ComponentId", String.valueOf(componentId.getItemId()))
				.withEntityParameterMap("TemplateId", String.valueOf(templateId.getItemId()))
				.build();
		
		com.sdl.web.content.client.odata.v2.edm.ComponentPresentation componentPresentationEntity = getEntity(com.sdl.web.content.client.odata.v2.edm.ComponentPresentation.class,  query);
		if (componentPresentationEntity != null) {
			componentPresentation = parseEntity(componentPresentationEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved component presentation {}", componentPresentation);
		}
		
		return componentPresentation;
	}

	public List<CustomMeta> getCustomMetas(TCMURI itemId) {
		List<CustomMeta> customMetas = new ArrayList<>();
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.CustomMeta.class)
				.withFilteringParameter(MessageFormat.format("ItemId eq {0}", itemId.getItemId()))
				.build();
		
		List<com.sdl.web.content.client.odata.v2.edm.CustomMeta> customMetaEntities = getEntities(com.sdl.web.content.client.odata.v2.edm.CustomMeta.class, query);
		if (customMetaEntities != null) {
			for (com.sdl.web.content.client.odata.v2.edm.CustomMeta customMetaEntity : customMetaEntities) {
				customMetas.add(parseEntity(customMetaEntity));
			}
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved custom metas {}", customMetas);
		}
		
		return customMetas;
	}

	public List<CustomMeta> getCustomMetas(TCMURI publicationId, String keyName, float floatValue) {
		String filter = MessageFormat.format("PublicationId eq {0} and KeyName eq ''{1}'' and FloatValue eq {2}",
				publicationId.getItemId(), keyName, floatValue);
		return getCustomMetas(filter);
	}

	public List<CustomMeta> getCustomMetas(TCMURI publicationId, String keyName, String stringValue) {
		String filter = MessageFormat.format("PublicationId eq {0} and KeyName eq ''{1}'' and StringValue eq ''{2}''",
				publicationId.getItemId(), keyName, stringValue);
		return getCustomMetas(filter);
	}

	@Override
	public List<CustomMeta> getCustomMetas(TCMURI publicationId, String keyName, LocalDateTime dateValue) {
		String filter = MessageFormat.format("PublicationId eq {0} and KeyName eq ''{1}'' and DateValue eq datetime''{2}''",
				publicationId.getItemId(), keyName, dateValue);
		return getCustomMetas(filter);
	}

	private List<CustomMeta> getCustomMetas(String filter) {
		List<CustomMeta> customMetas = new ArrayList<>();
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.CustomMeta.class)
				.withFilteringParameter(filter)
				.build();
		
		List<com.sdl.web.content.client.odata.v2.edm.CustomMeta> customMetaEntities = getEntities(com.sdl.web.content.client.odata.v2.edm.CustomMeta.class, query);
		if (customMetaEntities != null) {
			for (com.sdl.web.content.client.odata.v2.edm.CustomMeta customMetaEntity : customMetaEntities) {
				customMetas.add(parseEntity(customMetaEntity));
			}
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved custom metas {}", customMetas);
		}
		
		return customMetas;
	}

	@Override
	public Keyword getKeyword(TCMURI keywordId, TCMURI taxonomyId) {
		Keyword keyword = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.Keyword.class)
				.withEntityParameterMap("Id", String.valueOf(keywordId.getItemId()))
				.withEntityParameterMap("TaxonomyId", String.valueOf(taxonomyId.getItemId()))
				.withEntityParameterMap("PublicationId", String.valueOf(keywordId.getPublicationId()))
				.build();
		
		com.sdl.web.content.client.odata.v2.edm.Keyword pageEntity = getEntity(com.sdl.web.content.client.odata.v2.edm.Keyword.class, query);
		if (pageEntity != null) {
			keyword = parseEntity(pageEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved keyword {}", keyword);
		}
		
		return keyword;
	}

	@Override
	public List<Keyword> getKeywords(TCMURI taxonomyId) {
		List<Keyword> keywords = new ArrayList<>();
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.Keyword.class)
				.withFilteringParameter(MessageFormat.format("TaxonomyId eq {0} and PublicationId eq {1}", taxonomyId.getItemId(), taxonomyId.getPublicationId()))
				.build();
		
		List<com.sdl.web.content.client.odata.v2.edm.Keyword> keywordEntities = getEntities(com.sdl.web.content.client.odata.v2.edm.Keyword.class, query);
		if (keywordEntities != null) {
			for (com.sdl.web.content.client.odata.v2.edm.Keyword keywordEntity : keywordEntities) {
				keywords.add(parseEntity(keywordEntity));
			}
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved keywords {}", keywords);
		}
		
		return keywords;
	}

	@Override
	public Page getPage(TCMURI pageId) {
		Page page = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.Page.class)
				.withEntityParameterMap("PublicationId", String.valueOf(pageId.getPublicationId()))
				.withEntityParameterMap("ItemId", String.valueOf(pageId.getItemId()))
				.build();
		
		com.sdl.web.content.client.odata.v2.edm.Page pageEntity = getEntity(com.sdl.web.content.client.odata.v2.edm.Page.class, query);
		if (pageEntity != null) {
			page = parseEntity(pageEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved page {}", page);
		}
		
		return page;
	}

	@Override
	public PageContent getPageContent(TCMURI pageId) {
		PageContent pageContent = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.PageContent.class)
				.withEntityParameterMap("PublicationId", String.valueOf(pageId.getPublicationId()))
				.withEntityParameterMap("PageId", String.valueOf(pageId.getItemId()))
				.build();
		
		com.sdl.web.content.client.odata.v2.edm.PageContent pageContentEntity = getEntity(com.sdl.web.content.client.odata.v2.edm.PageContent.class, query);
		if (pageContentEntity != null) {
			pageContent = parseEntity(pageContentEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved page content {}", pageContent);
		}
		
		return pageContent;
	}

	@SuppressWarnings("unchecked")
	private <T> T getEntity(Class<T> entityClass, ODataClientQuery query) {
		return (T) contentClient.getEntity(entityClass.getName(), query);
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> getEntities(Class<T> entityClass, ODataClientQuery query) {
		return (List<T>)contentClient.getEntities(entityClass.getName(), query);
	}

	public static Binary parseEntity(com.sdl.web.content.client.odata.v2.edm.BinaryMeta binaryMetaEntity) {
		Binary binary = new Binary();
		
		binary.setBinaryId(new TCMURI(binaryMetaEntity.getPublicationId(), binaryMetaEntity.getBinaryId(), ItemTypes.COMPONENT, TCMURI_VERSION_NULL));
		binary.setType(binaryMetaEntity.getType());
		List<BinaryVariant> binaryVariants = new ArrayList<>();
		for (com.sdl.web.content.client.odata.v2.edm.BinaryVariant binaryVariantEntity : binaryMetaEntity.getBinaryVariants()) {
			binaryVariants.add(parseEntity(binaryVariantEntity));
		}
		binary.setBinaryVariants(binaryVariants);
		
		return binary;
	}

	public static BinaryVariant parseEntity(com.sdl.web.content.client.odata.v2.edm.BinaryVariant binaryVariantEntity) {
		BinaryVariant binaryVariant = new BinaryVariant();
		
		binaryVariant.setBinaryId(new TCMURI(binaryVariantEntity.getPublicationId(), binaryVariantEntity.getBinaryId(), ItemTypes.COMPONENT, -1));
		binaryVariant.setVariantId(binaryVariantEntity.getVariantId());
		binaryVariant.setDescription(binaryVariant.getDescription());
		binaryVariant.setType(binaryVariantEntity.getType());
		binaryVariant.setComponent(binaryVariantEntity.isComponent());
		binaryVariant.setPath(binaryVariantEntity.getPath());
		binaryVariant.setUrl(binaryVariantEntity.getUrlPath());
		
		return binaryVariant;
	}

	public static ComponentPresentation parseEntity(com.sdl.web.content.client.odata.v2.edm.ComponentPresentation componentPresentationEntity) {
		ComponentPresentation componentPresentation = new ComponentPresentation();
		
		componentPresentation.setComponentId(new TCMURI(componentPresentationEntity.getPublicationId(), componentPresentationEntity.getComponentId(), ItemTypes.COMPONENT, TCMURI_VERSION_NULL));
		componentPresentation.setTemplateId(new TCMURI(componentPresentationEntity.getPublicationId(), componentPresentationEntity.getTemplateId(), ItemTypes.COMPONENT_TEMPLATE, TCMURI_VERSION_NULL));
		componentPresentation.setPresentationContent(componentPresentationEntity.getPresentationContent());
		componentPresentation.setOutputFormat(componentPresentationEntity.getOutputFormat());
		componentPresentation.setEncoding(componentPresentationEntity.getEncoding());
		componentPresentation.setPriority(componentPresentationEntity.getPriority());
		
		return componentPresentation;
	}

	public static CustomMeta parseEntity(com.sdl.web.content.client.odata.v2.edm.CustomMeta customMetaEntity) {
		CustomMeta customMeta = new CustomMeta();
		
		customMeta.setId(customMetaEntity.getId());
		customMeta.setPublicationId(new TCMURI(0, customMetaEntity.getPublicationId(), ItemTypes.PUBLICATION, TCMURI_VERSION_NULL));
		customMeta.setKeyName(customMetaEntity.getKeyName());
		customMeta.setFloatValue(customMetaEntity.getFloatValue());
		customMeta.setStringValue(customMetaEntity.getStringValue());
		customMeta.setDateValue(customMetaEntity.getDateValue());
		customMeta.setItemId(new TCMURI(customMetaEntity.getPublicationId(), customMetaEntity.getItemId(), customMetaEntity.getItemType(), TCMURI_VERSION_NULL));
		customMeta.setItemType(customMetaEntity.getItemType());
		
		return customMeta;
	}

	public static Keyword parseEntity(com.sdl.web.content.client.odata.v2.edm.Keyword keywordEntity) {
		Keyword keyword = new Keyword();
		
		keyword.setId(new TCMURI(keywordEntity.getPublicationId(), keywordEntity.getId(), keywordEntity.getItemType(), TCMURI_VERSION_NULL));
		keyword.setTaxonomyId(new TCMURI(keywordEntity.getPublicationId(), keywordEntity.getTaxonomyId(), 512, TCMURI_VERSION_NULL));
		keyword.setPublicationId(new TCMURI(0, keywordEntity.getPublicationId(), ItemTypes.PUBLICATION, TCMURI_VERSION_NULL));
		keyword.setKey(keywordEntity.getKey());
		keyword.setTitle(keywordEntity.getName());
		keyword.setDescription(keywordEntity.getDescription());
		keyword.setAbstract(keywordEntity.isAbstract());
		keyword.setNavigable(keywordEntity.isNavigable());
		keyword.setHasChildren(keywordEntity.isHasChildren());
		keyword.setItemType(keywordEntity.getItemType());
		keyword.setLeft(keywordEntity.getLeft());
		keyword.setRight(keywordEntity.getRight());
		keyword.setDepth(keywordEntity.getDepth());
		keyword.setTotalRelatedItems(keywordEntity.getTotalRelatedItems());
		if (keywordEntity.getParent() != null) {
			keyword.setParent(parseEntity(keywordEntity.getParent()));
		}
		if (keywordEntity.getChildren() != null) {
			List<Keyword> children = new ArrayList<>();
			for (com.sdl.web.content.client.odata.v2.edm.Keyword k : keywordEntity.getChildren()) {
				children.add(parseEntity(k));
			}
			keyword.setChildren(children);
		}
		
		return keyword;
	}

	public static Page parseEntity(com.sdl.web.content.client.odata.v2.edm.Page pageEntity) {
		Page page = new Page();
		
		page.setItemId(new TCMURI(pageEntity.getPublicationId(), pageEntity.getItemId(), ItemTypes.PAGE, pageEntity.getMajorVersion()));
		page.setOwningPublication(new TCMURI(0, pageEntity.getOwningPublication(), ItemTypes.PUBLICATION, TCMURI_VERSION_NULL));
		page.setTemplateId(new TCMURI(pageEntity.getPublicationId(), pageEntity.getTemplateId(), ItemTypes.PAGE_TEMPLATE, TCMURI_VERSION_NULL ));
		page.setTitle(pageEntity.getTitle());
		page.setAuthor(pageEntity.getAuthor());
		page.setPagePath(pageEntity.getPagePath());
		page.setCreationDate(pageEntity.getCreationDate());
		page.setModificationDate(pageEntity.getModificationDate());
		page.setInitialPublishDate(pageEntity.getInitialPublishDate());
		page.setLastPublishDate(pageEntity.getLastPublishDate());
		page.setMajorVersion(pageEntity.getMajorVersion());
		page.setMinorVersion(pageEntity.getMinorVersion());	
		page.setUrl(pageEntity.getUrl());
		
		return page;
	}

	public static PageContent parseEntity(com.sdl.web.content.client.odata.v2.edm.PageContent pageContentEntity) {
		PageContent pageContent = new PageContent();
		
		pageContent.setPageId(new TCMURI(pageContentEntity.getPublicationId(), pageContentEntity.getPageId(), ItemTypes.PAGE, TCMURI_VERSION_NULL));
		pageContent.setContent(pageContentEntity.getContent());
		pageContent.setCharSet(pageContentEntity.getCharSet());
		
		return pageContent;
	}

}
