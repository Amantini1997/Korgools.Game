package frontend;

import java.awt.Color;
import java.awt.event.MouseAdapter;

/**
 * Input the player that needs to be reversed in the UI. The player who's holes need to be numbered
 * 9-1 instead of 1-9.
 */
public class InputReversedPlayer extends ReversedPlayer {

    public InputReversedPlayer(MouseAdapter listener) {
        super(0, listener);
        scoreLabel = new ScoreGUITextField();
        scoreLabel.setName("blackInput");
        super.setBackground(Color.BLACK);
    }

    public String playerString() {
        String returnString = "";
        for (Hole hole : holes) {
            returnString += hole.getNumberOfKorgools() + ",";
        }
        returnString += getScore() + ",";
        returnString += addTuz();
        return returnString;
    }

    public int addTuz() {
        for (Hole hole : holes) {
            if (hole.isTuz()) {
                return hole.getIndex();
            }
        }
        return -1;
    }

    public int getAllHolesScores() {
        int sum = 0;
        for (Hole hole : holes) {
            sum += (hole.getNumberOfKorgools());
        }
        return sum;
    }

    public String getScore() {
        return scoreLabel.getScore();
    }
}
