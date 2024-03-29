import java.io.*;
import java.util.*;
public class WheresBessie {
	static int n;
	static char[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new FileReader(new File("USACOinput1")));
		StringTokenizer st = new StringTokenizer(bi.readLine());
		n = Integer.parseInt(st.nextToken());
		grid = new char[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(bi.readLine());
			String s = st.nextToken();
			for (int j=0; j<n; j++) {
				char a = s.charAt(j);
				grid[i][j] = a;
			}
		}
//		floodfill(new PCL(0, 0, 2, 2), 'B', 0, 1, new boolean[n][n]);
		check(new PCL(0,0,3,3));
	}
	
	public static boolean check(PCL pcl) {
		Set<Character> chars = new HashSet<Character>();
		for (int i=pcl.x1; i<=pcl.x2; i++) {
			for (int j=pcl.y1; j<pcl.y2; j++) {
				chars.add(grid[i][j]);
			}
		}
		if (chars.size()!=2) return false;
		boolean[][] visited = new boolean[n][n];
		for (int i=pcl.x1; i<=pcl.x2; i++) {
			for (int j=pcl.y1; j<pcl.y2; j++) {
				if (!visited[i][j]) {
					floodfill(pcl, grid[i][j], i, j, visited);
				}
				
			}
		}
		return false;
	}
	public static void floodfill(PCL pcl, char c, int x1, int y1, boolean[][] visited) {
		Stack<Coord> stack = new Stack<Coord>();
		
		visited[x1][y1] = true;
		stack.add(new Coord(x1, y1));
		while (!stack.isEmpty()) {
			Coord current = stack.pop();
			System.out.println(current.x + " " + current.y);
			if (current.x+1<=pcl.x2 && !visited[current.x+1][current.y] && grid[current.x+1][current.y]==c) {
				visited[current.x+1][current.y] = true;
				stack.add(new Coord(current.x+1, current.y));
			}
			if (current.y+1<=pcl.y2 && !visited[current.x][current.y+1]&& grid[current.x][current.y+1]==c) {
				visited[current.x][current.y+1] = true;
				stack.add(new Coord(current.x, current.y+1));
			}
			if (current.x-1>=pcl.x1 && !visited[current.x-1][current.y]&& grid[current.x-1][current.y]==c) {
				visited[current.x-1][current.y] = true;
				stack.add(new Coord(current.x-1, current.y));
			}
			if (current.y-1>=pcl.y1 && !visited[current.x][current.y-1] && grid[current.x][current.y-1]==c) {
				visited[current.x][current.y-1] = true;
				stack.add(new Coord(current.x, current.y-1));
			}
		}
		
	}
}

class PCL {
	int x1, y1, x2, y2;
	public PCL(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}

class Coord {
	int x, y;
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
