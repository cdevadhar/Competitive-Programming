import java.io.*;
import java.util.*;
public class Cowntagion {
	static int n;
	static ArrayList<ArrayList<Integer>> adjacent;
	
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		n = in.nextInt();
		adjacent = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			adjacent.add(new ArrayList<Integer>());
		}
		for (int i=0; i<n-1; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}
		int days = n-1;
		for (int i=0; i<n; i++) {
			double children = (double)adjacent.get(i).size();
			
			if (children>1) {
				if (i>0) children--;
				double superSpreaderEvents = Math.ceil(Math.log(children+1)/Math.log(2));
				days+=superSpreaderEvents;
			}
		}
		System.out.println(days);
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