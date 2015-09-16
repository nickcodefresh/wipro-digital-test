package com.wipro.domain;

import java.net.URI;

public class Link extends SiteNode implements LinkProvider {

	private final Domain domain;

	public Link(final Domain domain, final String url) {
		super(url);
		this.domain = domain;
	}

	@Override
	protected Link addLink(final String url) {
		return domain.createLink(this, url);
	}
	
	@Override
	public boolean isWithinDomain() {

		try {
			URI domainUri = new URI(domain.getUrl());
			URI linkUri = new URI(getUrl());
			// host can be null for mail: links
			return linkUri.getHost() != null && linkUri.getHost().equalsIgnoreCase(domainUri.getHost());
		} catch (Exception e) {
			return false;
			//throw new RuntimeException(e);
		}

	}

	@Override
	public String toString() {
		return "Link [url=" + getUrl() + "]";
	}

}
