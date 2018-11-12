public class Hole extends Cell{
	private boolean isTuz;
	private static final STARTING_KARGOOLS = 9;

	public Hole(){
		super(STARTING_KARGOOLS);
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

	public void korgoolsPlusOne(){
		korgools++;
	}

	public void setTuz(){
		isTuz = false;
	}

	public boolean isTuz(){
		return isTuz;
	}
}
