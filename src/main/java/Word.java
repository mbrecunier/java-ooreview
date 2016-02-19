import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> allWords = new ArrayList<Word>();

  private String mName;
  private int mId;

  public Word(String name) {
    mName = name;
    allWords.add(this);
    mId = allWords.size();
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
}
