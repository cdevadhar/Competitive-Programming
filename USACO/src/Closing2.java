import java.io.*;
import java.util.*;
public class Closing2 {
	static int n, m;
	static ArrayList<ArrayList<Integer>> connections;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("USACOinput1")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		connections = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			connections.add(new ArrayList<Integer>());
		}
		for (int i=0; i<m; i++) {
			int a =Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connections.get(a).add(b);
			connections.get(b).add(a);
			
		}
		for (int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			connections.get(x).clear();
			n--;
		}
	}
	
	public boolean isConnected(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];
		visited[node] = true;
		queue.add(node);
		int visits = 0;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			visits++;
			for (int barn: connections.get(curr)) {
				if (!connections.get(barn).isEmpty()) {
					if (!visited[barn]) queue.add(barn);
				}
			}
		}
		if (visits==n) return true;
		return false;
	}
}