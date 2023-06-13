import java.io.*;
import java.util.*;
public class Wizard {
	static int n, m;
	static ArrayList<ArrayList<Integer>> adj;
	static boolean[] visited;
	static ArrayList<int[]> ans;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		adj = new ArrayList<ArrayList<Integer>>();
		ans = new ArrayList<int[]>();
		visited = new boolean[n];
		for (int i=0; i<n; i++) adj.add(new ArrayList<Integer>());
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(i, -1);
			}
		}
		System.out.println(ans.size());
		for (int[] i: ans) {
			System.out.println((i[0]+1)+" "+(i[1]+1)+" "+(i[2]+1));
		}
	}
	public static boolean dfs(int node, int prev) {
		visited[node] = true;
		ArrayList<Integer> curr = new ArrayList<Integer>();
		// Go through its children
		for (int next: adj.get(node)) {
			if (next==prev) continue;
			// Back edge
			if (visited[next]) {
				// Why this?
				// We want to pair up some back edges?
				
				if (next>node) {
					curr.add(next);
				}
			}
			// Add children to the list to pair them up
			else if (dfs(next, node)) {
				curr.add(next);
			}
		}
		for (int i=0; i<curr.size()/2; i++) {
			int[] triple = {curr.get(2*i), node, curr.get(2*i+1)};
			ans.add(triple);
		}
		if (curr.size()%2==0) return true;
		if (prev!=-1) {
			int[] triple = {curr.get(curr.size()-1), node, prev};
			ans.add(triple);
		}
		return false;
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
