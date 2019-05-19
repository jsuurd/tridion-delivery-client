package org.suurd.tridion.content.client;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.BinaryContent;
import org.suurd.tridion.content.client.model.BinaryVariant;
import org.suurd.tridion.content.client.model.Component;
import org.suurd.tridion.content.client.model.ComponentPresentation;
import org.suurd.tridion.content.client.model.CustomMeta;
import org.suurd.tridion.content.client.model.Keyword;
import org.suurd.tridion.content.client.model.Page;
import org.suurd.tridion.content.client.model.PageContent;
import com.sdl.odata.client.api.ODataClientQuery;
import com.sdl.web.content.client.ContentClient;
import com.sdl.web.content.client.ContentClientProvider;
import com.sdl.web.content.client.ODataV2ClientQuery;

/**
 * Implementation of the content service client leveraging the OData V2
 * {@link ContentClient}.
 * 
 * @author jsuurd
 */
public class ODataV2ContentServiceClient implements ContentServiceClient {

	private static final Logger LOG = LoggerFactory.getLogger(ODataV2ContentServiceClient.class);

	private ContentClient contentClient;

	public ODataV2ContentServiceClient() {
		super();
		this.contentClient = ContentClientProvider.getInstance().getContentClient();
	}

	@Override
	public Binary getBinary(int publicationId, int binaryId) {
		Binary binary = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.BinaryMeta.class)
				.withEntityParameterMap("PublicationId", String.valueOf(publicationId))
				.withEntityParameterMap("BinaryId", String.valueOf(binaryId))
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
	public BinaryContent getBinaryContent(int publicationId, int binaryId, String variantId) {
		BinaryContent binaryContent = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.BinaryContent.class)
				.withEntityParameterMap("BinaryId", String.valueOf(binaryId))
				.withEntityParameterMap("PublicationId", String.valueOf(publicationId))
				.withEntityParameterMap("VariantId", variantId).build();
		
		com.sdl.web.content.client.odata.v2.edm.BinaryContent binaryContentEntity = getEntity(com.sdl.web.content.client.odata.v2.edm.BinaryContent.class, query);
		if (binaryContentEntity != null) {
			binaryContent = parseEntity(binaryContentEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved binary content {}", binaryContent);
		}
		
		return binaryContent;
	}

	@Override
	public Component getComponent(int publicationId, int componentId) {
		Component component = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.Component.class)
				.withEntityParameterMap("PublicationId", String.valueOf(publicationId))
				.withEntityParameterMap("ItemId", String.valueOf(componentId)).build();
		
		com.sdl.web.content.client.odata.v2.edm.Component componentEntity = getEntity(com.sdl.web.content.client.odata.v2.edm.Component.class, query);
		if (componentEntity != null) {
			component = parseEntity(componentEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved component {}", component);
		}
		
		return component;
	}

	@Override
	public ComponentPresentation getComponentPresentation(int publicationId, int componentId, int templateId) {
		ComponentPresentation componentPresentation = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.ComponentPresentation.class)
				.withEntityParameterMap("PublicationId", String.valueOf(publicationId))
				.withEntityParameterMap("ComponentId", String.valueOf(componentId))
				.withEntityParameterMap("TemplateId", String.valueOf(templateId)).build();
		
		com.sdl.web.content.client.odata.v2.edm.ComponentPresentation componentPresentationEntity = getEntity(com.sdl.web.content.client.odata.v2.edm.ComponentPresentation.class, query);
		if (componentPresentationEntity != null) {
			componentPresentation = parseEntity(componentPresentationEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved component presentation {}", componentPresentation);
		}
		
		return componentPresentation;
	}

	@Override
	public List<CustomMeta> getCustomMetas(int publicationId, int itemId) {
		List<CustomMeta> customMetas = new ArrayList<>();
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.CustomMeta.class).withFilteringParameter(MessageFormat.format("PublicationId eq {0} and ItemId eq {1}", publicationId, itemId))
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
	public List<CustomMeta> getCustomMetas(int publicationId, String keyName, LocalDateTime dateValue) {
		String filter = MessageFormat.format("PublicationId eq {0} and KeyName eq ''{1}'' and DateValue eq datetime''{2}''",
				publicationId, keyName, dateValue);
		return getCustomMetas(filter);
	}

	@Override
	public List<CustomMeta> getCustomMetas(int publicationId, String keyName, float floatValue) {
		String filter = MessageFormat.format("PublicationId eq {0} and KeyName eq ''{1}'' and FloatValue eq {2}",
				publicationId, keyName, floatValue);
		return getCustomMetas(filter);
	}

