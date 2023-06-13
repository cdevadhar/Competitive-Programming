import java.io.*;
import java.util.*;
public class Paths {
	static ArrayList<ArrayList<Edge>> adj;
	static boolean[] visited;
	static int maxPath, endNode;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		String s = in.next();
		adj = new ArrayList<ArrayList<Edge>>();
		visited = new boolean[n];
		for (int i=0; i<n; i++) adj.add(new ArrayList<Edge>());
		for (int i=0; i<n-1; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			boolean bad = s.charAt(a)!=s.charAt(b);
			adj.get(a).add(new Edge(b, bad));
			adj.get(b).add(new Edge(a, bad));
		}
		maxPath = 0;
		endNode = 0;
		dfs(0, 0);
//		System.out.println(maxPath+" "+endNode);
		visited = new boolean[n];
		maxPath = 0;
		dfs(endNode, 0);
		System.out.println(maxPath);
	}
	public static void dfs(int node, int numBad) {
		if (visited[node]) return;
		visited[node] = true;
//		System.out.println(node+" "+numBad);
		if (numBad>maxPath) {
			maxPath = numBad;
			endNode = node;
		}
		for (Edge next: adj.get(node)) {
			if (next.bad) {
				dfs(next.to, numBad+1);
				
			}
			else dfs(next.to, numBad);
		}
	}
	static class Edge {
		int to;
		boolean bad;
		public Edge(int to, boolean bad) {
			this.to = to;
			this.bad = bad;
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
