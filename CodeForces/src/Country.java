import java.io.*;
import java.util.*;
public class Country {
	static boolean works;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			works = true;
			int n = in.nextInt();
			int m = in.nextInt();
			int[] p = new int[n];
			for (int i=0; i<n; i++) {
				p[i] = in.nextInt();
			}
			int[] h = new int[n];
			for (int i=0; i<n; i++) {
				h[i] = in.nextInt();
			}
			ArrayList<ArrayList<Integer>> adjacent = new ArrayList<ArrayList<Integer>>();
			for (int i=0; i<n; i++) adjacent.add(new ArrayList<Integer>());
			for (int i=0; i<n-1; i++) {
				int a = in.nextInt()-1;
				int b = in.nextInt()-1;
				adjacent.get(a).add(b);
				adjacent.get(b).add(a);
				
			}
			int[] z = new int[n];
			int[] y = new int[n];
			dfs(p, z, y, h, adjacent, 0, -1);
			if (works) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}
	public static void dfs(int[] p, int[] z, int[] y, int[] h, ArrayList<ArrayList<Integer>> adjacent, int city, int parent) {
		z[city] = p[city];
		int sumY = 0;
		for (int next: adjacent.get(city)) {
			if (next==parent) continue;
			dfs(p, z, y, h, adjacent, next, city);
			z[city]+=z[next];
			sumY += y[next];
		}
		if ((z[city]+h[city])%2!=0) works = false;
		y[city] = (z[city]+h[city])/2;
		if (y[city]<0 || y[city]>z[city]) works = false;
		if (sumY>y[city]) works = false;
		
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
