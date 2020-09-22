package ch.iso.m120.controller;

import ch.iso.m120.model.Config;
import ch.iso.m120.view.Circle;
import ch.iso.m120.model.Globals;
import ch.iso.m120.view.Score;
import ch.iso.m120.view.targetCircles;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;



public class GameLoop extends AnimationTimer {
    private Circle c;
    private GraphicsContext gc = null;
    private targetCircles scoreCircles;
    private Score score;
    private int waitFrames;
    private int targetWaitFrames;
    private CircleSpawner spawner;


    public GameLoop(GraphicsContext gc) {
        this.gc = gc;
        this.scoreCircles = new targetCircles();
        this.score = new Score();
        this.waitFrames = 60;
        this.targetWaitFrames = (Config.getWaitBeforeStartingInSeconds()*60);
        this.spawner = new CircleSpawner(1,60,103);
        this.c = spawner.getNextCircle();
        Globals.setCircle(this.c);
        Globals.setGameLoop(this);
        Globals.setScore(this.score);
    }

    @Override
    public void handle(long now) {
        gc.clearRect(0,0,800,800);
        if (waitFrames < targetWaitFrames) {
            waitFrames++;
        } else {
            drawCircle();
        }
        drawTargetCircles(scoreCircles);
        drawScore(score);
        if (score.getNumFailures()> Config.getFailuresToEnd()) {
            drawEndscreen();
        }

    }

    private void drawCircle() {
        gc.setFill(c.getColor());
        gc.fillOval(c.getX(),c.getY(),c.getWidth(),c.getHeight());
        gc.setStroke(c.getBorderColor());
        gc.setLineWidth(c.getBorderThicc());
        gc.strokeOval(c.getX(), c.getY(), c.getWidth(), c.getHeight());
        c.setY(c.getY() + c.getyIncrement());

        if (c.getY() > Config.getCircleDespawnYPosition()) {
            if (!c.isWasHit()) {
                score.addFailure(1);
            }
            c = spawner.getNextCircle();
            Globals.setCircle(c);
            }

    }


    private void drawTargetCircles(targetCircles tc) {
        gc.setStroke(tc.getCircleColor());
        gc.strokeOval(tc.getInnerright(), tc.getTargetY(), tc.getOuterCircleWidth(), tc.getOuterCircleHeight());
        gc.strokeOval(tc.getInnerleft(), tc.getTargetY(), tc.getOuterCircleWidth(), tc.getOuterCircleHeight());
        gc.strokeOval(tc.getOuterright(), tc.getTargetY(), tc.getOuterCircleWidth(), tc.getOuterCircleHeight());
        gc.strokeOval(tc.getOuterleft(), tc.getTargetY(), tc.getOuterCircleWidth(), tc.getOuterCircleHeight());

    }
    private void drawScore(Score score) {
        gc.setFill(score.getColor());
        gc.setFont(Font.font(20));
        gc.fillText(score.getScoreText(), score.getScoreX(), score.getScoreY());

    }

    private void drawEndscreen() {
        this.stop();
        Globals.getPlayer().stop();
        Globals.getRootPane().setEndScreen();
    }
}
