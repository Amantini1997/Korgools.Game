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
	private Board board;
	private Player black;
	private Player white;
	private MouseAdapter mouseClick = new MouseAdapter(){
		public void mouseClicked(MouseEvent e)
		{
			System.out.println("\n This is the board before the move:");
				System.out.println(board);
				int indexOfHole = ((Hole) e.getSource()).getIndex();
				//call backend, and tell them the index of the cell that has been clicked

				//get necessary information from backend to update the state of the game/GUI
				board.makeAMove(indexOfHole);
				updateGUI(board.toString());
				System.out.println("This is the board after the move:");
				System.out.println("BUTTON PRESSED: " +  indexOfHole);
				System.out.println(board);
		}
	};
  public BoardGUI()
  {
		board = new Board();
    this.setLayout(new GridLayout(3,1));
    black = new ReversedPlayer(9,mouseClick);
    this.add(black.showHoles());
    white = new NormalPlayer(9,mouseClick);
		this.add(setCenter());
    this.add(white.showHoles());
		this.setName("boardGUI");
		updateGUI(board.toString());
  }

  public BoardGUI(String boardString) {
      this();
      this.board = new Board(boardString);
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

  private void onButtonClick(MouseEvent e) {

  }

  public void updateGUI(String boardState) {
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
			black.blockHoles();
			white.unblockHoles();
		}
		else
		{
			white.blockHoles();
			black.unblockHoles();
		}
	}
}
