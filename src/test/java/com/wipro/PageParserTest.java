package com.wipro;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PageParserTest {

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
	public void processSimplePage() throws Exception {

		final String url = "http://localhost:8080/app/pageA.html";
		PageParser pp = new PageParser(url);

		List<String> links = pp.getLinksOnPage();

		assertEquals(1, links.size());
		assertEquals(1, links.stream().filter(link -> link.equals("http://localhost:8080/app/pageB.html")).count());

	}
	
	@Test
	public void processPageWithExternalLinkAndImage() throws Exception {

		final String url = "http://localhost:8080/app/pageB.html";
		PageParser pp = new PageParser(url);

		List<String> links = pp.getLinksOnPage();

		assertEquals(2, links.size());
		assertEquals(1, links.stream().filter(link -> link.equals("http://www.google.co.uk")).count());
		assertEquals(1, links.stream().filter(link -> link.equals("http://localhost:8080/app/cat.png")).count());

	}

	@After
	public void shutdownServer() throws Exception {
		server.stop();
	}
	
}
