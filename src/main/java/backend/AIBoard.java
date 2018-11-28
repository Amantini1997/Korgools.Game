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
  public boolean makeAMove(int pressedHole){
    super.makeAMove(pressedHole);
    int randomHole = evaluate();
    while(!isValidMove(randomHole)){
      randomHole = evaluate();
    }
    return super.makeAMove(evaluate());
    /*if(!isWhiteTurn){
      pressedHole = evaluate();
    }
    int kargoolsLeft = 0;
    Player currentPlayer = (isWhiteTurn)?white:black;
    kargoolsLeft = currentPlayer.act(pressedHole);
    while(kargoolsLeft>0){
      isWhiteTurn = !isWhiteTurn;
      if(isWhiteTurn){
        currentPlayer = white;
      }else{
        currentPlayer = black;
      }
      kargoolsLeft = currentPlayer.moveKorgools(kargoolsLeft);
    }

    setCurrentPlayer();
    moveKorgoolsFromTuzzes();
    currentPlayerHasWon(currentPlayer);
    if(!isWhiteTurn){
      makeAMove(0);
    }
    return false;*/
  }

  private boolean isValidMove(int pressedHole){
    return getPlayerHole(pressedHole).getKorgools() != 0;
  }

  /**
   * Return the hole to move for the AI Player
   * @return The hole selected
   */
  private int evaluate(){
    return (int)Math.random()*8;
  }
}
