import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
public class  Gui{
    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        Player pl1 = new Player("PLAYER 1",9,9,null);
        main.add(pl1.showHoles(), BorderLayout.NORTH);
        Player pl2 = new Player("PLAYER 2",9,9,null);
        main.add(pl2.showHoles(), BorderLayout.SOUTH);
        main.add(setCenter(pl1,pl2), BorderLayout.CENTER);
        frame.getContentPane().add(main);
        frame.pack();
        frame.setVisible(true);
    }

    private static JPanel setCenter(Player pl1, Player pl2)
    {
      JPanel center = new JPanel();
      center.setLayout(new FlowLayout());
      center.add(pl1.showCell());
      center.add(pl2.showCell());
      return center;
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
