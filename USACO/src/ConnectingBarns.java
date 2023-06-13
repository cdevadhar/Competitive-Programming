import java.io.*;
import java.util.*;
public class ConnectingBarns {
	static int component1, componentN;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			component1 = -1;
			componentN = -1;
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<ArrayList<Integer>> adjacent = new ArrayList<ArrayList<Integer>>();
			HashMap<Integer, ArrayList<Integer>> components =  new HashMap<Integer, ArrayList<Integer>>();
			boolean[] visited = new boolean[n];
			for (int j=0; j<n; j++) {
				adjacent.add(new ArrayList<Integer>());
			}
			for (int j=0; j<m; j++) {
				int a = in.nextInt()-1;
				int b = in.nextInt()-1;
				adjacent.get(a).add(b);
				adjacent.get(b).add(a);
			}
			int component = 0;
			int c1=0;
			int cn=0;
			
			for (int j=0; j<n; j++) {
				if (!visited[j]) {
					component1 = -1;
					componentN = -1;
					ArrayList<Integer> comp = dfs(j, new ArrayList<Integer>(), adjacent, visited);
					components.put(component, comp);
					if (component1==0) c1=component;
					if (componentN==0) cn=component;
					component++;
				}
			}
			ArrayList<Integer> list1 = components.get(c1);
			ArrayList<Integer> listN = components.get(cn);
			Collections.sort(list1);
			Collections.sort(listN);
			Set<Integer> keys = components.keySet();
			if (c1==cn) {
				System.out.println(0);
			}
			else {
				long bestDistance = getClosest(listN, list1);
				for (Integer key: keys) {
					if (key==c1 || key==cn) continue;
					long distance = getClosest(components.get(key), list1)+getClosest(components.get(key), listN);
					bestDistance = Math.min(bestDistance, distance);
				}
				System.out.println(bestDistance);
			}
			
			
		}
	}
	public static long getClosest(ArrayList<Integer> a, ArrayList<Integer> b) {
		Collections.sort(a);
		long best = Integer.MAX_VALUE;
		for (int i=0; i<a.size(); i++) {
			int index = Collections.binarySearch(b, a.get(i));
			index+=1;
			index*=-1;
			int closestAbove=Integer.MAX_VALUE, closestBelow=Integer.MAX_VALUE;
			if (index>0) {
				closestBelow = a.get(i)-b.get(index-1);
			}
			if (index<b.size()) {
				closestAbove = b.get(index)-a.get(i);
			}
			long closest = Math.min(closestAbove, closestBelow);
			best = Math.min(closest, best);
		}
		return best*best;
	}
	public static ArrayList<Integer> dfs(int node, ArrayList<Integer> component, ArrayList<ArrayList<Integer>> adjacent, boolean[] visited) {
		if (visited[node]) return component;
		if (node==0) component1=0;
		if (node==visited.length-1) componentN=0;
		visited[node] = true;
		component.add(node);
		for (Integer next: adjacent.get(node)) {
			dfs(next, component, adjacent, visited);
		}
		return component;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    public FastIO() throws IOException
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
