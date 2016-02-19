import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition testDef = new Definition();
    assertEquals(true, testDef instanceof Definition);
  }

}
