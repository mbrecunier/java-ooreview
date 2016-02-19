import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> allWords = new ArrayList<Word>();

  private String mName;
  private int mId;
  private static ArrayList<Definition> mDefinitions;

  public Word(String name) {
    mName = name;
    allWords.add(this);
    mId = allWords.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getName() {
    return mName;
  }

  public static ArrayList all() {
    return allWords;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList getDefinitions() {
    return mDefinitions;
  }

  public static void clear() {
    allWords.clear();
  }
}
