package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.Before;

public class BoardTest{
  private Board board;

  @Before
  public void setUp(){
    board = new Board();
  }

  @Test
  public void testBoardToStringTrue() {
    assertEquals(board.toString(), "9,9,9,9,9,9,9,9,9,0,-1\n"+
                                   "9,9,9,9,9,9,9,9,9,0,-1\nw");
  }

  @Test
  public void testBoardToStringFalse() {
    assertNotEquals(board.toString(), "9,9,9,9,9,9,9,9,9,0,-1\n"+
                                      "9,9,9,9,9,9,9,9,9,0,-1\nb");
  }

  @Test
  public void testBoardAfterFirstMoveToString() {
    assertEquals(board.toString(), "9,9,9,9,9,9,9,9,9,0,-1\n"+
                                   "9,9,9,9,9,9,9,9,9,0,-1\nw");

    //board = new Board();
    //board.makeAMove(8);
    //assertEquals(board.toString(), "1,10,10,10,10,10,10,10,10,0,-1\n9,9,9,9,9,9,9,9,9,0,-1\nb");
  }

  @Test
  public void makeAMoveShouldStealKorgoolsEndingInAEvenHole(){
    board.makeAMove(6);
    assertEquals(board.toString(), "10,10,10,10,10,0,9,9,9,0,-1\n"+
                                   "9,9,9,9,9,9,1,10,10,10,-1\nb");
  }

  @Test
  public void makeAMoveShouldntStealKorgoolsEndingInASamePlayerEvenHole(){
    board.makeAMove(0);
    board.makeAMove(0);
    board.makeAMove(1);
    board.makeAMove(0);
    board.makeAMove(2);
    board.makeAMove(0);
    board.makeAMove(8);
    assertEquals(board.toString(),"2,15,12,12,11,11,11,11,11,0,-1\n"+
                                  "2,2,1,12,12,12,12,12,1,0,-1\nb");
  }

  @Test
  public void makeAMoveOn1KorgoolTuzShouldEmptyIt(){
    board.makeAMove(0);
    board.makeAMove(0);
    board.makeAMove(0);
    assertEquals(board.toString(),"1,10,10,10,10,10,10,10,10,0,-1\n"+
                                  "0,11,10,10,10,10,10,10,10,0,-1\nb");
  }

  @Test
  public void makeAMoveOnAEmptyHoleShouldntChangePlayersTurn(){
    board.makeAMove(0);
    board.makeAMove(0);
    board.makeAMove(0);
    board.makeAMove(0);
    board.makeAMove(0);
    assertEquals(board.toString(),"0,11,10,10,10,10,10,10,10,0,-1\n"+
                                  "0,11,10,10,10,10,10,10,10,0,-1\nw");
  }

  @Test
  public void makeAMoveShouldCreateAtuz(){
    board.makeAMove(4);
    board.makeAMove(4);
    board.makeAMove(5);
    board.makeAMove(4);
    board.makeAMove(6);
    board.makeAMove(4);
    board.makeAMove(0);
    board.makeAMove(2);
    assertEquals(board.toString(),"13,12,1,3,2,15,12,12,11,13,-1\n"+
                                  "2,12,12,2,0,2,2,13,13,10,4\nw");
  }

  @Test
  public void makeAMovePassingOverATuzShouldEmptyTheTuzEvenForOpponentsMoves(){
    board.makeAMove(4);
    board.makeAMove(4);
    board.makeAMove(5);
    board.makeAMove(4);
    board.makeAMove(6);
    board.makeAMove(4);
    board.makeAMove(0);
    board.makeAMove(2);
    board.makeAMove(3);
    board.makeAMove(5);
    assertEquals(board.toString(),"14,13,1,3,2,1,13,13,12,15,-1\n"+
                                  "3,13,13,2,0,3,3,14,14,10,4\nw");
  }

  @Test
  public void makeAMovePassingOverATuzShouldEmptyIt(){
    board.makeAMove(4);
    board.makeAMove(4);
    board.makeAMove(5);
    board.makeAMove(4);
    board.makeAMove(6);
    board.makeAMove(4);
    board.makeAMove(0);
    board.makeAMove(2);
    board.makeAMove(3);
    assertEquals(board.toString(),"13,12,1,3,2,15,12,12,11,14,-1\n"+
                                  "2,12,12,1,0,2,2,13,13,10,4\nb");
  }

  @Test
  public void makeAMoveShouldNotCreateAtuzOnLastHole(){
  board.makeAMove(8);
  board.makeAMove(0);
  board.makeAMove(1);
  board.makeAMove(6);
  board.makeAMove(1);
  board.makeAMove(8);
  assertEquals(board.toString(),"1,11,11,11,11,11,1,2,1,10,-1\n"+
                                "2,2,13,12,12,12,12,12,3,12,-1\nw");

  }

  //@Test
  /*public void makeAMove(){
    board = new Board("0,0,0,0,0,0,0,0,0,13,0\n"+
                      "0,0,1,0,0,0,0,0,0,20,0\nw");
    board.makeAMove(2);
    assertEquals(board.toString(),"0,0,0,0,0,0,0,0,0,13,0\n"+
                                  "0,0,1,0,0,0,0,0,0,20,0\nw");
  }*/

}
