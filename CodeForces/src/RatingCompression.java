import java.io.*;
import java.util.*;
public class RatingCompression {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] occ = new int[n+1];
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				int x = in.nextInt()-1;
				occ[x]++;
				arr[i] = x;
			}
			int[] ans = new int[n];
			int one = 1;
			for (int i=0; i<n; i++) {
				if (occ[i]!=1) one=0;
			}
			ans[0] = one;
			if (occ[0]>0) {
				ans[n-1] = 1;
				int l=0, r=n-1;
				for (int i=n-1; i>=0; i--) {
					ans[i] = 1;
					int next = n-i-1;
					if (occ[next]==1 &&(arr[l]==next || arr[r]==next) && occ[next+1]>0) {
						if (arr[l]==next) l++;
						if(arr[r]==next) r--;
						occ[next]--;
						continue;
					}
					else break;
				}
			}
			for (int i=0; i<n; i++) System.out.print(ans[i]);
			System.out.println();
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
