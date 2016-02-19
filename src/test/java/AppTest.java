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
}
