import java.io.*;
import java.util.*;

public class SportsFestival {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] speeds = new int[n];
		for (int i=0; i<n; i++) {
			speeds[i] = in.nextInt();
			
		}
		Arrays.parallelSort(speeds);
		long[][] dpArray = new long[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				dpArray[i][j]=-1;
			}
		}
		System.out.println(dp(0, n-1, dpArray, speeds));
	}
	public static long dp(int l, int r, long[][] dpArray, int[] speeds) {
		if (dpArray[l][r]!=-1) return dpArray[l][r];
		if (l==r) return 0;
		dpArray[l][r] = speeds[r]-speeds[l]+Math.min(dp(l+1, r, dpArray, speeds), dp(l, r-1, dpArray, speeds));
		return dpArray[l][r];
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
