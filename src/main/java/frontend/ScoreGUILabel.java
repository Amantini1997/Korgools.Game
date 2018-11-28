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

public class ScoreGUILabel extends ScoreGUI
{
  public ScoreGUILabel()
  {
    super();
  }

  public void setScore()
  {
    score = new JLabel("0");
    this.add(score);
  }

  public void updateScore(String newScore)
  {
    ((JLabel) score).setText(newScore);
  }
  public String getScore()
  {
    return ((JLabel) score).getText();
  }
}
