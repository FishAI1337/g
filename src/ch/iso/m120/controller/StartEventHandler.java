package ch.iso.m120.controller;

import ch.iso.m120.model.Globals;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Globals.getRootPane().setGame();

    }
}
