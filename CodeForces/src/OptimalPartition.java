import java.io.*;
import java.util.*;
public class OptimalPartition {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long[] a = new long[n];
			long[] prefix = new long[n+1];
			for (int i=0; i<n; i++) {
				a[i] = in.nextLong();
				prefix[i+1] = prefix[i]+a[i];
			}
			long[] suffixMax = new long[n+1];
			suffixMax[n] = prefix[n];
			for (int i=n-1; i>=0; i--) {
				suffixMax[i] = Math.max(prefix[i], suffixMax[i+1]);
			}
			if (prefix[n]>0) {
				in.pr.println(n);
			}
			else {
				
			}
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
