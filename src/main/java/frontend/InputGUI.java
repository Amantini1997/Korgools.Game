package frontend;

import backend.Board;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class InputGUI extends JPanel{
  private InputReversedPlayer black;
	private InputNormalPlayer white;
  private InputHoleListener mouseClickWhite = new InputHoleListener(null);
  private InputHoleListener mouseClickBlack = new InputHoleListener(null);
  private JLabel errorText = new JLabel();
  private JButton startButton = new JButton("START GAME");
  public InputGUI()
  {
    startButton.addActionListener(e->startGame(e));
    this.setLayout(new BorderLayout());
    JPanel game = new JPanel();
    game.setLayout(new GridLayout(3,1));
    black = new InputReversedPlayer(mouseClickBlack);
    mouseClickBlack.setPlayer(black);
    game.add(black.showHoles());
    white = new InputNormalPlayer(mouseClickWhite);
    mouseClickWhite.setPlayer(white);

		game.add(setCenter());
    game.add(white.showHoles());
    this.add(errorText, BorderLayout.PAGE_START);
    this.add(game, BorderLayout.CENTER);
    this.add(startButton, BorderLayout.PAGE_END);
  }

  private void startGame(ActionEvent e)
  {
    try{
      int white1 = white.getAllHolesScores() + Integer.parseInt(white.getScore());
      int black2 = black.getAllHolesScores() + Integer.parseInt(black.getScore());
      if(white1+black2>162)
      {
          errorText.setText("Incorrect number of balls: Please remove " +  ((white1+black2)-162) + " balls");
      }
      else if(white1+black2<162)
      {
        errorText.setText("Incorrect number of balls: Please add " +  (162-(white1+black2)) + " balls");
      }
      else
      {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        System.out.println(white.playerString()+"\n"+black.playerString()+"\n"+"w");
        AIChoiceGUI aiChoiceGUI = new AIChoiceGUI(black.playerString()+"\n"+white.playerString()+"\n"+"w");
        frame.setContentPane(aiChoiceGUI);
        frame.revalidate();
        frame.repaint();
      }
    }
    catch(NumberFormatException err)
    {
      errorText.setText("Incorrect format type");
    }

  }

  private JPanel setCenter()
  {
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(1,2));
    center.add(black.showScoreLabel());
    center.add(white.showScoreLabel());
    return center;
  }

}
