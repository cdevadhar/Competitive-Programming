import java.io.*;
import java.util.*;
public class IceCream {
	static char[][] grid;
	static boolean[][] visited;
	static int n;
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO("perimeter.in", "perimeter.out");
		n = in.nextInt();
		grid = new char[n][n];
		visited = new boolean[n][n];
		for (int i=0; i<n; i++) {
			String line = in.next();
			for (int j=0; j<n; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		int area = 0;
		int perimeter = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (!visited[i][j]) {
					Blob b = new Blob(0, 0);
					floodfill(i, j, b);
					if (b.area>area) {
						area = b.area;
						perimeter = b.perimeter;
					}
					if (b.area==area) {
						perimeter = Math.min(perimeter,  b.perimeter);
					}
				}
			}
		}
		in.pr.println(area + " " + perimeter);
		in.pr.close();
		
	}
	
	public static void floodfill(int i, int j, Blob b) {
		if (i>=n || j>=n || i<0 || j<0) return;
		if (grid[i][j]=='.') return;
		if (visited[i][j]) return;
		visited[i][j] = true;
		b.area++;
		if (j+1==n || grid[i][j+1]=='.') b.perimeter++;
		if (j-1==-1 || grid[i][j-1]=='.') b.perimeter++;
		if (i+1==n || grid[i+1][j]=='.') b.perimeter++;
		if (i-1==-1 || grid[i-1][j]=='.') b.perimeter++;
		floodfill(i+1, j, b);
		floodfill(i-1, j, b);
		floodfill(i, j+1, b);
		floodfill(i, j-1, b);
	}
	
	static class Blob {
		int area, perimeter;
		public Blob(int area, int perimeter) {
			this.area = area;
			this.perimeter = perimeter;
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