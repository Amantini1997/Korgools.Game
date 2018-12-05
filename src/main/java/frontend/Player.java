package frontend;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ComponentAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Collections;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import java.awt.event.MouseAdapter;

public class  Player {
  protected JPanel holesPanel =  new JPanel();
  protected ScoreGUI scoreLabel;

  protected static final int NUMBER_OF_HOLES = 9;
  protected ArrayList<Hole> holes = new ArrayList<>();

  public Player(int numberOfKorgools, MouseAdapter listener)
  {
    scoreLabel = new ScoreGUILabel();
    holesPanel.setLayout(new GridLayout(1,NUMBER_OF_HOLES));
    holesPanel.setBorder(new EmptyBorder(10,10,10,10));
    for(int i=0; i<NUMBER_OF_HOLES; i++)
    {
      Hole hole = new Hole(i, numberOfKorgools, listener);
      holes.add(hole);
    }
  }

  public void setBackground(Color color)
  {
    holesPanel.setBackground(color);
    scoreLabel.setBackground(color);
  }
  public JPanel showHoles()
  {
    return holesPanel;
  }
  public JPanel showScoreLabel()
  {
    return scoreLabel;
  }
  public ArrayList<Hole> getHoles()
  {
    return holes;
  }
  public void update(String playerState)
  {
    String[] player = playerState.split(",");
    int[] holes = getHolesInfo(player);
    updateHoles(holes);
    updateScore(player[9]);
    int tuz = Integer.parseInt(player[10]);
    updateTuz(tuz);
  }

  private int[] getHolesInfo(String[] player)
  {
    int[] holesInfo = new int[NUMBER_OF_HOLES];
    for(int i=0; i< NUMBER_OF_HOLES; i++)
    {
      holesInfo[i]=Integer.parseInt(player[i]);
    }
    return holesInfo;
  }

  private void updateScore(String score)
  {
    scoreLabel.updateScore(score);
  }

  private void updateTuz(int tuz)
  {
    for(Hole hole: holes)
    {
        if(hole.getIndex()==tuz)
        {
          hole.makeTuz();
        }
    }
  }

  private void updateHoles(int[] holeValues) {
    for (Hole hole: holes) {
      hole.update(holeValues[hole.getIndex()]);
    }
  }

  public void unblockHoles(){
    for(Hole hole: holes)
    {
      if(hole.getNumberOfKorgools()!=0)
      {
        hole.setEnabled(true);
      }
    }
  }

  public void block0Holes()
  {
    for(Hole hole: holes)
    {
      if(hole.getNumberOfKorgools()==0)
      {
        hole.setEnabled(false);
      }
    }
  }

  public void blockHoles(){
    for(Hole hole: holes)
    {
      hole.setEnabled(false);
    }
  }
}
