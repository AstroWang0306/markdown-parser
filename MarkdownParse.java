//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParse {

    static final int nonexist = -1;

    public static ArrayList<String> getLinks(String markdown) {
       
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        //System.out.println(markdown.length());
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
             if(openBracket == nonexist){
               break;
            }
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);    
            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen == nonexist){
                break;
            }
            
            String inParen = markdown.substring(openParen + 1, closeParen);
            if(inParen.toLowerCase().endsWith(".jpg") || 
                inParen.toLowerCase().endsWith(".png") ||
                ! inParen.contains(".") || 
                inParen.indexOf(".") == inParen.length()-1 
                ) {}
            else {
                toReturn.add(inParen);
            }
            currentIndex = closeParen + 1;

            
            //System.out.println(currentIndex);
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        //System.out.println("hello");
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}


