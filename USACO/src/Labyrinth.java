import java.io.*;
import java.util.*;

public class Labyrinth {
	static char[][] grid;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		grid = new char[n][m];
		visited = new boolean[n][m];
		for (int i=0; i<n; i++) {
			String line = in.nextLine();
			for (int j=0; j<m; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		
		
	}
	public static void floodfill(int x, int y) {
		if (x>=grid.length || x<0 || y>grid[0].length || y<0) return;
		if (visited[x][y]) return;
		visited[x][y] = true;
		floodfill(x+1, y);
		floodfill(x-1, y);
		floodfill(x, y+1);
		floodfill(x, y-1);
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	            new InputStreamReader(System.in));
	       
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
