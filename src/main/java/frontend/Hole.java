package frontend;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Color;

public class Hole extends JButton{
    private int index;
    private int numberOfKorgools;

    public Hole(int index, int numberOfKorgools, ActionListener listener){
        this.index = index;
        this.numberOfKorgools = numberOfKorgools;

        this.setText(numberOfKorgools+"");
        this.addActionListener(listener);
    }

    public int getIndex() {
        return this.index;
    }

    public int getNumberOfKorgools()
    {
      return this.numberOfKorgools;
    }

    public void makeTuz()
    {
      this.setBackground(Color.RED);
      this.setOpaque(true);
     this.setBorderPainted(false); // this is to make it work on mac
    }

    public void update(int number){
        this.setText(number+"");
    }

}
