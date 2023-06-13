import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HoofPaperScissors2 {
	static int[][] prefixes;
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastIO in = new FastIO();
		int n = in.nextInt();
		//System.out.println(n);
		prefixes = new int[n][3];
		int hcount = 0;
		int pcount = 0;
		int scount = 0;
		for (int i=0; i<n; i++) {
			String s = in.nextLine();
			if (s.equals("H")) hcount++;
			if (s.equals("P")) pcount++;
			if (s.equals("S")) scount++;
			prefixes[i][0] = hcount;
			prefixes[i][1] = pcount;
			prefixes[i][2] = scount;
			//System.out.println(hcount + " " + pcount + " " + scount);
		}
		int maxWins = 0;
		for (int i=0; i<n; i++) {
			int maxLeft = Math.max(Math.max(prefixes[i][0], prefixes[i][1]), prefixes[i][2]);
			int maxRight = Math.max(Math.max(hcount-prefixes[i][0], pcount- prefixes[i][1]), scount-prefixes[i][2]);
			if ((maxLeft+maxRight)>maxWins) maxWins = maxLeft+maxRight;
		}
		System.out.println(maxWins);
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO()
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
