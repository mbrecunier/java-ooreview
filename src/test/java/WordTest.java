import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Cat");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getName_returnsWordName_cat() {
    Word testWord = new Word("Cat");
    assertEquals("Cat", testWord.getName());
  }

}
