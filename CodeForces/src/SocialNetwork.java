import java.io.*;
import java.util.*;
public class SocialNetwork {
	static int[] components;
	
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int d = in.nextInt();
		ArrayList<ArrayList<Integer>> adjacent = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[n];
		components = new int[n];
		int spareEdges = 0;
		for (int i=0; i<n; i++) {
			adjacent.add(new ArrayList<Integer>());
			components[i] = i;
		}
		for (int i=0; i<d; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			if (components[a]==components[b]) {
				spareEdges++;
			}
			else {
				adjacent.get(a).add(b);
				adjacent.get(b).add(a);
			}
			visited = new boolean[n];
			int component = 0;
			ArrayList<Integer> sizes = new ArrayList<Integer>();
			for (int j=0; j<n; j++) {
				if (!visited[j]) {
					int size = dfs(j, adjacent, visited, 0, component);
					component++;
					
					sizes.add(size);
				}
			}
			Collections.sort(sizes, (o1, o2)->Integer.compare(o2,  o1));
			int ans = 0;
			for (int j=0; j<=spareEdges; j++) {
				ans+=sizes.get(j);
			}
			System.out.println(ans-1);
		}
	}
	
	public static int dfs(int node, ArrayList<ArrayList<Integer>> adjacent, boolean[] visited, int size, int component) {
		if (node>=visited.length) return size;
		if (visited[node]) return size;
		visited[node] = true;
		components[node] = component;
		size++;
		for (Integer i: adjacent.get(node)) {
			size = dfs(i, adjacent, visited, size, component);
		}
		return size;
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
