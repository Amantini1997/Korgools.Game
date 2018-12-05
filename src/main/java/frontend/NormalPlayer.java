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
public class NormalPlayer extends Player{
  protected int number=1;
  public NormalPlayer(int numberOfKorgools, MouseAdapter listener)
  {
    super(numberOfKorgools,listener);
    super.setBackground(Color.WHITE);
    addHoles();
    setNames();
  }

  private void addHoles()
  {
    for(Hole hole: holes)
    {
      JPanel holeInfo = new JPanel();
      holeInfo.setLayout(new GridLayout(2,1));
      JLabel holeNumber = new JLabel(hole.getIndex()+1 + "", SwingConstants.CENTER);
      holeNumber.setOpaque(true);
      holeNumber.setForeground(Color.BLACK);
      holeInfo.add(hole);
      holeInfo.add(holeNumber);
      holeNumber.setBackground(Color.WHITE);
      holesPanel.add(holeInfo);
    }
  }

  private void setNames()
  {
    for(Hole hole: holes)
    {
      hole.setName("Hole"+number);
      number=(number+1)%(10);
      if(number==0)
      {
        number=1;
      }
    }
  }
}
