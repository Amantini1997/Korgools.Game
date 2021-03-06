package backend;
/** Implementation of a player in the game. */
public class Player {
    private static final int N_HOLES = 9;
    private static final int UNTUZZABLE_HOLE = N_HOLES - 1; // position in the array
    private Hole[] holes;
    private Kazan kazan;
    private boolean tuzIsAvailable;

    /** Public constructor for Board game */
    public Player() {
        holes = new Hole[N_HOLES];
        for (int i = 0; i < N_HOLES; i++) {
            holes[i] = new Hole();
        }
        kazan = new Kazan();
        tuzIsAvailable = true;
    }

    /**
     * Initialises the player with a given state
     *
     * @param playerString Initial state of the player
     */
    public Player(String playerString) {
        holes = new Hole[N_HOLES];

        String[] tokens = playerString.split(",");

        for (int i = 0; i < N_HOLES; i++) {
            holes[i] = new Hole(Integer.parseInt(tokens[i]));
        }

        kazan = new Kazan(Integer.parseInt(tokens[N_HOLES]));

        if (Integer.parseInt(tokens[tokens.length - 1]) != -1) {
            holes[Integer.parseInt(tokens[tokens.length - 1])].setTuz();
            tuzIsAvailable = false;
        }
    }
    /**
    * @return the korgools in the kazan
    */
    public int getKazanKorgools(){
      return kazan.getKorgools();
    }

    /**
    * @return a collection of the player's holes
    */
    public Hole[] getHoles(){
      return holes;
    }

    /**
    * Finds the player's tuz and returns it
    * @return the tuz index if it exists, -1 otherwise
    */
    public int getTuz() {
        for (int i = 0; i < holes.length; i++) {
            if (holes[i].isTuz()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Take the number of a hole, empty it and move all the balls into the next holes. A tuz can be
     * called after a move.
     *
     * @param startHole : The position of the hole you want to empty
     * @param moveStartedFromThisPlayer : True if the hole pressed this turn belongs with the
     *     current player, False otherwise;
     * @return 0 if all the korgools moveble from the starting hole have been moved, otherwise
     *     return the remaining korgools;
     */
    public int act(int startHole, boolean moveStartedFromThisPlayer,int opponentTuz){
      if(holes[startHole].getKorgools()<=1){
        return moveOneKorgool(startHole);
      }
      int movebleKorgools = holes[startHole].setKorgoolsToZero();
		  return moveKorgools(movebleKorgools,startHole,moveStartedFromThisPlayer,opponentTuz);
    }

    public int act(int startHole, int opponentTuz){
      return act(startHole,true, opponentTuz);
    }

    /**
     * Special case where is just one korgool contained in a holes
     *
     * @param pressedHole the number of the hole pressed in the
     * @return 1 if the hole is the last of the line, 0 otherwise ( not a boolean because we decided
     *     to keep it consistent with the method it's called from)
     */
    private int moveOneKorgool(int pressedHole) {
        if (holes[pressedHole].getKorgools() == 0) return 0;
        else {
            holes[pressedHole].setKorgoolsToZero();
            if (pressedHole < N_HOLES - 1) {
                holes[pressedHole + 1].korgoolsPlusOne();
                return 0;
            } else return 1;
        }
    }

  /**
   * When moveKorgools method is called from outside, it means it has to start from the first
   * hole, it only needs to know the korgoolsLeft
   *
   * @param korgoolsLeft: The left korgools to be distributed on board
   * @param moveStartedFromThisPlayer : True if the hole pressed this turn belongs with the
   *     current player, False otherwise;
   * @param opponentTuz: the hole containing opponent's tuz
   * @return 0 if all the korgools left have been moved, otherwise return the remaining korgools;
   */
	 public int moveKorgools(int korgoolsLeft, boolean moveStartedFromThisPlayer, int opponentTuz){
		   return moveKorgools(korgoolsLeft,0,moveStartedFromThisPlayer, opponentTuz);
	 }

   /**
    * Distribute the korgools taken from a hole into the following holes.
    *
    * @param korgoolsLeft: the korgools to redistribute.
    * @param currentHole: the hole to start from to redistribute
    * @param moveStartedFromThisPlayer : True if the hole pressed this turn belongs with the
    *     current player, False otherwise;
    * @return 0 if all the korgools have been redistributed, otherwise return the remaining
    *     korgools;
    */
	 private int moveKorgools(int korgoolsLeft,int currentHole, boolean moveStartedFromThisPlayer,int opponentTuz){

       while(korgoolsLeft>0){
          holes[currentHole].korgoolsPlusOne();
		      korgoolsLeft--;
          if(currentHole == N_HOLES-1){
            return korgoolsLeft;
          }
          currentHole++;
       }
       currentHole--;
       if(hasTuzOption(currentHole,moveStartedFromThisPlayer, opponentTuz)){
            holes[currentHole].setTuz();
            tuzIsAvailable = false;
        }
        return 0;
    }

    /**
     * Check if the player can set a tuz on a hole,
     *
     * @param currentHole : The hole to be tuzzed
     * @param moveStartedFromThisPlayer : True if the hole pressed this turn belongs with the
     *     current player, False otherwise;
     * @return True if the player can tuz such hole, False otherwise.
     */
    public boolean hasTuzOption(int currentHole, boolean moveStartedFromThisPlayer, int opponentTuz){
      return (tuzIsAvailable
              && holes[currentHole].isTuzzable()
              && currentHole != UNTUZZABLE_HOLE
              && !moveStartedFromThisPlayer
              && currentHole != N_HOLES-1-currentHole);
    }

    /**
     * Checks if the player has won
     *
     * @return if the player has has won
     */
    public boolean hasWon() {
        return kazan.hasWon();
    }

    /**
     * Empties the tuz and returns the number of korgools removed
     *
     * @return korgools removed from tuz if any, 0 otherwise*
     */
    public int emptyTuz() {
        for (Hole hole : holes) {
            if (hole.isTuz()) return hole.setKorgoolsToZero();
        }
        return 0;
    }

    /**
     * Increases the number of korgools in the kazan.
     *
     * @param numKorgools the number of korgools to add
     * @return the number of korgools added
     */
    public int addKorgoolsToKazan(int numKorgools) {
        kazan.increaseKorgoolsBy(numKorgools);
        return numKorgools;
    }

    /**
     * If the player has no korgools left in their holes they can't make a move
     *
     * @return True if the player has at least one possible move, False otherwise.
     */
    public boolean hasAMove() {
        for (Hole hole : holes) {
            if (hole.getKorgools() != 0) return true;
        }
        return false;
    }

    /**
     * Gets the string representation of the player's state
     *
     * @return the player's current state
     */
    @Override
    public String toString() {
        String stringToReturn = "";

        for (Hole hole : holes) {
            stringToReturn += hole.getKorgools() + ",";
        }

        stringToReturn += kazan.getKorgools() + ",";
        stringToReturn += getTuz();
        return stringToReturn;
    }
}
