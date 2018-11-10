import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
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
}
