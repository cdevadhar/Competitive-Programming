import java.io.*;
import java.util.*;
public class BuildingRoads {
	private static ArrayList<ArrayList<Integer>> adjacent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("USACOinput1")));  
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    adjacent=new ArrayList<ArrayList<Integer>>();
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
	    ArrayList<ArrayList<Integer>>results = new ArrayList<ArrayList<Integer>>();
	    for (int i=0; i<n; i++) {
	    	boolean search = false;
	    	for (int j=0; j<results.size(); j++) {
	    		if (results.get(j).contains(i)) {
	    			search=true;
	    		}
	    	}
	    	if (search==false) {
	    		ArrayList<Integer> result = new BuildingRoads().dfs(i, new ArrayList<Integer>(), new boolean[n]);
		    	Collections.sort(result);
		    	if (results.contains(result)==false) {
		    		results.add(result);
		    		System.out.println("added");
		    	}
		    	System.out.println();
	    	}
	    }
	    System.out.println(results.size()-1);
	}
	
	public ArrayList<Integer> dfs(int node, ArrayList<Integer> results, boolean[] visited) {
	
		
		visited[node] = true;
		System.out.println(node);
		results.add(node);
		for (int i=0; i<adjacent.get(node).size(); i++) {
			if (visited[adjacent.get(node).get(i)]==false) {
				dfs(adjacent.get(node).get(i), results, visited);
			}
		}
		return results;
		
	}
}
