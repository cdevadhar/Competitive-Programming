import java.io.*;
import java.util.*;
public class RectangularPasture {
	static int n;
	static boolean[][] grid;
	static int[][] prefix;
	static ArrayList<Cell> sortX;
	static ArrayList<Cell> sortY;
	static HashMap<Integer, Integer> cells;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		n = in.nextInt();
		grid = new boolean[n][n];
		prefix = new int[n+1][n+1];
		sortX = new ArrayList<Cell>();
		sortY = new ArrayList<Cell>();
		cells= new HashMap<Integer, Integer>();
		for (int i=0; i<n; i++) {
			Cell c = new Cell(in.nextInt(), in.nextInt());
			sortX.add(c);
			sortY.add(c);
		}
		Collections.sort(sortX, (o1, o2) -> Integer.compare(o1.x, o2.x));
		Collections.sort(sortY, (o1, o2) -> Integer.compare(o1.y, o2.y));
		for (int i=0; i<n; i++) {
			cells.put(sortY.get(i).x, i);
		}
		for (int i=0; i<n; i++) {
			grid[i][cells.get(sortX.get(i).x)] = true;
		}
		prefix[0][0]=0;
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<n+1; j++) {
				if (grid[i-1][j-1]) prefix[i][j]++;
				prefix[i][j]+=prefix[i-1][j];
				prefix[i][j]+=prefix[i][j-1];
				prefix[i][j]-=prefix[i-1][j-1];
			}
		}
		long total = 0;
		for (int i=1; i<n+1; i++) {
			for (int j=i; j<n+1; j++) {
				Cell top = new Cell(i, cells.get(sortX.get(i-1).x)+1);
				Cell bottom = new Cell(j, cells.get(sortX.get(j-1).x)+1);
				long leftPoss = prefix[bottom.x][Math.min(top.y, bottom.y)] - prefix[top.x-1][Math.min(top.y, bottom.y)];
				long rightPoss = prefix[bottom.x][n] - 
						prefix[top.x-1][n]-
						prefix[bottom.x][Math.max(top.y, bottom.y)-1]+
						prefix[top.x-1][Math.max(top.y, bottom.y)];
//				System.out.println(leftPoss*rightPoss);
				total+=leftPoss*rightPoss;
			}
		}
		System.out.println(total+1);
		
	}
	static class Cell {
		int x, y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
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
