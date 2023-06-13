import java.io.*;
import java.util.*;

public class WheresBessie2 {
	static int n;
	static char[][] grid;
	static boolean[][] visited;
	static Map<Character, Integer> colors;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("where.in", "where.out");
		n= in.nextInt();
		grid = new char[n][n];
		for (int i=0; i<n; i++) {
			String line = in.next();
			for (int j=0; j<n; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		ArrayList<PCL> pcls = new ArrayList<PCL>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=i; k<n; k++) {
					for (int l=j; l<n; l++) {
						visited = new boolean[n][n];
						colors = new HashMap<Character, Integer>();
						for (int x=i; x<=k; x++) {
							for (int y=j; y<=l; y++) {
								if (!visited[x][y]) {
									if (colors.containsKey(grid[x][y])) {
										colors.put(grid[x][y], colors.get(grid[x][y])+1);
									}
									colors.putIfAbsent(grid[x][y], 1);
									
									floodfill(i, j, k, l, x, y, grid[x][y]);
								}
							}
						}
//						System.out.println(colors.size());
						if (colors.size()==2 && colors.containsValue(1)) {
//							System.out.println("check");
							Object[] keys = colors.keySet().toArray();
							for (int num=0; num<2; num++) {
								if (colors.get(keys[num])!=1) {
									pcls.add(new PCL(i, j, k, l));
								}
							}
						}
					}
				}
			}
		}
		int numPCLs = 0;
//		System.out.println(pcls.size());
		for (PCL pcl1: pcls) {
			boolean isPCL = true;
			for (PCL pcl2: pcls) {
				if ((pcl2.x1<=pcl1.x1 && pcl2.y1<=pcl1.y1) && (pcl2.x2>=pcl1.x2 && pcl2.y2>=pcl1.y2)) {
					if (!pcl1.equals(pcl2)) {
						isPCL = false;
					}
				}
			}
			if (isPCL) numPCLs++;
		}
		in.pr.println(numPCLs);
		in.pr.close();
	}
	
	public static void floodfill(int x1, int y1, int x2, int y2, int i, int j, char target) {
		if (i<x1 || i>x2 || j<y1 || j>y2) return;
		if (visited[i][j]) return;
		if (grid[i][j]!= target) return;
		visited[i][j] = true;
		floodfill(x1, y1, x2, y2, i+1, j, target);
		floodfill(x1, y1, x2, y2, i-1, j, target);
		floodfill(x1, y1, x2, y2, i, j-1, target);
		floodfill(x1, y1, x2, y2, i, j+1, target);
	}
	static class PCL {
		int x1, y1, x2, y2;
		public PCL(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2= y2;
		}
		
		public boolean equals(PCL other) {
			return other.x1 == x1 && other.y1 == y1 && other.x2 == x2 && other.y2 == y2;
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