package com.wipro.domain;

import java.util.List;

public interface LinkProvider {

	String getUrl();
	
	List<Link> getLinks();
	
	List<Link> addLinks(final List<String> urls);
	
	boolean isWithinDomain();
	
}
