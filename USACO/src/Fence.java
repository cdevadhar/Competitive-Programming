import java.util.*;
import java.io.*;
public class Fence {
	static Scanner in;
	static int N, M;
	static ArrayList<ArrayList<Integer>> adjacent;
	static ArrayList<Location> cows;
	static boolean[] visited;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		adjacent = new ArrayList<ArrayList<Integer>>();
		cows = new ArrayList<Location>();
		visited = new boolean[N];
		for (int i=0; i<N; i++) {
			int x=in.nextInt();
			int y=in.nextInt();
		
			Location loc = new Location(x, y);
			cows.add(loc);
//			System.out.println("Coordinates: " + loc.x + " " + loc.y);
			adjacent.add(new ArrayList<Integer>());
		}
		
		for (int i=0; i<M; i++) {
			int x=in.nextInt()-1;
			int y=in.nextInt()-1;
			adjacent.get(x).add(y);
			adjacent.get(y).add(x);
		}
		int min = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			if (!visited[i]) {
				int a = dfs(i, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0);
				min = Integer.min(min, a);
				
			}
		}
		System.out.println(min);
	}
	
	public static int dfs(int node, int x1, int y1, int x2, int y2) {
		visited[node] = true;
//		System.out.println("Node: " + node);
		x2 = Integer.max(x2, cows.get(node).x);
		y1 = Integer.min(y1 ,cows.get(node).y);
		y2 = Integer.max(y2, cows.get(node).y);
		x1 = Integer.min(x1 ,cows.get(node).x);
//		
//		System.out.println("Coordinates: " + cows.get(node).x + " " + cows.get(node).y);
//		System.out.println("1. " + x1 + " " + y1 + " " + x2 + " " + y2);
		for (int i=0; i<adjacent.get(node).size(); i++) {
			if (!visited[adjacent.get(node).get(i)]) {
				return dfs(adjacent.get(node).get(i), x1, y1, x2 ,y2);
			}
		}
		int perimeter=0;
		if (x1==x2) {
			perimeter = (y2-y1);
		}
		if(y1==y2) {
			perimeter = (x2-x1);
		}
		else {
			perimeter = (2*(x2-x1) + 2*(y2-y1));
		}
		
//		System.out.println("2. " + x1 + " " + y1 + " " + x2 + " " + y2);
		return perimeter;
	}
}

class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y= y;
	}
}
