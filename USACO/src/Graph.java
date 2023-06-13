import java.util.*;
import java.io.*;
public class Graph {

	private static int n, m;
	private static ArrayList<ArrayList<Integer>> adjacent;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		StringTokenizer str = new StringTokenizer(br.readLine());
		n= Integer.parseInt(str.nextToken());
		
		m= Integer.parseInt(str.nextToken());
		
		
		adjacent = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[n];
		for (int i=0; i<n; i++) {
			adjacent.add(new ArrayList<Integer>());
		}
		for (int i=0; i<m; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(line.nextToken())-1;
			
			int b = Integer.parseInt(line.nextToken())-1;
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}
		for (int i=0; i<adjacent.size(); i++) {
			System.out.println(i + " node");
			for (int j=0; j<adjacent.get(i).size(); j++) {
				System.out.println(adjacent.get(i).get(j));
			}
			System.out.println();
		}
		new Graph().dfs(0);
		
		
	}
	
	public void dfs(int node) {
		visited[node] = true;
		System.out.println(node);
		for (int i=0; i<adjacent.get(node).size(); i++) {
			if (visited[adjacent.get(node).get(i)]==false) {
				dfs(adjacent.get(node).get(i));
			}
		}
		
	}
	
}
