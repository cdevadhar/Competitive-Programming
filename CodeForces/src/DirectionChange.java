import java.io.*;
import java.util.*;
public class DirectionChange {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			if (n==1 && m==1) {
				System.out.println(0);
			}
			else if (n==1) {
				if (m==2) System.out.println(1);
				else System.out.println(-1);
			}
			else if (m==1) {
				if (n==2) System.out.println(1);
				else System.out.println(-1);
			}
			else {
				int needed = Math.max(n, m);
				needed--;
				int leftOver = Math.min(n, m);
				int minLeft = needed-1;
				if (minLeft%2==leftOver%2) minLeft++;
				needed+=minLeft;
				System.out.println(needed);
			}
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
