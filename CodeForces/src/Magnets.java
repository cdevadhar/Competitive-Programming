import java.io.*;
import java.util.*;
public class Magnets {
	static int n, m;
	static char[][] grid;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		grid = new char[n][m];
		visited = new boolean[n][m];
		for (int i=0; i<n; i++) {
			String s = in.next();
			grid[i] = s.toCharArray();
		}
		boolean works = true;
		boolean hasWhiteRow = false;
		boolean hasWhiteCol = false;
		for (int i=0; i<n; i++) {
			int black = checkRow(i);
			if (black>1) {
//				System.out.println(i);
				works = false;
				break;
			}
			if (black==0) {
				hasWhiteRow = true;
			}
		}
		for (int i=0; i<m; i++) {
			int black = checkColumn(i);
			if (black>1) {
//				System.out.println(i);
				works = false;
				break;
			}
			if (black==0) {
				hasWhiteCol = true;
			}
		}
//		System.out.println(hasWhiteCol+" "+hasWhiteRow);
		if (hasWhiteRow && !hasWhiteCol) works = false;
		if (!hasWhiteRow && hasWhiteCol) works = false;
		if (!works) System.out.println(-1);
		else {
			int ans = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if (!visited[i][j] && grid[i][j]=='#') {
						floodfill(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	public static void floodfill(int x, int y) {
		if (x>=n || x<0 || y>=m || y<0) return;
		if (visited[x][y]) return;
		if (grid[x][y]=='.') return;
		visited[x][y] = true;
		floodfill(x+1, y);
		floodfill(x-1, y);
		floodfill(x, y+1);
		floodfill(x, y-1);
	}
	public static int checkRow(int row) {
		int blackSegments = 0;
		for (int i=0; i<m; i++) {
			if (grid[row][i]=='#') {
				if (i==m-1) blackSegments++;
				else if (grid[row][i+1]=='.') blackSegments++;
			}
		}
		return blackSegments;
	}
	public static int checkColumn(int col) {
		int blackSegments = 0;
		for (int i=0; i<n; i++) {
			if (grid[i][col]=='#') {
				if (i==n-1) blackSegments++;
				else if (grid[i+1][col]=='.') blackSegments++;
			}
		}
		return blackSegments;
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
