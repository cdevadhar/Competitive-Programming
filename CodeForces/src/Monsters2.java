import java.io.*;
import java.util.*;
public class Monsters2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		long c = in.nextLong();
		long[] best = new long[(int) c+1];
		for (int i=0; i<n; i++) {
			int cost = in.nextInt();
			long d = in.nextLong();
			long h = in.nextLong();
			best[cost] = Math.max(best[cost], d*h);
		}
		for (int cost = 1; cost<=c; cost++) {
			for (int cx = cost; cx<=c; cx+=cost) {
				best[cx] = Math.max(best[cx], best[cost]*(cx/cost));
			}
		}
		for (int i=1; i<=c; i++) {
			best[i] = Math.max(best[i], best[i-1]);
//			System.out.println(i+" "+best[i]);
		}
		int m = in.nextInt();
		for (int i=0; i<m; i++) {
			long d = in.nextLong();
			long h = in.nextLong();
			int min = binarySearch(d*h, best);
			if (min>c) System.out.print(-1+" ");
			else System.out.print(min+" ");
		}
	}
	// Returns index of earliest element greater than cost
	public static int binarySearch(long cost, long[] best) {
		if (best[best.length-1]<=cost) return -1;
		int hi = best.length-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo)/2;
			if (best[mid]<=cost) lo = mid+1;
			else hi = mid;
		}
		return hi;
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
