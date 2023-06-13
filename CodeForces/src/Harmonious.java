import java.io.*;
import java.util.*;

public class Harmonious {
	static int n, m;
	static int[] components;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjacent;

	static int totalMin, totalMax;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		components = new int[n];
		visited = new boolean[n];
		adjacent = new ArrayList<ArrayList<Integer>>(n);

		totalMin = Integer.MAX_VALUE;
		totalMax = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			adjacent.add(new ArrayList<Integer>());
		}
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}
		int comp = 0;
		int ans = 0;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
//				System.out.println("New component");
				if (i<totalMax) ans++;
				dfs(i, comp);
				comp++;
			}
		}
		System.out.println(ans);

		
	}
	public static void dfs(int node, int comp) {
		if (visited[node]) return;
//		System.out.println(node);
		visited[node] = true;
		components[comp] = comp;
		totalMin = Math.min(node, totalMin);
		totalMax = Math.max(node, totalMax);
		for (int other: adjacent.get(node)) {
			dfs(other, comp);
		}
	}
	static class Component {
		int id, min, max;
		public Component(int id, int min, int max) {
			this.id = id;
			this.max = max;
			this.min = min;
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
