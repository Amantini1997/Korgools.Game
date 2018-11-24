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
import java.util.concurrent.*;
import javax.swing.Timer;
public class  Player{
  private JPanel holesPanel =  new JPanel();
  private ScoreGUI scoreLabel = new ScoreGUI();

  private static final int NUMBER_OF_HOLES = 9;
  private Color background = Color.WHITE;
  private ArrayList<Hole> holes = new ArrayList<>();
  private static boolean reverse=true;
  private final static int playerDelay = 2000;

  public Player(int kargools,ActionListener listener)
  {
    holesPanel.setLayout(new GridLayout(1,NUMBER_OF_HOLES));
    holesPanel.setBorder(new EmptyBorder(10,10,10,10));

    for(int i=0; i<NUMBER_OF_HOLES; i++)
    {
      Hole hole = new Hole(i, kargools, listener);
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
      if(reverse)
      {
        holesPanel.add(hole.showHoleWithLabel(Color.WHITE,background));
      }
      else
      {
        holesPanel.add(hole.showHoleWithLabel(Color.BLACK,background));
      }
    }
    if(reverse)
    {
      Collections.reverse(holes);
    }
    reverse = !reverse;
  }

  public JPanel showHoles()
  {
    return holesPanel;
  }
  public JPanel showScoreLabel()
  {
    return scoreLabel;
  }

  public synchronized void update(String playerState, int move)
  {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    scheduler.schedule((new Runnable(){public void run(){
      update(playerState);
    }}),playerDelay*move,TimeUnit.MILLISECONDS);
    scheduler.shutdown();
  }

  private void update(String playerState){
    String[] player = playerState.split(",");
    int[] holes = getHolesInfo(player);
    updateHoles(holes, Integer.parseInt(player[10]));
    updateScore(player[9]);
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

  private void updateHoles(int[] holeValues, int tuz) {
    int delay = playerDelay/NUMBER_OF_HOLES;
    for(Hole hole: holes){
      if(hole.getIndex()==tuz)
      {
        hole.update(holeValues[hole.getIndex()],true,delay);
      }
      else{
        hole.update(holeValues[hole.getIndex()],false,delay);
      }
      delay+=playerDelay/NUMBER_OF_HOLES;
    }
  }

  public void unblockHoles(){
    for(Hole hole: holes)
    {
      if(!hole.getText().equals("")){
        if(Integer.parseInt(hole.getText())!=0){
          hole.setEnabled(true);
        }
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
