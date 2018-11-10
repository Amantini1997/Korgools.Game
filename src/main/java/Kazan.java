public class Kazan extends Cell{
	private static final int KORGOOLS_TO_WIN = 82;

	public Kazan(boolean isWhite){
		super(isWhite,0);
	}

	public void increaseKorgoolsBy(int n){
		korgools+=n;
	}

	public boolean isWinning(){
		return korgools >= KORGOOLS_TO_WIN;
	}
}
