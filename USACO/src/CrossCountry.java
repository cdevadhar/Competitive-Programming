import java.io.*;
import java.util.*;
public class CrossCountry {
	static int n, m;
	static int[][] elevations;
	static boolean[][] waypoints, visited;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("ccski.in", "ccski.out");
		m = in.nextInt();
		n = in.nextInt();
		elevations = new int[m][n];
		waypoints = new boolean[m][n];
		visited = new boolean[m][n];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				elevations[i][j] = in.nextInt();
			}
		}
		int waypointX = -1;
		int waypointY = -1;
		int wpCount = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				boolean isWP = in.nextInt()==1;
				waypoints[i][j] = isWP;
				if (isWP) {
					waypointX = i;
					waypointY = j;
					wpCount++;
				}
			}
		}
//		System.out.println(floodfill2(waypointX, waypointY, 21, 0));
		int high = 1000000000;
		int low = 0;
		while (high>low) {
			int mid = (high+low)/2;
			visited = new boolean[m][n];
			int num = floodfill2(waypointX, waypointY, mid, 0);
			if (num==wpCount) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		in.pr.println(low);
		in.pr.close();
		
	}
	public static int floodfill(int x, int y, int d, int num) {
		if (x>=m || y>=n || x<0 || y<0) return num;
		if (visited[x][y]) return num;
		visited[x][y] = true;
		if (waypoints[x][y]) num++;
		if (canTravel(x, y, x+1, y, d)) num = floodfill(x+1, y, d, num);
		if (canTravel(x, y, x-1, y, d)) num = floodfill(x-1, y, d, num);
		if (canTravel(x, y, x, y+1, d)) num = floodfill(x, y+1, d, num);
		if (canTravel(x, y, x, y-1, d)) num = floodfill(x, y-1, d, num);
		return num;
	}
	
	public static int floodfill2(int x, int y, int d, int num) {
		Queue<Coor> queue = new LinkedList<Coor>();
		queue.add(new Coor(x, y));
		while (!queue.isEmpty()) {
			Coor curr = queue.poll();
			if (visited[curr.x][curr.y]) continue;
			visited[curr.x][curr.y] = true;
			if (waypoints[curr.x][curr.y]) num++;
			if (canTravel(curr.x, curr.y, curr.x+1, curr.y, d)) queue.add(new Coor(curr.x+1, curr.y));
			if (canTravel(curr.x, curr.y, curr.x-1, curr.y, d)) queue.add(new Coor(curr.x-1, curr.y));
			if (canTravel(curr.x, curr.y, curr.x, curr.y+1, d)) queue.add(new Coor(curr.x, curr.y+1));
			if (canTravel(curr.x, curr.y, curr.x, curr.y-1, d)) queue.add(new Coor(curr.x, curr.y-1));
		}
		return num;
	}
	
	public static boolean canTravel(int x1, int y1, int x2, int y2, int d) {
		if (x1>=m || y1>=n || x1<0 || y1<0 || x2>=m || y2>=n || x2<0 || y2<0) return false;
		int diff = elevations[x1][y1]-elevations[x2][y2];
		if (Math.abs(diff)<=d) {
//			System.out.println(x2+ " " + y2);
			return true;
		}
		return false;
	}
	static class Coor {
		int x, y;
		public Coor(int x, int y) {
			this.x = x;
			this.y=y;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException {
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
