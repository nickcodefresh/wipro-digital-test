package com.wipro;

import org.htmlparser.util.ParserException;

import com.wipro.domain.HeadLink;
import com.wipro.domain.AbstractLink;
import com.wipro.domain.Link;

/**
 * Generates the sitemap object structure from a given URL.
 */
public class Crawler {

	private final String url;

	public Crawler(final String url) {
		this.url = url;
	}

	public HeadLink process() {

		HeadLink topLink = new HeadLink(url);

		try {
			processLinks(topLink, topLink);
		} catch (ParserException e) {
			throw new RuntimeException(e);
		}
		return topLink;

	}

	/**
	 * Traverses a list of links within a LinkProvider, recursively calling
	 * itself for each child link if that link is on the same domain as the head
	 * link.
	 */
	private void processLinks(final HeadLink topLink, final AbstractLink link) throws ParserException {

		System.out.print(".");
		
		PageParser pp = new PageParser(link.getUrl());
		topLink.addLinks(link, pp.getLinksOnPage());

		for (Link childLinks : link.getLinks()) {
			if (childLinks.isWithinDomain()) {
				processLinks(topLink, childLinks);
			}
		}

	}

	public String getUrl() {
		return url;
	}

}
