package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class BoardTest{

  @Test
  public void testBoardToStringTrue() {
    Board board = new Board();

    assertEquals(board.toString(), "9,9,9,9,9,9,9,9,9,0,-1\n9,9,9,9,9,9,9,9,9,0,-1\nw");
  }

  @Test
  public void testBoardToStringFalse() {
    Board board = new Board();

    assertNotEquals(board.toString(), "8,9,9,9,9,9,9,9,9,0,-1\n9,9,9,9,9,9,9,9,9,0,-1\nw");
  }

  @Test
  public void testBoardAfterFirstMoveToString() {
    Board board = new Board();
    assertEquals(board.toString(), "9,9,9,9,9,9,9,9,9,0,-1\n9,9,9,9,9,9,9,9,9,0,-1\nw");

    board = new Board();
    //board.makeAMove(8);
    //assertEquals(board.toString(), "1,10,10,10,10,10,10,10,10,0,-1\n9,9,9,9,9,9,9,9,9,0,-1\nb");

    board = new Board();
    board.makeAMove(0);
  }

}
