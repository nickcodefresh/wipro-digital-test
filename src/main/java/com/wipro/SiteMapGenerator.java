package com.wipro;

import org.apache.commons.lang3.StringUtils;

import com.wipro.domain.AbstractLink;
import com.wipro.domain.HeadLink;

/**
 * Generates the sitemap string for a domain.
 */
public class SiteMapGenerator {

	private final static String NEWLINE = System.getProperty("line.separator");
	private HeadLink domain;

	public SiteMapGenerator(final HeadLink domain) {
		this.domain = domain;
	}

	public String generate() {

		return processLinks(0, domain);

	}

	private String processLinks(final int depth, final AbstractLink linkProvider) {

		StringBuilder sb = new StringBuilder(
				StringUtils.leftPad(linkProvider.getUrl(), linkProvider.getUrl().length() + (depth * 3)));
		sb.append(NEWLINE);
		linkProvider.getLinks().forEach(link -> {
			sb.append(processLinks(depth + 1, link));
		});
		return sb.toString();

	}

}
