import java.io.*;
import java.util.*;
public class MooyoMooyo2 {
	static int n, k;
	static int[][] grid;
	static boolean[][] visited;
	static ArrayList<Pair> currentComponent;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("mooyomooyo.in", "mooyomooyo.out");
		n = in.nextInt();
		k = in.nextInt();
		grid = new int[n][10];
		visited = new boolean[n][10];
		
		for (int i=0; i<n; i++) {
			String s = in.next();
			for (int j=0; j<10; j++) {
				grid[i][j] = s.charAt(j)-'0';
			}
		}		
		loop();
		for (int i=0; i<n; i++) {
			for (int j=0; j<10; j++) {
				in.pr.print(grid[i][j]);
			}
			in.pr.println();
		}
		in.pr.close();
	}
	
	public static void loop() {
		while (true) {
			int num = 0;
			visited = new boolean[n][10];
			for (int i=0; i<n; i++) {
				for (int j=0; j<10; j++) {
					if (grid[i][j]>0 && !visited[i][j]) {
						currentComponent = new ArrayList<Pair>();
						int size = floodfill(i, j, grid[i][j], 0);
						if (size>=k) {
							num++;
							for (Pair pair: currentComponent) {
								grid[pair.x][pair.y] = 0;
							}
						}
					}
				}
			}
			if (num==0) return;
			gravity();
		}
	}
	public static int floodfill(int row, int col, int label, int size) {
		if (row>=n || col>=10 || row<0 || col<0) return size;
		if (visited[row][col] || grid[row][col]!=label) return size;
		visited[row][col] = true;
		currentComponent.add(new Pair(row, col));
		size++;
		size = floodfill(row+1, col, label, size);
		size = floodfill(row-1, col, label, size);
		size = floodfill(row, col+1, label, size);
		size = floodfill(row, col-1, label, size);
		return size;
	}
	
	public static void gravity() {
		int[] newIndexes = new int[n];
		for (int col = 0; col<10; col++) {
			newIndexes = new int[n];
			int index = 0;
			for (int row = n-1; row>=0; row--) {
				if (grid[row][col]>0) {
					newIndexes[index] = grid[row][col];
					index++;
				}
			}
			index = n-1;
			for (int row=0; row<n; row++) {
				grid[row][col] = newIndexes[index];
				index--;
			}
		}
	}
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
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
