import java.io.*;
import java.util.*;

public class Journey {
	static int componentSize;
	
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			String s = in.next();
			int[] leftMost = new int[n+1];
			int[] rightMost = new int[n+1];
			for (int i=0; i<n+1; i++) {
				leftMost[i] = i;
				rightMost[i] = i;
			}
			for (int i=0; i<n+1; i++) {
				if (i==0 || s.charAt(i-1)=='R') leftMost[i] = i;
				else if (i==1 || s.charAt(i-2)=='L') leftMost[i] = i-1;
				else leftMost[i] = leftMost[i-2];
			}
			for (int i=n-1; i>=0; i--) {
				if (i==n || s.charAt(i)=='L') rightMost[i] = i;
				else if (i==n-1 || s.charAt(i+1)=='R') rightMost[i] = i+1;
				else rightMost[i] = rightMost[i+2];
			}
			for (int i=0; i<n+1; i++) {
				System.out.print((rightMost[i]-leftMost[i]+1)+" ");
			}
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
