package ch.iso.m120.model;

import ch.iso.m120.view.HighscoreTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HighscoreObservableList {
    private final static ObservableList<Highscore> data = FXCollections.observableArrayList();
    private static HighscoreTable table;

    public static ObservableList<Highscore> getData() {
        return data;
    }

    public static void setTable(HighscoreTable highscoreTable) {
        table = highscoreTable;
    }

    public static HighscoreTable getTable() {
        return table;
    }
}
