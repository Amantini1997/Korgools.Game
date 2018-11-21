package frontend;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.SwingUtilities;

public class  Gui
{
    private JFrame frame = new JFrame();

    /**
    * Create the window with the Choice panel and prepare it for display
    **/
    public Gui()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChoiceGUI main = new ChoiceGUI();
        frame.setContentPane(main);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // if the window currently open is a a board (so it won't try to save if we are in main menu)
                if (frame.getContentPane() instanceof BoardGUI) {
                    BoardGUI board = (BoardGUI) frame.getContentPane();
                    String str = board.getBoardDisplayed().toString();

                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/gameSaves.txt"));
                        writer.write(str);
                        writer.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    /**
    * Run the application
    **/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui gui = new Gui();
            }
        });
    }

    // TODO this is for testing, maybe make the class extend jframe so we dont
    // need this method
    public JFrame getFrame() {
        return frame;
    }
}
