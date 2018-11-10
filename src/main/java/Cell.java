public class Cell {
	protected boolean isWhite;
	protected int korgools;
	
	public Cell(boolean isWhite,int korgools){
		this.isWhite = isWhite;
		this.korgools = korgools;
	}
	
	public boolean isWhite(){
		return isWhite;
	}

	public int getKorgools(){	
		return korgools;
	}
}
