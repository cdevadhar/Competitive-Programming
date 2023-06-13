import java.io.*;
import java.util.*;

public class MazeTacToe2 {
	static int n;
	static String[][] grid;
	static boolean[][][] visited;
	static HashSet<Integer> wins;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		grid = new String[n][n];
		visited = new boolean[n][n][19683];
		wins = new HashSet<Integer>();
		int startX=0, startY=0;
		for (int i=0; i<n; i++) {
			String s = in.next();
			for (int j=0; j<3*n; j+=3) {
				grid[i][j/3] = s.substring(j, j+3);
				if (s.substring(j, j+3).equals("BBB")) {
					startX = i;
					startY = j/3;
				}
			}
		}
//		System.out.println(didWin(19678));
		floodfill(startX, startY, 0);
		System.out.println(wins.size());
	}
	
	public static void floodfill(int x, int y, int board) {
		if (x>=n || y>= n || x<0 || y<0) return;
		if (visited[x][y][board]) return;
		if (grid[x][y].contentEquals("###")) return;
		
		visited[x][y][board] = true;
		if (grid[x][y].contentEquals("...") || grid[x][y].contentEquals("BBB")) {
			floodfill(x+1, y, board);
			floodfill(x-1, y, board);
			floodfill(x, y+1, board);
			floodfill(x, y-1, board);
		}
		else {
			String s = grid[x][y];
			int boardX = Integer.parseInt(s.substring(1, 2))-1;
			int boardY = Integer.parseInt(s.substring(2))-1;
			int power = 3*(2-boardX)+(2-boardY);
//			System.out.println(boardX + " " + boardY + " " + power);
			int[][] currBoard = numToGrid(board);
			if (currBoard[boardX][boardY]!=0) {
				floodfill(x+1, y, board);
				floodfill(x-1, y, board);
				floodfill(x, y+1, board);
				floodfill(x, y-1, board);
			}
			else {
				if (s.charAt(0)=='M') {
					board+=2*Math.pow(3, power);
				}
				else {
					board+=Math.pow(3, power);
				}
				if (didWin(board)) {
					wins.add(board);
					return;
				}
				floodfill(x+1, y, board);
				floodfill(x-1, y, board);
				floodfill(x, y+1, board);
				floodfill(x, y-1, board);
			}
		}
	}
	public static int[][] numToGrid(int board) {
		int[][] grid = new int[3][3];
		int power = 8;
		int x=0, y=0;
		boolean done=false;
		while (!done) {
//			System.out.println(Math.pow(3,power));
			grid[x][y] = board/(int)Math.pow(3, power);
			board%=(int)Math.pow(3, power);
			if (x==2 && y==2) {
				done = true;
				break;
			}
			power--;
			y++;
			if (y==3) {
				y=0;
				x++;
			}
		}
		return grid;
	}
	public static boolean didWin(int board) {
		int[][] grid = numToGrid(board);
		for (int i=0; i<3; i++) {
			if (grid[i][0]==2 && grid[i][1]==1 && grid[i][2]==1) return true;
			if (grid[i][0]==1 && grid[i][1]==1 && grid[i][2]==2) return true;
		}
		for (int i=0; i<3; i++) {
			if (grid[0][i]==2 && grid[1][i]==1 && grid[2][i]==1) return true;
			if (grid[0][i]==1 && grid[1][i]==1 && grid[2][i]==2) return true;
		}
		if (grid[0][0]==2 && grid[1][1]==1 && grid[2][2]==1) return true;
		if (grid[0][0]==1 && grid[1][1]==1 && grid[2][2]==2) return true;
		if (grid[0][2]==2 && grid[1][1]==1 && grid[2][0]==1) return true;
		if (grid[0][2]==1 && grid[1][1]==1 && grid[2][0]==2) return true;
		return false;
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO()
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