package frontend;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.SwingUtilities;
/**
* Panel with initial screen, which lets the player choose game type
**/
public class AIChoiceGUI extends JPanel
{
  private static final String EASY_TEXT = "Easy";
  private static final String MEDIUM_TEXT = "Medium";
  private static final String HARD_TEXT = "Hard";

  private String boardString;

  public AIChoiceGUI()
  {
    this.setLayout(new BorderLayout());
    this.add(setCenter(), BorderLayout.CENTER);
  }

    public AIChoiceGUI(String boardString)
    {
        this();
        this.boardString = boardString;
    }

  /**
  *Set center of this panel with two buttons in the middle
  **/
  private JPanel setCenter()
  {
    JPanel center = new JPanel();
    center.setLayout(new FlowLayout());
    center.add(creatOptionButton(EASY_TEXT));
    center.add(creatOptionButton(MEDIUM_TEXT));
    center.add(creatOptionButton(HARD_TEXT));
    return center;
  }

  /**
  * Update the window content based on button press.
  * It may create new game or it may show the board to input the game scenario.
  **/
  private void getNewScreen(ActionEvent e)
  {
      JFrame frame = (JFrame) SwingUtilities.getRoot(this);
      //What was one the button?
      switch(((JButton)e.getSource()).getText()){
        case(EASY_TEXT):{
            if(boardString == null){
                frame.setContentPane(new BoardGUI(1));
            }
            else{
                frame.setContentPane(new BoardGUI(boardString, 1));
            }
          
          break;
        }
        case(MEDIUM_TEXT):{
            if(boardString == null){
                frame.setContentPane(new BoardGUI(2));
            }
            else{
                frame.setContentPane(new BoardGUI(boardString, 2));
            }
          break;
        }
        case(HARD_TEXT): {
          if(boardString == null){
                frame.setContentPane(new BoardGUI(3));
            }
            else{
                frame.setContentPane(new BoardGUI(boardString, 3));
            }
          break;
        }
      }
      frame.pack();
      frame.repaint();
  }

  /**
  *Create new button with ActionListener.
  **/
  private JButton creatOptionButton(String text)
  {
    JButton button = new JButton(text);
    button.setName(text);
    button.addActionListener(e -> getNewScreen(e));
    return button;
  }
}
