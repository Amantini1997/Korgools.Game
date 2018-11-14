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

  @Override
  public String toString() {
    String line1 = white.toString();
    String line2 = black.toString();
    String line3 = (isWhiteTurn? "w" : "b");

    return line1 + "\n" + line2 + "\n" + line3;
  }
}
