import java.io.*;
import java.util.*;
public class MakeIncreasing {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		long[] a = new long[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextLong();
		}
		long minAns = Long.MAX_VALUE;
		for (int i=0; i<n; i++) {
			minAns = Math.min(minAns, check(a, i));
		}
		System.out.println(minAns);
	}
	public static long check(long[] a, int index) {
		long ans = 0;
		long prev = 0;
		for (int i=index+1; i<a.length; i++) {
			long operations = (prev+a[i])/a[i];
			ans+=operations;
			prev = operations*a[i];
		}
		prev = 0;
		for (int i=index-1; i>=0; i--) {
			long operations = (prev+a[i])/a[i];
			ans+=operations;
			prev = operations*a[i];
		}
		return ans;
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
