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
  }

	/**
	 * Move the korgools according to the pressed hole
	 * @param pressedHole: the hole pressed
	 */
  public boolean makeAMove(int pressedHole){
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
      kargoolsLeft = currentPlayer.act(0);
    }
    //FOR TESTS
    System.out.println();
    for(int i = 8; i>=0;i--){
		System.out.print(black.holes[i] .getKorgools()+ " ");
    }
    System.out.println("\n");
    for(Cell c : white.holes){
		System.out.print(c.getKorgools() + " ");
	 }
	 
    moveKorgoolsFromTuzzes();
    return currentPlayerHasWon(currentPlayer);
  }

  /**
   * Remove the korgools from the tuz hole
   * in the kazan they belong to
   */
  private void moveKorgoolsFromTuzzes(){
    white.addKorgoolsToKazan(black.emptyTuz());
    black.addKorgoolsToKazan(white.emptyTuz());
  }

  /**
  * TO-DO implement this method, it's will be called
  * when one of the player wins
  */
  private boolean currentPlayerHasWon(Player currentPlayer){
    return currentPlayer.hasWon();
  }
}
