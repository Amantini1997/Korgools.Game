package backend;

public class Board {
  protected Player white;
  protected Player black;
  protected Player currentPlayer;
  protected boolean isWhiteTurn;
  protected static final boolean WHITE_MOVES_FIRST = true;

  public Board(){
    white = new Player();
    black = new Player();
    isWhiteTurn = WHITE_MOVES_FIRST;
    setCurrentPlayer();
  }

  public Board(String boardString) {
    String[] lines = boardString.split("\n");
    white = new Player(lines[0]);
    black = new Player(lines[1]);

    if (lines[2].equals("w")) {
      isWhiteTurn = true;
    }
    else {
      isWhiteTurn = false;
    }
    setCurrentPlayer();
  }

  /**
   * Sets the currentPlayer according to isWhiteTurn
   */
  private void setCurrentPlayer(){
    currentPlayer = (isWhiteTurn)?white:black;
  }

	/**
	 * Move the korgools according to the pressed hole
	 * @param pressedHole: the hole pressed
   * @return True if the current player has won,
   *    False otherwise
	 */
    public void makeAMove(int pressedHole){
    if(! currentPlayer.hasAMove())
      return;
    //if the player presses a hole containing 0 korgools nothing happens
    int initKorgools = getPlayerHole(pressedHole).getKorgools();
    if(initKorgools > 1){
      initKorgools--;
    }
    if(initKorgools==0){
      return ;
    }
    int kargoolsLeft = currentPlayer.act(pressedHole);
    while(kargoolsLeft>0){
      currentPlayer = (currentPlayer == black)?white:black;
      kargoolsLeft = currentPlayer.moveKorgools(kargoolsLeft);
    }
    //checking that the ending hole is an opponent's one
    if((currentPlayer == white && !isWhiteTurn)||(currentPlayer == black && isWhiteTurn)){
      int finalHole = (pressedHole+initKorgools)%9;
      if(getPlayerHole(finalHole).getKorgools()%2==0){
        stealKorgools(finalHole);
      }
    }
    isWhiteTurn = !isWhiteTurn;
    setCurrentPlayer();
    moveKorgoolsFromTuzzes();
   currentPlayerHasWon(currentPlayer);
  }

   /**
    * The ending hole is an opponent's one
    * and the number of korgools is now even so, the current player
    * steal them.
    * @param hole: the hole to steal korgools from
    */
    private void stealKorgools(int hole){
      int stolenKorgools = getPlayerHole(hole).setKorgoolsToZero();
      setCurrentPlayer();
      currentPlayer.addKorgoolsToKazan(stolenKorgools);
    }
  /**
   * Remove the korgools from the tuz hole
   * in the kazan they belong to
   */
  protected void moveKorgoolsFromTuzzes(){
    white.addKorgoolsToKazan(black.emptyTuz());
    black.addKorgoolsToKazan(white.emptyTuz());
  }

  /**
  * TO-DO implement this method, it will be called
  * when one of the player wins
  */
  protected void currentPlayerHasWon(Player currentPlayer){
    if(currentPlayer.hasWon()){
      String cPlayer = (isWhiteTurn)? "WHITE" : "BLACK";
     System.out.println("\nCONGRATS "+cPlayer+" PLAYER, YOU WON");
      System.exit(0);
    }
  }

  @Override
  public String toString() {
    String line1 = black.toString();
    String line2 = white.toString();
    String line3 = (isWhiteTurn? "w" : "b");

    return line1 + "\n" + line2 + "\n" + line3;
  }

  protected Hole getPlayerHole(int hole){
    return currentPlayer.getHoles()[hole];
  }
}
