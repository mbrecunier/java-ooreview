import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> allDefinitions = new ArrayList<Definition>();

  private String mDescription;
  private String mPartOfSpeech;
  private int mId;

  public Definition(String description) {
    mDescription = description;
    allDefinitions.add(this);
    mId = allDefinitions.size();
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
    return allDefinitions;
  }

  public static void clear() {
    allDefinitions.clear();
  }

  public int getId() {
    return mId;
  }

  public static Definition find(int id) {
    try {
      return allDefinitions.get(id-1);
    } catch (IndexOutOfBoundsException e) {
      System.err.println("IndexOutOfBoundsException: " + e.getMessage());
      return null;
    }
  }
}
