package frontend;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.util.Collections;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** The player who's cells are numbered 9-1 instead of 1-9. Default it's the computer using it. */
public class ReversedPlayer extends Player {
    protected int number = -1;

    public ReversedPlayer(int numberOfKorgools, MouseAdapter listener) {
        super(numberOfKorgools, listener);
        Collections.reverse(holes);
        super.setBackground(Color.BLACK);
        addHoles();

        this.scoreLabel.setName("blackScore");

        Collections.reverse(holes);
        setNames();
    }

    private void addHoles() {
        for (Hole hole : holes) {
            JPanel holeInfo = new JPanel();
            holeInfo.setLayout(new GridLayout(2, 1));
            JLabel holeNumber = new JLabel(hole.getIndex() + 1 + "", SwingConstants.CENTER);
            holeNumber.setOpaque(true);
            holeNumber.setForeground(Color.WHITE);
            holeInfo.add(holeNumber);
            holeInfo.add(hole);
            holeNumber.setBackground(Color.BLACK);
            holesPanel.add(holeInfo);

            hole.setName("blackHole" + hole.getIndex());
        }
    }

    private void setNames() {
        for (Hole hole : holes) {
            hole.setName("Hole" + number);
            number = (number - 1) % (-10);
            if (number == 0) {
                number = -1;
            }
        }
    }
}
