import java.io.*;
import java.util.*;
public class ChristmasTrees {
	static int n, m;
	static Long[] trees;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		trees = new Long[n];
		for (int i=0; i<n; i++) {
			trees[i] = in.nextLong();
		}
		Arrays.parallelSort(trees);
		bfs();
	}
	public static void bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();
		HashSet<Long> visited = new HashSet<Long>();
		ArrayList<Long> ans = new ArrayList<Long>();
		long distanceSum = 0;
		int count = 0;
		for (long i: trees) {
			queue.add(new Pair(i, 0L));
		}
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			if (visited.contains(p.x)) continue;
			if (count==m) break;
			distanceSum+=p.y;
			if (p.y>0) {
				ans.add(p.x);
				count++;
			}
			visited.add(p.x);
			
			queue.add(new Pair(p.x-1, p.y+1));
			queue.add(new Pair(p.x+1, p.y+1));
		}
		System.out.println(distanceSum);
		for (long i: ans) {
			System.out.print(i+" ");
		}
	}
	static class Pair {
		long x, y;
		public Pair(long x, long y) {
			this.x = x;
			this.y = y;
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
