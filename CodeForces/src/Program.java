import java.io.*;
import java.util.*;
public class Program {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] prefix = new int[n+1];
			int[] prefixMin = new int[n+1];
			int[] prefixMax = new int[n+1];
			int[] suffixMin = new int[n+1];
			int[] suffixMax = new int[n+1];
			int curr=0;
			prefixMin[0] = 0;
			prefixMax[0] = 0;
			String s = in.next();
			for (int i=0; i<n; i++) {
				if (s.charAt(i)=='+') curr++;
				else curr--;
				prefix[i+1] = curr;
				prefixMin[i+1] = Math.min(prefixMin[i], curr);
				prefixMax[i+1] = Math.max(prefixMax[i], curr);
			}
			suffixMin[n] = 0;
			suffixMax[n] = 0;
			for (int i=n-1; i>=0; i--) {
				int d = s.charAt(i)=='+' ? 1: -1;
				suffixMin[i] = Math.min(0, suffixMin[i+1]+d);
				suffixMax[i] = Math.max(0, suffixMax[i+1]+d);
			}
			for (int i=0; i<m; i++) {
				int l = in.nextInt();
				int r = in.nextInt();
				l--;
				int l1 = prefixMin[l], r1 = prefixMax[l];
				int l2 = suffixMin[r]+prefix[l], r2 = suffixMax[r]+prefix[l];
				System.out.println(Math.max(r1, r2)-Math.min(l1, l2)+1);
			}
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
