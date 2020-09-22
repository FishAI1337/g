package ch.iso.m120.view;

import ch.iso.m120.model.Config;
import ch.iso.m120.model.Globals;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Circle {
    private Color color;
    private int width;
    private int height;
    private double x;
    private double y;
    private double yIncrement;
    private double baseYIncrement;
    private double bps;
    private int type;
    private KeyCode circleKey;
    private static int OuterLeftStartingXPosition = Config.getOuterLeftStartingXPosition();
    private static int InnerLeftStartingXPosition = Config.getInnerLeftStartingXPosition();
    private static int InnerRightStartingXPosition = Config.getInnerRightStartingXPosition();
    private static int OuterRightStartingXPosition = Config.getOuterRightStartingXPosition();
    private static int YStartingPosition = 0;
    private boolean wasHit;
    private int borderThicc;
    private Color borderColor;





    public Circle(int type, float bpm) {
        this.color = Config.getCircleDefaultColor();
        this.height = 70;
        this.width = 70;
        this.borderThicc = Config.getCircleBorderSize();
        this.borderColor = Config.getCircleBorderColor();
        this.y = YStartingPosition;
        this.baseYIncrement = Config.getCircleDespawnYPosition()/60;
        this.type = type;
        this.wasHit = false;
        this.bps = bpm/60;
        this.yIncrement = baseYIncrement*bps;
        switch (type) {
            case 0:
                this.x = OuterLeftStartingXPosition;
                this.circleKey = KeyCode.A;
                break;
            case 1:
                this.x = InnerLeftStartingXPosition;
                this.circleKey = KeyCode.S;
                break;
            case 2:
                this.x = InnerRightStartingXPosition;
                this.circleKey = KeyCode.D;
                break;
            case 3:
                this.x = OuterRightStartingXPosition;
                this.circleKey = KeyCode.F;
                break;

        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getyIncrement() {
        return yIncrement;
    }

    public void setyIncrement(int yIncrement) {
        this.yIncrement = yIncrement;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Color getColor() {
        return color;

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isWasHit() {
        return wasHit;
    }

    public void setWasHit(boolean wasHit) {
        this.wasHit = wasHit;
    }

    public KeyCode getCircleKey() {
        return circleKey;
    }

    public void setCircleKey(KeyCode circleKey) {
        this.circleKey = circleKey;
    }

    public void setyIncrement(double yIncrement) {
        this.yIncrement = yIncrement;
    }

    public double getBaseYIncrement() {
        return baseYIncrement;
    }

    public void setBaseYIncrement(double baseYIncrement) {
        this.baseYIncrement = baseYIncrement;
    }

    public double getBps() {
        return bps;
    }

    public void setBps(double bps) {
        this.bps = bps;
    }

    public void reset() {
        this.setY(YStartingPosition);
        this.color = Config.getCircleDefaultColor();
        if (!this.wasHit) {
            Globals.getScore().addFailure(1);
        }
        this.wasHit = false;


    }

    public int checkAccuracy() {
        if (this.getY() < Config.getPerfectMarginHigh() && this.getY() > Config.getPerfectMarginLow()) {
            return 1;
        } else if (this.getY() < Config.getGoodMarginHigh() && this.getY() > Config.getGoodMarginLow()) {
            return 2;
        } else if (this.getY() < Config.getOkMarginHigh() && this.getY() > Config.getOkMarginLow()) {
            return 3;
        } else {
            return 4;
        }
    }

    public Paint getBorderColor() {
        return borderColor;
    }

    public int getBorderThicc() {
        return borderThicc;
    }
}
