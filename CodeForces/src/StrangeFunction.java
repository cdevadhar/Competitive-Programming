import java.io.*;
import java.util.*;
public class StrangeFunction {
	static int mod = 1000000007;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			long n = in.nextLong();
			long ans=0;
			for (long i=2; i<42; i++) {
				long lcm=1;
				for (long j=2; j<i; j++) {
					lcm = lcm(lcm, j);
				}
				long lcm2 = lcm(lcm, i);
				long ans1 = n/lcm;
				long ans2 = n/lcm2;
				ans+=(ans1-ans2)*i;
			}
			System.out.println(ans%mod);
		}
	}
	public static long gcf(long a, long b) {
		if (a==0) return b;
		return gcf(b%a, a);
	}
	public static long lcm(long a, long b) {
		return a*b/gcf(a, b);
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
