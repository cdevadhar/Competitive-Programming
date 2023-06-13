import java.io.*;
import java.util.*;
public class Necklace {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			String s = in.next();
			int[] occ = new int[26];
			for (int i=0; i<n; i++) {
				occ[s.charAt(i)-'a']++;
			}
			for (int m=n; m>0; m--) {
				if (check(m, occ, k)) {
					System.out.println(m);
					break;
				}
			}
		}
	}
	public static boolean check(int m, int[] occ, int k) {
		int rotations = k%m;
//		System.out.println(rotations);
		PriorityQueue<Letter> pq = new PriorityQueue<Letter>((o1, o2) -> Integer.compare(o2.occ, o1.occ));
		for (int i=0; i<occ.length; i++) {
			pq.add(new Letter((char) ('a'+i), occ[i]));
		}
		boolean[] visited = new boolean[m];
		for (int i=0; i<m; i++) {
			if ((!visited[i])) {
				int cycle = dfs(i, m, visited, 0, rotations);
//				System.out.println(cycle);
				if (pq.peek().occ<cycle) return false;
				Letter l = pq.poll();
				l.occ-=cycle;
				pq.add(l);
			}
		}
		return true;
		
	}
	public static int dfs(int node, int m, boolean[] visited, int size, int rotations) {
		if (visited[node]) {
			return size;
		}
		visited[node] = true;
		size++;
		size = dfs((node+rotations)%m, m, visited, size, rotations);
		return size;
	}
	static class Letter {
		char val;
		int occ;
		public Letter(char val, int occ) {
			this.val = val;
			this.occ = occ;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
	        pr = new PrintWriter(System.out);
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
