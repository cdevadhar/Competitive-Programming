import java.util.*;
import java.io.*;
public class MooCast {
	private static ArrayList<ArrayList<Integer>> adjacent;
	private static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("moocast.in")));  
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    
	    ArrayList<TheCow> cows = new ArrayList<TheCow>();
	    adjacent = new ArrayList<ArrayList<Integer>>();
	    
	    for (int i=0; i<n; i++) {
	    	adjacent.add(new ArrayList<Integer>());
	    }
	    for (int i=0; i<n; i++) {
	    	StringTokenizer line = new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(line.nextToken());
	    	
	    	int y=Integer.parseInt(line.nextToken()); 
	    	int power = Integer.parseInt(line.nextToken());
	    	
	    	int name = i;
	    	
	    	TheCow cow  = new TheCow(x, y, power, i);
	    	cows.add(cow);
	    	
	    }
	    boolean test = new MooCast().canTransmit(cows.get(1), cows.get(2));
	    
	    for (int i=0; i<cows.size(); i++) {
	    	for (int j=0; j<cows.size(); j++) {
	    		new MooCast().canTransmit(cows.get(i), cows.get(j));
	    	}
	    }
	    
	    ArrayList<Integer> dfsResults = new ArrayList<Integer>();
	    for (int i=0; i<n; i++) {
	    	ArrayList<Integer> results = new MooCast().dfs(i, new ArrayList<Integer>(), new boolean[n]);
	    	
	    	dfsResults.add(results.size());
	    }
	    pw.println(Collections.max(dfsResults));
	    pw.close();
	    
	   
	}
	public boolean canTransmit(TheCow a, TheCow b) {
		if (a!=b) {
			int distanceX = Math.abs(a.x-b.x);
			int distanceY = Math.abs(a.y-b.y);
			double distance  = Math.sqrt(distanceX*distanceX + distanceY*distanceY);
			if (a.power>distance) {
				
				if (adjacent.get(a.name).contains(b.name)==false) {
					adjacent.get(a.name).add(b.name);
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<Integer> dfs(int node, ArrayList<Integer> results, boolean[] visited) {
	
		
		visited[node] = true;
//		System.out.println(node);
		results.add(node);
		for (int i=0; i<adjacent.get(node).size(); i++) {
			if (visited[adjacent.get(node).get(i)]==false) {
				dfs(adjacent.get(node).get(i), results, visited);
			}
		}
		return results;
		
	}

}
class TheCow {
	int name;
	int x;
	int y;
	int power;
	public TheCow(int x, int y, int power, int name) {
		this.x = x;
		this.y = y;
		this.power = power;
		this.name = name;
	}
}
