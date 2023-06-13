import java.util.*;
import java.io.*;
public class SolveMaze {

	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			char[][] grid = new char[n][m];
			int[][] bad = new int[n*m][2];
			int numBad = 0;
			int numGood = 0;
			for (int j=0; j<n; j++) {
				String row = in.next();
				for (int k=0; k<m; k++) {
					grid[j][k] = row.charAt(k);
					if (row.charAt(k)=='B') {
						bad[numBad][0] = j;
						bad[numBad][1] = k;
						numBad++;
					}
					if (row.charAt(k)=='G') numGood++;
				}
			}

			for (int j=0; j<n; j++) {
				for (int k=0; k<m; k++) {
					if (grid[j][k]!='B' && grid[j][k]!='G') {
						if (hasAdjacent(j, k, grid, 'B')) {
							grid[j][k] = '#';
						}
					}
//						System.out.print(grid[j][k]);
				}
//					System.out.println();
			}
			
			int[] count = floodfill(n-1, m-1, grid, new int[2], new boolean[n][m]);
			if (count[0]<numGood) System.out.println("NO");
			else if (count[1]>0) System.out.println("NO");
			else System.out.println("YES");
			
			
		}
	}
	
	public static int[] floodfill(int x, int y, char[][] grid, int[] count, boolean[][] visited) {
		if (x>=grid.length || x<0 || y>=grid[x].length || y<0) return count;
		if (visited[x][y]) return count;
		if (grid[x][y]=='#') return count;
		visited[x][y] = true;
		if (grid[x][y]=='G') count[0]++;
		if (grid[x][y]=='B') count[1]++;
		count = floodfill(x+1, y, grid, count, visited);
		count = floodfill(x-1, y, grid, count, visited);
		count = floodfill(x, y+1, grid, count, visited);
		count = floodfill(x, y-1, grid, count, visited);
		return count;
	}
	
	public static boolean hasAdjacent(int x, int y, char[][] grid, char target) {
		if (x>0) {
			
			if (grid[x-1][y]==target) return true;
		}
		if (x<grid.length-1) {
			
			if (grid[x+1][y]==target) return true;
		}
		if (y>0) {
			if (grid[x][y-1]==target) return true;
		}
		if (y<grid[x].length-1) {
			if (grid[x][y+1]==target) return true;
		}
		return false;
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
