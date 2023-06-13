import java.io.*;
import java.util.*;
public class LineEmpire {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long a = in.nextInt();
			long b = in.nextInt();
			long[] pos = new long[n+1];
			for (int i=1; i<=n; i++) {
				pos[i] = in.nextLong();
				pos[i]+=pos[i-1];
			}
			long minAns = pos[n]*b;
			long currAns = 0;
			for (int i = 1; i <= n; i++) {
				 
	            long dist = pos[i] - pos[i - 1];
	            if (i > 1) dist -= (pos[i - 1] - pos[i - 2]);
	            currAns+=a*dist;
	            currAns+=b*dist;
	            minAns = Math.min(minAns, currAns + b * ((pos[n] - pos[i]) - (n - i) * (pos[i] - pos[i - 1])));
	 
	        }
			System.out.println(minAns);
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
