package com.titanhelix.hermes.controllers.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.titanhelix.hermes.models.UrlCrawl;
import com.titanhelix.hermes.services.CrawlerService;

@RestController
public class CrawlerRestController {

	private static final Logger	logger	= LoggerFactory.getLogger(CrawlerRestController.class);

	@Autowired
	private CrawlerService		crawlerService;

	@RequestMapping(method = RequestMethod.POST, value = "/crawl", produces = "application/json")
	public String crawl(HttpServletResponse httpServletResponse, @RequestBody UrlCrawl url) throws IOException {
		final String METHOD_NAME = "crawl()";
		logger.info(METHOD_NAME);

		// Fire request to the crawler
		return crawlerService.crawl(url);
	}
}
