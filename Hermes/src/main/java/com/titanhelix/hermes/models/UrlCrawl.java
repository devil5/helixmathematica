package com.titanhelix.hermes.models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UrlCrawl {
	private String	url;
	private Integer	depth;
	private Integer	traversalLimit;
	private Object	result;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getTraversalLimit() {
		return traversalLimit;
	}

	public void setTraversalLimit(Integer traversalLimit) {
		this.traversalLimit = traversalLimit;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
