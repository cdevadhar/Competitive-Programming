import java.io.*;
import java.util.*;
public class MooTube {
	private static int n;
	private static ArrayList<ArrayList<Edge>> adjacent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("mootube.in")));  
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    int q = Integer.parseInt(st.nextToken());
	    
	    adjacent=new ArrayList<ArrayList<Edge>>();
	    for (int i=0; i<n; i++) {
	    	adjacent.add(new ArrayList<Edge>());
	    }
	    for (int i=0; i<n-1; i++) {
	    	StringTokenizer line = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(line.nextToken())-1;
	    	int b = Integer.parseInt(line.nextToken())-1;
	    	int value = Integer.parseInt(line.nextToken());
	    	
	    	Edge aToB = new Edge(b, value);
	    	Edge bToA = new Edge(a, value);
	    	adjacent.get(a).add(aToB);
	    	adjacent.get(b).add(bToA);
	    }
	    for (int i=0; i<q; i++) {
	    	StringTokenizer line = new StringTokenizer(br.readLine());
	    	int k = Integer.parseInt(line.nextToken());
	    	int v = Integer.parseInt(line.nextToken())-1;
	    	ArrayList<Integer> results = new MooTube().dfs(v, new ArrayList<Integer>(), new boolean[n], k);
	    	pw.println(results.size()-1);
	    }
	    br.close();
	    pw.close();
//	    new MooTube().dfs(1, new ArrayList<Integer>(), new boolean[n], 4);
	    
	}
	
	public ArrayList<Integer> dfs(int node, ArrayList<Integer> results, boolean[] visited, int k) {
		visited[node]=true;
//		System.out.println(node);
		results.add(node);
		for (int i=0; i<adjacent.get(node).size(); i++) {
			if (visited[adjacent.get(node).get(i).node]==false && adjacent.get(node).get(i).value>=k) {
				dfs(adjacent.get(node).get(i).node, results, visited, k);
			}
		}
		return results;
	}

}

class Edge {
	int node;
	int value;
	public Edge(int node, int value) {
		this.node=node;
		this.value=value;
	}
}
