package ch.iso.m120.view;

import ch.iso.m120.model.Config;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Score {
    private int score;
    private double scoreX;
    private double scoreY;
    private Color color = Color.WHITE;
    private int numFailures;

    public Score() {
        this.score = 0;
        this.scoreX = Config.getScoreXPosition();
        this.scoreY = Config.getScoreYPosition();
        this.numFailures = 0;



    }

    public void addScore(int points) {
        this.score += points;
    }

    public void addFailure(int fail) {
        this.numFailures += fail;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getScoreX() {
        return scoreX;
    }

    public void setScoreX(double scoreX) {
        this.scoreX = scoreX;
    }

    public double getScoreY() {
        return scoreY;
    }

    public void setScoreY(double scoreY) {
        this.scoreY = scoreY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getScoreText() {
        return Integer.toString(this.score);
    }

    public int getNumFailures() {
        return numFailures;
    }

    public void setNumFailures(int numFailures) {
        this.numFailures = numFailures;
    }
}
