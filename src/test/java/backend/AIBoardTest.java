package backend;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AIBoardTest{
  private AIBoard board;

  // @Test
  // public void makeAMove(){
  //   board = new Board("0,0,0,0,0,0,0,0,0,13,0\n"+
  //                     "0,0,1,0,0,0,0,0,0,20,0\nw");
  //   board.makeAMove(2);
  //   assertTrue(board.toString().equals("0,0,0,0,0,0,0,0,0,13,0\n"+
  //                                      "0,0,1,0,0,0,0,0,0,20,0\nw"));
  // }
  @Test
  public void AI1MakesAMoveWithoutTellingIt(){
    board = new AIBoard("2,0,0,0,0,0,0,0,0,60,-1\n"+
                        "2,0,0,0,0,0,0,0,0,81,-1\nw",1);
    board.makeAMove(0);
    assertEquals(board.toString(),"1,1,0,0,0,0,0,0,0,60,-1\n"+
                                  "1,1,0,0,0,0,0,0,0,81,-1\nw");
  }

  @Test
  public void AI2MakesAMoveWithoutTellingIt(){
    board = new AIBoard("2,0,0,0,0,0,0,0,0,60,-1\n"+
                        "2,0,0,0,0,0,0,0,0,81,-1\nw",2);
    board.makeAMove(0);
    assertEquals(board.toString(),"1,1,0,0,0,0,0,0,0,60,-1\n"+
                                  "1,1,0,0,0,0,0,0,0,81,-1\nw");
  }

  @Test
  public void AI3MakesAMoveWithoutTellingIt(){
    board = new AIBoard("2,0,0,0,0,0,0,0,0,60,-1\n"+
                        "2,0,0,0,0,0,0,0,0,81,-1\nw",3);
    board.makeAMove(0);
    assertEquals(board.toString(),"1,1,0,0,0,0,0,0,0,60,-1\n"+
                                  "1,1,0,0,0,0,0,0,0,81,-1\nw");
  }

  @Test
  public void AI3MakesTheRightMove(){
    board = new AIBoard("0,1,1,3,1,0,8,3,1,65,-1\n"+
                        "1,1,3,2,2,1,1,1,0,67,-1\nw",3);
    board.makeAMove(2);
    assertEquals(board.toString(),"0,1,1,3,1,0,1,4,2,69,-1\n"+
                                  "2,2,2,4,0,1,1,1,0,67,-1\nw");
  }

  @Test
  public void playerWins(){
    board = new AIBoard("1,0,0,0,0,0,0,0,0,81,-1\n"+
                        "1,0,0,0,0,0,0,0,2,80,-1\nw",2);
    assertEquals("White",board.makeAMove(8));
  }

  @Test
  public void AIWins(){
    board = new AIBoard("0,0,0,0,0,0,0,0,3,81,-1\n"+
                        "0,1,0,0,0,0,0,0,1,60,-1\nw",2);
    assertEquals("Black",board.makeAMove(8));
  }

  @Test
  public void noOneWins(){
    board = new AIBoard("1,0,0,0,0,0,0,0,0,81,-1\n"+
                        "1,0,0,0,0,0,0,0,0,60,-1\nw",2);
    assertEquals(null,board.makeAMove(0));
  }
}
