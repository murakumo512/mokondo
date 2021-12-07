package id.ac.ukdw.fti.rpl.mokondo;
//disini buat masukin code yang dari scene builder

import java.net.URL;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.rpl.mokondo.database.Database;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import id.ac.ukdw.fti.rpl.mokondo.modal.Verses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class FXMLController implements Initializable {

    private ObservableList<Verses> verses = FXCollections.observableArrayList();

    @FXML
    private TextField cariField;

    @FXML
    private ComboBox<Verses> verseBook = new ComboBox<Verses>();

    @FXML
    private TableView<Verses> tableVerses;

    @FXML
    private TableColumn<Verses, Integer> verseIdColumn;

    @FXML
    private TableColumn<Verses, String> verseColumn;

    @FXML
    private TableColumn<Verses, String> verseTextColumn;

    @FXML
    private TableColumn<Verses, String> versePlacesColumn;

    @FXML
    private TableColumn<Verses, Integer> verseLongtitudeColumn;

    @FXML
    private TableColumn<Verses, Integer> verseAltitudeColumn;

    @FXML
    void search(KeyEvent event) {
        //hehe
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verses = Database.instance.getAllVerses();
        verseIdColumn.setCellValueFactory(new PropertyValueFactory<Verses, Integer>("verseId"));
        verseColumn.setCellValueFactory(new PropertyValueFactory<Verses, String>("verse"));
        verseTextColumn.setCellValueFactory(new PropertyValueFactory<Verses,String>("verseText"));
        versePlacesColumn.setCellValueFactory(new PropertyValueFactory<Verses, String>("versePlace"));
        verseLongtitudeColumn.setCellValueFactory(new PropertyValueFactory<Verses, Integer>("verseLongtitude"));
        verseAltitudeColumn.setCellValueFactory(new PropertyValueFactory<Verses, Integer>("verseAltitude"));
        // verseBook.setCellValueFactory(new PropertyValueFactory<Verses, String>("verseBook"));
        
        //filter list 2
        FilteredList<Verses> filteredData = new FilteredList<>(verses, e -> true);
        cariField.textProperty().addListener((observableValue, oldValue, newValue) ->{
            filteredData.setPredicate(verses -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                String aa = verses.getVersePlace().toLowerCase();
                if(aa.contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        });
        SortedList<Verses> verses = new SortedList<>(filteredData);
        verses.comparatorProperty().bind(tableVerses.comparatorProperty());
        tableVerses.setItems(verses);
    }

    
}
