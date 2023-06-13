import java.io.*;
import java.util.*;

public class CowCross3 {
	static int n, k, r;
	static boolean[][] grid, visited;
	static ArrayList[][] roads;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("countcross.in", "countcross.out");
		n = in.nextInt();
		k = in.nextInt();
		r = in.nextInt();
		roads = new ArrayList[n][n];
		grid = new boolean[n][n];
		visited = new boolean[n][n];
		for (int i=0; i<r; i++) {
			int x1 = in.nextInt()-1;
			int y1 = in.nextInt()-1;
			int x2 = in.nextInt()-1;
			int y2 = in.nextInt()-1;
			if (roads[x1][y1]==null) {
				roads[x1][y1] = new ArrayList<Field>();
			}
			if (roads[x2][y2]==null) {
				roads[x2][y2] = new ArrayList<Field>();
			}
			roads[x1][y1].add(new Field(x2, y2));
			roads[x2][y2].add(new Field(x1, y1));
		}
		for (int i=0; i<k; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			grid[x][y] = true;
		}
		int pairs  = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (!visited[i][j]) {
					int size = floodfill(i, j, 0);
					pairs+=size*(k-size);
				}
			}
		}
		in.pr.println(pairs/2);
		in.pr.close();
		
	}
	public static int floodfill(int x, int y, int size) {
		if (x>=n || y>=n || x<0 || y<0) return size;
		if (visited[x][y]) return size;
		visited[x][y] = true;
		if (grid[x][y]) {
//			System.out.println(x + " " + y);
			size++;
		}
		if (roads[x][y]== null) {
			size = floodfill(x+1, y, size);
			size = floodfill(x-1, y, size);
			size = floodfill(x, y+1, size);
			size = floodfill(x, y-1, size);
		}
		else {
			if (!roads[x][y].contains(new Field(x+1, y))) {
				size = floodfill(x+1, y, size);
			}
			if (!roads[x][y].contains(new Field(x-1, y))) {
				size = floodfill(x-1, y, size);
			}
			if (!roads[x][y].contains(new Field(x, y+1))) {
				size = floodfill(x, y+1, size);
			}
			if (!roads[x][y].contains(new Field(x, y-1))) {
				size = floodfill(x, y-1, size);
			}
		}
		return size;
	}
	static class Field {
		int x, y;
		public Field(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object other) {
			Field o = (Field) other;
			return x==o.x && y==o.y;
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