package frontend;

import backend.Board;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import backend.*;

/**
 * Panel with the board game
 **/
public class BoardGUI extends JPanel
{
	private Board board = new Board();
	private Player black;
	private Player white;

	private MouseAdapter mouseClick = new MouseAdapter(){
		public void mouseClicked(MouseEvent e)
		{
			if(((Hole) e.getSource()).isEnabled()){
			System.out.println("\n This is the board before the move:");
				System.out.println(board);
				System.out.println("NAME: "+((Hole) e.getSource()).getName());
				int indexOfHole = ((Hole) e.getSource()).getIndex();
				//call backend, and tell them the index of the cell that has been clicked

				//get necessary information from backend to update the state of the game/GUI
				boolean hasWon = board.makeAMove(indexOfHole);
				updateGUI(board.toString());
				System.out.println("This is the board after the move:");
				System.out.println("BUTTON PRESSED: " +  indexOfHole);
				System.out.println(board);
				if (hasWon){
					JOptionPane.showMessageDialog(null, "Congratulations, you won!");
					JFrame frame = (JFrame) SwingUtilities.getRoot(	(Hole)e.getSource());
					frame.setContentPane(new ChoiceGUI());
					frame.pack();
					frame.repaint();
					frame.revalidate();
				}
			}
		}
	};

  public BoardGUI(int hardness)
  {
  	//TO DO let the player select the level
		if(hardness == -1){
			board = new Board();
		}
		else {
			board = new AIBoard(hardness);
		}
    this.setLayout(new GridLayout(3,1));
    black = new ReversedPlayer(9,mouseClick);
    this.add(black.showHoles());
    white = new NormalPlayer(9,mouseClick);
		this.add(setCenter());
    this.add(white.showHoles());
		this.setName("boardGUI");
		updateGUI(board.toString());
  }

  public BoardGUI(String boardString, int hardness) {
      this(hardness);
      this.board = new AIBoard(boardString, hardness);
      updateGUI(board.toString());
  }

  private JPanel setCenter()
  {
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(1,2));
    center.add(black.showScoreLabel());
    center.add(white.showScoreLabel());
    return center;
  }

  private void updateGUI(String boardState) {
    //update the information
		String[] info = boardState.split("\n");
		black.update(info[0]);
		white.update(info[1]);
		blockPlayer(info[2]);
    this.repaint();
		this.revalidate();
		if(SwingUtilities.getRoot(this)!=null){
			JFrame frame = (JFrame) SwingUtilities.getRoot(this);
			frame.pack();
		}
  }

  public Board getBoardDisplayed() {
      return board;
  }

	private void blockPlayer(String player)
	{
		if(player.equals("w"))
		{
			white.block0Holes();
			black.blockHoles();
			white.unblockHoles();
		}
		else
		{
			black.block0Holes();
			white.blockHoles();
			black.unblockHoles();
		}
	}

	/**
	 * @return the instance of the board
	 */
	public Board getBoard(){
		return board;
	}
}
