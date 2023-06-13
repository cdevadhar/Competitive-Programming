import java.io.*;
import java.util.*;
public class Cross {
	static int mod = 998244353;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int q = in.nextInt();
			HashSet<Integer> rows = new HashSet<Integer>();
			HashSet<Integer> cols = new HashSet<Integer>();
			Pair[] ops = new Pair[q];
			for (int i=0; i<q; i++) {
				ops[i] = new Pair(in.nextInt(), in.nextInt());
			}
			int power = 0;
			for (int i=q-1; i>=0; i--) {
				int x = ops[i].x;
				int y = ops[i].y;
				if ((!rows.contains(x) || !cols.contains(y)) && (cols.size()<m && rows.size()<n)) {
					power++;
				}
				rows.add(x);
				cols.add(y);
			}
//			System.out.println(power);
			long ans = 1;
			for (int i=0; i<power; i++) {
				ans*=k;
				ans%=mod;
			}
			System.out.println(ans);
		}
	}
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
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
