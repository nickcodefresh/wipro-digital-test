package com.wipro.domain;

import java.util.HashSet;
import java.util.Set;

public class Domain extends SiteNode implements LinkProvider {

	private Set<String> allLinks = new HashSet<>();
	
	public Domain(final String domain) {
		super(domain);
	}
	
	protected Link addLink(final String url) {
		
		Link link = null;
		if (!allLinks.contains(url)) {
			link = createLink(url);
			links.add(link);
		}
		return link;
		
	}
	
	public Link createLink(final Link parent, final String url) {
		
		Link link = null;
		if (!allLinks.contains(url)) {
			link = createLink(url);
			parent.addLink(link);
		}
		return link;
		
	}
	
	private Link createLink(final String url) {
		
		Link link = new Link(this, url);
		allLinks.add(url);
		return link;
		
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
