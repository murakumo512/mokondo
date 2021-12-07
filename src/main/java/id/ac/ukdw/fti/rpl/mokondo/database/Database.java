package id.ac.ukdw.fti.rpl.mokondo.database;
import id.ac.ukdw.fti.rpl.mokondo.modal.Verses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    final String querySelect = "SELECT verses.verseID, verses.osisRef, verses.verseText, verses.book, places_translate.displayTitle, places.latitude FROM verses INNER JOIN places_translate ON verses.osisRef = places_translate.verses INNER JOIN places ON places_translate.displayTitle = places.displayTitle";
    final String url = "jdbc:sqlite:vizbible.db";
    private ObservableList<Verses> verses = FXCollections.observableArrayList();
    private Connection connection = null;
    public static Database instance = new Database();

    public Database() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<Verses> getAllVerses() {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()) {
                Verses verse = new Verses();
                // verse.setVerseBook(result.getString("book"));
                verse.setVerseId(result.getInt("verseID"));
                verse.setVerse(result.getString("osisRef"));
                verse.setVerseText(result.getString("verseText"));
                verse.setVersePlace(result.getString("displayTitle"));
                // verse.setVerseAltitude(result.getInt("latitude"));
                // verse.setVerseLongtitude(result.getInt("longitude"));
                verses.add(verse);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return verses;
    }

	public Connection openConnection(Database database) {
	    return database.connection;
	}
}

