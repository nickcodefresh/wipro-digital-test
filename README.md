# wipro-digital-test

Points to note:

* To keep it simple the application is single threaded. It is therefore reasonably slow for URLs with many links.
* I've assumed that such a project would want to use the crawled links for something, hence the sitemap isn't output immediately, but rather a object hierarchy is built beforehand.
* The HTML parser library used doesn't always seem to handle URLs in JavaScript correctly. It also requires double parsing for href and img links, which isn't efficient.
* Some unit test are strictly speaking integration tests as they spin up a basic web server.

To run the program:

```
gradle run -Dexec.args="http://wiprodigital.com"

```

To run the tests

```
gradle test
```