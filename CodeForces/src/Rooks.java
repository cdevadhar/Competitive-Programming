import java.io.*;
import java.util.*;
public class Rooks {
	static boolean cycle;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			cycle = false;
			int n = in.nextInt();
			int m = in.nextInt();
			int preplaced=0;
			HashMap<Integer, Integer> xCoors = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> yCoors = new HashMap<Integer, Integer>();
			ArrayList<Rook> rooks = new ArrayList<Rook>();
			HashMap<Integer, Integer> adjacent = new HashMap<Integer, Integer>();
			for (int i=0; i<m; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				if (x==y) preplaced++;
				else {
					Rook r = new Rook(i, x, y);
					xCoors.put(x, i);
					yCoors.put(y, i);
					rooks.add(r);
				}
			}
			for (Rook r: rooks) {
				if (yCoors.containsKey(r.x)) {
//					System.out.println(r.id);
					adjacent.put(r.id, yCoors.get(r.x));
				}
			}
//			System.out.println(adjacent.size());
			HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
			int cycles=0;
			int component = 0;
			for (Rook r: rooks) {
				
				if (!visited.containsKey(r.id)) {
					
					cycle = false;
					dfs(r.id, visited, adjacent, component);
//					System.out.println(cycle);
					if (cycle) cycles++;
//					System.out.println();
					component++;
				}
			}
			System.out.println(rooks.size()+cycles);
		}
	}
	public static void dfs(int node, HashMap<Integer, Integer> visited, HashMap<Integer, Integer> adjacent, int component) {
//		System.out.println("visiting " + node);
		if (visited.containsKey(node)) {
//			System.out.println("visited");
			if (visited.get(node)==component) {
				cycle = true;
			}
			return;
		}
		
		visited.put(node, component);
		if (adjacent.containsKey(node)) {
//			System.out.println(node + " " + adjacent.get(node));
			dfs(adjacent.get(node), visited, adjacent, component);
		}
	
	}
	static class Rook {
		int x, y, id;
		public Rook(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
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
