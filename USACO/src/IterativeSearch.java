import java.io.*;
import java.util.*;
public class IterativeSearch {
	static ArrayList<ArrayList<Integer>> adjacent;
	static int[][] grid;
	static int n, m;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
//		m = in.nextInt();
		adjacent = new ArrayList<ArrayList<Integer>>();
		grid = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j] = 0;
//				System.out.print(grid[i][j]);
			}
//			System.out.println();
		}
//		for (int i=0; i<n; i++) {
//			adjacent.add(new ArrayList<Integer>());
//		}
//		for (int i=0; i<m; i++) {
//			int a = in.nextInt();
//			int b = in.nextInt();
//			adjacent.get(a).add(b);
//			adjacent.get(b).add(a);
//		}
//		dfs(0);
		dfsFloodFill(1, 1);
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];
		visited[node] = true;
		queue.add(node);
		while (!queue.isEmpty()) {
			int current = queue.peek();
			System.out.println(current);
			queue.poll();
			for (int i=0; i<adjacent.get(current).size(); i++) {
				if (!visited[adjacent.get(current).get(i)]) {
					visited[adjacent.get(current).get(i)] = true;
					queue.add(adjacent.get(current).get(i));
				}
			}
		}
		
	}
	public static void dfs(int node) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[n];
		visited[node] = true;
		stack.add(node);
		while (!stack.isEmpty()) {
			int current = stack.peek();
			System.out.println(current);
			stack.pop();
			for (int i=0; i<adjacent.get(current).size(); i++) {
				if (!visited[adjacent.get(current).get(i)]) {
					visited[adjacent.get(current).get(i)] = true;
					stack.push(adjacent.get(current).get(i));
				}
			}
		}
	}
	public static void bfsFloodFill(int i, int j) {
		Queue<Location2> queue = new LinkedList<Location2>();
		boolean[][] visited = new boolean[n][n];
		visited[i][j] = true;
		queue.add(new Location2(i, j));
		while (!queue.isEmpty()) {
			Location2 current = queue.peek();
			System.out.println(current.x + " " + current.y);
			queue.poll();
			if (current.x>0) {
				if (!visited[current.x-1][current.y] && grid[current.x-1][current.y] ==grid[current.x][current.y]) {
					visited[current.x-1][current.y] = true;
					queue.add(new Location2(current.x-1, current.y));
				}
			}
			if (current.y>0) {
				if (!visited[current.x][current.y-1] && grid[current.x][current.y] ==grid[current.x][current.y-1]) {
					visited[current.x][current.y-1] = true;
					queue.add(new Location2(current.x, current.y-1));
				}
			}
			if (current.x<n-1) {
				if (!visited[current.x+1][current.y] && grid[current.x+1][current.y] ==grid[current.x][current.y]) {
					visited[current.x+1][current.y] = true;
					queue.add(new Location2(current.x+1, current.y));
				}
			}
			if (current.y<n-1) {
				if (!visited[current.x][current.y+1] && grid[current.x][current.y+1] ==grid[current.x][current.y]) {
					visited[current.x][current.y+1] = true;
					queue.add(new Location2(current.x, current.y+1));
				}
			}
		}
		
	}
	public static void dfsFloodFill(int i, int j) {
		Stack<Location2> queue = new Stack<Location2>();
		boolean[][] visited = new boolean[n][n];
		visited[i][j] = true;
		queue.add(new Location2(i, j));
		while (!queue.isEmpty()) {
			Location2 current = queue.peek();
			System.out.println(current.x + " " + current.y);
			queue.pop();
			if (current.x>0) {
				if (!visited[current.x-1][current.y] && grid[current.x-1][current.y] ==grid[current.x][current.y]) {
					visited[current.x-1][current.y] = true;
					queue.add(new Location2(current.x-1, current.y));
				}
			}
			if (current.y>0) {
				if (!visited[current.x][current.y-1] && grid[current.x][current.y] ==grid[current.x][current.y-1]) {
					visited[current.x][current.y-1] = true;
					queue.add(new Location2(current.x, current.y-1));
				}
			}
			if (current.x<n-1) {
				if (!visited[current.x+1][current.y] && grid[current.x+1][current.y] ==grid[current.x][current.y]) {
					visited[current.x+1][current.y] = true;
					queue.add(new Location2(current.x+1, current.y));
				}
			}
			if (current.y<n-1) {
				if (!visited[current.x][current.y+1] && grid[current.x][current.y+1] ==grid[current.x][current.y]) {
					visited[current.x][current.y+1] = true;
					queue.add(new Location2(current.x, current.y+1));
				}
			}
		}
		
	}
	
}

class Location2 {
	int x, y;
	public Location2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
