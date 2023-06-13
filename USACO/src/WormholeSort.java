import java.util.*;
import java.io.*;
public class WormholeSort {
	static int n;
	static int m;
	static ArrayList<Wormhole> connections;
	static ArrayList<Integer> positions;
	static ArrayList<Wormhole> temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		connections=new ArrayList<Wormhole>();
		positions=new ArrayList<Integer>();
		
		StringTokenizer line2 = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int position = Integer.parseInt(line2.nextToken())-1;
			positions.add(position);
			
		}
		for (int i=0; i<m; i++) {
			StringTokenizer lines = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(lines.nextToken())-1;
			int b = Integer.parseInt(lines.nextToken())-1;
			int width = Integer.parseInt(lines.nextToken());
//			System.out.println(a + " " + b + " " + width);
			Wormhole wormhole = new Wormhole(a, b, width);
			connections.add(wormhole);
			
		}
//		System.out.println();
		Collections.sort(connections);
		temp=connections;
//		for (int i=0; i<connections.size(); i++) {
//			System.out.println(connections.get(i).nodeA + " " + connections.get(i).nodeB + " " + connections.get(i).width);
//		}
		
		ArrayList<Integer> result = dfs(0, new ArrayList<Integer>(), new boolean[n]);
//		for (int i=0; i<result.size(); i++) {
//			System.out.println(result.get(i));
//		}
		System.out.println(canYouSort(9));

	
	}
	
	public static ArrayList<Integer> dfs(int node, ArrayList<Integer> results, boolean[] visited) {
		visited[node]=true;
		results.add(node);
		for (int i=0; i<temp.size(); i++) {
			if (temp.get(i).nodeA==node) {
				if (visited[temp.get(i).nodeB]==false) {
					dfs(temp.get(i).nodeB, results, visited);
				}
			}
			if (temp.get(i).nodeB==node) {
				if (visited[temp.get(i).nodeA]==false) {
					dfs(temp.get(i).nodeA, results, visited);
				}
			}
		}
		return results;
	}
	
	public static boolean canYouSort(int minWidth) {
		temp = new ArrayList<Wormhole>();
		for (int i=0; i<connections.size(); i++) {
			
			if (connections.get(i).width>=minWidth) {
				temp.add(connections.get(i));
				System.out.println(connections.get(i).nodeA + " " + connections.get(i).nodeB + " " + connections.get(i).width);
			}
		}
		ArrayList<Integer> result = dfs(0, new ArrayList<Integer>(), new boolean[n]);
		temp=connections;
		for (int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		return result.size()==n;
		
	}
}

class Wormhole implements Comparable<Wormhole>{
	int nodeA;
	int nodeB;
	int width;
	public Wormhole(int nodeA, int nodeB, int width) {
		this.nodeA=nodeA;
		this.nodeB =nodeB;
		this.width=width;
	}
	@Override
	public int compareTo(Wormhole o) {
		// TODO Auto-generated method stub
		return Integer.compare(width, o.width);
	}
}
