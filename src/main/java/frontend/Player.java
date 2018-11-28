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

public class  Player{
  private JPanel holesPanel =  new JPanel();
  private ScoreGUI scoreLabel = new ScoreGUI();

  private static final int NUMBER_OF_HOLES = 9;
  private Color background = Color.WHITE;
  private ArrayList<Hole> holes = new ArrayList<>();
  private static boolean reverse=true;

  public Player(int numberOfKorgools, ActionListener listener)
  {
    holesPanel.setLayout(new GridLayout(1,NUMBER_OF_HOLES));
    holesPanel.setBorder(new EmptyBorder(10,10,10,10));

    for(int i=0; i<NUMBER_OF_HOLES; i++)
    {
      Hole hole = new Hole(i, numberOfKorgools, listener);
      holes.add(hole);
    }
    if(reverse)
    {
      Collections.reverse(holes);
      background = Color.BLACK;
    }
    holesPanel.setBackground(background);
    scoreLabel.setBackground(background);

    for(Hole hole: holes)
    {
      JPanel holeInfo = new JPanel();
      holeInfo.setLayout(new GridLayout(2,1));
      JLabel holeNumber = new JLabel(hole.getIndex()+1 + "", SwingConstants.CENTER);
      holeNumber.setOpaque(true);
      if(reverse)
      {
        holeNumber.setForeground(Color.WHITE);
        holeInfo.add(holeNumber);
        holeInfo.add(hole);
      }
      else
      {
        holeNumber.setForeground(Color.BLACK);
        holeInfo.add(hole);
        holeInfo.add(holeNumber);
      }
      holeNumber.setBackground(background);
      holesPanel.add(holeInfo);
    }

    reverse = !reverse;
    //Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    //cell.setBorder(border);
  }

  public JPanel showHoles()
  {
    return holesPanel;
  }
  public JPanel showScoreLabel()
  {
    return scoreLabel;
  }

  public void update(String playerState)
  {
    String[] player = playerState.split(",");
    int[] holes = getHolesInfo(player);
    updateHoles(holes);
    updateScore(player[9]);
    int tuz = Integer.parseInt(player[10]);
    if(tuz !=-1)
    {
      updateTuz(tuz);
    }
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
      if(Integer.parseInt(hole.getText())!=0)
      {hole.setEnabled(true);}
    }
  }

  public void blockHoles(){
    for(Hole hole: holes)
    {
      hole.setEnabled(false);
    }
  }
}
