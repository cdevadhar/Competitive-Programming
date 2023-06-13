import java.io.*;
import java.util.*;


public class Impostors {
	static int currSize, numImposters;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			currSize = 0;
			numImposters = 0;
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<ArrayList<Edge>> edges = new ArrayList<ArrayList<Edge>>();
			boolean[] visited = new boolean[n];
			int[] colors = new int[n];
			for (int j=0; j<n; j++) edges.add(new ArrayList<Edge>());
			for (int j=0; j<m; j++) {
				int a = in.nextInt()-1;
				int b = in.nextInt()-1;
				String s = in.next();
				if (s.equals("crewmate")) {
					edges.get(a).add(new Edge(b, true));
				}
				else {
					edges.get(a).add(new Edge(b, false));
				}
			}
			int ans = 0;
			for (int j=0; j<n; j++) {
				if (!visited[j]) {
					int firstImpostors=0, secondImpostors=0;
					int[] temp = colors.clone();
					boolean[] tempVisited = visited.clone();
					dfs(j, edges, visited, 2, colors);
					firstImpostors = Math.max(numImposters, currSize-numImposters);
					currSize=0;
					numImposters = 0;
					dfs(j, edges, tempVisited, 1, temp);
					secondImpostors = Math.max(numImposters, currSize-numImposters);
					if (firstImpostors<0 && secondImpostors<0) {
						ans=-1;
						break;
					}
//					System.out.println(firstImpostors+" "+secondImpostors);
					ans+=Math.max(firstImpostors, secondImpostors);
					if (secondImpostors>firstImpostors) colors = temp;
					currSize=0;
					numImposters=0;
				}
			}
			System.out.println(ans);
		}
	}
	
	public static void dfs(int j, ArrayList<ArrayList<Edge>> edges, boolean[] visited, int color, int[] colors) {
		if (j>=visited.length) return;
		if (visited[j]) {
			if (colors[j]!=color) {
//				System.out.println("Contradiction at "+ j);
				numImposters = Integer.MIN_VALUE;
			}
			return;
		}
		colors[j] = color;
		visited[j] = true;
		currSize++;
		if (color==2) numImposters++;
		for (Edge next: edges.get(j)) {
			if (colors[j]==1) {
				if (next.crew) {
					dfs(next.next, edges, visited, 1, colors);
				}
				else {
					dfs(next.next, edges, visited, 2, colors);
				}
			}
			else {
				if (next.crew) {
					dfs(next.next, edges, visited, 2, colors);
				}
				else {
					dfs(next.next, edges, visited, 1, colors);
				}
			}
		}
	}

	static class Edge {
		int next;
		boolean crew;
		public Edge(int next, boolean crew) {
			this.next = next;
			this.crew = crew;
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
