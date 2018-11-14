public class Kazan extends Cell{
	private static final int KORGOOLS_TO_WIN = 82;
	private static final int STARTING_KARGOOLS = 0;

	public Kazan(){
		super(0);
	}

	public void increaseKorgoolsBy(int n){
		korgools+=n;
	}

	public boolean hasWon(){
		return getKorgools() >= KORGOOLS_TO_WIN;
	}
}
