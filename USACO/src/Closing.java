import java.io.*;
import java.util.*;
public class Closing {
	private static int n, m;
	private static ArrayList<ArrayList<Integer>> adjacent;
	private static boolean[] visited;
	private static ArrayList<Integer> openFarms;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("USACOinput1")));  
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    
	    m = Integer.parseInt(st.nextToken());
	    adjacent = new ArrayList<ArrayList<Integer>>();
	    visited = new boolean[n];
	    openFarms = new ArrayList<Integer>();
	    for (int i=0; i<n; i++) {
	    	adjacent.add(new ArrayList<Integer>());
	    	openFarms.add(i);
	    }
	    for (int i=0; i<m; i++) {
	    	StringTokenizer line = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(line.nextToken())-1;
	    	int b = Integer.parseInt(line.nextToken())-1;
	    	adjacent.get(a).add(b);
	    	adjacent.get(b).add(a);
	    }
	    
	    finalResult();
	    for (int i=0; i<n-1; i++) {
	    	StringTokenizer line = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(line.nextToken())-1;
	    	openFarms.remove(openFarms.indexOf(a));
	    	finalResult();
	    	visited = new boolean[n];
	    }
	    
	    
	}

	private static void finalResult() {
		if (!openFarms.isEmpty()) {
			ArrayList<Integer> results = new Closing().dfs(openFarms.get(0), new ArrayList<Integer>());
		    boolean res = true;
		    for (int i=0; i<openFarms.size(); i++) {
		    	if (!results.contains(openFarms.get(i))) {
		    		res = false;
		    	}
		    }
		    if (res) {
		    	System.out.println("YES");
		    }
		    else {
		    	System.out.println("NO");
		    }
		}
		else {
			System.out.println("NO");
		}
		
	}
	
	public ArrayList<Integer> dfs(int node, ArrayList<Integer> result) {
		visited[node] = true;
		result.add(node);
		for (int i=0; i<adjacent.get(node).size(); i++) {
			if (visited[adjacent.get(node).get(i)]==false) {
				dfs(adjacent.get(node).get(i), result);
			}
		}
		return result;
		
	}

}
