import java.io.*;
import java.util.*;
public class AlmostSorted {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			long n = in.nextLong();
			long k = in.nextLong();
			long prefix=1;
			long count=0;
			long[] ans = new long[(int)n];
			while (prefix<n) {
				long operations = (n-prefix)*(n-prefix-1)/2 + 1;
				if (count+operations<k) {
					count+=operations;
					prefix++;
					continue;
				}
				int reverseLength = 2;
				while (count<k) {
					count+=(n-prefix-reverseLength+1);
					reverseLength++;
				}
				long insideOrder = count-k;
				long start = (n-reverseLength)-insideOrder;
				for (int i=0; i<start; i++) {
					ans[i] = i+1;
				}
				for (int i=(int)start; i<=start+reverseLength; i++) {
					ans[i] = (start+reverseLength)-i + start+1;
				}
				for (int i=(int)start+reverseLength+1; i<n; i++) {
					ans[i] = i+1;
				}
				break;
			}
			for (int i=0; i<n; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
