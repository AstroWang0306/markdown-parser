import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {

    @Test
    public void addition () {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test1 () throws IOException {

        ArrayList<String> forTest1 = new ArrayList<String>();
        forTest1.add("https://something.com");
        forTest1.add("some-thing.html");
        for(int i=0;i<2;i++) {
            System.out.println(forTest1.get(i));
        }

        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(forTest1, MarkdownParse.getLinks(content));
    }
}