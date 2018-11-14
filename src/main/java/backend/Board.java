package backend;

public class Board {
  private Player white;
  private Player black;
  private boolean isWhiteTurn;
  private static final boolean WHITE_MOVES_FIRST = true;

  public Board(){
    white = new Player();
    black = new Player();
    isWhiteTurn = WHITE_MOVES_FIRST;
    start();
  }

  public void start(){
    int hole = 0;
    Player currentPlayer = (isWhiteTurn)?white:black;
    while(true){
       hole = callAMove();
       hole = currentPlayer.act(hole);
       while(hole>0){
         if(isWhiteTurn){
           currentPlayer = white;
         }else{
           currentPlayer = black;
         }
         isWhiteTurn = !isWhiteTurn;
         hole = currentPlayer.act(hole);
       }
       if(currentPlayer.hasWon()){
         endGame();
         return;
       }
       moveKargoolsFromTuzzes();
    }
  }

  /**
   * Remove the kargools from the tuz hole
   * in the kazan they belong to
   */
  private void moveKargoolsFromTuzzes(){
    white.addKorgoolsToKazan(black.emptyTuz());
    black.addKorgoolsToKazan(white.emptyTuz());
  }

  /**
   * Ask the current player what hole they want to empty to move its balls
   * and return the associated number.
   * @return The position of the hole to empty
   */
  public int callAMove(){
    //GUI function selecting a hole
    int selectedHole = 0;//remove me
    return selectedHole;
  }

 /**
  * TO-DO implement this method, it's will be called
  * when one of the player wins
  */
  private void endGame(){
    System.out.println("Player x has won!!");
  }
}
