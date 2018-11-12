public class Player {
    private static final int N_HOLES = 9;
    private Hole[] holes;
    private Kazan kazans;
    private boolean tuz;

    /**
     * Public constructor for Board game
     */
    public Player(){
      holes = new Hole[N_HOLES];
      kazans = new Kazan();
      tuz = true;
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
			      if(currentHole==N_HOLES){
				          //the current player holes are terminated, let's switch player
				          return kargoolsLeft;
			      }
			      holes[currentHole].korgoolsPlusOne();
			      kargoolsLeft--;
		   }
       if(hasTuzOption(currentHole)){
            if(playerWantsToTuz()){

            }
       }
		   return 0;
	 }
    /**
     * Check if the player can still set a tuz,
     * @param n : The player who wants to set the tuz
     */
    public boolean hasTuzOption(int currentHole){
      return (tuz && holes[currentHole].isTuzzable());
    }

    public boolean playerWantsToTuz(){
      //TO-DO: implement this method so that the actual player
      //is asked if they want to set the hole as a tuz
      return true;
    }

}
