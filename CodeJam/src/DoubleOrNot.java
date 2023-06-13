import java.io.*;

import java.util.*;
public class DoubleOrNot {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			String s = in.next();
			StringBuilder curr = new StringBuilder();
			StringBuilder ans = new StringBuilder();
			char prev = ' ';
			for (int i=0; i<s.length(); i++) {
				if (s.charAt(i)!=prev) {
					curr = new StringBuilder();
				}
				curr.append(s.charAt(i));
				if (i==s.length()-1 || s.charAt(i)!=s.charAt(i+1)) {
					ans.append(curr.toString());
					if (i<s.length()-1) {
						if (s.charAt(i)<s.charAt(i+1)) ans.append(curr.toString());
					}
				}
				prev = s.charAt(i);
			}
			System.out.println("Case #" + (tc+1) + ": " + ans.toString());
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
