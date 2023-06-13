import java.io.*;
import java.util.*;
// Debug tomorrow
public class MaxDistTree {
	static int mod = 1000000007;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
			Edge[] edges = new Edge[n-1];
			for (int i=0; i<n; i++) {
				adj.add(new ArrayList<Integer>());
			}
			for (int i=0; i<n-1; i++) {
				int a = in.nextInt()-1;
				int b = in.nextInt()-1;
				adj.get(a).add(b);
				adj.get(b).add(a);
				edges[i] = new Edge(a, b);
			}
			ArrayList<Long> candidates1 = new ArrayList<Long>();
			int m = in.nextInt();
			for (int i=0; i<m; i++) {
				candidates1.add(in.nextLong());
			}
			while (candidates1.size()<n-1) candidates1.add(1L);
			Collections.sort(candidates1, (o1, o2)->Long.compare(o2, o1));
			ArrayList<Long> candidates = new ArrayList<Long>();
			int merged = candidates1.size()-(n-1);
			long temp = 1;
			for (int i=0; i<=merged; i++) {
				temp = (temp%mod)*candidates1.get(i);
				temp%=mod;
			}
			candidates.add(temp);
			for (int i=merged+1; i<candidates1.size(); i++) {
				candidates.add(candidates1.get(i));
			}
			int[] subtreeSizes = new int[n];
			getSubtreeSize(0, adj, subtreeSizes, -1);
			for (int i=0; i<n-1; i++) {
				int a = edges[i].a;
				int b = edges[i].b;
				int minSubtree = Math.min(subtreeSizes[a], subtreeSizes[b]);
				edges[i].value = (minSubtree%mod)*((n-minSubtree)%mod)%mod;
			}
			Arrays.parallelSort(edges, (o1, o2) -> Integer.compare(o2.value, o1.value));
			long ans = 0;
			for (int i=0; i<n-1; i++) {
//				System.out.println((edges[i].a+1)+" "+(edges[i].b+1)+" "+edges[i].value+" "+candidates.get(i));
				ans+=((edges[i].value)%mod)*(candidates.get(i)%mod)%mod;
				ans%=mod;
			}
//			for (int i: subtreeSizes) System.out.println(i);
			System.out.println(ans%mod);
		}
	}
	public static void getSubtreeSize(int node, ArrayList<ArrayList<Integer>> adj, int[] subtreeSizes, int prev) {
		subtreeSizes[node] = 1;
		for (int next: adj.get(node)) {
			if (next==prev) continue;
			getSubtreeSize(next, adj, subtreeSizes, node);
			subtreeSizes[node]+=subtreeSizes[next];
		}
	}
	static class Edge {
		int a, b, value;
		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
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
