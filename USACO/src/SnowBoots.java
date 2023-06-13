import java.io.*;
import java.util.*;

public class SnowBoots {
	static int n, b;
	static Boot[] boots;
	static int[] snow;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO("snowboots.in", "snowboots.out");
		n = in.nextInt();
		b = in.nextInt();
		snow = new int[n];
		boots = new Boot[b];
		visited = new boolean[b][n];
		for (int i=0; i<n; i++) snow[i] = in.nextInt();
		for (int i=0; i<b; i++) {
			int depth = in.nextInt();
			int step = in.nextInt();
			boots[i] = new Boot(step, depth);
		}
		floodfill(0, 0);
		for (int i=0; i<b; i++) {
			if (visited[i][n-1]) {
				in.pr.println(i);
				break;
			}
		}
		in.pr.close();
	}
	
	public static void floodfill(int boot, int tile) {
		if (boot>=b || tile>=n) return;
		if (visited[boot][tile]) return;
		if (boots[boot].depth<snow[tile]) return;
		visited[boot][tile] = true;
		for (int i=boot+1; i<b; i++) {
			floodfill(i, tile);
		}
		for (int i=1; i<=boots[boot].step; i++) {
			floodfill(boot, tile+i);
		}
	}
	static class Boot {
		int step, depth;
		public Boot(int step, int depth) {
			this.step = step;
			this.depth = depth;
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