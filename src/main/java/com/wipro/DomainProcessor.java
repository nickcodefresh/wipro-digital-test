package com.wipro;

import org.htmlparser.util.ParserException;

import com.wipro.domain.Domain;
import com.wipro.domain.Link;
import com.wipro.domain.LinkProvider;

/**
 * Generates the sitemap object structure for a domain.
 */
public class DomainProcessor {

	private final Domain domain;

	public DomainProcessor(final Domain domain) {
		this.domain = domain;
	}

	public void process() {

		try {
			processLinks(domain);
		} catch (ParserException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Traverses a list of links within a LinkProvider, recursively calling
	 * itself for each child link if that link is on the same master domain.
	 */
	private void processLinks(final LinkProvider linkProvider) throws ParserException {

		PageParser pp = new PageParser(linkProvider.getUrl());
		linkProvider.addLinks(pp.getLinksOnPage());

		for (Link link : linkProvider.getLinks()) {
			if (link.isWithinDomain()) {
				processLinks(link);
			}
		}

	}

}
