import java.io.*;
import java.util.*;
public class Zigzag {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long[] a = new long[n];
			for (int i=0; i<n; i++) {
				a[i] = in.nextLong()-1;
			}
			long[][] occurences = new long[n][n];
			long[] lOccurrences = new long[n];
			lOccurrences[(int) a[n-1]] = 1;
			long ans = 0;
			for (int j=n-3; j>0; j--) {
				int k=j+1;
				for (int l=0; l<n; l++) {
					if (lOccurrences[l]>0) {
						occurences[(int) a[k]][l] +=lOccurrences[l];
					}
				}
				lOccurrences[(int) a[k]]++;
				for (int i=0; i<j; i++) {
					ans+=occurences[(int) a[i]][(int) a[j]];
				}
			
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
