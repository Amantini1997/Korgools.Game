package frontend;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;

public class Hole extends JButton{
    private int index;
    private int numberOfKorgools;
    private boolean isTuz=false;
    public Hole(int index, int numberOfKorgools, MouseAdapter listener){
        this.index = index;
        this.numberOfKorgools = numberOfKorgools;

        this.setText(numberOfKorgools+"");
        this.setName("name:hole" + index);
        this.addMouseListener(listener);
    }

    public int getIndex() {
        return this.index;
    }

    public int getNumberOfKorgools()
    {
      return this.numberOfKorgools;
    }

    private void setNumberOfKorgools(int number)
    {
      numberOfKorgools=number;
    }

    public boolean isTuz()
    {
      return isTuz;
    }

    public void unTuz()
    {
      this.isTuz=false;
      this.setBackground(null);
      this.setOpaque(false);
      this.setBorderPainted(true);
    }

    public void makeTuz()
    {
      this.isTuz=true;
      this.setBackground(Color.RED);
      this.setOpaque(true);
      this.setBorderPainted(false); // this is to make it work on mac
    }

    public void update(int number){
        setNumberOfKorgools(number);
        this.setText(numberOfKorgools+"");
    }

}
