package frontend;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Collections;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public abstract class ScoreGUI extends JPanel{
  protected JComponent score;

  public ScoreGUI()
  {
    this.setLayout(new GridLayout());

    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

    this.setAlignmentY(CENTER_ALIGNMENT);
    this.setAlignmentX(CENTER_ALIGNMENT);
    this.setBorder(new EmptyBorder(10,10,10,10));
    setScore();
    score.setOpaque(true);
    score.setBackground(Color.WHITE);
    score.setBorder(border);
  }
  public abstract void updateScore(String newScore);
  public abstract void setScore();
  public abstract String getScore();

}
