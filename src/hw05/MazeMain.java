package hw05;

import java.io.File;
import java.util.Scanner;
/**
 * Main class to run the program.
 * 
 * @author Keenan Knaur for CS2013
 *
 */
public class MazeMain {
	public static void main(String[] args) {
		
		//Get a list of all the mazes
		File[] mazes = new File("src/maze_files").listFiles();

		while(true) {
			File mazeChoice = mazeMenu(mazes);
			
			System.out.println("=========================================================");
			System.out.println("Solving " + mazeChoice.getName());
			System.out.println("=========================================================");
			Maze maze = MazeReader.readMaze(mazeChoice);
			MazeSolver.solve(maze);
			System.out.println("=========================================================");
		}	
	}
	
	
	public static File mazeMenu(File[] mazes) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("================MAZE MENU===================");
		
		for (int i = 0 ; i < mazes.length ; i++) {
			System.out.println((i + 1) + ". " + mazes[i].getName());
		}
		System.out.println("0. Exit Program");
		
		while(true) {
			System.out.print("Enter your maze choice (1-" + mazes.length + ") or 0 to exit: ");
			
			int choice = in.nextInt();
			System.out.println();
			
			if (choice == 0) {
				System.out.println("Program will now exit.");
				System.exit(0);
			}
			else if (choice > mazes.length) {
				System.out.println("ERROR: The value you entered is not a valid option. Please try again!");
				continue;
			}
			else {
				return mazes[choice-1];
			}
			in.close();
		}
	}
}
