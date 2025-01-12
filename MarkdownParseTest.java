import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testGetLinks1() throws IOException{
        String file=Files.readString(Path.of("test-file.md"));
        assertEquals(MarkdownParse.getLinks(file), List.of("https://something.com","some-page.html"));
    }
    @Test
    public void testGetLinks2() throws IOException{
        String file=Files.readString(Path.of("test-file2.md"));
        assertEquals(MarkdownParse.getLinks(file), 
        List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ","https://www.google.com/maps"));
    }
    @Test
    public void testGetLinks3() throws IOException{
        String file=Files.readString(Path.of("test-file3.md"));
        assertEquals(MarkdownParse.getLinks(file), 
        List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
    }
    @Test
    public void testGetLinksBulk() throws IOException{
        String file=Files.readString(Path.of("test-file4.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        file=Files.readString(Path.of("test-file6.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        file=Files.readString(Path.of("test-file7.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        //tests below are bugged
        file=Files.readString(Path.of("test-file8.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of("a link on the first line"));
        file=Files.readString(Path.of("test-file5.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
    }

    @Test
    public void testSnippet1(){
        Path file = Path.of("snippet1.md");
        String contents = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("'google.com", "google.com", "ucsd.edu"), links);
    }

    @Test
    public void testSnippet2(){
        Path file = Path.of("snippet2.md");
        String contents = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), links);
    }

    @Test
    public void testSnippet3(){
        Path file = Path.of(snippet3.md);
        String contents = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), links);
    }

    
    /*
    @Test
    public void testGetLinksPhoto() throws IOException{
        String file = Files.readString(Path.of("test-file9.md"));
        assertEquals(List.of("https://something.com", "some-page.html", "www.google.com/test"), MarkdownParse.getLinks(file));
    }
    */
}