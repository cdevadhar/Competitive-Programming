import java.io.*;
import java.util.*;
public class RedBlue {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int r = in.nextInt();
			int b = in.nextInt();
			int segments = b+1;
			int min = r/segments;
			if (r%segments==0) {
				StringBuilder st = new StringBuilder();
				for (int i=0; i<segments-1; i++) {
					for (int j=0; j<min; j++) {
						st.append('R');
					}
					st.append('B');
				}
				for (int j=0; j<min; j++) {
					st.append('R');
				}
				System.out.println(st.toString());
			}
			else {
				int max = min+1;
				int numMax = r%segments;
				StringBuilder st = new StringBuilder();
				for (int i=0; i<segments-1; i++) {
					for (int j=0; j<min; j++) {
						st.append('R');
					}
					if (i<numMax) st.append('R');
					st.append('B');
				}
				for (int j=0; j<min; j++) {
					st.append('R');
				}
				System.out.println(st.toString());
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
