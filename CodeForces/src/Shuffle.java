import java.io.*;
import java.util.*;
public class Shuffle {
	static int mod = 998244353;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int k = in.nextInt();
		String s = in.next();
		int[] onesPrefix = new int[n+1];
		for (int i=0; i<n; i++) {
			onesPrefix[i+1] = onesPrefix[i];
			if (s.charAt(i)=='1') onesPrefix[i+1]++;
		}
		int ans = 0;
		int[][] count = new int[n+1][];
		for (int i=0; i<n+1; i++) {
			count[i] = new int[i+1];
			count[i][0] = 1;
			count[i][i] = 1;
			for (int j=1; j<i; j++) {
				count[i][j] = modAdd(count[i-1][j], count[i-1][j-1]);
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				int ones = onesPrefix[j+1]-onesPrefix[i]; 
				int cnt = j-i+1;
				if (ones>k || onesPrefix[n]<k) continue;
				cnt-=2;
				if (s.charAt(j)=='0') ones--;
				if (s.charAt(i)=='0') ones--;
				if (ones<=cnt && ones>=0 && cnt>=0) {
					ans = modAdd(ans, count[cnt][ones]);
				}
				
			}
		}
		System.out.println((ans+1)%mod);
	}
	public static int modAdd(int a, int b) {
		int res =a+b;
		while (res>=mod) res-=mod;
		while (res<0) res+=mod;
		return res;
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
