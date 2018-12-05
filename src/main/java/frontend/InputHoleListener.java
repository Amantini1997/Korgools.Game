package frontend;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class InputHoleListener extends MouseAdapter
{
  private Player player;
  public InputHoleListener(Player player)
  {
    this.player = player;
  }
  public void setPlayer(Player player)
  {
    this.player=player;
  }

  public void mouseClicked(MouseEvent e)
  {

      Hole hole = (Hole) e.getSource();
      if(e.getButton()==MouseEvent.BUTTON3)
      {
        if(hole.getNumberOfKorgools()>0)
        {
          hole.update(hole.getNumberOfKorgools()-1);

        }
        else
        {
          removeTuz();
          hole.makeTuz();
        }
      }
      else if(e.getButton()==MouseEvent.BUTTON1)
      {
        if(hole.isTuz())
        {
          hole.unTuz();
        }
        hole.update(hole.getNumberOfKorgools()+1);
      }
  }

  public void removeTuz(){
    for(Hole hol: player.getHoles())
    {
      if(hol.isTuz())
      {
        hol.unTuz();
      }
    }
  }
}
