import java.io.*;
import java.util.*;
public class Victory {
	static long maxLength = 0;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
		for (int i=0; i<n; i++) {
			adj.add(new ArrayList<Edge>());
		}
		long lenSum = 0;
		for (int i=0; i<n-1; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			long length = in.nextLong();
			lenSum+=length;
			adj.get(x).add(new Edge(y, length));
			adj.get(y).add(new Edge(x, length));
		}
		dfs(0, adj, 0, new boolean[n]);
		System.out.println((lenSum-maxLength)*2 + maxLength);
	}
	public static void dfs(int node, ArrayList<ArrayList<Edge>> adj, long length, boolean[] visited) {
		if (visited[node]) return;
		visited[node] = true;
		maxLength = Math.max(length, maxLength);
		for (Edge e: adj.get(node)) {
			dfs(e.dest, adj, length+e.length, visited);
		}
	}
	static class Edge {
		int dest;
		long length;
		public Edge(int dest, long length) {
			this.dest = dest;
			this.length = length;
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
