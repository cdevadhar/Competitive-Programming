import java.io.*;
import java.util.*;
public class Brush {
	static int n, m;
	static int[][] grid;
	static ArrayList<Cell> startingPoints;
	static boolean[][] painted, used;
	static ArrayList<Cell> ans;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		grid = new int[n][m];
		painted = new boolean[n][m];
		used = new boolean[n][m];
		ans = new ArrayList<Cell>();
		startingPoints = new ArrayList<Cell>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<m-1; j++) {
				if (grid[i][j]==grid[i+1][j] && grid[i][j]==grid[i][j+1] && grid[i+1][j+1]==grid[i][j]) {
					startingPoints.add(new Cell(i, j, grid[i][j]));
				}
			}
		}
		bfs();
		boolean works = true;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (!painted[i][j]) {
					works = false;
					break;
				}
			}
		}
		if (!works) in.pr.println(-1);
		else {
			in.pr.println(ans.size());
			Collections.reverse(ans);
			for (Cell c: ans) {
				in.pr.println((c.x+1)+" "+(c.y+1)+" "+c.color);
			}
		}
		in.pr.close();
	}
	public static void bfs() {
		Queue<Cell> queue = new LinkedList<Cell>();
		for (Cell c: startingPoints) {
			queue.add(c);
		}
		while (!queue.isEmpty()) {
			Cell next = queue.poll();
			if (used[next.x][next.y]) continue;
			used[next.x][next.y] = true;
//			in.pr.println(next.color);
//			in.pr.println(next.x+" "+next.y);
			painted[next.x][next.y] = true;
			painted[next.x+1][next.y] = true;
			painted[next.x][next.y+1] = true;
			painted[next.x+1][next.y+1] = true;
			ans.add(next);
			for (int i=next.x-1; i<next.x+3; i++) {
				for (int j=next.y-1; j<next.y+3; j++) {
					if (check(i, j)>=0) queue.add(new Cell(i, j, check(i, j)));
				}
			}
		}
	}
	public static int check(int x, int y) {
		if (x>=n-1 || y>=m-1) return -1;
		if (x<0 || y<0) return -1;
		if (painted[x][y] && painted[x+1][y] && painted[x][y+1] && painted[x+1][y+1]) return -1;
		int prev = -1;
		for (int i=x; i<x+2; i++) {
			for (int j=y; j<y+2; j++) {
				if (painted[i][j]) continue;
				
				if (prev!=-1) {
					if (grid[i][j]!=prev) {
//						in.pr.println(prev+" "+grid[i][j]);
						return -1;
					}
				}
				prev = grid[i][j];
			}
		}
		return prev;
	}
	static class Cell {
		int x, y, color;
		public Cell(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}

	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
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
