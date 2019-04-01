package org.suurd.tridion.content.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.ComponentPresentation;
import org.suurd.tridion.content.client.model.CustomMeta;
import org.suurd.tridion.content.client.model.Keyword;
import org.suurd.tridion.content.client.model.Page;
import org.suurd.tridion.content.client.model.PageContent;

import com.tridion.util.TCMURI;

public class ODataV2ContentServiceClientTests {

	private ODataV2ContentServiceClient contentServiceClient;

	@Before
	public void setUp() throws Exception {
		contentServiceClient = new ODataV2ContentServiceClient();
	}

	@Test
	@Ignore("Integration Test")
	public void getBinary_WithValidBinaryId_ShouldReturnBinary() throws ParseException {
		//TCMURI binaryId = new TCMURI("tcm:5-272");
		TCMURI binaryId = new TCMURI("tcm:5-81");
		
		Binary binary = contentServiceClient.getBinary(binaryId);
		
		assertNotNull(binary);
	}

	@Test
	@Ignore("Integration Test")
	public void getComponentPresentation_WithValidComponentAndTemplateId_ShouldReturnComponentPresentation() throws ParseException {
		TCMURI componentId = new TCMURI("tcm:5-256-16");
		TCMURI templateId = new TCMURI("tcm:5-174-32");
		
		ComponentPresentation componentPresentation = contentServiceClient.getComponentPresentation(componentId, templateId);
		
		assertNotNull(componentPresentation);
	}
	
	@Test
	@Ignore("Integration Test")
	public void getCustomMetas () throws ParseException {
		TCMURI itemId = new TCMURI("tcm:5-292");
		
		List<CustomMeta> customMetas = contentServiceClient.getCustomMetas(itemId);
		
		assertTrue(customMetas.size() > 0);
	}
	
	@Test
	@Ignore("Integration Test")
	public void getCustomMetas2 () throws ParseException {
		TCMURI publicationId = new TCMURI("tcm:0-5-1");
		String keyName = "sitemapKeyword";
		String stringValue = "000 Home";
		
		List<CustomMeta> customMetas = contentServiceClient.getCustomMetas(publicationId, keyName, stringValue);
		
		assertTrue(customMetas.size() > 0);
	}
	
	@Test
	@Ignore("Integration Test")
	public void getCustomMetas3 () throws ParseException {
		TCMURI publicationId = new TCMURI("tcm:0-5-1");
		String keyName = "pageSize";
		float floatValue = 5;
		
		List<CustomMeta> customMetas = contentServiceClient.getCustomMetas(publicationId, keyName, floatValue);
		
		assertTrue(customMetas.size() > 0);
	}

	@Test
	@Ignore("Integration Test")
	public void getCustomMetas4 () throws ParseException {
		TCMURI publicationId = new TCMURI("tcm:0-5-1");
		String keyName = "dateCreated";
		LocalDateTime dateValue = LocalDateTime.parse("2014-08-31T10:00:00");
		
		List<CustomMeta> customMetas = contentServiceClient.getCustomMetas(publicationId, keyName, dateValue);
		
		assertTrue(customMetas.size() > 0);
	}

	@Test
	@Ignore("Integration Test")
	public void getKeyword_WithValidKeywordIdAndTaxonomyId_ShouldReturnKeyword() throws ParseException {
		TCMURI keywordId = new TCMURI("tcm:5-293-1025");
		TCMURI taxonomyId = new TCMURI("tcm:5-47-512");
		
		Keyword keyword = contentServiceClient.getKeyword(keywordId, taxonomyId);
		
		assertNotNull(keyword);
	}
	
	@Test
	@Ignore("Integration Test")
	public void getKeywords_WithValidTaxonomyId_ShouldReturnKeywords() throws ParseException {
		TCMURI taxonomyId = new TCMURI("tcm:5-47-512");
		
		List<Keyword> keywords = contentServiceClient.getKeywords(taxonomyId);
		
		assertNotNull(keywords);
	}

	@Test
	@Ignore("Integration Test")
	public void getPage_WithValidPageId_ShouldReturnPage() throws ParseException {
		TCMURI pageId = new TCMURI("tcm:5-247-64");
		
		Page page = contentServiceClient.getPage(pageId);
		
		assertNotNull(page);
	}

	@Test
	@Ignore("Integration Test")
	public void getPageContent_WithValidPageId_ShouldReturnPageContent() throws ParseException {
		TCMURI pageId = new TCMURI("tcm:5-247-64");
		
		PageContent pageContent = contentServiceClient.getPageContent(pageId);
		
		assertNotNull(pageContent);
	}

}
