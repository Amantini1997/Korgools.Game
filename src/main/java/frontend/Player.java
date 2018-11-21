package frontend;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Collections;
import java.awt.Color;
import java.awt.GridLayout;

public class  Player{
  private JPanel holesPanel =  new JPanel();
  private JPanel scoreLabel = new scoreGUI();

  private static final int NUMBER_OF_HOLES = 9;

  private ArrayList<Hole> holes = new ArrayList<>();
  private static boolean reverse=true;

  public Player(int numberOfKorgools, ActionListener listener)
  {
    holesPanel.setLayout(new GridLayout(1,9));
    holesPanel.setBorder(new EmptyBorder(10,10,10,10));

    for(int i=0; i<NUMBER_OF_HOLES; i++)
    {
      Hole hole = new Hole(i, numberOfKorgools, listener);
      holes.add(hole);
    }

    if(reverse)
    {
      Collections.reverse(holes);
      holesPanel.setBackground(Color.BLACK);
      scoreLabel.setBackground(Color.BLACK);
    } else {
      holesPanel.setBackground(Color.WHITE);
      scoreLabel.setBackground(Color.WHITE);
    }

    for(Hole hole: holes)
    {
      holesPanel.add(hole);
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
  public void updateHoles(ArrayList<Integer> holeValues) {
    for (int i = 0; i < NUMBER_OF_HOLES; i ++ ) {
      holes.get(i).update(holeValues.get(i));
    }
  }


}
