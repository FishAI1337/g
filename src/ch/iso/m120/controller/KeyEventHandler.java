package ch.iso.m120.controller;

import ch.iso.m120.view.Circle;
import ch.iso.m120.model.Config;
import ch.iso.m120.model.Globals;
import ch.iso.m120.view.Score;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class KeyEventHandler implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) {
        Circle c = Globals.getCircle();
        Score s = Globals.getScore();
        if (c.getCircleKey() == event.getCode() && !c.isWasHit()) {
            switch (c.checkAccuracy()) {
                case 1:
                    System.out.println("Perfect");
                    s.addScore(Config.getPerfectScoreGain());
                    c.setWasHit(true);
                    c.setColor(Color.RED);
                    break;
                case 2:
                    System.out.println("Good");
                    s.addScore(Config.getGoodScoreGain());
                    c.setWasHit(true);
                    c.setColor(Color.RED);
                    break;
                case 3:
                    System.out.println("Ok");
                    s.addScore(Config.getOkScoreGain());
                    c.setWasHit(true);
                    c.setColor(Color.RED);
                    break;
                case 4:
                    System.out.println("Are you even trying?");
                    c.setWasHit(true);
                    c.setColor(Color.RED);
                    Globals.getScore().addFailure(1);
                    break;

            }
        }

    }
}

