package ch.iso.m120.model;


import javafx.scene.paint.Color;

public class Config {
    private static int waitBeforeStartingInSeconds = 1;

    private static Color circleDefaultColor = Color.rgb(0, 255, 64);
    private static Color circleBorderColor = Color.rgb(255, 255, 255);
    private static int CircleBorderSize = 2;
    private static int failuresToEnd = 10;

    private static int perfectScoreGain = 10;
    private static int goodScoreGain = 5;
    private static int okScoreGain = 2;

    private static double scoreXPosition = 15;
    private static double scoreYPosition = 40;

    private static double circleDespawnYPosition = 1100f;
    private static int lineYPosition = 700;


    private static int OuterLeftStartingXPosition = 70;
    private static int InnerLeftStartingXPosition = 270;
    private static int InnerRightStartingXPosition = 470;
    private static int OuterRightStartingXPosition = 670;

    private static double perfectMargin = 0.1;
    private static double perfectMarginHigh = lineYPosition + (lineYPosition * perfectMargin);
    private static double perfectMarginLow = lineYPosition - (lineYPosition * perfectMargin);
    private static double goodMargin = 0.3;
    private static double goodMarginHigh = lineYPosition + (lineYPosition * goodMargin);
    private static double goodMarginLow = lineYPosition - (lineYPosition * goodMargin);
    private static double okMargin = 0.5;
    private static double okMarginHigh = lineYPosition + (lineYPosition * okMargin);
    private static double okMarginLow = lineYPosition - (lineYPosition * okMargin);
    private static Color targetCircleColor = Color.rgb(255, 255, 255);

    public static int getWaitBeforeStartingInSeconds() {
        return waitBeforeStartingInSeconds;
    }

    public static Color getCircleDefaultColor() {
        return circleDefaultColor;
    }

    public static int getFailuresToEnd() {
        return failuresToEnd;
    }

    public static int getPerfectScoreGain() {
        return perfectScoreGain;
    }

    public static int getGoodScoreGain() {
        return goodScoreGain;
    }

    public static int getOkScoreGain() {
        return okScoreGain;
    }

    public static double getScoreXPosition() {
        return scoreXPosition;
    }

    public static double getScoreYPosition() {
        return scoreYPosition;
    }

    public static double getCircleDespawnYPosition() {
        return circleDespawnYPosition;
    }

    public static int getLineYPosition() {
        return lineYPosition;
    }

    public static double getPerfectMargin() {
        return perfectMargin;
    }

    public static double getPerfectMarginHigh() {
        return perfectMarginHigh;
    }

    public static double getPerfectMarginLow() {
        return perfectMarginLow;
    }

    public static double getGoodMargin() {
        return goodMargin;
    }

    public static double getGoodMarginHigh() {
        return goodMarginHigh;
    }

    public static double getGoodMarginLow() {
        return goodMarginLow;
    }

    public static double getOkMargin() {
        return okMargin;
    }

    public static double getOkMarginHigh() {
        return okMarginHigh;
    }

    public static double getOkMarginLow() {
        return okMarginLow;
    }

    public static int getOuterLeftStartingXPosition() {
        return OuterLeftStartingXPosition;
    }

    public static int getInnerLeftStartingXPosition() {
        return InnerLeftStartingXPosition;
    }

    public static int getInnerRightStartingXPosition() {
        return InnerRightStartingXPosition;
    }

    public static int getOuterRightStartingXPosition() {
        return OuterRightStartingXPosition;
    }

    public static int getCircleBorderSize() {
        return CircleBorderSize;
    }

    public static Color getCircleBorderColor() {
        return circleBorderColor;
    }

    public static Color getTargetCircleColor() {
        return targetCircleColor;
    }
}


