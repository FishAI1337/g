package ch.iso.m120.controller;

import ch.iso.m120.model.Database;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ExitEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Database.getINSTANCE().saveData();
        Platform.exit();
    }
}
