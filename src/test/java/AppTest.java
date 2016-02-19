import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void wordIsCreated() {
    goTo("http://localhost:4567/");
    click("a", withText("Add new word"));
    fill("#word").with("Butter");
    submit(".btn");
    assertThat(pageSource()).contains("Butter");
  }

  @Test
  public void eachWordHasOwnPage() {
    goTo("http://localhost:4567/");
    click("a", withText("Add new word"));
    fill("#word").with("Salsa");
    submit(".btn");
    click("a", withText("Salsa"));
    assertThat(pageSource()).contains("Add a new definition");
  }

  @Test
  public void wordDefinitionsFormisDisplay() {
    goTo("http://localhost:4567/");
    click("a", withText("Add new word"));
    fill("#word").with("Rock");
    submit(".btn");
    click("a", withText("Rock"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a Definition for Rock");
  }

  @Test
  public void definitionsAreAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Panther");
    submit(".btn");
    click("a", withText("Panther"));
    click("a", withText("Add a new definition"));
    fill("#description").with("a large kitty");
    submit(".btn");
    assertThat(pageSource()).contains("a large kitty");
  }

}
