package com.titanhelix.hermes.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crawl {
	private static final Logger logger = LoggerFactory.getLogger(Crawl.class);

	public Crawl() {
	}

	public UrlNode crawl(String url, int depth) {
		logger.debug(url, depth);
		UrlNode urlNode = new UrlNode();

		try {
			Document document = Jsoup.connect(url).get();
			urlNode.setTitle(document.title());
			urlNode.setUrl(url);

			List<UrlNode> urlNodes = new ArrayList<UrlNode>();
			if (depth > 0) {
				for (Element page : getChildLinks(url)) {
					urlNodes.add(crawl(page.attr("abs:href"), --depth));
				}

			}
			urlNode.setNodes(urlNodes);
		} catch (IOException e) {
			urlNode.setTitle("ERROR Retrieving node");
		}

		return urlNode;
	}

	public Elements getChildLinks(String url) throws IOException {
		return Jsoup.connect(url).get().select("a[href]");
	}
}