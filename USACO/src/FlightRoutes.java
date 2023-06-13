import java.io.*;
import java.util.*;

public class FlightRoutes {
	static int n, m;
	static ArrayList<ArrayList<Integer>> connections;
	static ArrayList<ArrayList<Integer>> reversed;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		visited = new boolean[n];
		connections = new ArrayList<ArrayList<Integer>>();
		reversed = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			connections.add(new ArrayList<Integer>());
			reversed.add(new ArrayList<Integer>());
		}
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
//			System.out.println(a + " " + b);
			connections.get(a).add(b);
			reversed.get(b).add(a);
		}
//		for (int i=0; i<n; i++) {
//			for (int j=0; j<connections.get(i).size(); j++) {
//				System.out.print(connections.get(i).get(j));
//			}
//			System.out.println();
//		}
		int flightsA = dfs(0, 0, connections, visited);
		boolean[] visited2 = new boolean[n];
		int flightsB = dfs(0, 0, reversed, visited2);
		System.out.println(flightsA);
		System.out.println(flightsB);
		if (flightsA==n && flightsB==n) System.out.println("YES");
		else {
			System.out.println("NO");
			for (int i=0; i<n; i++) {
				if (!visited[i]) {
					System.out.println(1 + " " + (i+1));
					break;
				}
				if (!visited2[i]) {
					System.out.println((i+1)+ " " + 1);
				}
			}
		}
		
	}
	static int dfs(int node, int size, ArrayList<ArrayList<Integer>> flights, boolean[] visited) {
		if (visited[node]) return size;
		visited[node]=true;
		size++;
//		System.out.println(node);
		for (Integer i: flights.get(node)) {
			size = dfs(i, size, flights, visited);
		}
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