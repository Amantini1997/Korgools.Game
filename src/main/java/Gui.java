import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

public class  Gui{

    public Gui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        Player pl1 = new Player("PLAYER 1",9, e -> onButtonClick(e));
        main.add(pl1.showHoles(), BorderLayout.NORTH);
        Player pl2 = new Player("PLAYER 2",9,e -> onButtonClick(e));
        main.add(pl2.showHoles(), BorderLayout.SOUTH);
        main.add(setCenter(pl1,pl2), BorderLayout.CENTER);

        frame.getContentPane().add(main);
        frame.pack();
        frame.setVisible(true);
    }

    private void onButtonClick(ActionEvent e) {
        int indexOfHole = ((Hole) e.getSource()).getIndex();
        System.out.println(indexOfHole); // TODO test

        //call backend, and tell them the index of the cell that has been clicked
        
        //get necessary information from backend to update the state of the game/GUI

        //update the information 
    }

    private JPanel setCenter(Player pl1, Player pl2)
    {
      JPanel center = new JPanel();
      center.setLayout(new FlowLayout());
      center.add(pl1.showScoreLabel());
      center.add(pl2.showScoreLabel());
      return center;
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                Gui gui = new Gui();
                //createAndShowGUI();

                
            }
        });
    }
}
