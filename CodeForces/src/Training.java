import java.io.*;
import java.util.*;

public class Training {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int testcase = 0; testcase<t; testcase++) {
			long n = in.nextInt();
			HashMap<Integer, Integer> difficulties = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> topics = new HashMap<Integer, Integer>();
			int[][] problems = new int[(int)n][2];
			for (int i=0; i<n; i++) {
				int top = in.nextInt();
				int diff = in.nextInt();
				problems[i][0] = top;
				problems[i][1] = diff;
				difficulties.putIfAbsent(diff, 0);
				topics.putIfAbsent(top, 0);
				difficulties.put(diff, difficulties.get(diff)+1);
				topics.put(top, topics.get(top)+1);
			}
			long ans=0;
			for (int i=0; i<n; i++) {
				ans+=(long)(difficulties.get(problems[i][1])-1)*(long)(topics.get(problems[i][0])-1);
			}
			System.out.println((n*(n-1)*(n-2))/6 -ans);
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
