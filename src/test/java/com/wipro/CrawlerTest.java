package com.wipro;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wipro.domain.HeadLink;
import com.wipro.domain.Link;

public class CrawlerTest {

	private Server server;

	@Before
	public void startServer() throws Exception {

		server = new Server(8080);
		server.setStopAtShutdown(true);
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setContextPath("/app");
		webAppContext.setResourceBase("src/test/resources");
		webAppContext.setClassLoader(getClass().getClassLoader());
		server.setHandler(webAppContext);
		server.start();

	}

	@Test
	public void processPages() throws Exception {

		final String url = "http://localhost:8080/app/pageA.html";

		Crawler target = new Crawler(url);
		HeadLink entryPoint = target.process();

		assertEquals(url, entryPoint.getUrl());

		List<Link> links = entryPoint.getLinks();
		assertEquals(1, links.size());

		Link pageBLink = links.get(0);
		assertEquals("http://localhost:8080/app/pageB.html", pageBLink.getUrl());
		assertEquals(2, pageBLink.getLinks().size());
		assertEquals(1,
				pageBLink.getLinks().stream().filter(link -> link.getUrl().equals("http://www.google.co.uk")).count());
		assertEquals(1, pageBLink.getLinks().stream()
				.filter(link -> link.getUrl().equals("http://localhost:8080/app/cat.png")).count());

	}

	@After
	public void shutdownServer() throws Exception {
		server.stop();
	}

}
