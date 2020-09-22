package ch.iso.m120.view;

import ch.iso.m120.model.Config;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class targetCircles {
    private double outerCircleWidth = 70;
    private double outerCircleHeight = 70;
    private double outerleft;
    private double innerleft;
    private double innerright;
    private double outerright;
    private double targetY = Config.getLineYPosition();
    private Color circleColor;



    public targetCircles() {
        outerleft = Config.getOuterLeftStartingXPosition();
        innerleft = Config.getInnerLeftStartingXPosition();
        innerright = Config.getInnerRightStartingXPosition();
        outerright = Config.getOuterRightStartingXPosition();
        circleColor = Config.getTargetCircleColor();

    }


    public double getOuterleft() {
        return outerleft;
    }


    public double getInnerleft() {
        return innerleft;
    }


    public double getInnerright() {
        return innerright;
    }


    public double getOuterright() {
        return outerright;
    }


    public double getTargetY() {
        return targetY;
    }


    public Color getCircleColor() {
        return circleColor;
    }


    public double getOuterCircleWidth() {
        return outerCircleWidth;
    }


    public double getOuterCircleHeight() {
        return outerCircleHeight;
    }
    
}


