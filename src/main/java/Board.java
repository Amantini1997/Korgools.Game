public class Board {
    private static final N_HOLES = 9;
    private static final N_PLAYERS = 2;
    private static final PLAYER_ONE = 0;
    private static final PLAYER_TWO = 1;
    private Hole[] holes;
    private Kazan[] kazans;
    private boolean[] tuzes;
    private int currentPlayer;

    /**
     * Public constructor for Board game
     */
    public Board(){
      holes = new Hole[N_HOLES*N_PLAYERS];
      kazans = new Kazan[N_PLAYERS];
      tuzes = new boolean[N_PLAYERS];
      currentPlayer = 0;
    }

    /**
     * Take the number of a hole, empty it and move all the balls
     * into the next holes. A tuz can be called after a move.
     * @param n : The position of the hole you want to empty
     */
    public void move(int n){
    }

    /**
      * Check if the player can still set a tuz,
      * @param n : The player who wants to set the tuz
      */
    public void hasTuzOption(int player){
    }

    /**
    *Increases the Korgools of the Kazan of the current player. Checks if the player has won
    *@param korgools the number of korgools to add
    *@return if the player has won the game
    */
    public boolean increaseKazanKorgools(int korgools){
      kazans[currentPlayer].increaseKorgoolsBy(korgools);
      return kazans[currentPlayer].hasWon();
    }
    /**
    *Sets the current player based on the position of the last hole
    *@param endHole the last hole of a move
    */
    public void setPlayerTurn(int endHole){
      currentPlayer = endHole/N_HOLES;
    }
    /**
    *Checks current player
    *@return currentPlayer
    */
    public int getCurrentPlayer(){
      return currentPlayer;
    }

}
