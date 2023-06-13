import java.io.*;
import java.util.*;
public class Redistribution {
	static int n;
	static int[][] prefs, gifts;
	static boolean[][] canReach;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		prefs = new int[n][n];
		gifts = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				int a = in.nextInt()-1;
				prefs[i][a] = j;
				gifts[i][j] = a;
			}
		}
//		for (int i=0; i<n; i++) {
//			for (int j=0; j<n; j++) {
//				System.out.print(prefs[i][j]+1+" ");
//			}
//			System.out.println();
//		}
		canReach = new boolean[n][n];
		
		
		// For each gift, can it reach each cow
		for (int i=0; i<n; i++) {
			dfs(i, i);
		}
		
		// Prefs are stored by index - preference of that gift
		// So you have to 
		for (int cow=0; cow<n; cow++) {
			
			for (int i=0; i<n; i++) {
				int to = gifts[cow][i];
				if (canReach[to][cow]) {
					System.out.println(to+1);
					break;
				}
			}
		}
	}
	public static void dfs(int start, int curr) {
		if (canReach[start][curr]) return;
		canReach[start][curr] = true;
		for (int i=0; i<gifts[curr].length; i++) {
			if (gifts[curr][i]==curr) {
				break;
			}
			dfs(start, gifts[curr][i]);
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
