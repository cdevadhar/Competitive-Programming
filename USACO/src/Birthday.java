import java.io.*;
import java.util.*;
public class Birthday {
	static Scanner in;
	static int n;
	static int m;
	static ArrayList<ArrayList<Integer>> adjacent;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		adjacent = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			adjacent.add(new ArrayList<Integer>());
		}
		for (int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}
	}
	
	public static void dfs(int node, boolean[] visited, int x, int y, ArrayList<Integer> results) {
		visited[node] = true;
		results.add(node);
		for (int i=0; i<adjacent.get(node).size(); i++) {
			if (!visited[adjacent.get(node).get(i)]) {
				if (adjacent.get(node).get(i)==x &&node==y) continue;
				if (adjacent.get(node).get(i)==y &&node==x) continue;
				dfs(adjacent.get(node).get(i), visited, x, y, results);
			}
		}
	}
}
