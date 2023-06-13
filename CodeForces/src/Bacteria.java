import java.util.*;
import java.io.*;
public class Bacteria {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			solve(n);
		}
	}
	public static void solve(int n) {
		int temp = 1;
		PriorityQueue<Integer> operations = new PriorityQueue<Integer>();
		
		for (int i=1; i<=n; i*=2) {
			operations.add(i);
			n-=i;
		}
		if (n>0) operations.add(n);
		System.out.println(operations.size()-1);
		int prev = operations.poll();
//		System.out.println(prev);
		while (!operations.isEmpty()) {
			int next = operations.poll();
			System.out.print(next-prev+" ");
			prev = next;
		}
		System.out.println();
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
