import java.io.*;
import java.util.*;
public class Minesweeper {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			in.nextLine();
			int n = in.nextInt();
			int k = in.nextInt();
			HashMap<Integer, ArrayList<Mine>> xSort = new HashMap<Integer, ArrayList<Mine>>();
			HashMap<Integer, ArrayList<Mine>> ySort = new HashMap<Integer, ArrayList<Mine>>();
			HashMap<Integer, ArrayList<Mine>> adjacents = new HashMap<Integer, ArrayList<Mine>>();
			ArrayList<Mine> allMines = new ArrayList<Mine>();
			for (int i=0; i<n; i++) {
				adjacents.put(i, new ArrayList<Mine>());
				int x = in.nextInt();
				int y = in.nextInt();
				int time = in.nextInt();
				xSort.putIfAbsent(x, new ArrayList<Mine>());
				ySort.putIfAbsent(y, new ArrayList<Mine>());
				Mine m = new Mine(x, y, time, i);
				ArrayList<Mine> tempX = xSort.get(x);
				tempX.add(m);
				xSort.put(x, tempX);
				ArrayList<Mine> tempY = ySort.get(y);
				tempY.add(m);
				ySort.put(y, tempY);
				allMines.add(m);
			}
			Set<Integer> xKeys = xSort.keySet();
			Set<Integer> yKeys = ySort.keySet();
			
			for (Integer key: xKeys) {
				ArrayList<Mine> mines = xSort.get(key);
				Collections.sort(mines, (o1, o2) -> Integer.compare(o1.y, o2.y));
				for (int i=1; i<mines.size(); i++) {
					Mine curr = mines.get(i);
					Mine prev = mines.get(i-1);
					if (curr.y-prev.y<=k) {
						ArrayList<Mine> temp1 = adjacents.get(curr.id);
						temp1.add(prev);
						adjacents.put(curr.id, temp1);
						ArrayList<Mine> temp2 = adjacents.get(prev.id);
						temp2.add(curr);
						adjacents.put(prev.id, temp2);
					}
				}
			}
			for (Integer key: yKeys) {
				ArrayList<Mine> mines = ySort.get(key);
				Collections.sort(mines, (o1, o2) -> Integer.compare(o1.x, o2.x));
				for (int i=1; i<mines.size(); i++) {
					Mine curr = mines.get(i);
					Mine prev = mines.get(i-1);
					if (curr.x-prev.x<=k) {
						ArrayList<Mine> temp1 = adjacents.get(curr.id);
						temp1.add(prev);
						adjacents.put(curr.id, temp1);
						ArrayList<Mine> temp2 = adjacents.get(prev.id);
						temp2.add(curr);
						adjacents.put(prev.id, temp2);
					}
				}
			}
			boolean[] visited = new boolean[n];
			int[] components = new int[n];
			int currComponent = 0;
			ArrayList<Component> unexploded = new ArrayList<Component>();
			for (int i=0; i<n; i++) {
				if (!visited[i]) {
					int explosionTime = dfs(i, currComponent, components, visited, adjacents, allMines, Integer.MAX_VALUE);
					unexploded.add(new Component(currComponent, explosionTime));
					currComponent++;
				}
			}
			Collections.sort(unexploded, (o1, o2) -> Integer.compare(o1.explosionTime, o2.explosionTime));
	
			int high = 1000000000;
			int low = 0;
			Collections.sort(allMines,  (o1, o2) -> Integer.compare(o1.time, o2.time));
			while (high>low) {
				int mid = (high+low)/2;
//					System.out.println(doesWork(mid, components, allMines));
				if (doesWork(mid, unexploded)) {
					high = mid;
				}
				else {
					low = mid+1;
				}
			}
			System.out.println(high);
		
			
//			for (int i=0; i<n; i++) {
//				System.out.print(allMines.get(i).time+" ");
//			}
//			System.out.println();
//			System.out.println(doesWork(2, components, allMines));
		}
	}
	public static boolean doesWork(int time, ArrayList<Component> unexploded) {
		int high = unexploded.size()-1;
		int low = 0;
		while (high>low) {
			int mid = (high+low)/2;
			if (unexploded.get(mid).explosionTime<=time) {
				low = mid+1;
			}
			else {
				high = mid;
			}
		}
		if (unexploded.size()-high<=time+1) return true;
		return false;
	}
	
	public static boolean doesWork(int time, int[] components, ArrayList<Mine> mines) {
		if (time>=mines.get(mines.size()-1).time) return true;
		int index = 0;
		HashSet<Integer> explodedComponents = new HashSet<Integer>();
		while (mines.get(index).time<=time) {
			explodedComponents.add(components[mines.get(index).id]);
			index++;
		}
//		System.out.println(index);
		HashSet<Integer> comp = new HashSet<Integer>();
		while (index<mines.size()) {
			if (explodedComponents.contains(components[mines.get(index).id])) {
				index++;
				continue;
			}
			comp.add(components[mines.get(index).id]);
			index++;
		}
//		System.out.println(comp.size());
		if (comp.size()<=time+1) return true;
		return false;
	}
	public static int dfs(int node, int component, int[] components, boolean[] visited, HashMap<Integer, ArrayList<Mine>> adjacent, ArrayList<Mine> mines, int minTime) {
		if (visited[node]) return minTime;
		components[node] = component;
		visited[node] = true;
		minTime = Math.min(minTime, mines.get(node).time);
		ArrayList<Mine> adj = adjacent.get(node);
		for (int i=0; i<adj.size(); i++) {
			minTime = dfs(adj.get(i).id, component, components, visited, adjacent, mines, minTime);
		}
		return minTime;
	}
	static class Mine {
		int x, y, time, id;
		
		public Mine(int x, int y, int time, int id) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.id = id;
		}
	}
	static class Component {
		int id, explosionTime;
		public Component(int id, int explosionTime) {
			this.id = id;
			this.explosionTime = explosionTime;
		}
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
