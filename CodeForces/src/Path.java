import java.io.*;
import java.util.*;
public class Path {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			long n = in.nextLong();
			String s = in.next();
			int rCount = 0;
			int dCount = 0;
			for (int i=0; i<s.length(); i++) {
				if (s.charAt(i)=='D') dCount++;
				else rCount++;
			}
			if (rCount==0 || dCount==0) {
				System.out.println(n);
				continue;
			}
			System.out.println(n*n-topArea(s, n, 'R', 'D')-topArea(s, n, 'D', 'R'));
		}
	}
	public static long topArea(String s, long n, char r, char d) {
		int occ = s.indexOf(r);
		long ans = 0;
		ans+=occ*(n-1);
		long size = 0;
		
		for (int i=s.length()-1; i>=occ; i--) {
			if (s.charAt(i)==d) ans+=size;
			else size++;
		}
		return ans;
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
