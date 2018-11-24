package frontend;

import backend.Board;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import backend.*;
import java.util.concurrent.*;
import java.lang.Process.*;
/**
* Panel with the board game
**/
public class BoardGUI extends JPanel
{
	private Board board;
	private Player black;
	private Player white;
  public BoardGUI()
  {
  	board = new Board();
    this.setLayout(new GridLayout(3,1));
    black = new Player(9,e -> onButtonClick(e));
    this.add(black.showHoles());
    white = new Player(9,e -> onButtonClick(e));
		this.add(setCenter());
    this.add(white.showHoles());
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

  private void onButtonClick(ActionEvent e) {
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

  private void updateGUI(String boardState) {
		String[] info = boardState.split("\n");
		updateBoard(info);
		repaint();
		revalidate();
  }

	private void updateBoard(String[] info)
	{
		if(info[2].equals("w"))
		{
			black.update(info[0],1);
 			white.update(info[1],2);
			white.unblockHoles();
			black.blockHoles();
		}
		else
		{
			black.update(info[0],2);
 			white.update(info[1],1);
			black.unblockHoles();
			white.blockHoles();
		}
	}
}
