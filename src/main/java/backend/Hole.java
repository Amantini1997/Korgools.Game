package backend;
/**
 * Hole class that inherits from Cell. It contains korgools
 * and adds the functionality of a Hole in the game
 */
public class Hole extends Cell{
	private boolean isTuz;
	private static final int STARTING_KORGOOLS = 9;
	private static final int KORGOOLS_TO_TUZ = 3;


/**
*Initialises a Hole with the default number of korgools
*/
	public Hole(){
		super(STARTING_KORGOOLS);
		isTuz = false;
	}
	/**
	*Initialises a Hole with the given number of korgools
	*@param korgools the number of korgools in the hole
	*/
	public Hole(int korgools) {
		super(korgools);
		isTuz = false;
	}

	/**
	 * Return the korgools contained and then set them to 0.
	 * @return The number of korgools
	 */
	public int setKorgoolsToZero(){
		int temp = korgools;
		korgools = 0;
		return temp;
	}

	/**
	*Increases the number of korgools by one
	*/
	public void korgoolsPlusOne(){
		korgools++;
	}
	/**
	*Sets the hole as a tuz
	*/
	public void setTuz(){
		isTuz = true;
	}
	/**
	*Checks if the hole is a tuz
	*@return if the hole is a tuz
	*/
	public boolean isTuz(){
		return isTuz;
	}
	/**
	*Checks if the hole can become a tuz
	@return if the hole can become a tuz
	*/
	public boolean isTuzzable(){
		return(!isTuz && korgools==KORGOOLS_TO_TUZ);
	}
}
