package org.suurd.tridion.content.client.model;

import com.tridion.util.TCMURI;

public class Page {

	private TCMURI id;

	private String title;

	private String url;

	public TCMURI getId() {
		return id;
	}

	public void setId(TCMURI id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
