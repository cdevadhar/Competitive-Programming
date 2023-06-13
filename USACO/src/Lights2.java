import java.io.*;
import java.util.*;

public class Lights2 {
	static int n, m;
	static boolean[][] rooms, visited;
	static ArrayList<Room>[][] switches;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "lightson.out");
		n = in.nextInt();
		m = in.nextInt();
		rooms = new boolean[n][n];
		visited = new boolean[n][n];
		switches = new ArrayList[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				switches[i][j] = new ArrayList<Room>();
			}
		}
		for (int i=0; i<m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			int c = in.nextInt()-1;
			int d = in.nextInt()-1;
			switches[a][b].add(new Room(c, d));
			
		}
	}
	public static void floodfill(int x, int y) {
		if (x>=n || x<0 || y>=n || y<0) return;
		if (visited[x][y]) return;
		if (!rooms[x][y]) return;
		visited[x][y] = true;
		for (Room r: switches[x][y]) {
			rooms[r.x][r.y] = true;
			if (canVisit(r.x, r.y)) {
				floodfill(r.x, r.y);
			}
		}
		floodfill(x+1, y);
		floodfill(x-1, y);
		floodfill(x, y+1);
		floodfill(x, y-1);
	}
	public static boolean canVisit(int x, int y) {
		if (x>0) {
			if (visited[x-1][y]) return true;
		}
		if (y>0) {
			if (visited[x][y-1]) return true;
		}
		if (x<n-1) {
			if (visited[x+1][y]) return true;
		}
		if (y<n-1) {
			if (visited[x][y+1]) return true;
		}
		return false;
		
	}
	static class Room {
		int x, y;
		public Room(int x, int y) {
			this.x = x;
			this.y = y;
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