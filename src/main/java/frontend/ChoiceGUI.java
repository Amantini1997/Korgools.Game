package frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/** Panel with initial screen, which lets the player choose game type */
public class ChoiceGUI extends JPanel {
    private static final String NEW_BUTTON_TEXT = "New Game";
    private static final String INPUT_BUTTON_TEXT = "Input Game";
    private static final String LOAD_PREVIOUS_GAME_TEXT = "Load Game";

    public ChoiceGUI() {
        this.setLayout(new BorderLayout());
        this.add(setCenter(), BorderLayout.CENTER);
    }

    /** Set center of this panel with two buttons in the middle */
    private JPanel setCenter() {
        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());
        center.add(creatOptionButton(NEW_BUTTON_TEXT));
        center.add(creatOptionButton(INPUT_BUTTON_TEXT));
        center.add(creatOptionButton(LOAD_PREVIOUS_GAME_TEXT));
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
            case (NEW_BUTTON_TEXT):
                {
                    frame.setContentPane(new PlayerChoiceGUI());
                    break;
                }
            case (INPUT_BUTTON_TEXT):
                {
                    frame.setContentPane(new InputGUI());
                    break;
                }
            case (LOAD_PREVIOUS_GAME_TEXT):
                {
                    // fetch the game state from the document
                    try {
                        BufferedReader reader =
                                new BufferedReader(new FileReader("src/main/java/gameSaves.txt"));

                        int level = Integer.parseInt(reader.readLine());

                        String boardState = "";
                        String line;
                        while ((line = reader.readLine()) != null) {
                            boardState += line + "\n";
                        }

                        // set the game state
                        BoardGUI boardGUI = new BoardGUI(boardState, level);
                        // display it
                        frame.setContentPane(boardGUI);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        frame.setContentPane(new PlayerChoiceGUI());
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
        button.setName(text);
        button.addActionListener(e -> getNewScreen(e));
        button.setName(text);
        return button;
    }
}
