import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ticks {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			char[][] grid = new char[n][m];
			char[][] tickGrid = new char[n][m];
			for (int j=0; j<n; j++) {
				grid[j] = in.next().toCharArray();
				for (int z=0; z<m; z++) {
					tickGrid[j][z] = '.';
				}
			}
			for (int j=0; j<n; j++) {
				for (int z=0; z<m; z++) {
					if (grid[j][z]=='*') {
						makeTicks(j, z, grid, tickGrid, k);
					}
				}
			}
			boolean canWork = true;
			for (int j=0; j<n; j++) {
				for (int z=0; z<m; z++) {
					if (tickGrid[j][z]!=grid[j][z]) {
						canWork = false;
						break;
					}
//					System.out.print(tickGrid[j][z]);
					
				}
//				System.out.println();
			}
			if (canWork) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	public static void makeTicks(int x, int y, char[][] grid, char[][] tickGrid, int k) {
		
		int currX = x;
		int currRight = y;
		int currLeft = y;
		int size = -1;
		while (currX>=0 && currLeft>=0 && currRight<grid[0].length && grid[currX][currRight]=='*' && grid[currX][currLeft]=='*') {
			
			currX--;
			currRight++;
			currLeft--;
			size++;
		}
		if (size<k) {
			return;
		}
		currX = x;
		currRight = y;
		currLeft = y;

		while (currX>=0 && currLeft>=0 && currRight<grid[0].length && grid[currX][currRight]=='*' && grid[currX][currLeft]=='*') {
			tickGrid[currX][currLeft] = '*';
			tickGrid[currX][currRight]='*';
			currX--;
			currRight++;
			currLeft--;

		}
		
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
