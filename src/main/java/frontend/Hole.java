package frontend;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;

/**
 * This class represents the Hole object, which in this version is just a button with some meta-information about the
 * hole.
 */
public class Hole extends JButton{
    private int index;
    private int numberOfKorgools;
    private boolean isTuz=false;

    /**
     * Constructor for the hole
     * @param index Index of the hole (a player has 9 holes default)
     * @param numberOfKorgools Number of korgools in that hole
     * @param listener What listener must be called upon clicking this button
     */
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

    /**
     * Set a hole that was previously tuz to a normal non-tuz hole
     */
    public void unTuz()
    {
      this.isTuz=false;
      this.setBackground(null);
      this.setOpaque(false);
      this.setBorderPainted(true);
    }

    /**
     * Make a hole tuz
     */
    public void makeTuz()
    {
      this.isTuz=true;
      this.setBackground(Color.RED);
      this.setOpaque(true);
      this.setBorderPainted(false); // this is to make it work on mac
    }

    /**
     * Set the number of kargoolz in the hole to a certain value
     * @param number The number of kargoolz now in that hole
     */
    public void update(int number){
        setNumberOfKorgools(number);
        this.setText(numberOfKorgools+"");
    }

}
