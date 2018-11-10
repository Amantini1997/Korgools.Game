public class Hole extends Cell{

	public Hole(boolean isWhite,int korgools){
		super(isWhite,korgools);
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

	public void KorgoolsPlusOne(){
		korgools++;
	}
}
