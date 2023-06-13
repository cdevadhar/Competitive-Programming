import java.io.*;
import java.util.*;
public class SumOfProducts {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		long[] a = new long[n];
		long[] b = new long[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextLong();
		}
		for (int i=0; i<n; i++) {
			b[i] = in.nextLong();
		}
		long[][] dp = new long[n][n];
		for (int l=0; l<n; l++) {
			for (int r=l; r<=l+1 && r<n; r++) {
				fill(dp, l, r, a, b);
			}
		}
		long[] sumPrefix = new long[n];
		long[] sumSuffix = new long[n];
		sumPrefix[0] = a[0]*b[0];
		sumSuffix[n-1] = a[n-1]*b[n-1];
		for (int i=1; i<n; i++) {
			sumPrefix[i] = sumPrefix[i-1]+a[i]*b[i];
		}
		for (int i=n-2; i>=0; i--) {
			sumSuffix[i] = sumSuffix[i+1]+a[i]*b[i];
		}
		long ans = sumPrefix[n-1];
		for (int l=0; l<n; l++) {
			for (int r=l; r<n; r++) {
				long currAns = dp[l][r];
				if (l>0) currAns+=sumPrefix[l-1];
				if (r<n-1) currAns += sumSuffix[r+1];
				ans = Math.max(ans, currAns);
			}
		}
		System.out.println(ans);
	}
	public static void fill(long[][] dp, int l, int r, long[] a, long[] b) {
		if (l==r) dp[l][r] = a[l]*b[l];
		else if (l==r-1) dp[l][r] = a[l]*b[r]+a[r]*b[l];
		else dp[l][r] = dp[l+1][r-1]+a[l]*b[r]+a[r]*b[l];
		if (l>0 && r<a.length-1) fill(dp, l-1, r+1, a, b);
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
