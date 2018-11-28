package frontend;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
/**
* Panel with initial screen, which lets the player choose game type
**/
public class ChoiceGUI extends JPanel
{
  private static final String NEW_BUTTON_TEXT = "New Game";
  private static final String INPUT_BUTTON_TEXT = "Input Game";
  public ChoiceGUI()
  {
    this.setLayout(new BorderLayout());
    this.add(setCenter(), BorderLayout.CENTER);
  }

  /**
  *Set center of this panel with two buttons in the middle
  **/
  private JPanel setCenter()
  {
    JPanel center = new JPanel();
    center.setLayout(new FlowLayout());
    center.add(creatOptionButton(NEW_BUTTON_TEXT));
    center.add(creatOptionButton(INPUT_BUTTON_TEXT));
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
      switch(( (JButton)e.getSource()).getText() ){
        case(NEW_BUTTON_TEXT):{
          frame.setContentPane(new BoardGUI());
          break;
        }
        case(INPUT_BUTTON_TEXT):{
          //TODO: Create "Input board panel"
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
    button.addActionListener(e -> getNewScreen(e));
    return button;
  }
}