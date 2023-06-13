import java.io.*;
import java.util.*;
public class Awards {
	static ArrayList<ArrayList<Integer>> adj;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		adj = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) adj.add(new ArrayList<Integer>());
		visited = new boolean[n];
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adj.get(a).add(b);
		}
		for (int i=0; i<n; i++) {
			dfs(i);
		}
	}
	public static void dfs(int node)  {
		if (visited[node]) return;
		visited[node] = true;
		for (int next: adj.get(node)) {
			dfs(next);
		}
		System.out.print(node+1+" ");
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
