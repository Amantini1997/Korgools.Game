package frontend;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** The class that holds the logic and data for the player that the use is using */
public class NormalPlayer extends Player {
    protected int number = 1;

    public NormalPlayer(int numberOfKorgools, MouseAdapter listener) {
        super(numberOfKorgools, listener);
        super.setBackground(Color.WHITE);
        addHoles();
        setNames();
        this.scoreLabel.setName("whiteScore");
    }

    private void addHoles() {
        for (Hole hole : holes) {
            JPanel holeInfo = new JPanel();
            holeInfo.setLayout(new GridLayout(2, 1));
            JLabel holeNumber = new JLabel(hole.getIndex() + 1 + "", SwingConstants.CENTER);
            holeNumber.setOpaque(true);
            holeNumber.setForeground(Color.BLACK);
            holeInfo.add(hole);
            holeInfo.add(holeNumber);
            holeNumber.setBackground(Color.WHITE);
            holesPanel.add(holeInfo);
        }
    }

    private void setNames() {
        for (Hole hole : holes) {
            hole.setName("Hole" + number);
            number = (number + 1) % (10);
            if (number == 0) {
                number = 1;
            }
        }
    }
}
