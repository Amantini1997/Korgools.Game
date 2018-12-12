package frontend;
import java.awt.event.MouseAdapter;
import java.awt.Color;

/**
 * Input the player that user is playing, default as white.
 */
public class InputNormalPlayer extends NormalPlayer{
  public InputNormalPlayer(MouseAdapter listener)
  {
    super(0,listener);

    scoreLabel=new ScoreGUITextField();
    scoreLabel.setName("whiteInput");
    super.setBackground(Color.WHITE);
  }
  public String playerString()
  {
    String returnString = "";
    for(Hole hole: holes)
    {
        returnString+=hole.getNumberOfKorgools()+",";
    }
    returnString+=getScore()+",";
    returnString+=addTuz();
    return returnString;
  }

  public int addTuz()
  {
    for(Hole hole: holes)
    {
      if(hole.isTuz())
      {
        return hole.getIndex();
      }
    }
    return -1;
  }

  public int getAllHolesScores()
  {
    int sum=0;
    for(Hole hole: holes)
    {
      sum+=(hole.getNumberOfKorgools());
    }
    return sum;
  }
  public String getScore()
  {
    return scoreLabel.getScore();
  }

}
