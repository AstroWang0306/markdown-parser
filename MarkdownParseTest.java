import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {

    @Test
    public void snippet3 () throws IOException {
        ArrayList<String> forTest1 = new ArrayList<String>();
        forTest1.add("https://www.twitter.com"); 
        forTest1.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        forTest1.add("https://cse.ucsd.edu/");

        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        assertEquals(forTest1, MarkdownParse.getLinks(content));
    }

    @Test
    public void snippet2 () throws IOException {
        ArrayList<String> forTest1 = new ArrayList<String>();
        forTest1.add("a.com"); //it's a nested link
        forTest1.add("a.com(())");
        forTest1.add("example.com");

        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        assertEquals(forTest1, MarkdownParse.getLinks(content));
    }

    @Test
    public void snippet1 () throws IOException {
        ArrayList<String> forTest1 = new ArrayList<String>();
        forTest1.add("url.com");
        forTest1.add("`google.com");
        forTest1.add("google.com");
        forTest1.add("ucsd.edu");

        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        assertEquals(forTest1, MarkdownParse.getLinks(content));
    }
}


    /*
    @Test
    public void addition () {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test1 () throws IOException {

        ArrayList<String> forTest1 = new ArrayList<String>();
        forTest1.add("https://something.com");
        forTest1.add("some-thing.html");
        
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(forTest1, MarkdownParse.getLinks(content));
    }

     @Test
    public void aFailingtest() {
        assertEquals("https://www.youtube.com/watch?v=dQw4w9WgXcQ",
        "Rick Roll");
    }
    */