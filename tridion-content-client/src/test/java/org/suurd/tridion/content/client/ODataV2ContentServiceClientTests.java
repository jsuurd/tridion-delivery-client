package org.suurd.tridion.content.client;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.suurd.tridion.content.client.ODataV2ContentServiceClient;
import org.suurd.tridion.content.client.model.Binary;
import org.suurd.tridion.content.client.model.Page;

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
		TCMURI binaryId = new TCMURI("tcm:5-272");
		
		Binary binary = contentServiceClient.getBinary(binaryId);
		
		assertNotNull(binary);
	}

	@Test
	@Ignore("Integration Test")
	public void getPage_WithValidPageId_ShouldReturnPage() throws ParseException {
		TCMURI pageId = new TCMURI("tcm:5-247-64");
		
		Page page = contentServiceClient.getPage(pageId);
		
		assertNotNull(page);
	}

}
