package hw05;


/**
 * 
 * This class represents a coordinate in the maze.  It stores the index of the
 * current row and the index of the current column as integer values.
 * 
 * @author Keenan Knaur for CS2013
 *
 * DO NOT CHANGE THE CODE IN THIS CLASS.
 */
public class Coordinate {
	private int rowIndex;
	private int colIndex;
	
	/**
	 * Creates a Coordinate from two integer values rowIndex and colIndex.
	 * 
	 * @param rowIndex The index of the current row.
	 * @param colIndex The index of the current column.
	 */
	public Coordinate(int rowIndex, int colIndex) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
	
	/**
	 * Return the value of the row index.
	 * 
	 * @return The value of the row index as an integer.
	 */
	public int getRowIndex() {
		return this.rowIndex;
	}
	
	/**
	 * Return the value of the column index.
	 * 
	 * @return The column index as an integer.
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
	 * 
	 * @return Returns a boolean indicating whether or not the two Coordinate objects are equal.
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
	 * 
	 * @return A string representing this Coordinate object.
	 */
	public String toString() {
		return "(" + this.rowIndex + ", " + this.colIndex + ")";
	}	
}