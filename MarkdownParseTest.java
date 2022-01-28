import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.*;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks(){
        assertEquals(MarkdownParse.getLinks("test-file.md"), List.of("https://something.com", "some-page.html"));
    }
}