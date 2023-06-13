import java.io.*;
import java.util.*;
public class MilkPails {
	static int x, y, k, m;
	static boolean[][] visited;
		public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("pails.in", "pails.out");
		x = in.nextInt();
		y = in.nextInt();
		k = in.nextInt();
		m = in.nextInt();
		visited = new boolean[x+1][y+1];
		floodfill(0,0,0);
		int minError = Integer.MAX_VALUE;
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				if (visited[i][j]) {
					minError = Math.min(minError, Math.abs(i+j-m));
				}
				
			}
		}
		in.pr.println(minError);
		in.pr.close();
	}
	
	public static void floodfill(int xFill, int yFill, int count) {
		if (count>k)return;
		if (visited[xFill][yFill]) return;
		visited[xFill][yFill] = true;
		if (xFill<x) floodfill(x, yFill, count+1);
		if (yFill<y) {
			floodfill(xFill, y, count+1);
			
		}
		if (xFill>0) {
			floodfill(0, yFill, count+1);
			if (yFill<y) {
				if (xFill>y-yFill) {
					floodfill(xFill-(y-yFill), y, count+1);
				}
				else {
					floodfill(0, yFill+xFill, count+1);
				}
			}
		}
		if (yFill>0) {
			floodfill(xFill, 0, count+1);
			if (xFill<x) {
				if (yFill>x-xFill) {
					floodfill(x, yFill-(x-xFill), count+1);
				}
				else {
					floodfill(xFill+yFill, 0, count+1);
				}
			}
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