import java.io.*;
import java.util.*;
public class Nearest {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] a = new int[n];
		ArrayList<ArrayList<Integer>> adjacent = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) adjacent.add(new ArrayList<Integer>());
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
			if (i+a[i]<n) adjacent.get(i+a[i]).add(i);
			if (i-a[i]>=0) adjacent.get(i-a[i]).add(i);
		}
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		bfs(a, ans, 0, n, new boolean[n], adjacent);
		bfs(a, ans, 1, n, new boolean[n], adjacent);
		for (int i: ans) in.pr.print(i+" ");
		in.pr.close();
	}
	public static void bfs(int[] a, int[] ans, int parity, int n, boolean[] visited, ArrayList<ArrayList<Integer>> adjacent) {
		Queue<Pair> queue = new LinkedList<Pair>();
		for (int i=0; i<a.length; i++) {
			if (a[i]%2==parity) queue.add(new Pair(i, 0));
		}
		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			if (visited[curr.x]) continue;
			visited[curr.x] = true;
			if (a[curr.x]%2!=parity) ans[curr.x] = curr.y;
			for (int next: adjacent.get(curr.x)) {
				queue.add(new Pair(next, curr.y+1));
			}
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
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
