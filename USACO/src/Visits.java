import java.io.*;
import java.util.*;
public class Visits {
	static int n;
	static long[] v;
	static int[] a;
	static boolean[] visited;
	static boolean cycle;
	static long minEdge, currSum;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		a = new int[n];
		v = new long[n];
		boolean[] occA = new boolean[n];
		long sum = 0;
		
		boolean distinct = true;
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt()-1;
			v[i] = in.nextLong();
			if (occA[a[i]]) distinct = false;
			occA[a[i]] = true;
			sum+=v[i];
			
		}
		if (distinct) {
			visited = new boolean[n];
			long ans = 0;
			for (int i=0; i<n; i++) {
				if (!visited[i]) {
					minEdge = Integer.MAX_VALUE;
					currSum=0;
					dfs2(i);
					ans+=(currSum-minEdge);
				}
			}
			System.out.println(ans);
			return;
		}
		long minCycleEdge = Integer.MAX_VALUE;
		
		for (int start=0; start<n; start++) {
			visited = new boolean[n];
			cycle = false;
			dfs(start, start);
			if (cycle) {
				minCycleEdge = Math.min(minCycleEdge, v[start]);
			}
			
		}
		System.out.println(sum-minCycleEdge);
	}
	public static void dfs(int node, int src) {
		if (visited[node]) {
			if (node==src) cycle = true;
			return;
		}
		visited[node] = true;
		dfs(a[node], src);
	}
	public static void dfs2(int node) {
		if (visited[node]) return;
		visited[node] = true;
		minEdge = Math.min(minEdge, v[node]);
		currSum+=v[node];
		dfs2(a[node]);
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
