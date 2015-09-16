package com.wipro.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents the entry point from where we wish to produce the sitemap from.
 */
public class HeadLink extends AbstractLink {

	private Set<String> allLinks = new HashSet<>();

	public HeadLink(final String domain) {
		super(domain);
	}

	public List<Link> addLinks(final AbstractLink parentLink, List<String> urls) {

		List<Link> newLinks = new ArrayList<>();
		urls.forEach(url -> {
			Link link = new Link(this, url);
			if (!allLinks.contains(url)) {
				parentLink.addLink(link);
				newLinks.add(link);
			}
		});
		allLinks.addAll(urls);
		return newLinks;

	}

	@Override
	public boolean isWithinDomain() {
		return true;
	}

	@Override
	public String toString() {
		return "Domain [url=" + getUrl() + "]";
	}

}
