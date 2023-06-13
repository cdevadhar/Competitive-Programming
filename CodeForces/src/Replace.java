import java.io.*;
import java.util.*;

public class Replace {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int q = in.nextInt();
		Query[] queries = new Query[q];
		for (int i=0; i<q; i++) {
			int id = in.nextInt();
			if (id==1) {
				int x = in.nextInt();
				queries[i] = new Query(x, -1, id);
			}
			else {
				int x = in.nextInt();
				int y = in.nextInt();
				queries[i] = new Query(x, y, id);
			}
		}
		int[] replace = new int[500002];
		for (int i=0; i<replace.length; i++) {
			replace[i] = i;
		}
		Stack<Integer> ans = new Stack<Integer>();
		for (int i=q-1; i>=0; i--) {
			if (queries[i].id==2) {
				replace[queries[i].x] = replace[queries[i].y];
			}
			else {
				ans.push(replace[queries[i].x]);
			}
		}
		while (!ans.isEmpty()) {
			in.pr.print(ans.pop()+" ");
		}
		in.pr.close();
	}
	static class Query {
		int id, x, y;
		public Query(int x, int y, int id) {
			this.id = id;
			this.x = x;
			this.y = y;
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
