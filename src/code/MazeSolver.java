package code;
/**
 * Author:        <Adam Dixon>
 * Description: <Solves the maze puzzle by recursivly cheaking each cardinal direction until a valid route is found. If that route becomes invalid the method recursivly backtacks 
 * 				 until a new valid route is found. finally it prints the solution with the maze and as a coordinate path.>
 **/
import java.util.ArrayList;

/**
 * Class to solve the maze recursively.
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
			if (nextPos.getColIndex() < maze.getNumCols() && maze.getMazeValue(nextPos.getRowIndex(), nextPos.getColIndex()) != '+' && !history.contains(nextPos)) {
				solve(maze, nextPos, path, history);
			}
	
			// Look position above
			nextPos = new Coordinate(currentPos.getRowIndex() - 1, currentPos.getColIndex());
			if (nextPos.getRowIndex() >= 0 && maze.getMazeValue(nextPos.getRowIndex(), nextPos.getColIndex()) != '+' && !history.contains(nextPos)) {
				solve(maze, nextPos, path, history);
			}
	
			// Look position to the left
			nextPos = new Coordinate(currentPos.getRowIndex(), currentPos.getColIndex() - 1);
			if (nextPos.getColIndex() >= 0 && maze.getMazeValue(nextPos.getRowIndex(), nextPos.getColIndex()) != '+' && !history.contains(nextPos)) {
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