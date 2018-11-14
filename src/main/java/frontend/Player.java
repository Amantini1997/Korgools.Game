package frontend;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Collections;
public class  Player{
  private JPanel holesPanel =  new JPanel();
  private JLabel scoreLabel = new JLabel();

  private static final int NUMBER_OF_HOLES = 9;

  private ArrayList<Hole> holes = new ArrayList<>();
  private static boolean reverse=true;

  public Player(String name, int numberOfKorgools, ActionListener listener)
  {
    holesPanel.setLayout(new FlowLayout());

    for(int i=0; i<NUMBER_OF_HOLES; i++)
    {
      Hole hole = new Hole(i, numberOfKorgools, listener);
      holes.add(hole);
    }

    if(reverse)
    {
      Collections.reverse(holes);
    }

    for(Hole hole: holes)
    {
      holesPanel.add(hole);
    }

    reverse = !reverse;
    scoreLabel.setText(name);
    //Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    //cell.setBorder(border);
  }

  public JPanel showHoles()
  {
    return holesPanel;
  }
  public JLabel showScoreLabel()
  {
    return scoreLabel;
  }
  public void updateHoles(ArrayList<Integer> holeValues) {
    for (int i = 0; i < NUMBER_OF_HOLES; i ++ ) {
      holes.get(i).update(holeValues.get(i));
    }
  }


}
