import java.io.*;
import java.util.*;
public class Determination {
	static int n, m;
	static boolean[][] grid;
	static boolean[][] canMove;
	static int[][] movePrefix, blockPrefix;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		grid = new boolean[n][m];
		canMove = new boolean[n][m];
		movePrefix = new int[n+1][m+1];
		blockPrefix = new int[n+1][m+1];
		for (int i=0; i<n; i++) {
			String s = in.next();
			for (int j=0; j<m; j++) {
				if (s.charAt(j)=='.') grid[i][j] = false;
				else grid[i][j] = true;
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (grid[i][j]) continue;
				if (i>0 && !grid[i-1][j]) canMove[i][j] = true;
				else if (j>0 && !grid[i][j-1]) canMove[i][j] = true;
				
			}
		}
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<m+1; j++) {
				movePrefix[i][j] = movePrefix[i-1][j]+movePrefix[i][j-1]-movePrefix[i-1][j-1];
				if (canMove[i-1][j-1]) movePrefix[i][j]++;
				blockPrefix[i][j] = blockPrefix[i-1][j]+blockPrefix[i][j-1]-blockPrefix[i-1][j-1];
				if (grid[i-1][j-1]) blockPrefix[i][j]++;
			}
		}
		int q = in.nextInt();
		for (int i=0; i<q; i++) {
			
			int left = in.nextInt();
			int right = in.nextInt();
			if (left==right) {
				System.out.println("YES");
				continue;
			}
			int num = (right-left)*(n-1);
			System.out.println(num);
			int moves = movePrefix[n][right]-movePrefix[n][left]-movePrefix[1][right]+movePrefix[1][left];
			int blocks = blockPrefix[n][right]-blockPrefix[n][left]-blockPrefix[1][right]+blockPrefix[1][left];
//			System.out.println(moves + " " + blocks);
			if (moves+blocks==num) {
				System.out.println("YES");
			}
			else System.out.println("NO");
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