	@Override
	public List<CustomMeta> getCustomMetas(int publicationId, String keyName, String stringValue) {
		String filter = MessageFormat.format("PublicationId eq {0} and KeyName eq ''{1}'' and StringValue eq ''{2}''",
				publicationId, keyName, stringValue);
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
	public Keyword getKeyword(int publicationId, int taxonomyId, int keywordId) {
		Keyword keyword = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.Keyword.class)
				.withEntityParameterMap("Id", String.valueOf(keywordId))
				.withEntityParameterMap("TaxonomyId", String.valueOf(taxonomyId))
				.withEntityParameterMap("PublicationId", String.valueOf(publicationId)).build();

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
	public List<Keyword> getKeywords(int publicationId, int taxonomyId) {
		List<Keyword> keywords = new ArrayList<>();
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.Keyword.class)
				.withFilteringParameter(MessageFormat.format("PublicationId eq {0} and TaxonomyId eq {1}", publicationId, taxonomyId))
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
	public Page getPage(int publicationId, int pageId) {
		Page page = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.Page.class)
				.withEntityParameterMap("PublicationId", String.valueOf(publicationId))
				.withEntityParameterMap("ItemId", String.valueOf(pageId)).build();
		
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
	public PageContent getPageContent(int publicationId, int pageId) {
		PageContent pageContent = null;
		
		ODataClientQuery query = new ODataV2ClientQuery.Builder()
				.withEntityType(com.sdl.web.content.client.odata.v2.edm.PageContent.class)
				.withEntityParameterMap("PublicationId", String.valueOf(publicationId))
				.withEntityParameterMap("PageId", String.valueOf(pageId)).build();
		
		com.sdl.web.content.client.odata.v2.edm.PageContent pageContentEntity = getEntity(
				com.sdl.web.content.client.odata.v2.edm.PageContent.class, query);
		if (pageContentEntity != null) {
			pageContent = parseEntity(pageContentEntity);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Retrieved page content {}", pageContent);
		}
		
		return pageContent;
	}

	@SuppressWarnings("unchecked")
	private <T> T getEntity(Class<T> clazz, ODataClientQuery query) {
		return (T) contentClient.getEntity(clazz.getName(), query);
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> getEntities(Class<T> clazz, ODataClientQuery query) {
		return (List<T>)contentClient.getEntities(clazz.getName(), query);
	}

	public static Binary parseEntity(com.sdl.web.content.client.odata.v2.edm.BinaryMeta binaryMetaEntity) {
		Binary binary = new Binary();
		
		binary.setBinaryId(binaryMetaEntity.getBinaryId());
		binary.setPublicationId(binaryMetaEntity.getPublicationId());
		binary.setType(binaryMetaEntity.getType());
		List<BinaryVariant> binaryVariants = new ArrayList<>();
		for (com.sdl.web.content.client.odata.v2.edm.BinaryVariant binaryVariantEntity : binaryMetaEntity.getBinaryVariants()) {
			binaryVariants.add(parseEntity(binaryVariantEntity));
		}
		binary.setBinaryVariants(binaryVariants);
		
		return binary;
	}

	public static BinaryContent parseEntity(com.sdl.web.content.client.odata.v2.edm.BinaryContent binaryContentEntity) {
		BinaryContent binaryContent = new BinaryContent();
		
		binaryContent.setBinaryId(binaryContentEntity.getBinaryId());
		binaryContent.setPublicationId(binaryContentEntity.getPublicationId());
		binaryContent.setVariantId(binaryContentEntity.getVariantId());
		binaryContent.setBinaryContentPath(binaryContentEntity.getBinaryContentPath());
		
		return binaryContent;
	}

	public static BinaryVariant parseEntity(com.sdl.web.content.client.odata.v2.edm.BinaryVariant binaryVariantEntity) {
		BinaryVariant binaryVariant = new BinaryVariant();
		
		binaryVariant.setBinaryId(binaryVariantEntity.getBinaryId());
		binaryVariant.setPublicationId(binaryVariantEntity.getPublicationId());
		binaryVariant.setVariantId(binaryVariantEntity.getVariantId());
		binaryVariant.setStructureGroupId(binaryVariantEntity.getStructureGroupId());
		binaryVariant.setDescription(binaryVariant.getDescription());
		binaryVariant.setType(binaryVariantEntity.getType());
		binaryVariant.setComponent(binaryVariantEntity.isComponent());
		binaryVariant.setPath(binaryVariantEntity.getPath());
		binaryVariant.setUrl(binaryVariantEntity.getUrlPath());
		
		return binaryVariant;
	}
	
	public static Component parseEntity(com.sdl.web.content.client.odata.v2.edm.Component componentEntity) {
		Component component = new Component();
		
		component.setItemId(componentEntity.getItemId());
		component.setPublicationId(componentEntity.getPublicationId());
		component.setOwningPublicationId(componentEntity.getOwningPublication());
		component.setSchemaId(component.getSchemaId());
		component.setTitle(component.getTitle());
		component.setAuthor(component.getAuthor());
		component.setCreationDate(component.getCreationDate());
		component.setModificationDate(component.getModificationDate());
		component.setInitialPublishDate(component.getInitialPublishDate());
		component.setLastPublishDate(component.getLastPublishDate());
		component.setMajorVersion(component.getMajorVersion());
		component.setMinorVersion(component.getMinorVersion());
		component.setMultimedia(component.isMultimedia());
		
		return component;
	}

	public static ComponentPresentation parseEntity(com.sdl.web.content.client.odata.v2.edm.ComponentPresentation componentPresentationEntity) {
		ComponentPresentation componentPresentation = new ComponentPresentation();
		
		componentPresentation.setPublicationId(componentPresentationEntity.getPublicationId());
		componentPresentation.setComponentId(componentPresentationEntity.getComponentId());
		componentPresentation.setTemplateId(componentPresentationEntity.getTemplateId());
		componentPresentation.setContent(componentPresentationEntity.getPresentationContent());
		componentPresentation.setOutputFormat(componentPresentationEntity.getOutputFormat());
		componentPresentation.setEncoding(componentPresentationEntity.getEncoding());
		componentPresentation.setPriority(componentPresentationEntity.getPriority());
		
		return componentPresentation;
	}

	public static CustomMeta parseEntity(com.sdl.web.content.client.odata.v2.edm.CustomMeta customMetaEntity) {
		CustomMeta customMeta = new CustomMeta();
		
		customMeta.setId(customMetaEntity.getId());
		customMeta.setPublicationId(customMetaEntity.getPublicationId());
		customMeta.setItemId(customMetaEntity.getItemId());
		customMeta.setItemType(customMetaEntity.getItemType());
		customMeta.setKeyName(customMetaEntity.getKeyName());
		customMeta.setDateValue(customMetaEntity.getDateValue());
		customMeta.setFloatValue(customMetaEntity.getFloatValue());
		customMeta.setStringValue(customMetaEntity.getStringValue());
		
		return customMeta;
	}

	public static Keyword parseEntity(com.sdl.web.content.client.odata.v2.edm.Keyword keywordEntity) {
		Keyword keyword = new Keyword();
		
		keyword.setId(keywordEntity.getId());
		keyword.setTaxonomyId(keywordEntity.getTaxonomyId());
		keyword.setPublicationId(keywordEntity.getPublicationId());
		keyword.setItemType(keywordEntity.getItemType());
		keyword.setKey(keywordEntity.getKey());
		keyword.setTitle(keywordEntity.getName());
		keyword.setDescription(keywordEntity.getDescription());
		keyword.setAbstract(keywordEntity.isAbstract());
		keyword.setNavigable(keywordEntity.isNavigable());
		keyword.setUsedForIdentification(keywordEntity.isUsedForIdentification());
		keyword.setHasChildren(keywordEntity.isHasChildren());
		keyword.setLeft(keywordEntity.getLeft());
		keyword.setRight(keywordEntity.getRight());
		keyword.setDepth(keywordEntity.getDepth());
		keyword.setTotalRelatedItems(keywordEntity.getTotalRelatedItems());
		
		return keyword;
	}

	public static Page parseEntity(com.sdl.web.content.client.odata.v2.edm.Page pageEntity) {
		Page page = new Page();
		
		page.setItemId(pageEntity.getItemId());
		page.setPublicationId(pageEntity.getPublicationId());
		page.setOwningPublicationId(pageEntity.getOwningPublication());
		page.setTemplateId(pageEntity.getTemplateId());
		page.setTitle(pageEntity.getTitle());
		page.setAuthor(pageEntity.getAuthor());
		page.setCreationDate(pageEntity.getCreationDate());
		page.setModificationDate(pageEntity.getModificationDate());
		page.setInitialPublishDate(pageEntity.getInitialPublishDate());
		page.setLastPublishDate(pageEntity.getLastPublishDate());
		page.setMajorVersion(pageEntity.getMajorVersion());
		page.setMinorVersion(pageEntity.getMinorVersion());
		page.setPath(pageEntity.getPagePath());
		page.setUrl(pageEntity.getUrl());
		
		return page;
	}

	public static PageContent parseEntity(com.sdl.web.content.client.odata.v2.edm.PageContent pageContentEntity) {
		PageContent pageContent = new PageContent();
		
		pageContent.setPageId(pageContentEntity.getPageId());
		pageContent.setPublicationId(pageContentEntity.getPublicationId());
		pageContent.setContent(pageContentEntity.getContent());
		pageContent.setCharSet(pageContentEntity.getCharSet());
		
		return pageContent;
	}

}
