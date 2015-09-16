package com.wipro;

import com.wipro.domain.Domain;

public class EntryPoint {

	private final Domain domain;
	private DomainProcessor domainProcessor;

	public EntryPoint(final String domainUrl) {
		domain = new Domain(domainUrl);
		domainProcessor = new DomainProcessor(domain);
	}

	public void run() {

		System.out.print(String.format("Processing %s ", domain.getUrl()));
		domainProcessor.process();
		System.out.println("");
		
		SiteMapGenerator smg = new SiteMapGenerator(domain);		
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
