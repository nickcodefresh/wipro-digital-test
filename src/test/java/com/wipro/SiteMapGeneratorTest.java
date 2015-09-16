package com.wipro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.wipro.domain.HeadLink;
import com.wipro.domain.Link;

public class SiteMapGeneratorTest {

	@Test
	public void simple2LevelOutput() {

		HeadLink domain = new HeadLink("http://www.test.com");
		domain.addLinks(domain, Lists.newArrayList("http://www.test.com/abc.html"));

		SiteMapGenerator smg = new SiteMapGenerator(domain);
		String expected = String.format("http://www.test.com%n   http://www.test.com/abc.html%n");
		assertEquals(expected, smg.generate());

	}

	@Test
	public void simple3LevelOutput() {

		HeadLink domain = new HeadLink("http://www.test.com");
		domain.addLinks(domain, Lists.newArrayList("http://www.test.com/abc.html"));

		Link link = domain.getLinks().get(0);
		domain.addLinks(link, Lists.newArrayList("http://www.test.com/def.html"));

		SiteMapGenerator smg = new SiteMapGenerator(domain);
		String expected = String
				.format("http://www.test.com%n   http://www.test.com/abc.html%n      http://www.test.com/def.html%n");
		assertEquals(expected, smg.generate());

	}

}
