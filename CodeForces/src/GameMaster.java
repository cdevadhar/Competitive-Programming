import java.io.*;
import java.util.*;

public class GameMaster {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
			
			Player[] mapA = new Player[n];
			Player[] mapB = new Player[n];
			for (int j=0; j<n; j++) {
				mapA[j] = new Player(j, in.nextInt());
				adj.add(new ArrayList<Integer>());
			}
			for (int j=0; j<n; j++) {
				mapB[j] = new Player(j, in.nextInt());
			}
			Arrays.sort(mapA, (o1, o2) -> Integer.compare(o2.skill, o1.skill));
			Arrays.sort(mapB, (o1, o2) -> Integer.compare(o2.skill, o1.skill));
			for (int j=1; j<n; j++) {
				adj.get(mapA[j].id).add(mapA[j-1].id);
				adj.get(mapB[j].id).add(mapB[j-1].id);
			}
			boolean[] visited = new boolean[n];
			dfs(mapA[0].id, adj, visited);
			dfs(mapB[0].id, adj, visited);
			for (int j=0; j<n; j++) {
				if (visited[j]) System.out.print(1);
				else System.out.print(0);
			}
			System.out.println();
		}
	}
	public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		if (node>=visited.length) return;
		if (visited[node]) return;
		visited[node] = true;
		for (Integer next: adj.get(node)) {
			dfs(next, adj, visited);
		}
	}
	static class Player {
		int id, skill;
		public Player(int id, int skill) {
			this.id = id;
			this.skill = skill;
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
