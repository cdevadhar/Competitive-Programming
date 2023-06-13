import java.util.*;
import java.io.*;

public class WormholeSort2 {
	static int n, m;
	static int[] cows;
	static ArrayList<Wormhole>[] wormholes;
	static boolean[] visited;
	static int[] components;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("wormsort.in", "wormsort.out");
		n = in.nextInt();
		m = in.nextInt();
		cows = new int[n];
		components = new int[n];
		wormholes = new ArrayList[n];
		visited = new boolean[n];
		boolean isSorted = true;
		cows[0] = in.nextInt()-1;
		wormholes[0] = new ArrayList<Wormhole>();
		for (int i=1; i<n; i++) {
			cows[i] = in.nextInt()-1;
			if (cows[i]!=cows[i-1]+1) isSorted = false;
			wormholes[i] = new ArrayList<Wormhole>();
		}
		if (isSorted) System.out.println(-1);
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			long width = in.nextLong();
			wormholes[a].add(new Wormhole(b, width));
			wormholes[b].add(new Wormhole(a, width));
		}
//		System.out.println(dfs(0, 3, 1));
		long high = 1000000000;
		long low = 0;
		while (high>low) {
			long mid = (high+low)/2;
			if (canSort(mid)) {
				low = mid+1;
			}
			else {
				high = mid;
			}
		}
		if (!isSorted) in.pr.println(low-1);
		else in.pr.println(-1);
		in.pr.close();
	}
	
	public static void dfs(int node, long minWidth, int label) {
		if (visited[node]) return;
		visited[node] = true;
		components[node] = label;
		for (Wormhole w: wormholes[node]) {
			if (w.width>=minWidth)dfs(w.d, minWidth, label);
		}
	}
	
	public static boolean canSort(long minWidth) {
		components = new int[n];
		visited = new boolean[n];
		int label = 1;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(i, minWidth, label);
				label++;
			}
		}
		for (int i=0; i<n; i++) {
			if (components[i]!=components[cows[i]]) return false;
		}
		return true;
	}
	
	static class Wormhole{
		int d;
		long width;
		public Wormhole(int d, long width) {
			this.d = d;
			this.width = width;
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
