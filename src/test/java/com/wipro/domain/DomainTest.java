package com.wipro.domain;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class DomainTest {

	private HeadLink domain;

	@Before
	public void setUp() {
		domain = new HeadLink("http://www.test.com");
	}

	@Test
	public void ensureNoDuplicateLinks() {

		List<String> linkUrls = Lists.newArrayList("http://www.test.com/abc.html");
		domain.addLinks(domain, linkUrls);

		assertEquals(1, domain.getLinks().stream().filter(link -> link.getUrl().equals(linkUrls.get(0))).count());
		assertEquals(1, domain.getLinks().size());

		domain.addLinks(domain, linkUrls);
		assertEquals(1, domain.getLinks().size());

	}

	@Test
	public void addLinks() {

		List<String> linkUrls = Lists.newArrayList("http://www.test.com/abc.html", "http://www.test.com/def.html");
		domain.addLinks(domain, linkUrls);

		assertEquals(2, domain.getLinks().size());

	}

}
