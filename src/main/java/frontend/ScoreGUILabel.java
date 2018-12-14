package frontend;

import javax.swing.*;
import javax.swing.JLabel;

public class ScoreGUILabel extends ScoreGUI {
    public ScoreGUILabel() {
        super();
    }

    public void setScore() {
        score = new JLabel("0");
        this.add(score);
    }

    public void updateScore(String newScore) {
        ((JLabel) score).setText(newScore);
    }

    public String getScore() {
        return ((JLabel) score).getText();
    }
}
