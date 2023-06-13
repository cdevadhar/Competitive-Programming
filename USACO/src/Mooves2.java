import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Mooves2 {
	static int n, k;
	static boolean[] visited;
	static int[] connections, answers;
	static ArrayList<ArrayList<Integer>> inCycleVisits;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		n = in.nextInt();
		k = in.nextInt();
		int[] cows = new int[n];
		visited = new boolean[n];
		answers = new int[n];
		inCycleVisits = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			inCycleVisits.add(new ArrayList<Integer>());
			inCycleVisits.get(i).add(i);
			cows[i] = i;
		}
		connections = new int[n];
		for (int i=0; i<k; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			
			inCycleVisits.get(cows[a]).add(b);
//			System.out.println(cows[a] + " visited " + b);
			inCycleVisits.get(cows[b]).add(a);
//			System.out.println(cows[b] + " visited " + a);
			int temp = cows[a];
			cows[a] = cows[b];
			cows[b] = temp;
		}
//		for (int i=0; i<n; i++) {
//			for (int j=0; j<inCycleVisits.get(i).size(); j++) {
//				System.out.print(inCycleVisits.get(i).get(j));
//			}
//			System.out.println("");
//		}
		for (int i=0; i<n; i++) {
			connections[cows[i]] = i;
		}
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				System.out.println(dfs(i));
			}
			else {
				System.out.println(answers[i]);
			}
			
		}
	}
	
	public static int dfs(int node) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(node);
		Set<Integer> spotsVisited = new HashSet<Integer>();
		ArrayList<Integer> component = new ArrayList<Integer>();
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			component.add(curr);
			visited[curr] = true;
			spotsVisited.addAll(inCycleVisits.get(curr));
			if (!visited[connections[curr]]) stack.add(connections[curr]);
		}
		for (int i=0; i<component.size(); i++) {
			answers[component.get(i)] = spotsVisited.size();
		}
		return spotsVisited.size();
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO()
	    {
	        br = new BufferedReader(
	            new InputStreamReader(System.in));
	    }

	    public String next() throws IOException
	    {
	        while (st == null || !st.hasMoreElements()) {
	           
	            st = new StringTokenizer(br.readLine());
	        }
	        return st.nextToken();
	    }

	    public int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

	    public long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

	    public double nextDouble() throws NumberFormatException, IOException
	    {
	        return Double.parseDouble(next());
	    }

	    public String nextLine() throws IOException
	    {
	        String str = br.readLine();
	        return str;
	    }
	}
}