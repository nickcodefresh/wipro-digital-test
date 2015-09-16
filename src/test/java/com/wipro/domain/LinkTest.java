package com.wipro.domain;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LinkTest {

	private HeadLink domain;

	@Before
	public void setUp() {
		domain = new HeadLink("http://www.test.com");
	}

	@Test
	public void ensureNoDuplicateLinks() {

		List<String> linkUrls = Arrays.asList(new String[] { "http://www.test.com/abc.html" });
		List<Link> links = domain.addLinks(domain, linkUrls);

		Link link = links.get(0);
		domain.addLinks(link, linkUrls);

		assertEquals(0, link.getLinks().size());

	}

	@Test
	public void domainMatch() {

		List<String> linkUrls = Arrays.asList(new String[] { "http://www.test.com/abc.html" });
		List<Link> links = domain.addLinks(domain, linkUrls);

		assertTrue(links.get(0).isWithinDomain());

	}

	@Test
	public void domainMismatch() {

		List<String> linkUrls = Arrays.asList(new String[] { "http://www.bad.com/abc.html" });
		List<Link> links = domain.addLinks(domain, linkUrls);

		assertFalse(links.get(0).isWithinDomain());

	}

}
