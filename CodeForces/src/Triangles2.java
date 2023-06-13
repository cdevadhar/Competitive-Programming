import java.io.*;
import java.util.*;
public class Triangles2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = 1000050;
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		long[] prefix = new long[n];
		for (int i=a; i<=b; i++) {
			prefix[i+b]++;
			prefix[i+c+1]--;
		}
		for (int i=1; i<n; i++) {
			prefix[i] += prefix[i-1];
		}
		for (int i=1; i<n; i++) {
			prefix[i] += prefix[i-1];
		}
		long ans = 0;
		for (int i=c; i<=d; i++) {
			ans+=(prefix[b+c+1]-prefix[i]);
		}
		System.out.println(ans);
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
