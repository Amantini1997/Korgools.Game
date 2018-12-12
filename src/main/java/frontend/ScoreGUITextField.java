package frontend;

import javax.swing.*;

public class ScoreGUITextField extends ScoreGUI
{
  public ScoreGUITextField()
  {
    super();
  }

  public void setScore()
  {
    score = new JTextField("0");
    this.add(score);
  }

  public String  getScore()
  {
    return ((JTextField) score).getText();
  }

  public void updateScore(String newScore)
  {
    //optional
    throw new UnsupportedOperationException();
  }
}
