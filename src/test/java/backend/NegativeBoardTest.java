package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NegativeBoardTest{

  @Parameters
  public static Collection<Object[]> data(){
    return Arrays.asList(new Object[][]{
      {new int[]{0,0,0,0,0},"0,11,10,10,10,10,10,10,10,0,-1\n"+
                            "0,11,10,10,10,10,10,10,10,0,-1\nw"},

      {new int[]{4,4,5,4,6,4,0,2},"13,12,1,3,2,15,12,12,11,13,-1\n"+
                                  "2,12,12,2,0,2,2,13,13,10,4\nw"},

      {new int[]{4,4,5,4,6,4,0,2,3,5},"14,13,1,3,2,1,13,13,12,15,-1\n"+
                                      "3,13,13,2,0,3,3,14,14,10,4\nw"},

      {new int[]{4,4,5,4,6,4,0,2,3},"13,12,1,3,2,15,12,12,11,14,-1\n"+
                                    "2,12,12,1,0,2,2,13,13,10,4\nb"}});

  }

  public String output;
  public int[] moves;
  private Board board;

  public NegativeBoardTest(int[] moves, String output){
    this.moves = moves;
    this.output = output;
    this.board = new Board();
  }

  @Test
  public void test(){
    if(moves != null)
      for(int i = 0; i< moves.length; i++)
         board.makeAMove(moves[i]);
    assertNotEquals(board.toString(),output);
  }
}
