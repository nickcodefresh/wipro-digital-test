package com.wipro;

import com.wipro.domain.HeadLink;

public class EntryPoint {

	private Crawler domainProcessor;

	public EntryPoint(final String entryUrl) {
		domainProcessor = new Crawler(entryUrl);
	}

	public void run() {

		System.out.print(String.format("Processing %s ", domainProcessor.getUrl()));
		HeadLink entryPoint = domainProcessor.process();
		System.out.println("");

		SiteMapGenerator smg = new SiteMapGenerator(entryPoint);
		System.out.println(smg.generate());

	}

	public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			System.out.println("Usage: EntryPoint <url>");
			System.exit(0);
		}

		String domainUrl = args[0];
		EntryPoint ep = new EntryPoint(domainUrl);
		ep.run();

	}

}
