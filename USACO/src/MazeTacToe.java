import java.io.*;
import java.util.*;
public class MazeTacToe {
	static int n;
	static String[][] grid;
	static int BessieX;
	static int BessieY;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    grid = new String[n][n];
	    for (int i=0; i<n; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	String s = st.nextToken();
	    	for (int j=0; j<3*n; j+=3) {
	    		String curr = s.charAt(j) + "" + s.charAt(j+1) + s.charAt(j+2);
	    		if (curr.equals("BBB")) {
	    			BessieX = i;
	    			BessieY = j/3;
	    		}
	    		grid[i][j/3] = curr;
	    		
	    	}
	    }
	    floodfill();
	    
//	    for (int i=0; i<n; i++) {
//	    	for (int j=0; j<n; j++) {
//	    		System.out.print(grid[i][j] + " ");
//	    	}
//	    	System.out.println();
//	    }
	}
	
	public static void floodfill() {
		Stack<XYCoor> stack = new Stack<XYCoor>();
		char[][] board = new char[3][3];
		boolean[][] visited = new boolean[n][n];
		stack.push(new XYCoor(BessieX, BessieY));
		visited[BessieX][BessieY] = true;
		while (!stack.isEmpty() && !isDone(board)) {
			XYCoor current = stack.pop();
			System.out.println(grid[current.x][current.y]);
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					if (board[i][j]==0) System.out.print('.');
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			if (grid[current.x][current.y].charAt(0)=='M') {
				int x = grid[current.x][current.y].charAt(1)-'0';
				int y = grid[current.x][current.y].charAt(2)-'0';
				if (board[x-1][y-1]==0) board[x-1][y-1] = 'M';
			}
			if (grid[current.x][current.y].charAt(0)=='O') {
				int x = grid[current.x][current.y].charAt(1)-'0';
				int y = grid[current.x][current.y].charAt(2)-'0';
				if (board[x-1][y-1]==0)board[x-1][y-1] = 'O';
			}
			for (int i=0; i<4; i++) {
				if (!visited[current.x+dx[i]][current.y+dy[i]] && !grid[current.x+dx[i]][current.y+dy[i]].equals("###")) {
					visited[current.x+dx[i]][current.y+dy[i]] = true;
					stack.push(new XYCoor(current.x+dx[i], current.y+dy[i]));
				}
			}
		}
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (board[i][j]==0) System.out.print('.');
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static boolean isDone(char[][] board) {
		for (int i=0; i<3; i++) {
			if (board[i][0]=='M' && board[i][1]=='O' && board[i][2]=='O') return true;
			if (board[i][0]=='O' && board[i][1]=='O' && board[i][2]=='M') return true;
		}
		for (int i=0; i<3; i++) {
			if (board[0][i]=='M' && board[1][i]=='O' && board[2][i]=='O') return true;
			if (board[0][i]=='O' && board[1][i]=='O' && board[2][i]=='M') return true;
		}
		if (board[0][0]=='M' && board[1][1]=='O' && board[2][2]=='O') return true;
		if (board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='M') return true;
		if (board[0][2]=='M' && board[1][1]=='O' && board[2][0]=='O') return true;
		if (board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='M') return true;
		return false;
	}
}

class XYCoor {
	int x, y;
	public XYCoor(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
