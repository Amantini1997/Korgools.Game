package frontend;
import org.junit.Test;
import org.junit.Before;
import org.junit.AfterClass;
import com.athaydes.automaton.Swinger;
import frontend.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import javax.swing.*;
import java.awt.Window;
import java.awt.event.WindowEvent;
public class BoardGUITest{
  @AfterClass
  public static void cleanup()
  {

      for(Window window : Window.getWindows())
      {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
      }

  }
  @Before
  public void start()
  {
    new Gui();
  }
  @Test
  public void testGUI()
  {
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    System.out.println(Window.getWindows().length);
    swinger.pause(500)
    .clickOn("text:New Game").pause(500)
    .clickOn("name:Hole9").pause(1000)
    .clickOn("name:Hole-9").pause(1000)
    .pause(500);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
  }
}
