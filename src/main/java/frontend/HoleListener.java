package frontend;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Mouse listener that listens for left and right clicks on buttons in the input selection screen.
 */
public class HoleListener extends MouseAdapter {
    private BoardGUI board;
    public HoleListener(BoardGUI board){
        this.board=board;
    }
    public void mouseClicked(MouseEvent e) {
        if (((Hole) e.getSource()).isEnabled()) {
            System.out.println("\n This is the board before the move:");
            System.out.println(board);
            System.out.println("NAME: " + ((Hole) e.getSource()).getName());
            int indexOfHole = ((Hole) e.getSource()).getIndex();
            // call backend, and tell them the index of the cell that has been clicked

            // get necessary information from backend to update the state of the
            // game/GUI
            String winningPlayer = (board.getBoard()).makeAMove(indexOfHole);
            //board.updateGUI(board.toString());
            System.out.println("This is the board after the move:");
            System.out.println("BUTTON PRESSED: " + indexOfHole);
            System.out.println(board);
            if (winningPlayer != null) {
                JOptionPane.showMessageDialog(null, winningPlayer + " player won!");
                JFrame frame = (JFrame) SwingUtilities.getRoot((Hole) e.getSource());
                frame.setContentPane(new ChoiceGUI());
                frame.pack();
                frame.repaint();
                frame.revalidate();
            }
        }
    }
}
