package backend;
/**
 *Cell class. It is in charge of storing and allowing access
 *to the number of korgools present in it.
 */
public class Cell {
	protected int korgools; //The number of korgools inside the cell

	/**
	 *Initialises the cell
	 *@param korgools the number of korgools the cell has inside
	 */
	public Cell(int korgools){
		this.korgools = korgools;
	}

	/**
	 *Gets the number of korgools in the cell
	 *@return the number of korgools
	 */
	public int getKorgools(){
		return korgools;
	}
}
