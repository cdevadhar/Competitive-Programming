import java.io.*;
import java.util.*;

public class Dominoes {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int num = n*m/2;
			int j = num-k;
			if (n%2==0 && m%2==0) {
				if (k%2==0) System.out.println("YES");
				else System.out.println("NO");
			}
			else if (n%2==1) {
				if (k>=m/2) {
					if ((k-m/2)%2==0) System.out.println("YES");
					else System.out.println("NO");
				}
				else System.out.println("NO");
			}
			else {
				if (j>=n/2) {
					if ((j-n/2)%2==0) System.out.println("YES");
					else System.out.println("NO");
				}
				else System.out.println("NO");
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
