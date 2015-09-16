package com.wipro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.ics.crawler4j.crawler.WebCrawler;

public class PageParser {

	protected static final Logger LOGGER = LoggerFactory.getLogger(WebCrawler.class);

	private final String url;

	public PageParser(final String url) {
		this.url = url;
	}

	public List<String> getLinksOnPage() throws ParserException {


		List<String> result = new ArrayList<>();
		result.addAll(getLinks());
		result.addAll(getImages());
		
		return result;

	}

	private List<String> getLinks() throws ParserException {

		Parser htmlParser = new Parser(url);
		NodeList tagNodeList = htmlParser.extractAllNodesThatMatch(new NodeClassFilter(LinkTag.class));
		List<String> result = new LinkedList<>();
		for (int j = 0; j < tagNodeList.size(); j++) {
			LinkTag loopLink = (LinkTag) tagNodeList.elementAt(j);
			result.add(loopLink.getLink());
		}
		return result;

	}

	private List<String> getImages() throws ParserException {

		Parser htmlParser = new Parser(url);
		NodeList tagNodeList = htmlParser.extractAllNodesThatMatch(new NodeClassFilter(ImageTag.class));
		List<String> result = new LinkedList<>();
		for (int j = 0; j < tagNodeList.size(); j++) {
			ImageTag loopLink = (ImageTag) tagNodeList.elementAt(j);
			result.add(loopLink.getImageURL());
		}
		return result;

	}
	
}
