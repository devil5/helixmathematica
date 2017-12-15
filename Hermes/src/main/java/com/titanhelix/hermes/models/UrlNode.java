package com.titanhelix.hermes.models;

import java.util.List;

public class UrlNode {
	private String			title;
	private String			url;
	private List<UrlNode>	nodes;

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

	public List<UrlNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<UrlNode> nodes) {
		this.nodes = nodes;
	}

}
