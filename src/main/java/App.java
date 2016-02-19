import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String wordName = request.queryParams("word");
      Word newWord = new Word(wordName);
      model.put("allWords", Word.all());

      model.put("template", "templates/words.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Integer wordId = Integer.parseInt(request.params(":id"));
      Word word = Word.find(wordId);
      model.put("word", word);

      ArrayList<Definition> definitions = word.getDefinitions();
      model.put("definitions", definitions);

      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id/definitions/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Integer wordId = Integer.parseInt(request.params(":id"));
      Word word = Word.find(wordId);
      model.put("word", word);

      model.put("template", "templates/word-definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definitions", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Integer wordId = Integer.parseInt(request.queryParams("wordId"));
      Word word = Word.find(wordId);
      ArrayList definitions = word.getDefinitions();
      model.put("word", word);
      model.put("definitions", definitions);

      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
