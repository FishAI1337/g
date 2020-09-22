package ch.iso.m120.view;

import ch.iso.m120.model.Highscore;
import ch.iso.m120.model.HighscoreObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HighscoreTable extends TableView<Highscore> {
    public HighscoreTable() {
        super();



        // define columns
        TableColumn<Highscore, String> nameCal = new TableColumn<Highscore, String>("Name");
        nameCal.getStyleClass().add("tableColumn");
        nameCal.setCellValueFactory(new PropertyValueFactory<Highscore, String>("name"));
        nameCal.setPrefWidth(266);


        TableColumn<Highscore, String> scoreCal = new TableColumn<Highscore, String>("Score");
        scoreCal.getStyleClass().add("tableColumn");
        scoreCal.setCellValueFactory(new PropertyValueFactory<Highscore, String>("score"));
        scoreCal.setPrefWidth(265);

        TableColumn<Highscore, String> dateCal = new TableColumn<Highscore, String>("Date");
        dateCal.getStyleClass().add("tableColumn");
        dateCal.setCellValueFactory(new PropertyValueFactory<Highscore, String>("date"));
        dateCal.setPrefWidth(266);

        //add columns
        this.getColumns().addAll(nameCal, scoreCal, dateCal);

        this.setItems(HighscoreObservableList.getData());

        HighscoreObservableList.setTable(this);
    }
}
