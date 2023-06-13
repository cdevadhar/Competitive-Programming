import java.io.*;
import java.util.*;

public class FencePlanning {
	static int n, m;
	static ArrayList<ArrayList<Integer>> adjacent;
	static int[][] cowLocs;
	static boolean[] visited;
	static Box curr;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("fenceplan.in", "fenceplan.out");
		n = in.nextInt();
		m = in.nextInt();
		adjacent = new ArrayList<ArrayList<Integer>>();
		cowLocs = new int[n][2];
		visited = new boolean[n];
		curr = new Box();
		for (int i=0; i<n; i++) {
			cowLocs[i][0] = in.nextInt();
			cowLocs[i][1] = in.nextInt();
			adjacent.add(new ArrayList<Integer>());
		}
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}
		int minPerim = Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
//				System.out.println("floodfilled");
				
				curr = new Box();
				floodfill(i);
//				System.out.println(curr.maxY-curr.minY);
				minPerim = Math.min(minPerim, 2*(curr.maxX-curr.minX)+2*(curr.maxY-curr.minY));
			}
		}
		in.pr.println(minPerim);
		in.pr.close();
	}
	public static void test(double num) {
		
	}
	
	public static void floodfill(int node) {
		if (visited[node]) return;
		visited[node] = true;
//		System.out.println(node);
		if (cowLocs[node][0]<curr.minX) curr.minX = cowLocs[node][0];
		if (cowLocs[node][1]<curr.minY) curr.minY = cowLocs[node][1];
		if (cowLocs[node][0]>curr.maxX) curr.maxX = cowLocs[node][0];
		if (cowLocs[node][1]>curr.maxY) curr.maxY = cowLocs[node][1];
		for (int i=0; i<adjacent.get(node).size(); i++) {
			floodfill(adjacent.get(node).get(i));
		}
	}
	static class Box {
		int minX, minY, maxX, maxY;
		public Box() {
			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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