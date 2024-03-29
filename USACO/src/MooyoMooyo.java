import java.io.*;
import java.util.*;
public class MooyoMooyo {
	static int n, k;
	static int[][] grid;
	static Scanner in;
	static boolean[][] visited;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		grid = new int[n][10];
		visited = new boolean[n][10];
		for (int i=0; i<n; i++) {
			String n = in.next();
			for (int j=0; j<10; j++) {
				grid[i][j] = Integer.parseInt(String.valueOf(n.charAt(j)));
			}
		}
		cycle();
		cycle();
		System.out.println();
		for (int i=0; i<n; i++) {
			for (int j=0; j<10; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		
	}

	private static void cycle() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<10; j++) {
				if (!visited[i][j]) {
					ArrayList<Position> results = floodfill(i, j, new ArrayList<Position>());
					System.out.println(results.size());
					if (results.size()>k) {
						System.out.println("Remove this!");
						for (int k=0; k<results.size(); k++) {
							grid[results.get(k).x][results.get(k).y] = 0;
						}
					}
					System.out.println();
				}
					
			}
		}
		visited = new boolean[n][10];
//		
		for (int i=0; i<10; i++) {
			gravity(i);
			
		}
	}
	
	public static ArrayList<Position> floodfill(int x, int y, ArrayList<Position> results) {
		if (x>=n||x<0||y>=10||y<0) return results;
		if (visited[x][y]) return results;
		visited[x][y] = true;
		results.add(new Position(x,y));
		System.out.println(grid[x][y]);
		if (y+1<10) {
			if (grid[x][y]==grid[x][y+1]) {
				floodfill(x, y+1, results);
			}
		}
		
		if (y-1>=0) {
			if (grid[x][y]==grid[x][y-1]) {
				floodfill(x, y-1, results);
			}
		}
		
		if (x+1<n) {
			if (grid[x][y]==grid[x+1][y]) {
				floodfill(x+1, y, results);
			}
		}
		
		if (x-1>=0) {
			if (grid[x][y]==grid[x-1][y]) {
				floodfill(x-1, y, results);
			}
		}
		
		return results;
		
	}
	
	public static void gravity(int column) {
		while (needsGravity(column)) {
			for (int row = n-1; row>0; row--) {
				if (grid[row][column]==0 && grid[row-1][column]!=0) {
					grid[row][column] = grid[row-1][column];
					grid[row-1][column] = 0;
				}
			}
		}
		
	}
	
	public static boolean needsGravity(int column) {
		for (int row =n-1; row>0; row--) {
			if (grid[row][column]==0 && grid[row-1][column]!=0) {
				return true;
			}
		}
		return false;
	}
	
}
class Position {
	int x, y;
	public Position(int x, int y) {
		this.x =x;
		this.y =y;
	}
}
