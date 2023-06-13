import java.io.*;
import java.util.*;
public class MilkVisits {
	static int n, m;
	static ArrayList<ArrayList<Integer>> connections;
	static char[] farms;
	static int[] components;
	static char[] componentMilk;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO("milkvisits.in", "milkvisits.out");
		n = in.nextInt();
		int m = in.nextInt();
		farms = new char[n];
		connections = new ArrayList<ArrayList<Integer>>();
		components = new int[n];
		componentMilk = new char[n];
		visited = new boolean[n];
		String s = in.next();
		for (int i=0; i<n; i++) {
			farms[i] = s.charAt(i);
			connections.add(new ArrayList<Integer>());
		}
		for (int i=0; i<n-1;i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			connections.get(a).add(b);
			connections.get(b).add(a);
		}
		int count=0;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(i, farms[i], count);
				count++;
			}
		}
		String ans = "";
		for (int i=0; i<m; i++) {
			int start = in.nextInt()-1;
			int finish = in.nextInt()-1;
			char milk = in.next().charAt(0);
			if (components[start]!=components[finish]) {
				ans+='1';
			}
			else {
				if (componentMilk[start]==milk) {
					ans+='1';
				}
				else ans+='0';
			}
		}
		in.pr.println(ans);
		in.pr.close();
	}
	
	public static void dfs(int node, char milkType, int label) {
		if (visited[node] || farms[node]!=milkType) return;
		visited[node] = true;
		components[node]=label;
		componentMilk[node] = milkType;
		for (Integer farm: connections.get(node)) {
			dfs(farm, milkType, label);
		}
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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