package ch.iso.m120.view;

import ch.iso.m120.controller.*;
import ch.iso.m120.model.Globals;
import ch.iso.m120.model.Highscore;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Builder {
    public static Node buildMainMenu() {
        VBox n = new VBox();
        n.setAlignment(Pos.CENTER);
        n.setSpacing(10);

        Button btnStart = new Button("Start");
        Button btnHighscores = new Button("Highscores");
        Button btnExit = new Button("Exit");

        btnExit.setMinWidth(200);
        btnStart.setMinWidth(200);
        btnHighscores.setMinWidth(200);

        btnExit.setOnAction(new ExitEventHandler());
        btnStart.setOnAction(new StartEventHandler());
        btnHighscores.setOnAction(new HighscoreEventHandler());

        btnExit.getStyleClass().add("menuButton");
        btnHighscores.getStyleClass().add("menuButton");
        btnStart.getStyleClass().add("menuButton");

        n.getChildren().addAll(btnStart,btnHighscores,btnExit);


        return n;
    }
    public static Node buildGame() {
        Canvas can = new Canvas(800,800);
        can.addEventFilter(KeyEvent.KEY_PRESSED, new KeyEventHandler());
        GameLoop loop = new GameLoop(can.getGraphicsContext2D());
        Globals.setGameLoop(loop);
        can.setFocusTraversable(true);
        loop.start();
        return can;
    }

    public static Node buildHighscore() {
        HighscoreTable table = new HighscoreTable();
        return table;
    }

    public static Node buildEndScreen() {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        Text score = new Text("Score: " + Globals.getScore().getScoreText());
        TextField playerName = new TextField();
        playerName.setMaxWidth(200);
        Globals.setEndScreenTextField(playerName);
        Text lol = new Text("Enter Name");
        Globals.setEndScreenText(lol);
        Button btnOk = new Button("Ok");
        btnOk.setOnAction(new EndScreenEventListener());
        box.getChildren().addAll(score,lol,playerName,btnOk);
        return box;
    }
}
