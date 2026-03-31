package Recursion.Backtracking;

/*
	 * RAT IN A MAZE (Backtracking)
	 *
	 * Original Question:
	 * You are given a maze of size m x n where:
	 * - '0' means open cell
	 * - 'X' means blocked cell
	 *
	 * A rat starts at the top-left cell (0, 0) and wants to reach
	 * the bottom-right cell (m - 1, n - 1).
	 *
	 * The rat can move only:
	 * - Right  (i, j + 1)
	 * - Down   (i + 1, j)
	 *
	 * Print one valid path using a solution matrix where:
	 * - 1 indicates the path cell
	 * - 0 indicates not part of the path
	 *
	 * Extension:
	 * Print all possible valid paths as well.
	 *
	 * If no path exists, print "No path found".
	 *
	 * Example maze:
	 * 0 0 0 0
	 * 0 X 0 X
	 * 0 0 0 0
	 * X X 0 0
	 */


public class RatInMaze {

	static boolean ratInMaze(char[][] maze, int[][] sol, int i, int j, int m, int n) {
		if (i == m - 1 && j == n - 1 && maze[i][j] != 'X') {
			sol[i][j] = 1;
			return true;
		}

		if (i >= m || j >= n || maze[i][j] == 'X') {
			return false;
		}

		sol[i][j] = 1;

		if (ratInMaze(maze, sol, i, j + 1, m, n)) {
			return true;
		}

		if (ratInMaze(maze, sol, i + 1, j, m, n)) {
			return true;
		}
        
		sol[i][j] = 0;
		return false;
	}

	static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	static void ratInMazeAllPaths(char[][] maze,int[][] sol,int i,int j,int m,int n,String path,int[] totalPaths) {
		if (i >= m || j >= n || maze[i][j] == 'X') {
			return;
		}

		sol[i][j] = 1;

		if (i == m - 1 && j == n - 1) {
			totalPaths[0]++;
			System.out.println("Path " + totalPaths[0] + " (moves: " + path + "):");
			printMatrix(sol);
			System.out.println();
			sol[i][j] = 0;
			return;
		}

		ratInMazeAllPaths(maze, sol, i, j + 1, m, n, path + "R", totalPaths);
		ratInMazeAllPaths(maze, sol, i + 1, j, m, n, path + "D", totalPaths);
		sol[i][j] = 0;
	}

	public static void main(String[] args) {
		char[][] maze = {
				{'0', '0', '0', '0'},
				{'0', 'X', '0', 'X'},
				{'0', '0', '0', '0'},
				{'X', 'X', '0', '0'}
		};

		int m = maze.length;
		int n = maze[0].length;
		int[][] sol = new int[m][n];

		boolean pathExists = ratInMaze(maze, sol, 0, 0, m, n);

		if (pathExists) {
			System.out.println("Path matrix:");
			printMatrix(sol);
		} else {
			System.out.println("No path found");
		}

		System.out.println();
		System.out.println("All possible paths:");
		int[][] allPathSol = new int[m][n];
		int[] totalPaths = {0};
		ratInMazeAllPaths(maze, allPathSol, 0, 0, m, n, "", totalPaths);
		if (totalPaths[0] == 0) {
			System.out.println("No path found");
		} else {
			System.out.println("Total paths: " + totalPaths[0]);
		}
	}
}
