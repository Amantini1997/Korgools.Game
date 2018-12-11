package frontend;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class InputHoleListener extends MouseAdapter
{
  private Player player;
  private Player secondPlayer;
  public InputHoleListener(Player player)
  {
    this.player = player;
    this.secondPlayer = secondPlayer;
  }
  public void setPlayers(Player player1, Player player2)
  {
    this.player=player1;
    this.secondPlayer = player2;
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
          player.removeTuz();
          hole.makeTuz();
          if(secondPlayer.getTuz()==player.getTuz())
          {
            secondPlayer.removeTuz();
          }
        }
      }
      else if(e.getButton()==MouseEvent.BUTTON1)
      {
        if(hole.isTuz())
        {
          hole.unTuz();
        }else
        {
          hole.update(hole.getNumberOfKorgools()+1);
        }
      }
  }
}
