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

/*
    @Test
    public void increaseKazanKorgoolsTest(){
      Board b1 = new Board();
      Board b2 = new Board();
      Board b3 = new Board();
      Board b4 = new Board();
      Board b5 = new Board();

      //Increase player 1's korgools by 50.
      //Since 50 < 82, the method should return false
      boolean t1 = b1.increaseKazanKorgools(50);
      assertEquals(false, t1);
      /*Initially increases player 2's korgools by 56, checks if it returns false.
      Then, it increases them by 16, enough for the player to win the game
      */
/*
      //Sets player to two
      b2.setPlayerTurn(10);
      boolean t2 = b2.increaseKazanKorgools(56);
      assertEquals(false, t2);
      t2 = b2.increaseKazanKorgools(26);
      assertEquals(true, t2);


      //Sets player 1's korgools to 85. Should return that the player has won
      boolean t3 = b3.increaseKazanKorgools(85);
      assertEquals(true, t3);

      //Sets twice the amount of korgools, until reaching the sum of 75. The player has not won
      boolean t4 = b4.increaseKazanKorgools(30);
      assertEquals(false, t4);
      t4 = b4.increaseKazanKorgools(45);
      assertEquals(false, t4);

      //Sets the amount of korgools to 85, shoudl return true. Then, it is set again to 85 + 20
      //Should return true;
      boolean t5 = b5.increaseKazanKorgools(85);
      assertEquals(true, t5);
      t5 = b5.increaseKazanKorgools(20);
      assertEquals(true, t5);

    }


    @Test
    public void setPlayerTurn(){
      Board b1 = new Board();
      Board b2 = new Board();
      for(int i = 0; i < 9; i++)
        b1.setPlayerTurn(i);
        assertEquals(0,b1.getCurrentPlayer());

      for(int i = 9; i < 18; i++)
        b2.setPlayerTurn(i);
        assertEquals(1,b2.getCurrentPlayer());
    }*/
}
