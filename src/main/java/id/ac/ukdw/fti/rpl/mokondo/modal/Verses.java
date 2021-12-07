package id.ac.ukdw.fti.rpl.mokondo.modal;

public class Verses {
    private int verseId;
    private String verse;
    private String verseText;
    private String versePlace;
    private String verseCari;
    private String verseBook;
    private int verseAltitude;
    private int verseLongtitude;

    public void setVerseId(int verseId) {
       this.verseId = verseId;
    }

    public void setVerseAltitude(int verseAltitude) {
        this.verseAltitude = verseAltitude;
     }

    public void setVerseLongtitude(int verseLongtitude) {
       this.verseLongtitude = verseLongtitude;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public void setVerseText(String verseText) {
        this.verseText = verseText;
    }

    public void setVersePlace(String versePlace) {
        this.versePlace = versePlace;
    }

    public void setVerseCari(String verseCari) {
        this.verseCari = verseCari;
    }

    public void setVerseBook(String verseBook) {
        this.verseBook = verseBook;
    }

    public int getVerseId() {
        return this.verseId;
    }

    public int getverseAltitude() {
        return this.verseAltitude;
    }

    public int getverseLongtitude() {
        return this.verseLongtitude;
    }

    public String getVerse() {
        return this.verse;
    }

    public String getVerseText() {
        return this.verseText;
    }

    public String getVersePlace() {
        return this.versePlace;
    }

    public String getVerseCari() {
        return this.verseCari;
    }

    public String getverseBook() {
        return this.verseBook;
    }
}
