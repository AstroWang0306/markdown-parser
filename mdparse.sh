#java -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:. MarkdownParse $1
for file in test-files/*.md;
do
    
    java MarkdownParse $file
done