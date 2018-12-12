package frontend;

import backend.*;
import backend.Board;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/** Panel with the board game */
public class BoardGUI extends JPanel {
    private Board board;
    private Player black;
    private Player white;

    private MouseAdapter mouseClick =
            new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (((Hole) e.getSource()).isEnabled()) {
                        System.out.println("\n This is the board before the move:");
                        System.out.println(board);
                        System.out.println("NAME: " + ((Hole) e.getSource()).getName());
                        int indexOfHole = ((Hole) e.getSource()).getIndex();
                        // call backend, and tell them the index of the cell that has been clicked

                        // get necessary information from backend to update the state of the
                        // game/GUI
                        boolean hasWon = board.makeAMove(indexOfHole);
                        updateGUI(board.toString());
                        System.out.println("This is the board after the move:");
                        System.out.println("BUTTON PRESSED: " + indexOfHole);
                        System.out.println(board);
                        if (hasWon) {
                            JOptionPane.showMessageDialog(null, "Congratulations, you won!");
                            JFrame frame = (JFrame) SwingUtilities.getRoot((Hole) e.getSource());
                            frame.setContentPane(new ChoiceGUI());
                            frame.pack();
                            frame.repaint();
                            frame.revalidate();
                        }
                    }
                }
            };

    /**
     * Creates a board given the difficulty selected from the user
     *
     * @param hardness the difficulty of the game AI (0 for no AI (2 player), 1 easy (random), 2
     *     (medium), 3 (hard))
     */
    public BoardGUI(int hardness) {
        if (hardness == -1) {
            board = new Board();
        } else {
            board = new AIBoard(hardness);
        }
        this.setLayout(new GridLayout(3, 1));
        black = new ReversedPlayer(9, mouseClick);
        this.add(black.showHoles());
        white = new NormalPlayer(9, mouseClick);
        this.add(setCenter());
        this.add(white.showHoles());
        this.setName("boardGUI");
        updateGUI(board.toString());
    }

    /**
     * Creates a new board given the board string and the difficulty of the AI that must be created
     *
     * @param boardString
     * @param hardness
     */
    public BoardGUI(String boardString, int hardness) {
        this(hardness);
        if (hardness == -1) {
            board = new Board(boardString);
        } else {
            this.board = new AIBoard(boardString, hardness);
        }

        updateGUI(board.toString());
    }

    /**
     * Recreates the centre of the JPanel
     *
     * @return the center component of the GUI
     */
    private JPanel setCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        center.add(black.showScoreLabel());
        center.add(white.showScoreLabel());
        return center;
    }

    /**
     * Updates the board GUI
     *
     * @param boardState The value of the board string that is sent to the GUI
     */
    private void updateGUI(String boardState) {
        String[] info = boardState.split("\n");
        black.update(info[0]);
        white.update(info[1]);
        blockPlayer(info[2]);
        this.repaint();
        this.revalidate();
        if (SwingUtilities.getRoot(this) != null) {
            JFrame frame = (JFrame) SwingUtilities.getRoot(this);
            frame.pack();
        }
    }

    /**
     * Getter for the board displayed
     *
     * @return The board displayed
     */
    public Board getBoardDisplayed() {
        return board;
    }

    /**
     * Grays out a section of the board not allowing the player to click his buttons (when the other
     * player is taking his turn)
     *
     * @param player The player you want to block from clicking the GUI
     */
    private void blockPlayer(String player) {
        if (player.equals("w")) {
            white.block0Holes();
            black.blockHoles();
            white.unblockHoles();
        } else {
            black.block0Holes();
            white.blockHoles();
            black.unblockHoles();
        }
    }

    /** @return the instance of the board */
    public Board getBoard() {
        return board;
    }
}
