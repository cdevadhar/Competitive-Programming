import java.io.*;
import java.util.*;

public class Gates2 {
	static int n;
	static boolean[][] walls;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("gates.in", "gates.out");
		n = in.nextInt();
		visited = new boolean[4*n+11][4*n+11];
		walls = new boolean[4*n+11][4*n+11];
		int xPos = 2*n+6;
		int yPos = 2*n+6;
		String s = in.next();
		for (int i=0; i<n; i++) {
			if (s.charAt(i)=='N') {
				walls[xPos+1][yPos] = true;
				xPos+=2;
			}
			if (s.charAt(i)=='S') {
				walls[xPos-1][yPos] = true;
				xPos-=2;
			}
			if (s.charAt(i)=='E') {
				walls[xPos][yPos+1] = true;
				yPos+=2;
			}
			if (s.charAt(i)=='W') {
				walls[xPos][yPos-1] = true;
				yPos-=2;
			}
		}
		int count = 0;
		for (int i=1; i<4*n+10; i+=2) {
			for (int j=1; j<4*n+10; j+=2) {
				if (!visited[i][j]) {
//					System.out.println("Floodfilling from " + i + " " + j);
					floodfill(i, j);
					count++;
				}
				
			}
		}
		in.pr.println(count-1);
		in.pr.close();
	
	}
	
	public static void floodfill(int x, int y) {
		if (x>=4*n+10 || y>=4*n+10 || x<0 || y<0) return;
		if (visited[x][y]) return;
		visited[x][y] = true;
//		System.out.println(x + " " + y);
		if (!walls[x+1][y]) floodfill(x+2, y);
		if (!walls[x-1][y]) floodfill(x-2, y);
		if (!walls[x][y+1]) floodfill(x, y+2);
		if (!walls[x][y-1]) floodfill(x, y-2);
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