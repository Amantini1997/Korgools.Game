package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import java.util.Arrays;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PlayerTest{

  @Parameters
  public static Collection<Object[]> data(){return Arrays.asList(new Object[][]{
    {3,3,true,1},
    {0,0,true,1},
    {7,7,true,1},
    {6,6,true,1}});
  }
  public Player p;
  public int returningKorgools;
  public int move;
  public boolean moveStartedFromThisPlayer;
  public int opponentTuz;

  public PlayerTest(int retKorg,int move, boolean moveSFTP, int opTuz){
    p = new Player();
    returningKorgools = retKorg;
    this.move = move;
    moveStartedFromThisPlayer = moveSFTP;
    opponentTuz = opTuz;
  }

  @Test
  public void actTest(){
    assertEquals(returningKorgools,p.act(move,moveStartedFromThisPlayer,opponentTuz));
  }

  /*
  @Test
  public void hasTuzOptionTestShouldReturnFalse1(){
      p.act(8);// 9 9 9 9 9 9 9 9 1
      p.act(7);// 9 9 9 9 9 9 9 1 2
      p.act(0);// 1 x x x x x x 2 3
      assertEquals(false,p.hasTuzOption(8));//last hole can't be tuz
  }

  @Test
  public void hasTuzOptionTestShouldReturnFalse2(){
               // 0 1 2 3 4 5 6 7 8
      p.act(5);// 1 x x x x 1 e 3 4
      p.act(6);// 1 x x x x 1 1 4 5
      p.act(7);// 1 x x x x 1 1 1 6
      p.act(4);// 1 x x x 1 2 2 2 7
      p.act(5);// 1 x x x 1 1 3 2 7
      assertEquals(false,p.hasTuzOption(6));
  }

  @Test
  public void hasTuzOptionTestShouldReturnFalse3(){
               // 0 1 2 3 4 5 6 7 8
      p.act(2);// 1 x 1 x 2 2 4 3 8
      p.act(7);// 1 x 1 x 2 2 4 1 9
      p.act(6);// 1 x x x 2 2 1 2 x
      p.act(4);// 1 x x x 1 3 1 2 x
      assertEquals(false,p.hasTuzOption(5));
  }
*/
}
