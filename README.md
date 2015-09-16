# wipro-digital-test

Points to note:

* To keep it simple the application is single threaded. It is therefore reasonably slow for URLs with many links
* The HTML parser library it uses doesn't always seem to handle URLs in JavaScript correctly. It also required double parsing for href and img links, which isn't efficient.
* Some unit test are strictly speaking integration tests as they spin up a basic web server

To run the program:

```
gradle run -Dexec.args="http://wiprodigital.com"

```

To run the tests

```
gradle test
```