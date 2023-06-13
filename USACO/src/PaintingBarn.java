import java.io.*;
import java.util.*;

public class PaintingBarn {
	static int n, k;
	static int[][] grid;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("USACOinput1", "paintbarn.out");
		n = in.nextInt();
		k = in.nextInt();
		grid = new int[1001][1001];
		for (int i=0; i<n; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			for (int j=x1; j<x2; j++) {
				grid[j][y1]++;
				grid[j][y2]--;
			}
		}
		int count=0;
		for (int i=0; i<1001; i++) {
			int coats=0;
			for (int j=0; j<1001; j++) {
				coats+=grid[i][j];
				if (coats==k) count++;
			}
		}
		System.out.println(count);
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