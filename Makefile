# Makefile for MarkdownParse

# Step 1: make MarkdownParse.class
test.class: test.java
	javac test.java

# Step 2: make MarkdownParseTest.class
test.class: test.java test.class
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar test.java

# Step 3: run test cases
test: test.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore test