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
import com.athaydes.automaton.Speed;
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
  public void testNewGameGUIWithFewMoves()
  {
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(500)
    .clickOn("text:New Game",Speed.MAX_VALUE).pause(200)
    .clickOn("name:Two Player", Speed.MAX_VALUE).pause(200)
    .clickOn("name:Hole9",Speed.MAX_VALUE).pause(200)
    .clickOn("name:Hole-9",Speed.MAX_VALUE).pause(200)
    .pause(200);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
  }

  @Test
  public void testNewGameGUIWithFewMovesAndOneIncorrect()
  {
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(500)
    .clickOn("text:New Game",Speed.MAX_VALUE).pause(200)
    .clickOn("name:Two Player", Speed.MAX_VALUE).pause(200)
    .clickOn("name:Hole9",Speed.MAX_VALUE).pause(200)
    .clickOn("name:Hole-9",Speed.MAX_VALUE).pause(200)
    .clickOn("name:Hole7",Speed.MAX_VALUE).pause(200)
    .clickOn("name:Hole-9",Speed.MAX_VALUE).pause(200)
    .pause(200);
    String holeString = ((Hole)swinger.getAt("name:Hole-9")).getText();
    swinger.clickOn("name:Hole-9",Speed.MAX_VALUE).pause(200);
    String holeStringClick = ((Hole)swinger.getAt("name:Hole-9")).getText();
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
    assertEquals(holeString,holeStringClick);
  }

  @Test
  public void testOnePlayerEasyGame()
  {
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel;

    swinger.pause(500)
    .clickOn("text:New Game",Speed.MAX_VALUE).pause(200);

    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(PlayerChoiceGUI.class));
    
    swinger.clickOn("name:One Player",Speed.MAX_VALUE).pause(200);
    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(AIChoiceGUI.class));

    swinger.clickOn("name:Easy",Speed.MAX_VALUE).pause(200);
    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
  }

  @Test
  public void testOnePlayerMediumGame()
  {
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel;

    swinger.pause(500)
    .clickOn("text:New Game",Speed.MAX_VALUE).pause(200);

    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(PlayerChoiceGUI.class));
    
    swinger.clickOn("name:One Player",Speed.MAX_VALUE).pause(200);
    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(AIChoiceGUI.class));

    swinger.clickOn("name:Medium",Speed.MAX_VALUE).pause(200);
    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
  }

  @Test
  public void testOnePlayerHardGame()
  {
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel;

    swinger.pause(500)
    .clickOn("text:New Game",Speed.MAX_VALUE).pause(200);

    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(PlayerChoiceGUI.class));
    
    swinger.clickOn("name:One Player",Speed.MAX_VALUE).pause(200);
    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(AIChoiceGUI.class));

    swinger.clickOn("name:Hard",Speed.MAX_VALUE).pause(200);
    panel = (JPanel)frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
  }
}
