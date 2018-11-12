public class Player {
    private static final N_HOLES = 9;
    private Hole holes;
    private Kazan kazans;
    private boolean tuz;

    /**
     * Public constructor for Board game
     */
    public Board(){
      holes = new Hole[N_HOLES];
      kazans = new Kazan();
      tuz = true;
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
