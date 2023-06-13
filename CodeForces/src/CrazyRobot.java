import java.io.*;
import java.util.*;
public class CrazyRobot {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int labX = 0, labY = 0;
			char[][] grid = new char[n][m];
			for (int i=0; i<n; i++) {
				grid[i] = in.next().toCharArray();
				for (int j=0; j<m; j++) {
					if (grid[i][j]=='L') {
						labX = i;
						labY = j;
					}
				}
			}
			floodfill(labX, labY, grid, new boolean[n][m]);
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if (i==labX && j==labY) {
						in.pr.print('L');
					}
					else in.pr.print(grid[i][j]);
				}
				in.pr.println();
			}
		}
		in.pr.close();
	}
	public static void floodfill(int x, int y, char[][] grid, boolean[][] visited) {
		if (visited[x][y]) return;
		visited[x][y] = true;
		grid[x][y] = '+';
		if (x<grid.length-1 && grid[x+1][y]=='.') {
			if (freeNeighbors(x+1, y, grid)<=1) {
				floodfill(x+1, y, grid, visited);
			}
		}
		if (x>0 && grid[x-1][y]=='.') {
			if (freeNeighbors(x-1, y, grid)<=1) {
				floodfill(x-1, y, grid, visited);
			}
		}
		if (y<grid[0].length-1 && grid[x][y+1]=='.') {
			if (freeNeighbors(x, y+1, grid)<=1) {
				floodfill(x, y+1, grid, visited);
			}
		}
		if (y>0 && grid[x][y-1]=='.') {
			if (freeNeighbors(x, y-1, grid)<=1) {
				floodfill(x, y-1, grid, visited);
			}
		}
	}
	public static int freeNeighbors(int x, int y, char[][] grid) {
		int count = 0;
		if (x<grid.length-1) {
			if (grid[x+1][y]=='.') count++;
		}
		if (x>0) {
			if (grid[x-1][y]=='.') count++;
		}
		if (y<grid[0].length-1) {
			if (grid[x][y+1]=='.') count++;
		}
		if (y>0) {
			if (grid[x][y-1]=='.') count++;
		}
		return count;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
	        pr = new PrintWriter(System.out);
	    }
	    

	    public String next() throws IOException
	    {
	        while (st == null || !st.hasMoreElements()) {
	           
	            st = new StringTokenizer(br.readLine());
	        }
	        return st.nextToken();
	    }

	    public int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

	    public long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

	    public double nextDouble() throws NumberFormatException, IOException
	    {
	        return Double.parseDouble(next());
	    }

	    public String nextLine() throws IOException
	    {
	        String str = br.readLine();
	        return str;
	    }
	}
}
