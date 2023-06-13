import java.io.*;
import java.util.*;
public class EscapeRoom {
	static int n, m;
	static int[][] grid;
	static boolean [][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new FileReader(new File("USACOinput1")));
		StringTokenizer st = new StringTokenizer(bi.readLine());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bi.readLine());
		n = Integer.parseInt(st.nextToken());
		grid = new int[m+1][n+1];
		visited = new boolean[m+1][n+1];
		for (int i=1; i<=m; i++) {
			st = new StringTokenizer(bi.readLine());
			for (int j=1; j<=n; j++) {
				int a = Integer.parseInt(st.nextToken());
				grid[i][j] = a;
			}
		}
		getDivisors(3);
		dfs(1, 1);
	}
	
	public static ArrayList<Coordinate> getDivisors(int a) {
		ArrayList<Coordinate> coors = new ArrayList<Coordinate>();
		for (int i=1; i<Math.sqrt(a) && (i<=n||i<=m); i++) {
			double b = ((double) a)/((double) i);
			if (b%1==0) {
				
				if (b<=n && i<=m) {
					Coordinate coor = new Coordinate(i, ((int) b));
					coors.add(coor);
//					System.out.println(coor.x + " " + coor.y);
				}
				if (b<=m && i<=n) {
					Coordinate coor = new Coordinate(((int) b), i);
					coors.add(coor);
//					System.out.println(coor.x + " " + coor.y);
				}
			}
		}
		return coors;
	}
	
	public static void dfs(int x, int y) {
		Stack<Coordinate> stack = new Stack<Coordinate>();
		visited[x][y] = true;
		stack.add(new Coordinate(x, y));
		
		while (!stack.isEmpty()) {
			Coordinate current = stack.pop();
			System.out.println(grid[current.x][current.y]);
			if (current.x==m && current.y==n) return;
			ArrayList<Coordinate> coors = getDivisors(grid[current.x][current.y]);
			for (int i=0; i<coors.size(); i++) {
				if (!visited[coors.get(i).x][coors.get(i).y]) {
					visited[coors.get(i).x][coors.get(i).y] = true;
					stack.add(new Coordinate(coors.get(i).x, coors.get(i).y));
				}
			}
		}
		
	}
}

class Coordinate {
	int x, y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
