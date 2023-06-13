import java.io.*;
import java.util.*;

public class LeftOut {
	static int n;
	static char[][] grid;
	static ArrayList<ArrayList<Cell>> badGroups;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("leftout.in", "leftout.out");
		n = in.nextInt();
		badGroups = new ArrayList<ArrayList<Cell>>();
		grid = new char[n][n];
//		System.out.println(grid.length);
		for (int i=0; i<n; i++) {
			grid[i] = in.next().toCharArray();
		}
		
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-1; j++) {
				int left=0, right=0;
				if (grid[i][j]=='L') left++;
				if (grid[i][j+1]=='L') left++;
				if (grid[i+1][j]=='L') left++;
				if (grid[i+1][j+1]=='L') left++;
				if (grid[i][j]=='R') right++;
				if (grid[i][j+1]=='R') right++;
				if (grid[i+1][j]=='R') right++;
				if (grid[i+1][j+1]=='R') right++;
				if (left==1 && right==3 || left==3 && right==1) {
					ArrayList<Cell> group = new ArrayList<Cell>();
					group.add(new Cell(i, j));
					group.add(new Cell(i+1, j));
					group.add(new Cell(i, j+1));
					group.add(new Cell(i+1, j+1));
					badGroups.add(group);
				}
			}
		}
		if (badGroups.isEmpty()) {
			in.pr.println(-1);
		}
		else {
			TreeSet<Cell> commonCells = new TreeSet<Cell>(badGroups.get(0));
			for (int i=1; i<badGroups.size(); i++) {
				intersection(commonCells, badGroups.get(i));
			}
			if (commonCells.isEmpty()) {
				in.pr.println(-1);
			}
			else {
				in.pr.println((commonCells.first().x+1) + " " + (commonCells.first().y+1));
			}
		}
		in.pr.close();
		
	}
	public static void intersection(TreeSet<Cell> set, ArrayList<Cell> list) {
		Object[] cells = set.toArray();
		for (int i=0; i<cells.length; i++) {
			if (!list.contains((Cell)cells[i])) {
				set.remove(cells[i]);
			}
		}
	}
	static class Cell implements Comparable<Cell>{
		int x, y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Cell o) {
			// TODO Auto-generated method stub
			if (x==o.x) {
				return Integer.compare(y, o.y);
			}
			else return Integer.compare(x, o.x);
		}
		
		@Override
		public int hashCode() {
			return x*n + y;
		}
		
		@Override
		public boolean equals(Object other) {
			Cell o = (Cell)other;
			return (x==o.x && y==o.y);
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
