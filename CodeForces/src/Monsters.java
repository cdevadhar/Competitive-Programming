import java.io.*;
import java.util.*;
public class Monsters {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long[][] monsters = new long[n][2];
			ArrayList<Interval> intervals = new ArrayList<Interval>();
			for (int i=0; i<n; i++) {
				monsters[i][0] = in.nextInt();
			}
			for (int i=0; i<n; i++) {
				monsters[i][1] = in.nextInt();
				intervals.add(new Interval(monsters[i][0]-monsters[i][1], monsters[i][0]));
			}
			Collections.sort(intervals, (o1, o2) -> Long.compare(o1.start, o2.start));
			long left=-1, right=-1;
			long ans=0;
			
			for (Interval i: intervals) {
				if (i.start>=right) {
					ans+=(right-left)*(right-left+1)/2;
					left=i.start;
					right = i.finish;
				}
				else {
					right = Math.max(right, i.finish);
				}
			}
			ans+=(right-left)*(right-left+1)/2;
			System.out.println(ans);	
		}
	}
	static class Interval {
		long start, finish;
		public Interval(long start, long finish) {
			this.start = start;
			this.finish = finish;
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
