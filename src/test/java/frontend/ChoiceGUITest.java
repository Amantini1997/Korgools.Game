package frontend;
import org.junit.Test;
import org.junit.Before;
import org.junit.AfterClass;
import com.athaydes.automaton.Swinger;
import frontend.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import java.io.BufferedReader;
import javax.swing.*;
import java.io.IOException;
import java.awt.Window;
import java.awt.event.WindowEvent;
public class ChoiceGUITest
{
  @AfterClass
  public static void cleanup()
  {
    for(Window window : Window.getWindows())
    {
      window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }
  }

  @Test
  public void testInputGame(){
    new Gui();
    Swinger swinger= Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(500)
    .clickOn("name:Input Game")
    .pause(500);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(InputGUI.class));
  }

  @Test
  public void testNewGame(){
    new Gui();
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(500)
    .clickOn("text:New Game")
    .pause(500);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
  }
}
