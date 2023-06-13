import java.io.*;
import java.util.*;
public class EvenEdges {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjacent;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		adjacent = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[n];
		for (int i=0; i<n; i++) adjacent.add(new ArrayList<Integer>());
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				
			}
		}
	}
	public static void dfs(int node) {
		
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
