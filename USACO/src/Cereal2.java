import java.io.*;
import java.util.*;
public class Cereal2 {
	static int n, m;
	static ArrayList<ArrayList<Edge>> adj;
	static boolean[] visited, visitedCycle, isFed;
	static int cereals, cows;
	static Edge cycle;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		adj = new ArrayList<ArrayList<Edge>>();
		for (int i=0; i<m; i++) adj.add(new ArrayList<Edge>());
		for (int i=0; i<n; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adj.get(a).add(new Edge(b, i));
			adj.get(b).add(new Edge(a, i));
		}
		visited = new boolean[m];
		visitedCycle = new boolean[m];
		isFed = new boolean[n];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i=0; i<m; i++) {
			if (!visitedCycle[i]) {
				cereals = 0;
				cows = 0;
				cycle = null;
				findCycle(i, -1);
				cows/=2;
				if (cycle==null) {
					dfs(i, ans);
				}
				else {
//					System.out.println(cycle.id);
					ans.add(cycle.id);
					isFed[cycle.id] = true;
					visited[cycle.to] = true;
					dfs(cycle.to, ans);
				}
			}
		}
		int hungry = 0;
		for (int i=0; i<n; i++) {
			if (!isFed[i]) {
				hungry++;
				ans.add(i);
			}
		}
		System.out.println(hungry);
		for (int i: ans) {
			System.out.println(i+1);
		}
	}
	public static void findCycle(int node, int prev) {
		visitedCycle[node] = true;
		cereals++;
		cows+=adj.get(node).size();
		for (Edge next: adj.get(node)) {
			if (next.to==prev) continue;
			if (visitedCycle[next.to]) {
				if (cycle==null) cycle = next;
			}
			else {
				findCycle(next.to, node);
			}
		}
	}
	public static void dfs(int node, ArrayList<Integer> ans) {
		visited[node] = true;
		for (Edge next: adj.get(node)) {
			if (!visited[next.to]) {
				ans.add(next.id);
				isFed[next.id] = true;
				dfs(next.to, ans);
			}
		}
	}
	static class Edge {
		int to, id;
		public Edge(int to, int id) {
			this.to = to;
			this.id = id;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
