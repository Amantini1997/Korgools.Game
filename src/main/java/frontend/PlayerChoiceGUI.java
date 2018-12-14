package frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/** Panel with initial screen, which lets the player choose the number of players */
public class PlayerChoiceGUI extends JPanel {
    private static final String ONE_PLAYER_TEXT = "One Player";
    private static final String TWO_PLAYER_TEXT = "Two Player";

    private String boardString;

    public PlayerChoiceGUI() {
        this.setLayout(new BorderLayout());
        this.add(setCenter(), BorderLayout.CENTER);
    }

    public PlayerChoiceGUI(String boardString) {
        this();
        this.boardString = boardString;
    }

    /** Set center of this panel with two buttons in the middle */
    private JPanel setCenter() {
        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());
        center.add(creatOptionButton(ONE_PLAYER_TEXT));
        center.add(creatOptionButton(TWO_PLAYER_TEXT));
        return center;
    }

    /**
     * Update the window content based on button press. It may create new game or it may show the
     * board to input the game scenario.
     */
    private void getNewScreen(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        // What was one the button?
        switch (((JButton) e.getSource()).getText()) {
            case (ONE_PLAYER_TEXT):
                {
                    // Go to choose difficulty screen
                    if (boardString == null) {
                        frame.setContentPane(new AIChoiceGUI());
                    } else {
                        frame.setContentPane(new AIChoiceGUI(boardString));
                    }



                    break;
                }
            case (TWO_PLAYER_TEXT):
                {
                    // Go to Board GUI screen but start with Board not AIBoard (hardness = -1)
                    if (boardString == null) {
                        frame.setContentPane(new BoardGUI(-1));
                    } else {
                        frame.setContentPane(new BoardGUI(boardString, -1));
                    }
                    break;
                }
        }
        frame.pack();
        frame.repaint();
    }

    /** Create new button with ActionListener. */
    private JButton creatOptionButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> getNewScreen(e));
        button.setName(text);
        return button;
    }
}
