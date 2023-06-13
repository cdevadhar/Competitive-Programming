import java.io.*;
import java.util.*;

public class CardGame {
	static int maxT = 10000001;
	static int[] ans;
	static int cow, location;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int c = in.nextInt();
		int q = in.nextInt();
		ans = new int[maxT];
		for (int i=0; i<n; i++) {
			for (int j=0; j<c; j++) {
				int card = in.nextInt();
				if (card==1) {
					cow = i;
					location = c-j-1;
					ans[0] = cow;
				}
			}
		}
		for (int i=0; i<10; i++) {
			int turn = i%n;
//			System.out.println(turn);
//			System.out.println(cow+" "+location);
			if (turn==cow) {
				if (cow+1>location) {
					cow = (cow+location+1)%n;
					location = 0;
				}
				else {
					location-=(turn+1);
					if (turn==n-1) location++;
				}
			}
			else {
				int distance = 0;
				if (cow<turn) distance = (n-turn)+cow;
				else distance = cow-turn;
				if (turn+1>=distance) {
					location++;
				}
			}
			
			ans[i+1] = cow;
		}
		for (int i=0; i<q; i++) {
			int t = in.nextInt();
			System.out.println(ans[t]+1);
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
