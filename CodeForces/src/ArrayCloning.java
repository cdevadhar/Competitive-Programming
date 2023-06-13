import java.io.*;
import java.util.*;

public class ArrayCloning {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long[] a = new long[n];
			long[] b = new long[n];
			for (int i=0; i<n; i++) {
				a[i] = in.nextLong();
			}
			for (int i=0; i<n; i++) {
				b[i] = in.nextLong();
			}
			long prevA = a[0];
			long prevB = b[0];
			long sum=0;
			for (int i=1; i<n; i++) {
				long check1 = Math.abs(a[i]-prevA) + Math.abs(b[i]-prevB);
				long check2 = Math.abs(a[i]-prevB) + Math.abs(b[i]-prevA);
				if (check1<check2) {
					sum+=check1;
					prevA = a[i];
					prevB = b[i];
				}
				else {
					sum+=check2;
					prevA = b[i];
					prevB = a[i];
				}
			}
			System.out.println(sum);
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
