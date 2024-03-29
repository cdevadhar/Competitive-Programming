import java.io.*;
import java.util.*;
public class PairWeight {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			HashMap<Long, Long> occurences = new HashMap<Long, Long>();
			long ans= 0;
			long[] dp = new long[n];
			
			for (int i=0; i<n; i++) {
				long x = in.nextLong();
				if (i>0) dp[i] = dp[i-1];
				if (occurences.containsKey(x)) {
					dp[i]+=(occurences.get(x));
				}
				occurences.putIfAbsent(x, 0L);
				occurences.put(x, occurences.get(x)+(i+1));
				ans+=dp[i];
			}
			System.out.println(ans);
			
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
