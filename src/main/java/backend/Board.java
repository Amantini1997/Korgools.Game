package backend;

/**
 * This is board class that manages the game state and game logic
 */
public class Board {
  protected Player white;
  protected Player black;
  protected Player currentPlayer;
  protected boolean isWhiteTurn;
  protected static final boolean WHITE_MOVES_FIRST = true;

  /**
   * Initialises the board
   */
  public Board(){
    white = new Player();
    black = new Player();
    isWhiteTurn = WHITE_MOVES_FIRST;
    setCurrentPlayer();
  }

  /**
   * Initialises the board with the given state
   * @param boardString string representation of the board
   */
  public Board(String boardString) {
    String[] lines = boardString.split("\n");
    black = new Player(lines[0]);
    white = new Player(lines[1]);

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
   * Checks whether the turn has changed
   * @return if the turn has changed
   */
  private boolean hasMoveStartedFromThisPlayer(){
    return isWhiteTurn && currentPlayer == white
            || !isWhiteTurn && currentPlayer == black;
  }

  /**
   * Move the korgools according to the pressed hole
   * @param pressedHole: the hole pressed
   * @return True if the current player has won, False otherwise
   */
  public boolean makeAMove(int pressedHole){
    //if the player presses a hole containing 0 korgools nothing happens
    int initKorgools = getPlayerHole(pressedHole).getKorgools();
    if(initKorgools > 1){
        initKorgools--;
    }
    if(initKorgools==0){
        return playerHasWon(currentPlayer);
    }
    int kargoolsLeft = currentPlayer.act(pressedHole);
    while(kargoolsLeft>0){
        currentPlayer = (currentPlayer == black)?white:black;
        kargoolsLeft = currentPlayer.moveKorgools(kargoolsLeft, hasMoveStartedFromThisPlayer());
    }
    //checking that the ending hole is an opponent's one
    if( !hasMoveStartedFromThisPlayer()){//(currentPlayer == white && !isWhiteTurn)||(currentPlayer == black && isWhiteTurn)){
        int finalHole = (pressedHole+initKorgools)%9;
        if(getPlayerHole(finalHole).getKorgools()%2==0){
            stealKorgools(finalHole);
        }
    }
    isWhiteTurn = !isWhiteTurn;
    setCurrentPlayer();
    moveKorgoolsFromTuzzes();
    if(playerHasWon(black) || playerHasWon(white))
      return true;
      if(!currentPlayer.hasAMove()){
        isWhiteTurn = !isWhiteTurn;
        setCurrentPlayer();
      }
      return false;
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
   * Returns whether the current player has won
   * @param player the player we wonder if has won
   * @return true if the player has won
   */
  protected boolean playerHasWon(Player player){
    return player.hasWon();
  }

  /**
  *@return a visual representation of the board
  */
  @Override
  public String toString() {
    String line1 = black.toString();
    String line2 = white.toString();
    String line3 = (isWhiteTurn? "w" : "b");

    return line1 + "\n" + line2 + "\n" + line3;
  }

  /**
   *Gets the hole for the current player
   * @param hole the hole to get
   * @return the corresponding hole of the current player
   */
  protected Hole getPlayerHole(int hole){
    return currentPlayer.getHoles()[hole];
  }

  /**
   * Checks if the game has ended
   * @return if the game has finished
   */
  public boolean gameHasEnded() {
    return white.hasWon() || black.hasWon();
  }
}
