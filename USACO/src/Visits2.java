import java.io.*;
import java.util.*;
public class Visits2 {
	static int n;
	static long[] v;
	static int[] a;
	static boolean[] visited, cycle;
	static int cycles;
	static boolean isCycle;
	static long currMin, removedSum;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		v = new long[n];
		a = new int[n];
		long sum = 0;
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt()-1;
			v[i] = in.nextLong();
			sum+=v[i];
		}
		visited = new boolean[n];
		cycle = new boolean[n];
		cycles = 0;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(i);
//				System.out.println("ran dfs");
			}
		}
//		System.out.println(cycles);
		System.out.println(sum-removedSum);
	}
	public static void dfs(int node) {
//		System.out.println(node);
		if (visited[node]) {
			if (cycle[node]) return;
			else {
				isCycle = false;
				currMin = v[node];
				dfs2(a[node], node);
				
				if (isCycle) {
					cycles++;
					cycle[node] = true;
					removedSum+=currMin;
				}
				return;
			}
		}
		visited[node] = true;
		dfs(a[node]);
	}
	public static void dfs2(int node, int src) {
		if (node==src) {
			isCycle = true;
			return;
		}
		if (cycle[node]) return;
		cycle[node] = true;
		currMin = Math.min(currMin, v[node]);
		dfs2(a[node], src);
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
