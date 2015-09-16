package com.wipro.domain;

import java.net.URI;

public class Link extends AbstractLink {

	private final HeadLink domain;

	Link(final HeadLink domain, final String url) {
		super(url);
		this.domain = domain;
	}

	@Override
	public boolean isWithinDomain() {

		try {
			URI domainUri = new URI(domain.getUrl());
			URI linkUri = new URI(getUrl());
			// host can be null for mail: links
			return linkUri.getHost() != null && linkUri.getHost().equalsIgnoreCase(domainUri.getHost());
		} catch (Exception e) {
			// htmlparser library that we're using doesn't always extract URLs
			// correctly, so we have to ignore an invalid ones. On a production
			// system we'd never swallow an exception like this
			return false;
		}

	}

	@Override
	public String toString() {
		return "Link [url=" + getUrl() + "]";
	}

}
