package com.wipro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.wipro.domain.Domain;
import com.wipro.domain.Link;

public class SiteMapGeneratorTest {

	@Test
	public void simple2LevelOutput() {

		Domain domain = new Domain("http://www.test.com");
		domain.addLinks(Lists.newArrayList("http://www.test.com/abc.html"));

		SiteMapGenerator smg = new SiteMapGenerator(domain);
		String expected = String.format("http://www.test.com%n   http://www.test.com/abc.html%n");
		assertEquals(expected, smg.generate());

	}

	@Test
	public void simple3LevelOutput() {

		Domain domain = new Domain("http://www.test.com");
		domain.addLinks(Lists.newArrayList("http://www.test.com/abc.html"));

		Link link = domain.getLinks().get(0);
		link.addLinks(Lists.newArrayList("http://www.test.com/def.html"));

		SiteMapGenerator smg = new SiteMapGenerator(domain);
		String expected = String
				.format("http://www.test.com%n   http://www.test.com/abc.html%n      http://www.test.com/def.html%n");
		assertEquals(expected, smg.generate());

	}

}
