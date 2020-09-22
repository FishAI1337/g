package ch.iso.m120.view;

import ch.iso.m120.controller.ExitToMainMenuEventHandler;
import ch.iso.m120.model.Database;
import ch.iso.m120.model.Globals;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class RootPane extends BorderPane {
    public RootPane() {
        super();
        this.setMinHeight(800);
        this.setMinWidth(800);
        this.setCenter(Builder.buildMainMenu());
        this.getStyleClass().add("mainMenuPanel");
        Globals.setRootPane(this);

    }
    public void setGame() {
        this.setCenter(Builder.buildGame());
        Button b = new Button("Exit");
        b.setOnAction(new ExitToMainMenuEventHandler());
        b.setMinWidth(800);
        b.getStyleClass().add("menuButton");
        File file = new File("resources/soundtrack.mp3");
        MediaPlayer lol = new MediaPlayer(
                new Media(file.toURI().toString())
        );
        Globals.setPlayer(lol);
        lol.play();
        lol.setOnEndOfMedia(() -> lol.seek(Duration.ZERO));
        this.setBottom(b);
    }
    public void setMainMenu() {
        this.setCenter(Builder.buildMainMenu());
        this.setBottom(null);
        if (Globals.getGameLoop() != null) {
            Globals.getGameLoop().stop();
            Globals.getPlayer().stop();
        }
    }

    public void setHighScore() {
        this.setCenter(Builder.buildHighscore());
        Button b = new Button("Exit");
        b.setOnAction(new ExitToMainMenuEventHandler());
        b.setMinWidth(800);
        b.getStyleClass().add("menuButton");
        this.setBottom(b);

    }

    public void setEndScreen() {
        this.setCenter(Builder.buildEndScreen());
        this.setBottom(null);

    }
}
