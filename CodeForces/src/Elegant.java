import java.io.*;
import java.util.*;
public class Elegant {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] grid = new int[n][m];
			for (int i=0; i<n; i++) {
				String s = in.next();
				for (int j=0; j<m; j++) {
					grid[i][j] = s.charAt(j)-'0';
				}
			}
			boolean works = true;
			for (int i=0; i<n-1; i++) {
				for (int j=0; j<m-1; j++) {
					int sum = grid[i][j]+grid[i][j+1]+grid[i+1][j]+grid[i+1][j+1];
					if (sum==3) works = false;
				}
			}
			if (works) System.out.println("YES");
			else System.out.println("NO");
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
