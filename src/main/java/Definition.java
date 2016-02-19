import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mDescription;
  private String mPartOfSpeech;

  public Definition(String description) {
    mDescription = description;
    instances.add(this);
  }

  public String getDescription() {
    return mDescription;
  }

  public void setPartOfSpeech(String part) {
    mPartOfSpeech = part;
  }

  public String getPartOfSpeech() {
    return mPartOfSpeech;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

}
