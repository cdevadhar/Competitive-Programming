import java.io.*;
import java.util.*;
public class TwoTwentyOne {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int q = in.nextInt();
			String s = in.next();
			int[] prefix = new int[n+1];
			for (int i=0; i<n; i++) {
				if (i%2==0) {
					if (s.charAt(i)=='+') {
						prefix[i+1] = prefix[i]+1;
					}
					else {
						prefix[i+1] = prefix[i]-1;
					}
				}
				else {
					if (s.charAt(i)=='+') {
						prefix[i+1] = prefix[i]-1;
					}
					else {
						prefix[i+1] = prefix[i]+1;
					}
				}
			}
			for (int i=0; i<q; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				if (prefix[end]-prefix[start-1]==0) {
					in.pr.println(0);
				}
				else {
					if ((start-end)%2==0) {
						in.pr.println(1);
					}
					else in.pr.println(2);
				}
			}
		}
		in.pr.close();
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
