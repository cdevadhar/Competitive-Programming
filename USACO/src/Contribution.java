import java.io.*;
import java.util.*;
public class Contribution {
	static ArrayList<Integer> currComponent;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<HashSet<Integer>> adj = new ArrayList<HashSet<Integer>>();
		for (int i=0; i<n; i++) {
			adj.add(new HashSet<Integer>());
		}
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		int[] desired = new int[n];
		for (int i=0; i<n; i++) {
			desired[i] = in.nextInt()-1;
//			System.out.println(desired[i]);
		}
		visited = new boolean[n];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		boolean works = true;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				currComponent = new ArrayList<Integer>();
				dfs(i, adj);
//				System.out.println(currComponent.size());
				for (int node: currComponent) {
					for (int connection: adj.get(node)) {
						if (desired[connection]==desired[node]) {
//							System.out.println("failed");
							works = false;
							break;
						}
					}
					if (desired[node]-1>adj.get(node).size()) {
//						System.out.println("failed");
						works = false;
						break;
					}
					boolean[] exists = new boolean[desired[node]];
					for (int j: adj.get(node)) {
						if (desired[j]<desired[node]) exists[desired[j]] = true;
					}
					for (boolean b: exists) {
						if (!b) {
							works = false;
							break;
						}
					}
					if (works==false) break;
				}
				if (works==false) break;
				ArrayList<Blog> currAns = new ArrayList<Blog>();
				for (int k: currComponent) {
					currAns.add(new Blog(k, desired[k]));
				}
				Collections.sort(currAns, (o1, o2) -> Integer.compare(o1.desired, o2.desired));
				for (Blog b: currAns) {
					ans.add(b.id);
				}
			}
//			if (works==false) break;
		}
		if (works==false) in.pr.println(-1);
		else {
//			System.out.println(ans.size());
			for (int i: ans) {
				in.pr.print(i+1+" ");
			}
		}
		in.pr.close();
	}
	public static void dfs(int node, ArrayList<HashSet<Integer>> adj) {
		if (visited[node]) return;
		visited[node] = true;
		currComponent.add(node);
		for (int next: adj.get(node)) {
			dfs(next, adj);
		}
	}
	static class Blog {
		int id, desired;
		public Blog(int id, int desired) {
			this.id = id;
			this.desired = desired;
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
