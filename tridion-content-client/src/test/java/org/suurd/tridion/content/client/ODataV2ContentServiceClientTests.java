package org.suurd.tridion.content.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.BinaryContent;
import org.suurd.tridion.content.client.model.Component;
import org.suurd.tridion.content.client.model.ComponentPresentation;
import org.suurd.tridion.content.client.model.CustomMeta;
import org.suurd.tridion.content.client.model.Keyword;
import org.suurd.tridion.content.client.model.Page;
import org.suurd.tridion.content.client.model.PageContent;

public class ODataV2ContentServiceClientTests {

	private ODataV2ContentServiceClient contentServiceClient;

	@Before
	public void setUp() throws Exception {
		contentServiceClient = new ODataV2ContentServiceClient();
	}

	@Test
	@Ignore("Integration Test")
	public void getBinary_WithValidIds_ShouldReturnBinary() {
		int publicationId = 5;
		int binaryId = 272;
		
		Binary binary = contentServiceClient.getBinary(publicationId, binaryId);
		
		assertNotNull(binary);
	}

	@Test
	 @Ignore("Integration Test")
	public void getBinaryContent_WithValidIds_ShouldReturnBinaryContent() {
		int publicationId = 5;
		int binaryId = 272;
		String variantId = "WyNkZWYjXQ==";
		
		BinaryContent binary = contentServiceClient.getBinaryContent(publicationId, binaryId, variantId);
		
		assertNotNull(binary);
	}

	@Test
	@Ignore("Integration Test")
	public void getComponent_WithValidIds_ShouldReturnComponent() {
		int publicationId = 5;
		int componentId = 256;
		
		Component component = contentServiceClient.getComponent(publicationId, componentId);
		
		assertNotNull(component);
	}

	@Test
	@Ignore("Integration Test")
	public void getComponentPresentation_WithValidIds_ShouldReturnComponentPresentation() {
		int publicationId = 5;
		int componentId = 256;
		int templateId = 174;
		
		ComponentPresentation componentPresentation = contentServiceClient.getComponentPresentation(publicationId, componentId, templateId);
		
		assertNotNull(componentPresentation);
	}

	@Test
	@Ignore("Integration Test")
	public void getCustomMetas_WithValidIds_ShouldReturnCustomMetas () {
		int publicationId = 5;
		int itemId = 292;
		
		List<CustomMeta> customMetas = contentServiceClient.getCustomMetas(publicationId, itemId);
		
		assertTrue(customMetas.size() > 0);
	}

	@Test
	@Ignore("Integration Test")
	public void getCustomMetas_WithValidDateValue_ShouldReturnCustomMetas  () {
		int publicationId = 5;
		String keyName = "dateCreated";
		LocalDateTime dateValue = LocalDateTime.parse("2014-08-31T10:00:00");
		
		List<CustomMeta> customMetas = contentServiceClient.getCustomMetas(publicationId, keyName, dateValue);
		
		assertTrue(customMetas.size() > 0);
	}

	@Test
	@Ignore("Integration Test")
	public void getCustomMetas_WithValidFloatValue_ShouldReturnCustomMetas () {
		int publicationId = 5;
		String keyName = "pageSize";
		float floatValue = 5;
		
		List<CustomMeta> customMetas = contentServiceClient.getCustomMetas(publicationId, keyName, floatValue);
		
		assertTrue(customMetas.size() > 0);
	}

	@Test
	@Ignore("Integration Test")
	public void getCustomMetas_WithValidStringValue_ShouldReturnCustomMetas () {
		int publicationId = 5;
		String keyName = "sitemapKeyword";
		String stringValue = "000 Home";
		
		List<CustomMeta> customMetas = contentServiceClient.getCustomMetas(publicationId, keyName, stringValue);
		
		assertTrue(customMetas.size() > 0);
	}

	@Test
	@Ignore("Integration Test")
	public void getKeyword_WithValidIds_ShouldReturnKeyword() {
		int publicationId = 5;
		int taxonomyId = 47;
		int keywordId = 293;
		
		Keyword keyword = contentServiceClient.getKeyword(publicationId, taxonomyId, keywordId);
		
		assertNotNull(keyword);
	}

	@Test
	@Ignore("Integration Test")
	public void getKeywords_WithValidIds_ShouldReturnKeywords() {
		int publicationId = 5;
		int taxonomyId = 47;
		
		List<Keyword> keywords = contentServiceClient.getKeywords(publicationId, taxonomyId);
		
		assertNotNull(keywords);
	}

	@Test
	@Ignore("Integration Test")
	public void getPage_WithValidIds_ShouldReturnPage() {
		int publicationId = 5;
		int pageId = 247;
		
		Page page = contentServiceClient.getPage(publicationId, pageId);
		
		assertNotNull(page);
	}

	@Test
	@Ignore("Integration Test")
	public void getPageContent_WithValidIds_ShouldReturnPageContent() {
		int publicationId = 5;
		int pageId = 247;
		
		PageContent pageContent = contentServiceClient.getPageContent(publicationId, pageId);
		
		assertNotNull(pageContent);
	}

}
