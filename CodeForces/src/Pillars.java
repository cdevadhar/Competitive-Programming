import java.io.*;
import java.util.*;
public class Pillars {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int a = in.nextInt();
		int r = in.nextInt();
		int m = in.nextInt();
		m = Math.min(m, a+r);
		long[] h = new long[n];
		long sum = 0;
		for (int i=0; i<n; i++) {
			h[i] = in.nextLong();
			sum+=h[i];
		}
		Arrays.sort(h);
		long[] prefix = new long[n+1];
		for (int i=0; i<n; i++) {
			prefix[i+1] = prefix[i]+h[i];
		}
		long cost = Long.MAX_VALUE;
		cost = cost(sum/n, prefix, h, n, a, r, m);
		cost = Math.min(cost, cost(sum/n + 1, prefix, h, n, a, r, m));
		for (int i=0; i<n; i++) {
			cost = Math.min(cost, cost(h[i], prefix, h, n, a, r, m));
		}
		System.out.println(cost);
	}
	public static long cost(long height, long[] prefix, long[] h, int n, int a, int r, int m) {
		int index = Arrays.binarySearch(h, height);
		if (index<0) {
			index*=-1;
			index-=1;
		}
		long p = height*index-prefix[index];
		long q = prefix[n]-prefix[index] - (n-index)*height;
		long ans = Math.min(p,q);
		p-=ans;
		q-=ans;
		ans*=m;
		ans+=p*a;
		ans+=q*r;
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
