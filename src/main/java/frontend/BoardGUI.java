package frontend;

import backend.Board;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
	private Player pl1;
	private Player pl2;
  public BoardGUI()
  {
  	board = new Board();
    this.setLayout(new GridLayout(3,1));
    pl1 = new Player(9, e -> onButtonClick(e));
    this.add(pl1.showHoles());
    pl2 = new Player(9,e -> onButtonClick(e));
    this.add(setCenter(pl1,pl2));
    this.add(pl2.showHoles());
  }

  public BoardGUI(String boardString) {
      this();
      this.board = new Board(boardString);
      updateGUI(board.toString());
  }

  private JPanel setCenter(Player pl1, Player pl2)
  {
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(1,2));
    center.add(pl1.showScoreLabel());
    center.add(pl2.showScoreLabel());
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

  public void updateGUI(String boardState) {
    //update the information
		String[] info = boardState.split("\n");
		pl1.update(info[0],true);
		pl2.update(info[1],false);
      // update the holes
      // update the score
      // update the tuz location

    this.repaint();
  }

  public Board getBoardDisplayed() {
      return board;
  }

}
