import java.io.*;
import java.util.*;
public class Beach {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int l = in.nextInt();
			int[][] grid = new int[2*k][n+2];
			for (int i=0; i<n; i++) {
				int depth = in.nextInt();
				grid[0][i+1] = depth;
			}
			for (int i=1; i<2*k; i++) {
				for (int j=1; j<n+1; j++) {
					if (i<=k) {
						grid[i][j] = grid[i-1][j]+1;
					}
					else {
						grid[i][j] = grid[i-1][j]-1;
					}
				}
			}
//			
			boolean[][] visited = new boolean[2*k][n+2];
			floodfill(0, 0, grid, visited, l, k);
			boolean works = false;
			for (int i=0; i<2*k; i++) {
				if (visited[i][n+1]) {
					works = true;
					break;
				}
			}

			if (works) System.out.println("Yes");
			else System.out.println("No");
		}
	}
	public static void floodfill(int x, int y, int[][] grid, boolean[][] visited, int l, int k) {
		if (x>=grid.length || y>=grid[0].length) return;
		if (visited[x][y]) return;
		if (grid[x][y]>l) return;
		visited[x][y] = true;
		floodfill((x+1)%(2*k), y, grid, visited, l, k);
		floodfill((x+1)%(2*k), y+1, grid, visited, l, k);
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    
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
