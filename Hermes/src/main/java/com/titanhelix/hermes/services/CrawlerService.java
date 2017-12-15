package com.titanhelix.hermes.services;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.titanhelix.hermes.models.Crawl;
import com.titanhelix.hermes.models.UrlCrawl;
import com.titanhelix.hermes.models.UrlNode;

@Service
public class CrawlerService {

	public String crawl(UrlCrawl urlCrawl) throws JsonProcessingException {
		if (UrlValidator.getInstance().isValid(urlCrawl.getUrl())) {
			Crawl crawl = new Crawl(); // Crawling Spiders! Object isn't needed, yet. Till I implement the threaded solution
			UrlNode urlNode = crawl.crawl(urlCrawl.getUrl(), urlCrawl.getDepth());
			return new ObjectMapper().writeValueAsString(urlNode);
		}

		return "error\t Invalid URL:" + urlCrawl.getUrl();
	}

}
