import java.io.*;
import java.util.*;
public class ClockTree {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("clocktree.in", "clocktree.out");
		int n = in.nextInt();
		int[] settings = new int[n];
		int[] groups = new int[n];
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			settings[i] = in.nextInt();
			adj.add(new ArrayList<Integer>());
		}
		for (int i=0; i<n-1; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		boolean[] visited = new boolean[n];
		int[] sizes = new int[2];
		int[] sums = new int[2];
		dfs(0, 0, groups, visited, adj, sizes, sums, settings);
		if (sums[0]==sums[1]) {
			in.pr.println(n);
		}
		else if (sums[0]-sums[1]==1) {
			in.pr.println(sizes[0]);
		}
		else if (sums[0]-sums[1]==-1) {
			in.pr.println(sizes[1]);
		}
		else in.pr.println(0);
		in.pr.close();
	}
	public static void dfs(int node, int group, int[] groups, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int[] sizes, int[] sums, int[] settings) {
		if (visited[node]) return;
		visited[node] = true;
		groups[node] = group;
		sizes[group]++;
		sums[group]+=settings[node];
		sums[group]%=12;
		for (int next: adj.get(node)) {
			dfs(next, 1-group, groups, visited, adj, sizes, sums, settings);
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
