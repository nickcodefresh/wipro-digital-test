package com.wipro.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public abstract class SiteNode {

	private final String url;
	protected List<Link> links = new ArrayList<>();

	protected SiteNode(final String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public List<Link> getLinks() {
		return Lists.newArrayList(links);
	}

	public List<Link> addLinks(final List<String> urls) {
		
		List<Link> ls = new ArrayList<>();
		urls.forEach(url -> ls.add(addLink(url)));
		return ls;
		
	}
	
	public void addLink(final Link link) {
		links.add(link);
	}
	
	protected abstract Link addLink(final String url);

}