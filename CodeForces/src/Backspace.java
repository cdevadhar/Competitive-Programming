import java.io.*;
import java.util.*;

public class Backspace {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int q = in.nextInt();
		for (int i=0; i<q; i++) {
			String s = in.next();
			String t = in.next();
			System.out.println(canObtain(s, t));
		}
	}
	
	public static String canObtain(String s, String t) {
		int i=s.length(); int j=t.length();
		int matchedChars = 0;
		while (i>=0 && j>=0) {
			if (s.charAt(i)==t.charAt(j)) {
				i--; j--;
				matchedChars++;
			}
			else {
				while (s.charAt(i)!=t.charAt(j)) {
					i-=2;
				}
				matchedChars++;
			}
		}
		if (matchedChars==t.length()) return "YES";
		else return "NO";
		
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
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
