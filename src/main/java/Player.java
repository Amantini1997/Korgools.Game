import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class  Player{
  private JPanel holesPanel =  new JPanel();
  private JLabel scoreLabel = new JLabel();

  private static final int NUMBER_OF_HOLES = 9;
  
  private ArrayList<Hole> holes = new ArrayList<>();
  private static int lastIndexAssigned;

  public Player(String name, int numberOfBalls, ActionListener listener)
  {
    holesPanel.setLayout(new FlowLayout());
    
    for(int i=0; i<NUMBER_OF_HOLES; i++)
    {
      Hole hole = new Hole(lastIndexAssigned + i, numberOfBalls, listener);
      
      holes.add(hole);
      holesPanel.add(hole);

    }
    lastIndexAssigned+=NUMBER_OF_HOLES;
    
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
