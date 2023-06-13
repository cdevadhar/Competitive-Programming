import java.io.*;
import java.util.*;
public class EatingCandies {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] w = new int[n];
			for (int i=0; i<n; i++) {
				w[i] = in.nextInt();
			}
			int[] prefix = new int[n+1];
			int[] suffix = new int[n+1];
			for (int i=0; i<n; i++) {
				prefix[i+1] = prefix[i]+w[i];
			}
			for (int i=n-1; i>=0; i--) {
				suffix[i] = suffix[i+1]+w[i];
			}
			int max = 0;
			for (int i=n; i>=0; i--) {
//				System.out.print(suffix[i]+" ");
				int pref = Arrays.binarySearch(prefix, suffix[i]);
				if (pref>=0 && pref<=i) {
//					System.out.println(pref);
					int length = (n-i)+pref;
					max = Math.max(max, length);
				}
			}
			System.out.println(max);
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
