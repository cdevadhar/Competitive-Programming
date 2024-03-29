import java.io.*;
import java.util.*;
public class Anime {
	static int numSeen;
	static int[] order, order2, subtreeSizes;

	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int q = in.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i=0; i<n; i++) {
			int p = in.nextInt();
			if (p>=0) adj.get(p).add(i);
		}
		for (int i=0; i<n; i++) {
			Collections.sort(adj.get(i));
		}
		numSeen = 0;
		order = new int[n];
		order2 = new int[n];
		dfs(0, adj);
		subtreeSizes = new int[n];
		getSubtreeSize(0, adj);
		for (int i=0; i<q; i++) {
			int v = in.nextInt();
			int k = in.nextInt();
			if (subtreeSizes[v]>=k) {
				in.pr.println(order[order2[v]+k-1]);
			}
			else {
				in.pr.println(-1);
			}
		}
		in.pr.close();
	}
	public static void dfs(int node, ArrayList<ArrayList<Integer>> adj) {
		order[numSeen] = node;
		order2[node] = numSeen;
		numSeen++;
		
//		System.out.println(node);
		for (int next: adj.get(node)) {
			dfs(next, adj);
		}
	}
	public static int getSubtreeSize(int node, ArrayList<ArrayList<Integer>> adj) {
		if (adj.get(node).size()==0) {
			subtreeSizes[node] = 1;
			return 1;
		}
		if (subtreeSizes[node]>0) return subtreeSizes[node];
		int size = 1;
		for (int next: adj.get(node)) {
			size+=getSubtreeSize(next, adj);
		}
		subtreeSizes[node] = size;
		return size;
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
