import java.io.*;
import java.util.*;
public class NewYear2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int[][] grid = new int[m][n];
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					grid[i][j] = in.nextInt();
				}
			}
			int minFav = Integer.MAX_VALUE;
			int maxSecondBest = Integer.MIN_VALUE;
			for (int j=0; j<n; j++) {
				int maxIndex = -1;
				for (int i=0; i<m; i++) {
					if (maxIndex==-1 || grid[i][j]>grid[maxIndex][j]) maxIndex = i;
				}
				
				minFav = Math.min(minFav, grid[maxIndex][j]);
				
			}
			for (int i=0; i<m; i++) {
				Arrays.parallelSort(grid[i]);
				maxSecondBest = Math.max(maxSecondBest, grid[i][n-2]);
			}
			System.out.println(Math.min(maxSecondBest, minFav));
		}
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
