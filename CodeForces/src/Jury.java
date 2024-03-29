import java.io.*;
import java.util.*;

public class Jury {
	static int mod = 998244353;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int[] jury = new int[n];
			int max1 = 0;
			int max1Occurences = 0;
			int max2Occurences = 0;
			for (int j=0; j<n; j++) {
				int tasks = in.nextInt();
				if (tasks>max1) max1 = tasks;
				jury[j] = tasks;
				
			}
			for (int j=0; j<n; j++) {
				if (jury[j]==max1-1) max2Occurences++;
				if (jury[j]==max1) max1Occurences++;
			}
			
			System.out.println(max2Occurences);
			System.out.println(modFactorial(n)/4);
			long ans = modFactorial(n) - ((modFactorial(n))/(max2Occurences+1))%mod;
			
			if (max1Occurences>1) {
				System.out.println(modFactorial(n));
			}
			else System.out.println(ans%mod);
			
		}
		
	}
	public static long modFactorial(int n) {
		int curr = 1;
		long factorial = 1;
		while (curr<=n) {
			factorial = factorial*curr%mod;
			factorial%=mod;
			curr++;
		}
		return factorial;
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
