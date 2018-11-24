package frontend;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ScoreGUI extends JPanel{
  private JLabel scoreLabel;

  public ScoreGUI()
  {
    this.setLayout(new GridLayout());
    scoreLabel = new JLabel("0", SwingConstants.CENTER);
    scoreLabel.setOpaque(true);
    scoreLabel.setBackground(Color.WHITE);
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    scoreLabel.setBorder(border);
    this.add(scoreLabel);
    this.setBorder(new EmptyBorder(10,10,10,10));
  }

  public void updateScore(String newScore)
  {
    scoreLabel.setText(newScore);
  }
}
