import java.io.*;
import java.util.*;
public class Tennis {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			TreeSet<Integer> breaks = new TreeSet<Integer>();
			possBreaks(a, b, breaks);
			possBreaks(b, a, breaks);
			System.out.println(breaks.size());

			for (int num: breaks) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	public static void possBreaks(int a, int b, TreeSet<Integer> breaks) {
		int aServes = (int)Math.ceil((double)(a+b)/2);
		int bServes = (int)Math.floor((double)(a+b)/2);
		for (int i=0; i<=aServes; i++) {
			int y = a - (aServes-i);
			if (y>=0 && y<=bServes) {
				breaks.add(i+y);
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
