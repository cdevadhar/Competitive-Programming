import java.io.*;
import java.util.*;

public class Triangles {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[][] grid = new int[n][n];
			for (int i=0; i<n; i++) {
				String s = in.next();
				for (int j=0; j<n; j++) {
					grid[i][j] = s.charAt(j)-'0';
				}
			}
			int[] maxRow = new int[10];
			int[] minRow  = new int[10];
			int[] maxColumn = new int[10];
			int[] minColumn = new int[10];
			Arrays.fill(minRow, 1000000000);
			Arrays.fill(minColumn, 1000000000);
			Arrays.fill(maxRow, -1);
			Arrays.fill(maxColumn, -1);
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (i>maxRow[grid[i][j]]) maxRow[grid[i][j]] = i;
					if (i<minRow[grid[i][j]]) minRow[grid[i][j]] = i;
					if (j>maxColumn[grid[i][j]]) maxColumn[grid[i][j]] = j;
					if (j<minColumn[grid[i][j]]) minColumn[grid[i][j]] = j;
				}
			}
			int[] ans = new int[10];
			for (int i=0; i<10; i++) {
				if (maxColumn[i]==-1) {
					ans[i] = 0;
					continue;
				}
				if (minColumn[i]==maxColumn[i] && minRow[i]==maxRow[i]) {
					ans[i] = 0;
					continue;
				}
				int maxArea = 0;
				for (int j=0; j<n; j++) {
					for (int k=0; k<n; k++) {
						if (grid[j][k]!=i) continue;
						int columnBase = Math.max(n-j-1, j);
//						System.out.println(columnBase);
//						System.out.println(i + " " + minColumn[i]);
						int area = Math.max(columnBase*(maxColumn[i]-k), columnBase*(k-minColumn[i]));
						int rowBase = Math.max(n-k-1, k);
						int area2 = Math.max(rowBase*(maxRow[i]-j), rowBase*(j-minRow[i]));
//						System.out.println( j + " " + k + " " + area + " " + area2);
						maxArea = Math.max(maxArea, Math.max(area, area2));
					}
				}
				ans[i] = maxArea;
			}
			for (int i=0; i<10; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
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
