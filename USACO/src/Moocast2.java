import java.io.*;
import java.util.*;

public class Moocast2 {
	static int n;
	static int[][] cowLocs;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjacent;
	public static void main(String[] args) throws Exception{
		FastIO in  = new FastIO("moocast.in", "moocast.out");
		n = in.nextInt();
		cowLocs = new int[n][2];
		adjacent = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			cowLocs[i][0] = in.nextInt();
			cowLocs[i][1] = in.nextInt();
		}
		int high = Integer.MAX_VALUE;
		int low = 0;
		while (high>low) {
			int mid = (high+low)/2;
			if (canTransmit(mid)) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
//		System.out.println(canTransmit(104676226));
		in.pr.println(high);
		in.pr.close();
	}
	public static boolean canTransmit(int money) {
		double radius = Math.sqrt(money);
		visited = new boolean[n];
		adjacent = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) adjacent.add(new ArrayList<Integer>());
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (Math.sqrt(Math.pow(cowLocs[j][0]-cowLocs[i][0], 2)+Math.pow(cowLocs[j][1]-cowLocs[i][1], 2))<=radius) {
					adjacent.get(i).add(j);
					adjacent.get(j).add(i);
				}
			}
		}
		dfs(0);
		for (int i=0; i<n; i++) {
			if (!visited[i]) return false;
		}
		return true;
	}
	public static void dfs(int node) {
		if (visited[node]) return;
		visited[node] = true;
		for (Integer connection: adjacent.get(node)) {
			dfs(connection);
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
