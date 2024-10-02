package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class which represents a Maze object. Contains data fields to store the characters that make
 * up the maze (in a 2D array of type char.), Coordinate objects for the start and the end positions
 * in the maze.
 */
public class Maze {
	private char[][] maze;
	private Coordinate start;
	private Coordinate end;

	/**
	 * Constructor to create a maze object given the maze data, and the start and end
	 * coordinates.
	 */
	public Maze(char[][] maze, Coordinate start, Coordinate end) {
		this.initMaze(maze);
		this.start = start;
		this.end = end;
	}

	/**
	 * Method to read in a maze from a file.
	 */
	public static Maze readMaze(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            char[][] mazeData = new char[rows][cols];
            Coordinate start = null;
            Coordinate end = null;

            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < cols; j++) {
                    mazeData[i][j] = line.charAt(j);
                    if (mazeData[i][j] == 'S') {
                        start = new Coordinate(i, j);
                    } else if (mazeData[i][j] == 'E') {
                        end = new Coordinate(i, j);
                    }
                }
            }

            return new Maze(mazeData, start, end);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getName());
            return null;
        }
    }
	
	/**
	 * Private method to initialize the maze data field using the data from the maze parameter.
	 * This method is to ensure that the internal maze is a deep copy of the data read from the file
	 * so the maze cannot be changed one it has been initialized.
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
	 */
	public Coordinate getStart() {
		return this.start;
	}
	
	/**
	 * Method to return the ending coordinate.
	 */
	public Coordinate getEnd() {
		return this.end;
	}
	
	/**
	 * Method to return the char value from the maze at the given row and column indexes.
	 */
	public char getMazeValue(int row, int col) {
		return this.maze[row][col];
	}
	
	/**
	 * Method to return the number of rows in this maze.
	 */
	public int getNumRows() {
		return this.maze.length;
	}
	
	/**
	 * Method to return the number of columns in this maze.
	 */
	public int getNumCols() {
		return this.maze[0].length;
	}
	
	/**
	 * Method to print a String representation of this maze. The string includes the start and end
	 * coordinates, as well as a visual console visualization of what the maze looks like.
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