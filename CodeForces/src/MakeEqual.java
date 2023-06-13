import java.io.*;
import java.util.*;
public class MakeEqual {
	// Continue later
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] b = new int[n];
			int[] c = new int[n];
			int[] operations = new int[1001];
			for (int i=0; i<n; i++) b[i] = in.nextInt();
			for (int i=0; i<n; i++) c[i] = in.nextInt();
			Arrays.fill(operations, Integer.MAX_VALUE);
			operations[0] = 0;
			operations[1]= 0;
			for (int i=1; i<1001; i++) {
				int currX = i;
				while (currX>0) {
					if (i+i/currX<1001) operations[i+i/currX] = Math.min(operations[i+i/currX], operations[i]+1);
					currX--;
				}
			}
			// Row i assumes we only use elements 1-i
			// Column j assumes our weight maximum is j
			k = Math.min(k, 12*n);
			int[][] dp = new int[n+1][k+1];
			for (int i=0; i<k+1; i++) {
				dp[0][i] = 0;
			}
			for (int i=0; i<n+1; i++) {
				dp[i][0] = 0;
			}
		}
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
