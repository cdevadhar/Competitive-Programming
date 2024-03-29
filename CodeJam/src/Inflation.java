import java.io.*;
import java.util.*;
public class Inflation {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int p = in.nextInt();
			long[][] minMax = new long[n][2];
			for (int i=0; i<n; i++) {
				long[] objects = new long[p];
				long min = Integer.MAX_VALUE;
				long max = Integer.MIN_VALUE;
				for (int j=0; j<p; j++) {
					objects[j] = in.nextLong();
					min = Math.min(min, objects[j]);
					max = Math.max(max, objects[j]);
				}
//				System.out.println(min+" "+max);
				minMax[i][0] = min;
				minMax[i][1] = max;
			}
			long ans = 0;
			long[][] dp = new long[n][2];
			dp[0][0] = minMax[0][1]-minMax[0][0]+minMax[0][1];
			dp[0][1] = minMax[0][1]-minMax[0][0]+minMax[0][0];
//			System.out.println(dp[0][0]+" "+dp[0][1]);
			for (int i=1; i<n; i++) {
				dp[i][0] = Math.min(Math.abs(minMax[i][1]-minMax[i-1][1])+dp[i-1][1], Math.abs(minMax[i][1]-minMax[i-1][0])+dp[i-1][0]);
				dp[i][1] = Math.min(Math.abs(minMax[i][0]-minMax[i-1][1])+dp[i-1][1], Math.abs(minMax[i][0]-minMax[i-1][0])+dp[i-1][0]);
				dp[i][0]+=(minMax[i][1]-minMax[i][0]);
				dp[i][1]+=(minMax[i][1]-minMax[i][0]);
//				System.out.println(dp[i][0]+" "+dp[i][1]);
			}
			ans = Math.min(dp[n-1][0], dp[n-1][1]);
			System.out.println("Case #" + (tc+1) + ": " + ans);
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
