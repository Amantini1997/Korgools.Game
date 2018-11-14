public class Player {
    private static final int N_HOLES = 9;
    private static final int UNTUZZABLE_HOLE = N_HOLES-1;//position in the array
    private Hole[] holes;
    private Kazan kazans;
    private boolean tuzIsAvailable;

    /**
     * Public constructor for Board game
     */
    public Player(){
      holes = new Hole[N_HOLES];
      kazans = new Kazan();
      tuzIsAvailable = true;
    }

    /**
     * Take the number of a hole, empty it and move all the balls
     * into the next holes. A tuz can be called after a move.
     * @param startHole : The position of the hole you want to empty
     * @return 0 if all the kargools moveble from the starting hole have been moved,
     * otherwise return the remaining kargools;
     */
    public int act(int startHole){
    	  int movebleKargools = holes[startHole].setKorgoolsToZero();
		    return moveKargools(movebleKargools,startHole);
    }


	 /**
	  * When moveKargools method is called from outside, it means it has to start from
	  * the first hole, it only needs to know the kargoolsLeft
	  * @param kargoolsLeft: The left kargools to be distributed on board
	  * @return 0 if all the kargools left have been moved,
    * otherwise return the remaining kargools;
    */
	 public int moveKargools(int kargoolsLeft){
		   return moveKargools(kargoolsLeft,0);
	 }

	 /**
    * Distribute the kargools taken from a hole into the following holes.
    * @param kargoolsLeft: the kargools to redistribute.
    * @param currentHole: the hole to start from to redistribute
    * @return 0 if all the kargools have been redistributed, otherwise
    * return the remaining kargools;
    */
	 public int moveKargools(int kargoolsLeft,int currentHole){
		   while(kargoolsLeft>0){
			      currentHole++;
            tuzIsAvailable = false;
			      holes[currentHole].korgoolsPlusOne();
			      kargoolsLeft--;
		   }
       if(hasTuzOption(currentHole)){
            hole[currentHole].setTuz();
            tuzIsAvailable = false;
       }
		   return 0;
	 }
    /**
     * Check if the player can still set a tuz,
     * @param n : The player who wants to set the tuz
     */
    public boolean hasTuzOption(int currentHole){
      return (tuzIsAvailable && holes[currentHole].isTuzzable() && currentHole != UNTUZZABLE_HOLE);
    }

    public boolean hasWon(){
      return kazan.hasWon();
    }

    public void addKorgoolsToKazan(int currentHole){
      int korgools = holes[currentHole].getKorgools();
      holes[currentHole].setKorgoolsToZero();
      kazan.increaseKorgoolsBy(korgools);
    }
}
