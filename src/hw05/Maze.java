package hw05;

/**
 * Class which represents a Maze object.  Contains data fields to store the characters that make
 * up the maze (in a 2D array of type char.), Coordinate objects for the start and the end positions
 * in the maze.
 * 
 * @author Keenan Knaur for CS2013
 * 
 * DO NOT CHANGE THE CODE IN THIS CLASS.
 * 
 * @see {@code Coordinate}
 */
public class Maze {
	private char[][] maze;
	private Coordinate start;
	private Coordinate end;

	/**
	 * Constructor to create a maze object given the maze data, and the start and end
	 * coordinates.
	 * 
	 * @param maze	A 2D char array that holds the character data for each position in the maze.
	 *              Each character is an S (indicating the start position), an E (indicating the
	 *              exit from the maze), an O (indicating a possible path through the maze), or a 
	 *              + sign (indicating a wall in the maze).
	 * 
	 * @param start The starting {@code Coordinate} position in the maze.  See {@code Coordinate} class
	 *              for more details.
	 * 
	 * @param end   The ending {@code Coordinate} position in the maze.  See {@code Coordinate} class
	 *              for more details.
	 */
	public Maze(char[][] maze, Coordinate start, Coordinate end) {
		this.initMaze(maze);
		this.start = start;
		this.end = end;
	}
	
	/**
	 * Private method to initialize the maze data field using the data from the maze parameter.
	 * This method is to ensure that the internal maze is a deep copy of the data read from the file
	 * so the maze cannot be changed one it has been initialized.
	 * 
	 * @param maze	The maze data (containing all the characters that make-up the maze) which was 
	 * 				previously read from a file.
	 */
	private void initMaze(char[][] maze) {
		this.maze = new char[maze.length][maze[0].length];
	
		for (int i = 0 ; i < maze.length ; i++) {
			for (int j = 0 ; j < maze[i].length; j++) {
				this.maze[i][j] = maze[i][j];
			}
		}
	}
	
	/**
	 * Method to return the starting coordinate.
	 * 
	 * @return	A {@code Coordinate} object that represents the starting position in the maze.
	 */
	public Coordinate getStart() {
		return this.start;
	}
	
	/**
	 * Method to return the ending coordinate.
	 * 
	 * @return	A {@code Coordinate} object that represents the ending position in the maze.
	 */
	public Coordinate getEnd() {
		return this.end;
	}
	
	/**
	 * Method to return the char value from the maze at the given row and column indexes.
	 * 
	 * @param row	The row index of the value to retrieve.
	 * @param col   The colulmn index of the value to retrieve.
	 * @return		A char value that is stored at position (row, col) in the maze.
	 */
	public char getMazeValue(int row, int col) {
		return this.maze[row][col];
	}
	
	/**
	 * Method to return the number of rows in this maze.
	 * 
	 * @return An integer representing the number of rows in this maze.
	 */
	public int getNumRows() {
		return this.maze.length;
	}
	
	/**
	 * Method to return the number of columns in this maze.
	 * 
	 * @return An integer representing the number of c in this maze.
	 */
	public int getNumCols() {
		return this.maze[0].length;
	}
	
	/**
	 * Method to print a String representation of this maze. The string includes the start and end
	 * coordinates, as well as a visual console visualization of what the maze looks like.
	 * 
	 * @return A string representation of this maze object.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("Start:\t" + this.start + "\n");
		result.append("End:\t" + this.end + "\n");
		for (int i = 0 ; i < this.maze.length ; i++) {
			for (int j = 0 ; j < this.maze[i].length ; j++) {
				result.append(this.maze[i][j]);
			}
			result.append("\n");
		}
		
		return result.toString();
	}
}