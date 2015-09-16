package com.wipro.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public abstract class AbstractLink {

	private final String url;
	private List<Link> links = new ArrayList<>();

	protected AbstractLink(final String url) {
		this.url = url;
	}

	public final String getUrl() {
		return url;
	}

	public final List<Link> getLinks() {
		return Lists.newArrayList(links);
	}

	protected final void addLink(final Link link) {
		links.add(link);
	}

	abstract boolean isWithinDomain();

}