package frontend;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ComponentAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Collections;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.concurrent.*;
import javax.swing.Timer;
public class Hole extends JButton{
    private int index;
    public Hole(int index, int kargools, ActionListener listener){
        this.index = index;

        this.setText(kargools+"");
        this.addActionListener(listener);
    }

    public int getIndex() {
        return this.index;
    }

    public void makeTuz()
    {
      this.setBackground(Color.RED);
      this.setOpaque(true);
      this.setBorderPainted(false); // this is to make it work on mac
    }

    public void update(int number,boolean tuz, int delay){
      ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
      scheduler.schedule((new Runnable(){public void run(){
        update(number);
        if(tuz){makeTuz();}
      }}),delay,TimeUnit.MILLISECONDS);
      scheduler.shutdown();
    }

    public void update(int number)
    {
      this.setText(number+"");
      this.revalidate();
      this.repaint();
      if(SwingUtilities.getRoot(this)!=null){
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        frame.pack();
      }
    }

    public JPanel showHoleWithLabel(Color foreground,Color background)
    {
      JPanel holeInfo = new JPanel();
      holeInfo.setLayout(new GridLayout(2,1));
      JLabel holeNumber = new JLabel(this.getIndex()+1 + "", SwingConstants.CENTER);
      holeNumber.setOpaque(true);
      holeNumber.setForeground(foreground);
      holeInfo.add(holeNumber);
      holeInfo.add(this);
      holeNumber.setBackground(background);
      return holeInfo;
    }
}
