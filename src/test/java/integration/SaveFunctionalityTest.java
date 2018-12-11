package frontend;

import frontend.BoardGUI;
import org.junit.FixMethodOrder;
import org.junit.Test;
import com.athaydes.automaton.Swinger;
import com.athaydes.automaton.Speed;
import org.junit.runners.MethodSorters;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.Window;
import java.awt.event.WindowEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaveFunctionalityTest {
    @Test
    public void testSave() {
        JFrame frame = new frontend.Gui().getFrame();
        Swinger swinger =Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
        swinger.clickOn("name:New Game", Speed.MAX_VALUE).pause(500).clickOn("name:Two Player", Speed.MAX_VALUE).pause(250);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        String boardState = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/gameSaves.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                boardState += line + "\n";
            }
        } catch (Exception e1) {
            fail("Not able to read from the file");
        }

        String startingBoard = "-1\n" +
                               "9,9,9,9,9,9,9,9,9,0,-1\n" +
                               "9,9,9,9,9,9,9,9,9,0,-1\n" +
                               "w\n";

        assertEquals(boardState, startingBoard);
    }

    @Test
    public void ztestLoad() {
        // if the window currently open is a a board (so it won't try to save if we are in main menu)

        String boardToTestAgainst = "9,9,9,8,9,9,9,9,9,0,-1\n" +
                                    "9,9,9,9,9,10,9,9,9,0,-1\n" +
                                    "b\n";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/gameSaves.txt"));
            writer.write(boardToTestAgainst);
            writer.close();
        } catch (Exception e1) {
            fail("Not able to write to file");
            e1.printStackTrace();
        }

        JFrame frame = new frontend.Gui().getFrame();
        Swinger swinger = Swinger.getUserWith(Window.getWindows()[Window.getWindows().length-1]);
        swinger.clickOn("name:Load Game", Speed.MAX_VALUE);
        frame.dispose();

        String boardState = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/gameSaves.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                boardState += line + "\n";
            }
        } catch (Exception e1) {
            fail("Not able to read from the file");
        }

        assertEquals(boardToTestAgainst, boardState);
    }
}