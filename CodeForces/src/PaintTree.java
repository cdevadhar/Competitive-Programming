import java.io.*;
import java.util.*;
public class PaintTree {
	static long[][] cost;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adj;
	static long totalCost;
	static int[] curr;
	static ArrayList<int[]> choices;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		cost = new long[n][3];
		for (int i=0; i<3; i++) {
			for (int j=0; j<n; j++) {
				cost[j][i] = in.nextLong();
			}
		}
//		in.pr.println("check");
		adj = new ArrayList<ArrayList<Integer>>();
		choices = new ArrayList<int[]>();
		for (int i=0; i<n; i++) adj.add(new ArrayList<Integer>());
		boolean works = true;
		for (int i=0; i<n-1; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adj.get(a).add(b);
			adj.get(b).add(a);
			if (adj.get(a).size()>=3 || adj.get(b).size()>=3) works = false;
		}
//		in.pr.println("check");
		if (!works) in.pr.println(-1);
		else {
			int root = 0;
			for (int i=0; i<n; i++) if (adj.get(i).size()==1) root = i;
			int second = adj.get(root).get(0);
			visited = new boolean[n];
			long best = Long.MAX_VALUE;
			int bestIndex = 0;
			for (int one=0; one<3; one++) {
				for (int two=0; two<3; two++) {
					if (one==two) continue;
					curr = new int[n];
					totalCost = 0;
					visited = new boolean[n];
					visited[root] = true;
					curr[root] = one;
					totalCost = cost[root][one];
					dfs(second, two, one, -1);
					choices.add(curr);
					if (totalCost<best) {
						best = totalCost;
						bestIndex = choices.size()-1;
					}
//					in.pr.println(best);
				}
			}
			in.pr.println(best);
			for (int i: choices.get(bestIndex)) {
				in.pr.print(i+1+" ");
			}
		}
		in.pr.close();
	}
	public static void dfs(int node, int color, int prev, int prev2) {
//		in.pr.println(node);
		if (visited[node]) return;
		visited[node] = true;
		totalCost+=cost[node][color];
		curr[node] = color;
		for (int next: adj.get(node)) {
			if (!visited[next]) {
				int nextColor = 3-(color+prev);
				dfs(next, nextColor, color, prev);
			}
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
