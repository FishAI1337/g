package ch.iso.m120.model;

import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Highscore {
    private String name;
    private String score;
    private String date;


    public Highscore(String name, String score, String date) {
        this.name = name;
        this.score = score;
        this.date = date;

    }

    public Highscore(String name, String score) {
        this.name = name;
        this.score = score;
        this.date = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
