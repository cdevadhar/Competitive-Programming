import java.io.*;
import java.util.*;
public class Pancakes {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] d = new int[n];
			for (int i=0; i<n; i++) {
				d[i] = in.nextInt();
			}
			int left = 0;
			int right = n-1;
			int max = 0;
			int ans = 0;
			while (right>left) {
				if (d[right]<d[left]) {
					if (d[right]>=max) {
						ans++;
						max = d[right];
					}
					right--;
				}
				else {
					if (d[left]>=max) {
						ans++;
						max = d[left];
					}
					left++;
				}
			}
			System.out.println("Case #" + (tc+1) + ": " + (ans+1));
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
