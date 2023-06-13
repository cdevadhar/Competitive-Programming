import java.io.*;
import java.util.*;
public class SocialDistance {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long m = in.nextLong();
			Long[] minGap = new Long[n];
			for (int i=0; i<n; i++) {
				minGap[i] = in.nextLong();
			}
			Arrays.sort(minGap);
			long pos = minGap[n-1];
			long gap = minGap[n-1];
			boolean works = true;
			for (int i=n-2; i>=0; i--) {
				pos = pos+gap+1;
				gap = minGap[i];
				
				if (pos>=m) {
					works = false;
					break; 
				}
			}
			if (works) in.pr.println("YES");
			else in.pr.println("NO");
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
