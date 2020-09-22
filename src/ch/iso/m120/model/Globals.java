package ch.iso.m120.model;

import ch.iso.m120.controller.GameLoop;
import ch.iso.m120.view.Circle;
import ch.iso.m120.view.RootPane;
import ch.iso.m120.view.Score;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;


import java.util.ArrayList;

public class Globals {
    private static Circle circle = null;
    private static RootPane rootPane = null;
    private static GraphicsContext gc = null;
    private static GameLoop gameLoop = null;
    private static Score score = null;
    private static MediaPlayer player = null;
    private static TextField endScreenTextField = null;
    private static Text endScreenText = null;

    public static RootPane getRootPane() {
        return rootPane;
    }

    public static void setRootPane(RootPane rootPane) {
        Globals.rootPane = rootPane;
    }

    public static GraphicsContext getGc() {
        return gc;
    }

    public static void setGc(GraphicsContext gc) {
        Globals.gc = gc;
    }

    public static GameLoop getGameLoop() {
        return gameLoop;
    }

    public static void setGameLoop(GameLoop gameLoop) {
        Globals.gameLoop = gameLoop;
    }

    public static Circle getCircle() {
        return circle;
    }

    public static void setCircle(Circle circle) {
        Globals.circle = circle;
    }

    public static Score getScore() {
        return score;
    }

    public static void setScore(Score score) {
        Globals.score = score;
    }

    public static MediaPlayer getPlayer() {
        return player;
    }

    public static void setPlayer(MediaPlayer player) {
        Globals.player = player;
    }

    public static TextField getEndScreenTextField() {
        return endScreenTextField;
    }

    public static void setEndScreenTextField(TextField endScreenTextField) {
        Globals.endScreenTextField = endScreenTextField;
    }

    public static Text getEndScreenText() {
        return endScreenText;
    }

    public static void setEndScreenText(Text endScreenText) {
        Globals.endScreenText = endScreenText;
    }
}

