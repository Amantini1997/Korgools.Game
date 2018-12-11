package frontend;
import org.junit.Test;
import org.junit.Before;
import org.junit.AfterClass;
import com.athaydes.automaton.Swinger;
import com.athaydes.automaton.Speed;
import frontend.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import javax.swing.*;
import java.awt.Window;
import java.awt.event.WindowEvent;

public class InputGUITest{

  @AfterClass
  public static void cleanup()
  {
      for(Window window : Window.getWindows())
      {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
      }

  }

  @Test
  public void testGUI()
  {
    new Gui();
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(500)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(500);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(InputGUI.class));
  }

  @Test
  public void createBoardWithNotEnoughBalls()
  {
    new Gui();
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200).moveTo("name:Hole-1", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:Hole1",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole3",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole-3", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:whiteInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(InputGUI.class));
    Hole hole1 = (Hole)swinger.getAt("name:Hole1");
    Hole hole3 = (Hole)swinger.getAt("name:Hole3");
    Hole hole_3 = (Hole)swinger.getAt("name:Hole-3");
    ScoreGUITextField whiteScore = (ScoreGUITextField)swinger.getAt("name:whiteInput");
    ScoreGUITextField blackScore = (ScoreGUITextField)swinger.getAt("name:blackInput");
    assertThat(panel,instanceOf(InputGUI.class));
    assertEquals(hole1.getText(),"1");
    assertEquals(hole3.getText(),"1");
    assertEquals(hole_3.isTuz(),true);
    assertEquals(whiteScore.getScore(),"80");
    assertEquals(blackScore.getScore(),"0");
  }

  @Test
  public void createBoardFromInputScenarioWithTuzOnWhiteSide()
  {
    new Gui();
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200).moveTo("name:Hole-1", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:Hole1",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole3",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole-3", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:whiteInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:blackInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Two Player",Speed.MAX_VALUE)
    .pause(200);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
    Hole hole1 = (Hole)swinger.getAt("name:Hole1");
    Hole hole3 = (Hole)swinger.getAt("name:Hole3");
    Hole hole_3 = (Hole)swinger.getAt("name:Hole-3");
    ScoreGUILabel whiteScore = (ScoreGUILabel)swinger.getAt("name:whiteScore");
    ScoreGUILabel blackScore = (ScoreGUILabel)swinger.getAt("name:blackScore");
    assertThat(panel,instanceOf(BoardGUI.class));
    assertEquals(hole1.getText(),"1");
    assertEquals(hole3.getText(),"1");
    assertEquals(hole_3.isTuz(),true);
    assertEquals(whiteScore.getScore(),"80");
    assertEquals(blackScore.getScore(),"80");
  }

  @Test
  public void createBoardFromInputScenarioWithTuzOnBlackSide()
  {
    new Gui();
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200).moveTo("name:Hole1", Speed.MAX_VALUE).rightClick()
    .pause(200)
    .clickOn("name:Hole-1",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole-3",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole3", Speed.MAX_VALUE).rightClick()
    .pause(200)
    .clickOn("name:whiteInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:blackInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Two Player",Speed.MAX_VALUE)
    .pause(200);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(BoardGUI.class));
    Hole hole_1 = (Hole)swinger.getAt("name:Hole-1");
    Hole hole_3 = (Hole)swinger.getAt("name:Hole-3");
    Hole hole3 = (Hole)swinger.getAt("name:Hole3");
    ScoreGUILabel whiteScore = (ScoreGUILabel)swinger.getAt("name:whiteScore");
    ScoreGUILabel blackScore = (ScoreGUILabel)swinger.getAt("name:blackScore");
    assertThat(panel,instanceOf(BoardGUI.class));
    assertEquals(hole_1.getText(),"1");
    assertEquals(hole_3.getText(),"1");
    assertEquals(hole3.isTuz(),true);
    assertEquals(whiteScore.getScore(),"80");
    assertEquals(blackScore.getScore(),"80");
  }

  @Test
  public void createBoardWithTooManyBalls()
  {
    new Gui();
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole1",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole3",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole-3", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:whiteInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("85")
    .pause(200)
    .clickOn("name:blackInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("85")
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(InputGUI.class));
    Hole hole1 = (Hole)swinger.getAt("name:Hole1");
    Hole hole3 = (Hole)swinger.getAt("name:Hole3");
    Hole hole_3 = (Hole)swinger.getAt("name:Hole-3");
    ScoreGUITextField whiteScore = (ScoreGUITextField)swinger.getAt("name:whiteInput");
    ScoreGUITextField blackScore = (ScoreGUITextField)swinger.getAt("name:blackInput");
    assertThat(panel,instanceOf(InputGUI.class));
    assertEquals(hole1.getText(),"1");
    assertEquals(hole3.getText(),"1");
    assertEquals(hole_3.isTuz(),true);
    assertEquals(whiteScore.getScore(),"85");
    assertEquals(blackScore.getScore(),"85");
  }

  @Test
  public void testGUIForHandlingIncorrectValues()
  {
    new Gui();
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:whiteInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("xxxxxxxx")
    .pause(200)
    .clickOn("name:blackInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("sahjbsacghsahc")
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    assertThat(panel,instanceOf(InputGUI.class));
  }

  @Test
  public void testTuzRedistribution()
  {
    new Gui();
    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole1",Speed.MAX_VALUE).rightClick()
    .pause(200)
    .clickOn("name:Hole1",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole1",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole1",Speed.MAX_VALUE).rightClick()
    .pause(200)
    .moveTo("name:Hole1",Speed.MAX_VALUE).rightClick()
    .pause(200)
    .moveTo("name:Hole1",Speed.MAX_VALUE).rightClick()
    .pause(200)
    .moveTo("name:Hole-1",Speed.MAX_VALUE).rightClick()
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel = (JPanel) frame.getContentPane();
    Hole hole1 = (Hole)swinger.getAt("name:Hole1");
    Hole hole_1 = (Hole)swinger.getAt("name:Hole-1");
    assertThat(panel,instanceOf(InputGUI.class));
    assertEquals(hole1.isTuz(),false);
    assertEquals(hole1.getText(),"0");
    assertEquals(hole_1.isTuz(),true);
  }


  @Test
  public void testOnePlayerEasyGame(){
    new Gui();

    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel;

    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200).moveTo("name:Hole-1", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:Hole1",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole3",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole-3", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:whiteInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:blackInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200);

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
  public void testOnePlayerMediumGame(){
    new Gui();

    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel;

    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200).moveTo("name:Hole-1", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:Hole1",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole3",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole-3", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:whiteInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:blackInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200);

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
  public void testOnePlayerHardGame(){
    new Gui();

    Swinger swinger =  Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
    JFrame frame = (JFrame)swinger.getAt("name:frame");
    JPanel panel;

    swinger.pause(200)
    .clickOn("text:Input Game",Speed.MAX_VALUE)
    .pause(200).moveTo("name:Hole-1", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:Hole1",Speed.MAX_VALUE)
    .pause(200)
    .clickOn("name:Hole3",Speed.MAX_VALUE)
    .pause(200)
    .moveTo("name:Hole-3", Speed.MAX_VALUE)
    .rightClick()
    .pause(200)
    .clickOn("name:whiteInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:blackInput",Speed.MAX_VALUE)
    .pause(200)
    .enterText("80")
    .pause(200)
    .clickOn("name:startGame",Speed.MAX_VALUE)
    .pause(200);

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
