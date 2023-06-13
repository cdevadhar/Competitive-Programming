import java.io.*;
import java.util.*;
public class FallDown {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			char[][] grid = new char[n][m];
			for (int i=0; i<n; i++) {
				grid[i] = in.next().toCharArray();
			}
			for (int col=0; col<m; col++) {
				fix(grid, col);
			}
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) System.out.print(grid[i][j]);
				System.out.println();
			}
		}
	}
	public static void fix(char[][] grid, int col) {
		int count = 0;
		for (int i=0; i<grid.length; i++) {
			if (grid[i][col]=='o') {
				if (count>0) {
					for (int j=1; j<=count; j++) {
						grid[i-j][col] = '*';
					}
				}
				count = 0;
			}
			else if (grid[i][col]=='*') {
				grid[i][col] = '.';
				count++;
			}
		}
		for (int j=1; j<=count; j++) {
			grid[grid.length-j][col] = '*';
		}
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
