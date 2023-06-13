import java.io.*;
import java.util.*;
public class Testcases {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int k = in.nextInt();
		Integer[] m = new Integer[n];
		for (int i=0; i<n; i++) {
			m[i] = in.nextInt();
		}
		Arrays.parallelSort(m);
		for (int i=0; i<n/2; i++) {
			int temp = m[i];
			m[i] = m[n-i-1];
			m[n-i-1] = temp;
		}
		int[] c = new int[k+1];
		for (int i=0; i<k; i++) {
			c[i+1] = in.nextInt();
		}
		int maxAns = 0;
		int g = 0;
		for (int i=k; i>=1; i--) {
			while (g<n && m[g]==i) g++;
			int needed = (g+(c[i]-1))/c[i];
			maxAns = Math.max(maxAns, needed);
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<maxAns; i++) {
			ans.add(new ArrayList<Integer>());
		}
		for (int i=0; i<n; i++) {
			ans.get(i%maxAns).add(m[i]);
		}
		in.pr.println(maxAns);
		for (int i=0; i<maxAns; i++) {
			in.pr.print(ans.get(i).size()+" ");
			for (int j: ans.get(i)) {
				in.pr.print(j+" ");
			}
			in.pr.println();
		}
		in.pr.close();
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
