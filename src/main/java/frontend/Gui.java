package frontend;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
public class  Gui
{
    private JFrame frame;

    /**
    * Create the window with the Choice panel and prepare it for display
    **/
    public Gui()
    {
        frame = new JFrame();
        frame.setName("frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ChoiceGUI main = new ChoiceGUI();
        frame.setContentPane(main);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
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
