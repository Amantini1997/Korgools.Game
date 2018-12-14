package frontend;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import com.athaydes.automaton.Speed;
import com.athaydes.automaton.Swinger;
import java.awt.Window;
import java.awt.event.WindowEvent;
import javax.swing.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class BoardGUITest {
    @AfterClass
    public static void cleanup() {

        for (Window window : Window.getWindows()) {
            window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
        }
    }

    @Before
    public void start() {
        new Gui();
    }

    @Test
    public void testNewGameGUIWithFewMoves() {
        Swinger swinger = Swinger.getUserWith(Window.getWindows()[Window.getWindows().length - 1]);
        swinger.pause(500)
                .clickOn("text:New Game", Speed.MAX_VALUE)
                .pause(500)
                .clickOn("name:Two Player", Speed.MAX_VALUE)
                .pause(500)
                .clickOn("name:Hole9", Speed.MAX_VALUE)
                .pause(500)
                .clickOn("name:Hole-9", Speed.MAX_VALUE)
                .pause(500)
                .pause(500);
        JFrame frame = (JFrame) swinger.getAt("name:frame");
        JPanel panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(BoardGUI.class));
    }

    @Test
    public void testNewGameGUIWithFewMovesAndOneIncorrect() {
        Swinger swinger = Swinger.getUserWith(Window.getWindows()[Window.getWindows().length - 1]);
        swinger.pause(500)
                .clickOn("text:New Game", Speed.MAX_VALUE)
                .pause(500)
                .clickOn("name:Two Player", Speed.MAX_VALUE)
                .pause(500)
                .clickOn("name:Hole9", Speed.MAX_VALUE)
                .pause(500)
                .clickOn("name:Hole-9", Speed.MAX_VALUE)
                .pause(500)
                .clickOn("name:Hole7", Speed.MAX_VALUE)
                .pause(500)
                .clickOn("name:Hole-9", Speed.MAX_VALUE)
                .pause(500)
                .pause(500);
        String holeString = ((Hole) swinger.getAt("name:Hole-9")).getText();
        swinger.pause(500).clickOn("name:Hole-9", Speed.MAX_VALUE).pause(500);
        String holeStringClick = ((Hole) swinger.getAt("name:Hole-9")).getText();
        JFrame frame = (JFrame) swinger.getAt("name:frame");
        JPanel panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(BoardGUI.class));
        assertEquals(holeString, holeStringClick);
    }

    @Test
    public void testOnePlayerEasyGame() {
        Swinger swinger = Swinger.getUserWith(Window.getWindows()[Window.getWindows().length - 1]);
        JFrame frame = (JFrame) swinger.getAt("name:frame");
        JPanel panel;

        swinger.pause(500).clickOn("text:New Game", Speed.MAX_VALUE).pause(500);

        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(PlayerChoiceGUI.class));

        swinger.pause(500).clickOn("name:One Player", Speed.MAX_VALUE).pause(500);
        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(AIChoiceGUI.class));

        swinger.pause(500).clickOn("name:Easy", Speed.MAX_VALUE).pause(500);
        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(BoardGUI.class));
    }

    @Test
    public void testOnePlayerMediumGame() {
        Swinger swinger = Swinger.getUserWith(Window.getWindows()[Window.getWindows().length - 1]);
        JFrame frame = (JFrame) swinger.getAt("name:frame");
        JPanel panel;

        swinger.pause(500).clickOn("text:New Game", Speed.MAX_VALUE).pause(500);

        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(PlayerChoiceGUI.class));

        swinger.pause(500).clickOn("name:One Player", Speed.MAX_VALUE).pause(500);
        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(AIChoiceGUI.class));

        swinger.pause(500).clickOn("name:Medium", Speed.MAX_VALUE).pause(500);
        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(BoardGUI.class));
    }

    @Test
    public void testOnePlayerHardGame() {
        Swinger swinger = Swinger.getUserWith(Window.getWindows()[Window.getWindows().length - 1]);
        JFrame frame = (JFrame) swinger.getAt("name:frame");
        JPanel panel;

        swinger.pause(500).clickOn("text:New Game", Speed.MAX_VALUE).pause(500);

        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(PlayerChoiceGUI.class));

        swinger.pause(500).clickOn("name:One Player", Speed.MAX_VALUE).pause(500);
        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(AIChoiceGUI.class));

        swinger.pause(500).clickOn("name:Hard", Speed.MAX_VALUE).pause(500);
        panel = (JPanel) frame.getContentPane();
        assertThat(panel, instanceOf(BoardGUI.class));
    }
}
