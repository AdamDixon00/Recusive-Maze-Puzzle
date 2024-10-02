package code;


/**
 * 
 * This class represents a coordinate in the maze.  It stores the index of the
 * current row and the index of the current column as integer values.
 */
public class Coordinate {
	private int rowIndex;
	private int colIndex;
	
	/**
	 * Creates a Coordinate from two integer values rowIndex and colIndex.
	 */
	public Coordinate(int rowIndex, int colIndex) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
	
	/**
	 * Return the value of the row index.
	 */
	public int getRowIndex() {
		return this.rowIndex;
	}
	
	/**
	 * Return the value of the column index.
	 */
	public int getColIndex() {
		return this.colIndex;
	}
	
	/**
	 * Method which checks whether or not two Coordinate objects are equal to one another.
	 * Two Coordinate objects are equal to one another if they have the same rowIndex and
	 * colIndex values.
	 * 
	 * Returns false if other is null, or other is not an instance of the Coordinate class.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (this == other) {
			return true;
		}
		
		if(!(other instanceof Coordinate)) {
			return false;
		}
		
		Coordinate temp = (Coordinate)(other);
		return this.rowIndex == temp.rowIndex && this.colIndex == temp.colIndex;	
	}



	/**
	 * Returns a String representation of a Coordinate object in the form (rowIndex, colIndex).
	 */
	public String toString() {
		return "(" + this.rowIndex + ", " + this.colIndex + ")";
	}	
}