# wipro-digital-test

Points to note:

* For simplicities sake, the application is single threaded. It is therefore reasonably slow for URLs with many links
* The HTML parser library it uses doesn't always seem to handle URLs in JavaScript correctly
* Some unit test are strictly speaking integration tests as they spin up a basic web server

To run the program:

java com.wipro.EntryPoint http://wiprodigital.com

To run the test

gradle test