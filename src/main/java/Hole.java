import java.awt.event.ActionListener;

import javax.swing.*;

public class Hole extends JButton{
    private int index;
    private int numberOfBalls;

    public Hole(int index, int numberOfBalls, ActionListener listener){
        this.index = index;
        this.numberOfBalls = numberOfBalls;

        this.setText(numberOfBalls+"");
        this.addActionListener(listener);
    }

    public int getIndex() {
        return this.index;
    }

    public void update(int number){
        this.setText(number+"");
    }

}