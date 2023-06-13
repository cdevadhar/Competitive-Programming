import java.io.*;
import java.util.*;
public class Permutations2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] c = new int[n];
			int start = -1;
			for (int i=0; i<n; i++) {
				c[i] = in.nextInt();
				if (c[i]==1) start = i;
			}
			if (start<0) System.out.println("NO");
			else {
				
				int curr = (start+1)%n;
				int prev = 1;
				boolean works = true;
				while (curr!=start) {
					if (c[curr]==1) {
//						System.out.println("fail1");
						works = false;
						break;
					}
					if (c[curr]>prev+1) {
//						System.out.println("fail2");
						works = false;
						break;
					}
					else {
						prev = c[curr];
						curr = (curr+1)%n;
					}
				}
				if (works) System.out.println("YES");
				else System.out.println("NO");
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
