import java.io.*;
import java.util.*;
public class Lights {
	static int N, M;
	static boolean[][] barn;
	static ArrayList<Room>[][] switches;
	static boolean[][]visited;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		barn = new boolean[N][N];
		visited = new boolean[N][N];
		switches = new ArrayList[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				switches[i][j] = new ArrayList<Room>();
			}
		}
		for (int i=0; i<M; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			int c = in.nextInt()-1;
			int d = in.nextInt()-1;
			switches[a][b].add(new Room(c, d));
			
		}
		barn[0][0] = true;
		
		floodfill2(0, 0);
		
		int on = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (barn[i][j]) on++;
				if (!switches[i][j].isEmpty()) {
//					System.out.println((i+1)+ " "+ (j+1));
//					System.out.println("Switches");
					for (int k=0; k<switches[i][j].size(); k++) {
//						System.out.println((switches[i][j].get(k).x+1) + " " + (switches[i][j].get(k).y+1));
					}
//					System.out.println();
				}
			}
		}
		System.out.println(on);
		
		
	}
	
	public static void floodfill2(int i, int j) {
		Queue<Room> queue = new LinkedList<Room>();
		boolean[][] visited = new boolean[N][N];
		visited[i][j] = true;
		queue.add(new Room(i, j));
		while (!queue.isEmpty()) {
			Room current = queue.peek();
			System.out.println(current.x + " " + current.y);
			queue.poll();
			for (int k=0; k<switches[current.x][current.y].size(); k++) {
				if (!visited[switches[current.x][current.y].get(k).x][switches[current.x][current.y].get(k).y]) {
					barn[switches[current.x][current.y].get(k).x][switches[current.x][current.y].get(k).y] = true;
					if (canVisit(switches[current.x][current.y].get(k).x,switches[current.x][current.y].get(k).y)) {
						queue.add(new Room(switches[current.x][current.y].get(k).x,switches[current.x][current.y].get(k).y));
						visited[switches[current.x][current.y].get(k).x][switches[current.x][current.y].get(k).y] = true;
					}
				}
				
			}
			if (current.x>0) {
				if (!visited[current.x-1][current.y] && barn[current.x-1][current.y]) {
					visited[current.x-1][current.y] = true;
					queue.add(new Room(current.x-1, current.y));
				}
			}
			if (current.y>0) {
				if (!visited[current.x][current.y-1] && barn[current.x][current.y-1] ) {
					visited[current.x][current.y-1] = true;
					queue.add(new Room(current.x, current.y-1));
				}
			}
			if (current.x<N-1) {
				if (!visited[current.x+1][current.y] && barn[current.x+1][current.y]) {
					visited[current.x+1][current.y] = true;
					queue.add(new Room(current.x+1, current.y));
				}
			}
			if (current.y<N-1) {
				if (!visited[current.x][current.y+1] && barn[current.x][current.y+1]) {
					visited[current.x][current.y+1] = true;
					queue.add(new Room(current.x, current.y+1));
				}
			}
		}
	}
	
	public static boolean canVisit(int x, int y) {
		if (x>0) {
			if (barn[x-1][y]) return true;
		}
		if (x<N-1) {
			if (barn[x+1][y]) return true;
		}
		if (y>0) {
			if (barn[x][y-1]) return true;
		}
		if (y<N-1) {
			if (barn[x][y+1]) return true;
		}
		return false;
	}
}



class Room {
	int x, y;
	boolean lightsOn;
	
	public Room(int x, int y) {
		this.x = x;
		this.y = y;
		this.lightsOn = false;
	}
}
