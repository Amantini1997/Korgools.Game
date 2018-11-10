import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.AbstractAction;
import java.util.ArrayList;
public class  Player{
  private JPanel holesPanel =  new JPanel();
  private JLabel cell = new JLabel();
  private ArrayList<JButton> holes = new ArrayList<>();
  public Player(String name,int numberOfHoles, int numberOfBalls, AbstractAction listener)
  {
    holesPanel.setLayout(new FlowLayout());
    for(int i=0; i<numberOfHoles; i++)
    {
      JButton hole = new JButton(numberOfBalls+"");
      hole.addActionListener(listener);
      holes.add(hole);
      holesPanel.add(hole);
    }
    cell.setText(name);
    //Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    //cell.setBorder(border);
  }

  public JPanel showHoles()
  {
    return holesPanel;
  }
  public JLabel showCell()
  {
    return cell;
  }

}
