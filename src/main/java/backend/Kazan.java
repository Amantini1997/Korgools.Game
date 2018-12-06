package backend;
/**
*Kazan class that extends from Cell. Implements the behaviour
*of a Kazan in the game.
*/
public class Kazan extends Cell{
	private static final int KORGOOLS_TO_WIN = 82;
	private static final int STARTING_KARGOOLS = 0;

	/**
	*Initialises the kazan
	*/
	public Kazan(){
		super(0);
	}
	/**
	*Initialises the kazan with the given number of korgools
	*@param korgools the initial number of korgools
	*/
	public Kazan(int korgools) {
		super(korgools);
	}

	/**
	*Increases the korgools in the kazan by a given amount
	*@param n the number to increase the korgools by
	*/
	public void increaseKorgoolsBy(int n){
		korgools+=n;
	}
	/**
	*Checks whether the player has enough korgools
	*in the kazan tu win
	*@return if the player has won
	*/
	public boolean hasWon(){
		return getKorgools() >= KORGOOLS_TO_WIN;
	}

}
