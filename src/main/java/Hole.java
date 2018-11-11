public class Hole extends Cell{

	private boolean isTuz;

	public Hole(boolean isWhite,int korgools){
		super(isWhite,korgools);
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

	public void KorgoolsPlusOne(){
		korgools++;
	}

	public void setTuz(){
		isTuz = false;
	}

	public boolean isTuz(){
		return isTuz;
	}
}
