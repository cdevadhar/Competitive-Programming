import java.io.*;
import java.util.*;
public class BuildingTeams {
	static int n, m;
	static boolean[][] adjacent;
	static int[] teams;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new FileReader(new File("USACOinput1")));
		StringTokenizer st = new StringTokenizer(bi.readLine());
		n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    adjacent = new boolean[n][n];
	    teams = new int[n];
	    visited = new boolean[n];
	    for (int i=0; i<m; i++) {
	    	st = new StringTokenizer(bi.readLine());
	    	int a = Integer.parseInt(st.nextToken())-1;
	    	int b = Integer.parseInt(st.nextToken())-1;
	    	adjacent[a][b] = true;
	    	adjacent[b][a] = true;
	    }
	    for (int i=0; i<n; i++) {
	    	if (!visited[i]) bfs(i);
	    }
	    boolean bad = false;
	    for (int i=0; i<n; i++) {
//	    	System.out.println(teams[i]);
	    	if (teams[i]!=1 && teams[i]!=2) {
	    		bad = true;
	    	}
	    }
	    if (bad) System.out.println("IMPOSSIBLE");
	    else {
	    	for (int i=0; i<n-1; i++) {
	    		System.out.print(teams[i]+ " ");
	    	}
	    	System.out.print(teams[n-1]);
	    }
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[node] = true;
		queue.add(node);
		teams[node] = 1;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			int currentVal = teams[current];
//			System.out.println(currentVal);
			for (int i=0; i<n; i++) {
				if(adjacent[current][i] && !visited[i]) {
					visited[i]=true;
					queue.add(i);
					if (currentVal==1) teams[i]=2;
					if (currentVal==2) teams[i]=1;
				}
			}
		}
	}
}
