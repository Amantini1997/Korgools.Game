package backend;
import java.lang.Math;
public class AIBoard extends Board{

  private static final int HARD = 3;
  private static final int MEDIUM = 2;
  private static final int EASY = 1;

  private int level;

  public AIBoard(int hardness){
    super();
    level = hardness;
  }
  /**
   * Move the korgools according to the pressed hole
   * @param pressedHole: the hole pressed
   * @return True if the current player has won,
   *    False otherwise
   */
  @Override
  public void makeAMove(int pressedHole){
    if(isWhiteTurn)
      super.makeAMove(pressedHole);
    makeAIMove();
  }

  private void makeAIMove(){
    switch(level){
      case 1:
        easyMove();
        break;
      case 2:
        mediumMove();
        break;
      case 3:
        hardMove();
        break;
    }
  }

  /**
   * AI makes a move based on randomness
   */
  private void easyMove(){
    int randomHole = evaluate();
    while(!isValidMove(randomHole)){
      randomHole = evaluate();
    }
    super.makeAMove(randomHole);
  }

  /**
   * Return the hole to move for the AI Player
   * @return The hole selected
   */
  private int evaluate(){
    return (int)(Math.random()*8);
  }

  private boolean isValidMove(int pressedHole){
    return getPlayerHole(pressedHole).getKorgools() != 0;
  }

  /**
   * AI makes a move based on a basic logic
   */
  private void mediumMove(){
      // EITHER alternate Nich's code with the stupid code
      // OR nich's code with shorter forsees
  }

  /**
   * AI makes a smart move
   */
  private void hardMove(){
    // nich's code HERE
  }
}
