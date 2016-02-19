import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

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

  @Test
  public void all_returnsAllInstanceOfDefinition_true() {
    Definition testDef1 = new Definition("type of bird");
    Definition testDef2 = new Definition("type of hotdog");
    assertTrue(Definition.all().contains(testDef1));
    assertTrue(Definition.all().contains(testDef2));
  }

  @Test
  public void clear_emptiesDefinitionsFromInstances() {
    Definition testDef = new Definition("exotic rug");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_definitionsInstantiateWithAnId() {
    Definition testDef1 = new Definition("type of bird");
    assertEquals(Definition.all().size(), testDef1.getId());
    Definition testDef2 = new Definition("type of hotdog");
    assertEquals(Definition.all().size(), testDef2.getId());
  }

  @Test
  public void fine_returnsDefinitionById_testDef2() {
    Definition testDef1 = new Definition("type of bird");
    Definition testDef2 = new Definition("type of hotdog");
    assertEquals(Definition.find(testDef2.getId()), testDef2);
  }

  @Test
  public void find_returnsNullWhenNoTaskFound_null() {
    Definition testDef = new Definition("a slow march");
    assertTrue(Definition.find(999) == null);
  }

}
