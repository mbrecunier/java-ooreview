import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition testDef = new Definition("a nice surprise");
    assertEquals(true, testDef instanceof Definition);
  }

  @Test
  public void getDescription_returnsDescription() {
    Definition testDef = new Definition("a furry thing");
    assertEquals("a furry thing", testDef.getDescription());
  }

  @Test
  public void getPartOfSpeech_returnsPartOfSpeech_noun() {
    Definition testDef = new Definition("a furry thing");
    testDef.setPartOfSpeech("noun");
    assertEquals("noun", testDef.getPartOfSpeech());
  }

}
