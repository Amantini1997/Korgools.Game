package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PositiveBoardTest{

  @Parameters
  public static Collection<Object[]> data(){
    return Arrays.asList(new Object[][]{
      {null,"9,9,9,9,9,9,9,9,9,0,-1\n"+
            "9,9,9,9,9,9,9,9,9,0,-1\nw"},

      {new int[]{6},"10,10,10,10,10,0,9,9,9,0,-1\n"+
                    "9,9,9,9,9,9,1,10,10,10,-1\nb"},

      {new int[]{0,0,1,0,2,0,8},"2,15,12,12,11,11,11,11,11,0,-1\n"+
                                "2,2,1,12,12,12,12,12,1,0,-1\nb"},

      {new int[]{0,0,0},"1,10,10,10,10,10,10,10,10,0,-1\n"+
                        "0,11,10,10,10,10,10,10,10,0,-1\nb"},

      {new int[]{8,0,1,6,1,8},"1,11,11,11,11,11,1,2,1,10,-1\n"+
                              "2,2,13,12,12,12,12,12,3,12,-1\nw"}});
  }

    public String output;
    public int[] moves;
    private Board board;

  public PositiveBoardTest(int[] moves, String output){
    this.moves = moves;
    this.output = output;
    this.board = new Board();
  }

  @Test
  public void test(){
    if(moves != null)
      for(int i = 0; i< moves.length; i++)
         board.makeAMove(moves[i]);
    assertEquals(board.toString(),output);
  }
}
