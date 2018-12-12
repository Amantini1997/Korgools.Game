package frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Gui that allows the player to input a game state and start from that board. Allows the user to
 * practice certain game scenarios and also practice game scenarios that are unreachable with a
 * normal playthrough
 */
public class InputGUI extends JPanel {
    private InputReversedPlayer black;
    private InputNormalPlayer white;
    private InputHoleListener mouseClickWhite = new InputHoleListener(null);
    private InputHoleListener mouseClickBlack = new InputHoleListener(null);
    private JLabel errorText = new JLabel();
    private JButton startButton = new JButton("START GAME");

    public InputGUI() {
        startButton.addActionListener(e -> startGame(e));
        startButton.setName("startGame");
        this.setLayout(new BorderLayout());
        JPanel game = new JPanel();
        game.setLayout(new GridLayout(3, 1));
        black = new InputReversedPlayer(mouseClickBlack);
        game.add(black.showHoles());
        white = new InputNormalPlayer(mouseClickWhite);
        mouseClickWhite.setPlayers(white, black);
        mouseClickBlack.setPlayers(black, white);
        game.add(setCenter());
        game.add(white.showHoles());
        this.add(errorText, BorderLayout.PAGE_START);
        this.add(game, BorderLayout.CENTER);
        this.add(startButton, BorderLayout.PAGE_END);
    }

    /**
     * Tries to create the board and start the game, checking that it matches certain requirements
     * like that the total number of kargoolz is smaller or equal to 162.
     */
    private void startGame(ActionEvent e) {
        try {
            int white1 = white.getAllHolesScores() + Integer.parseInt(white.getScore());
            int black2 = black.getAllHolesScores() + Integer.parseInt(black.getScore());

            if (white1 + black2 > 162) {
                errorText.setText(
                        "Incorrect number of balls: Please remove "
                                + ((white1 + black2) - 162)
                                + " balls");
            } else if (white1 + black2 < 162) {
                errorText.setText(
                        "Incorrect number of balls: Please add "
                                + (162 - (white1 + black2))
                                + " balls");
            } else {
                JFrame frame = (JFrame) SwingUtilities.getRoot(this);

                System.out.println(white.playerString() + "\n" + black.playerString() + "\n" + "w");

                PlayerChoiceGUI playerChoiceGUI =
                        new PlayerChoiceGUI(
                                black.playerString() + "\n" + white.playerString() + "\n" + "w");

                frame.setContentPane(playerChoiceGUI);
                frame.revalidate();
                frame.repaint();
            }
        } catch (NumberFormatException err) {
            errorText.setText("Incorrect format type");
        }
    }

    private JPanel setCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        center.add(black.showScoreLabel());
        center.add(white.showScoreLabel());
        return center;
    }
}
