import java.io.*;
import java.util.*;
public class RestStops {
	static long l, f, b;
	static int n;
	static RestStop[] rss;
	static int[] suffixMax;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("reststops.in", "reststops.out");
		l = in.nextInt();
		n = in.nextInt();
		f = in.nextInt();
		b = in.nextInt();
		rss = new RestStop[n];
		suffixMax = new int[n+1];
		for (int i=0; i<n; i++) {
			RestStop r = new RestStop(in.nextInt(), in.nextInt());
			rss[i] = r;
		}
		Arrays.sort(rss, (o1, o2) -> Integer.compare(o1.x, o2.x));
		int max = rss[n-1].taste;
		suffixMax[n-1] = max;
		for (int i=n-2; i>=0; i--) {
			max = Math.max(max, rss[i].taste);
			suffixMax[i] = max;
		}
//		for (int i=0; i<n; i++) {
//			System.out.println(suffixMax[i]);
//		}
		long ret = 0;
		long prev = 0;
		for (int i=0; i<n; i++) {
			if (suffixMax[i]!=suffixMax[i+1]) {
				
				ret+=suffixMax[i]*(f*(rss[i].x-prev)-b*(rss[i].x-prev));
//				System.out.println(ret);
				prev = rss[i].x;
			}
		}
		in.pr.println(ret);
		in.pr.close();
	}
	static class RestStop {
		int x, taste;
		public RestStop(int x, int taste) {
			this.x = x;
			this.taste = taste;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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
