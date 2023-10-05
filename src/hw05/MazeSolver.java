package hw05;
/**
 * Name:        <Adam Dixon>
 * CIN:         <304772993>
 * Course:      <CS 2013-07>
 * Section:     <34334>
 * Description: <Solves the maze puzzle by recursivly cheaking each cardinal direction until a valid route is found. If that route becomes invalid the method recursivly backtacks 
 * 				 until a new valid route is found. finally it prints the solution with the maze and as a coordinate path.>
 **/
import java.util.ArrayList;

/**
 * Class to solve the maze recursively.
 * 
 * @author <YOUR INFORMATION GOES HERE>
 *
 * YOU MAY ONLY CHANGE THE METHOD THAT IS INDICATED IN THIS CLASS.
 */

public class MazeSolver {

	
	/**
	 * Constructor is private since there is no need to instantiate this class as it only contains
	 * static methods.
	 */
	private MazeSolver() {}

	/**
	 * Public method to solve a maze using recursion.  This method creates two empty ArrayLists
	 * that the recursive helper method will need to solve the given maze.
	 * 
	 * @param maze The {@code Maze} object we want to solve.
	 */
	public static void solve(Maze maze) {
		//ArrayList to keep track of which coordinates are on the path from start to end.
		ArrayList<Coordinate> path = new ArrayList<>();

		//ArrayList to keep track of which coordinates you have already been to.
		ArrayList<Coordinate> history = new ArrayList<>();
		solve(maze, maze.getStart(), path, history);
	}

	/**
	 * The recursive helper method that YOU will implement.  This method will do all the work for
	 * solving the maze.  
	 * 
	 * @param maze	The {@code Maze} object to solve.
	 * 
	 * @param currentPos	The {@code Coordinate} object that keeps track of your current position in the maze.
	 * 
	 * @param path			The {@code ArrayList} of {@code Coordinate} objects that are currently on the path
	 * 						from the start of the maze to the end.  This ArrayList should only contain the 
	 * 						coordinates from start up to your current position, and eventually should contain
	 * 						all the coordinates from start to end.
	 * 
	 * @param history		The {@code ArrayList} of {@code Coordinate} objects that you have already visited.
	 * 						This helps you to keep track of where you have been so you do not check the same
	 * 						position more than once.
	 */
	private static void solve(Maze maze, Coordinate currentPos, ArrayList<Coordinate> path, ArrayList<Coordinate> history) {
		if (currentPos.equals(maze.getEnd())){
			path.add(currentPos);
			printResult(maze, path);

		} else {
			history.add(currentPos);
			path.add(currentPos);
	
			Coordinate nextPos = null;
	
			// Look position to the right
			nextPos = new Coordinate(currentPos.getRowIndex(), currentPos.getColIndex() + 1);
			if (nextPos.getColIndex() >= 0 && maze.getMazeValue(nextPos.getRowIndex(), nextPos.getColIndex()) != '+' && !history.contains(nextPos)) {
				solve(maze, nextPos, path, history);
			}
	
			// Look position above
			nextPos = new Coordinate(currentPos.getRowIndex() - 1, currentPos.getColIndex());
			if (nextPos.getRowIndex() >= 0 && maze.getMazeValue(nextPos.getRowIndex(), nextPos.getColIndex()) != '+' && !history.contains(nextPos)) {
				solve(maze, nextPos, path, history);
			}
	
			// Look position to the left
			nextPos = new Coordinate(currentPos.getRowIndex(), currentPos.getColIndex() - 1);
			if (nextPos.getColIndex() < maze.getNumCols() && maze.getMazeValue(nextPos.getRowIndex(), nextPos.getColIndex()) != '+' && !history.contains(nextPos)) {
				solve(maze, nextPos, path, history);
			}
	
			// Look position below
			nextPos = new Coordinate(currentPos.getRowIndex() + 1, currentPos.getColIndex());
			if (nextPos.getRowIndex() < maze.getNumRows() && maze.getMazeValue(nextPos.getRowIndex(), nextPos.getColIndex()) != '+' && !history.contains(nextPos)) {
				solve(maze, nextPos, path, history);
			}
	
			path.remove(path.size() - 1);
			history.remove(currentPos);
		}
	}
	/**
	 * Private method to print the final results once a solution has been found.
	 * 
	 * @param maze	A {@code Maze} object that we wish to display.
	 * @param path  An ArrayList of {@code Coordinate} objects that are on the path from the start
	 *              of the maze to the end.
	 */
	private static void printResult(Maze maze, ArrayList<Coordinate> path) {

		for (int i = 0 ; i < maze.getNumRows() ; i++) {
			for (int j = 0 ; j < maze.getNumCols(); j++) {
				Coordinate current = new Coordinate(i, j);
				
				if (current.equals(maze.getStart())) {
					System.out.print("S");
				}
				else {
					char ch = (path.contains(current) ? '*' : maze.getMazeValue(i, j));
					System.out.print(ch);
				}
			}
			System.out.println();
		}
		
		System.out.println("\nPATH:");
		
		for (int i = 1 ; i <= path.size() ; i++) {
			
			if (i == path.size()) {
				System.out.print(path.get(i - 1));
			}
			else {
				System.out.print(path.get(i - 1) + ", ");
			}
			
			
			if (i % 10 == 0)  {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}
}