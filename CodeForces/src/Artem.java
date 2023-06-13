import java.io.*;
import java.util.*;
public class Artem {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] grid = new int[n][m];
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					grid[i][j] = in.nextInt();
					if ((i+j)%2==0) {
						if (grid[i][j]%2==0) grid[i][j]++;
					}
					else {
						if (grid[i][j]%2==1) grid[i][j]++;
					}
				}
			}
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					in.pr.print(grid[i][j]+" ");
				}
				in.pr.println();
			}
		}
		in.pr.close();
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
