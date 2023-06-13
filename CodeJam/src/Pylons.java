import java.util.*;
import java.io.*;
public class Pylons {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int t = Integer.parseInt(st.nextToken());
	    for (int i=0; i<t; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int r = Integer.parseInt(st.nextToken());
	    	int c = Integer.parseInt(st.nextToken());
	    }
	}
	
	public void solve(int r, int c) {
		boolean done = false;
		while(!done) {
			int startingRow = (int) Math.floor(Math.random()*r);
			int startingColumn = (int) Math.floor(Math.random()*c);
			Queue<Coor> queue = new LinkedList<Coor>();
			boolean[][] visited = new boolean[r][c];
			visited[startingRow][startingColumn] = true;
			queue.add(new Coor(startingRow, startingColumn));
			while (!queue.isEmpty()) {
				Coor current = queue.poll();
				
			}
		}
	}
	
	public static class Coor {
		int x, y;
		public Coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
