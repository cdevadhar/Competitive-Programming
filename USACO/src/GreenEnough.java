import java.io.*;
import java.util.*;

public class GreenEnough {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[][] grid = new int[n][n];
		int[][] under100 = new int[n+1][n+1];
		int[][] hundreds = new int[n+1][n+1];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				int x = in.nextInt();
				grid[i][j] = x;
			}
		}
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<n+1; j++) {
				under100[i][j] = under100[i-1][j]+under100[i][j-1]-under100[i-1][j-1];
				if (grid[i-1][j-1]<100) under100[i][j]++;
				hundreds[i][j] = hundreds[i-1][j]+hundreds[i][j-1]-hundreds[i-1][j-1];
				if (grid[i-1][j-1]==100) hundreds[i][j]++;
			}
		}
		long ans = 0;
		for (int top=0; top<n; top++) {
			for (int bottom=top; bottom<n; bottom++) {
//				System.out.println("Top " + top + " Bottom " + bottom);
				int currColumn = -1;
				int closestSub100 = -1;
				for (int col=n-1; col>=0; col--) {
					// Check if this column has a number <100
					
					if (under100[bottom+1][col+1]-under100[bottom+1][col]-under100[top][col+1]+under100[top][col]>0) {
						currColumn = -1;
						closestSub100 = col;
					}
					else {
						if (hundreds[bottom+1][col+1]-hundreds[bottom+1][col]-hundreds[top][col+1]+hundreds[top][col]>0) {
							currColumn = col;
						}
					}
					if (currColumn>=0) {
						if (closestSub100>=0) {
							ans+=(closestSub100-currColumn);
						}
						else {
							ans+=(n-currColumn);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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