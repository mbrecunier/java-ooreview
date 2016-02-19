public class Definition {
  private String mDescription;
  private String mPartOfSpeech;

  public Definition(String description) {
    mDescription = description;
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

}
