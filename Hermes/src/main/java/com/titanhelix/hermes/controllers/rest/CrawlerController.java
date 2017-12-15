package com.titanhelix.hermes.controllers.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.titanhelix.hermes.models.UrlCrawl;
import com.titanhelix.hermes.services.CrawlerService;

@Controller
public class CrawlerController {

	@Autowired
	private CrawlerService crawlerService;

	@RequestMapping("/crawler")
	public String crawlerForm(Model model) {
		model.addAttribute("urlcrawl", new UrlCrawl());
		return "crawler";
	}

	@PostMapping("/crawler")
	public String crawlerSubmit(@ModelAttribute UrlCrawl urlCrawl) throws IOException {
		String jsonResult = crawlerService.crawl(urlCrawl);
		ObjectMapper objectMapper = new ObjectMapper();
		Object json = objectMapper.readValue(jsonResult, Object.class);
		String indented = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		urlCrawl.setResult(indented);
		return "crawlerresult";
	}

}