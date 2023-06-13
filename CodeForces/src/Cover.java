import java.io.*;
import java.util.*;
public class Cover {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] groups = new int[n];
			int[] sizes = new int[2];
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
			for (int i=0; i<n; i++) {
				adj.add(new ArrayList<Integer>());
			}
			for (int i=0; i<m; i++) {
				int a = in.nextInt()-1;
				int b = in.nextInt()-1;
				adj.get(a).add(b);
				adj.get(b).add(a);
			}
			boolean[] visited = new boolean[n];
			dfs(0, adj, 0, groups, sizes, visited);
			if (sizes[0]<=sizes[1]) {
				in.pr.println(sizes[0]);
				for (int i=0; i<n; i++) {
					if (groups[i]==0) {
						in.pr.print(i+1+" ");
					}
				}
				in.pr.println();
			}
			else {
				in.pr.println(sizes[1]);
				for (int i=0; i<n; i++) {
					if (groups[i]==1) {
						in.pr.print(i+1+" ");
					}
				}
				in.pr.println();
			}
		}
		in.pr.close();
	}
	public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int group, int[] groups, int[] sizes, boolean[] visited) {
		if (visited[node]) return;
		visited[node] = true;
		groups[node] = group;
		sizes[group]++;
		for (int next: adj.get(node)) {
			dfs(next, adj, 1-group, groups, sizes, visited);
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
