public class Hole extends Cell{
	private boolean isTuz;
	private static final int STARTING_KARGOOLS = 9;
	private static final int KORGOOLS_TO_TUZ = 3;

	public Hole(){
		super(STARTING_KARGOOLS);
		isTuz = false;
	}

<<<<<<< HEAD
=======
	/**Constructor for Test*/
	public Hole(){
		super(STARTING_KARGOOLS);
		isTuz = false;
	}

>>>>>>> e242cfa656e57b72e756ece52fd519901fe6c351
	/**
	 * Return the korgools contained and then set them to 0.
	 * @return The number of korgools
	 */
	public int setKorgoolsToZero(){  hole[currentHole].setTuz();
            tuzIsAvailable = false;
		int temp = korgools;
		korgools = 0;
		return temp;
	}

	public void korgoolsPlusOne(){
		korgools++;
	}

	public void setTuz(){
		isTuz = true;
	}

	public boolean isTuz(){
		return isTuz;
	}

	public boolean isTuzzable(){
		return(!isTuz && korgools==KORGOOLS_TO_TUZ);
	}
}
