import java.io.*;
import java.util.*;
public class TwentyFive {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		String s = in.next();
		int ans = 0;
		for (int i=0; i<100000000; i+=25) {
			String test = i+"";
			if (test.length()!=s.length()) continue;
			int xValue = -1;
			boolean works = true;
			for (int j=0; j<s.length(); j++) {
				if (s.charAt(j)=='X') {
					if (xValue==-1) {
						xValue = test.charAt(j);
					}
					if (test.charAt(j)!=xValue) {
						works = false;
						break;
					}
				}
				else if (s.charAt(j)!='_') {
					if (test.charAt(j)!=s.charAt(j)) {
						works = false;
						break;
					}
				}
			}
			if (works) ans++;
		}
		System.out.println(ans);
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
