import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

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

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word word1 = new Word("Hammer");
    Word word2 = new Word("Cheese");
    assertTrue(Word.all().contains(word1));
    assertTrue(Word.all().contains(word2));
  }

  @Test
  public void getId_returnsWordId() {
    Word testWord = new Word("Dirge");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList() {
    Word newWord = new Word("Dolphin");
    assertEquals(0, newWord.getDefinitions().size());
  }

  @Test
  public void clear_removesWordsFromArrayList() {
    Word newWord = new Word("tax");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

}
