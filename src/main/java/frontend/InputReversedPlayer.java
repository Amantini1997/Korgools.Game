package frontend;

import backend.Board;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.event.MouseEvent;
public class InputReversedPlayer extends ReversedPlayer{

  public InputReversedPlayer(MouseAdapter listener)
  {
    super(0,listener);
    scoreLabel=new ScoreGUITextField();
    super.setBackground(Color.BLACK);
  }

  public String playerString()
  {
    String returnString = "";
    for(Hole hole: holes)
    {
        returnString+=hole.getNumberOfKorgools()+",";
    }
    returnString+=getScore()+",";
    returnString+=addTuz();
    return returnString;
  }

  public int addTuz()
  {
    for(Hole hole: holes)
    {
      if(hole.isTuz())
      {
        return hole.getIndex();
      }
    }
    return -1;
  }

  public int getAllHolesScores()
  {
    int sum=0;
    for(Hole hole: holes)
    {
      sum+=(hole.getNumberOfKorgools());
    }
    return sum;
  }
  public String getScore()
  {
    return scoreLabel.getScore();
  }
}
