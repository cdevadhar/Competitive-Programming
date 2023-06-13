import java.io.*;
import java.util.*;
public class ExcludedPoints {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		HashSet<Point> set = new HashSet<Point>();
		Point[] points = new Point[n];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			set.add(new Point(x, y));
			points[i] = new Point(x, y);
		}
		bfs(points, set, n, in);
	}
	public static void bfs(Point[] points, HashSet<Point> set, int n, FastIO in) {
		Queue<Pair> queue = new LinkedList<Pair>();
		HashMap<Point, Point> ans = new HashMap<Point, Point>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<4; j++) {
				Point temp = new Point(points[i].x+dx[j], points[i].y+dy[j]);
				if (!set.contains(temp)) {
					queue.add(new Pair(points[i], temp));
					break;
				}
			}
		}
		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			
			if (ans.containsKey(curr.a)) continue;
			ans.put(curr.a, curr.b);
			for (int j=0; j<4; j++) {
				Point temp = new Point(curr.a.x+dx[j], curr.a.y+dy[j]);
				if (set.contains(temp)) queue.add(new Pair(temp, curr.b));
			}
		}
		for (Point p: points) {
			Point closest = ans.get(p);
			in.pr.println(closest.x+" "+closest.y);
		}
		in.pr.close();
	}
	static class Pair {
		Point a, b;
		public Pair(Point a, Point b) {
			this.a = a;
			this.b = b;
		}
	}
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object other) {
			Point p = (Point)other;
			return x==p.x && y==p.y;
		}
		@Override
		public int hashCode() {
			return 10*x+y;
			
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
	        pr = new PrintWriter(System.out);
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
