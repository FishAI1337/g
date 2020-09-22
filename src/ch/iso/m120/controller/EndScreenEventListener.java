package ch.iso.m120.controller;

import ch.iso.m120.model.Database;
import ch.iso.m120.model.Globals;
import ch.iso.m120.model.Highscore;
import ch.iso.m120.model.HighscoreObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.regex.Pattern;

public class EndScreenEventListener implements EventHandler<ActionEvent> {
    private String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ ";


    @Override
    public void handle(ActionEvent event) {
        String scoreScore = Integer.toString(Globals.getScore().getScore());
        String scoreName = Globals.getEndScreenTextField().getText();
        TextField endScreenTextField = Globals.getEndScreenTextField();
        Text endScreenText = Globals.getEndScreenText();

        if ((checkSpecialChars(scoreName)) && (scoreName != null)) {
            endScreenTextField.clear();
            endScreenTextField.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            endScreenText.setText("( ͡° ͜ʖ ͡°) NO SPECIAL CHARACTERS ALLOWED!!!!!!!!!!!!!!! ( ͡° ͜ʖ ͡°)");
            endScreenText.setFont(new Font("COMIC SANS MS", 24));

        } else {
            endScreenTextField.setBorder(null);
            HighscoreObservableList.getData().add(new Highscore(scoreName.strip(),scoreScore));
            Database.getINSTANCE().saveData();
            Database.getINSTANCE().loadData();
            Globals.getRootPane().setHighScore();
        }

    }

    private boolean checkSpecialChars(String string) {

        boolean[] allowed = new boolean[string.length()];

        for (int i = 0; i<string.length(); i++) {
            for (int j = 0; j < allowedChars.length(); j++) {
                if (string.charAt(i) == allowedChars.charAt(j)) {
                    allowed[i] = true;
                    break;
                }
            }
        }

        for (Boolean b: allowed) {
            if (!b) {
                return true;
            }
        }
        return false;
        }

    }

