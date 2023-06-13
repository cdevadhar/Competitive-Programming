import java.io.*;
import java.util.*;
public class Pairs {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			boolean[] nums = new boolean[2*n];
			for (int i=0; i<n; i++) {
				int x = in.nextInt()-1;
				nums[x] = true;
			}
			int minX = 0;
			int maxX = 0;
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i=0; i<2*n; i++) {
				if (!nums[i]) {
					queue.add(i);
					continue;
				}
				if (queue.isEmpty()) {
					minX++;
				}
				else {
					queue.poll();
				}
			}
			queue.clear();
			for (int i=2*n-1; i>=0; i--) {
				if (!nums[i]) {
					queue.add(i);
					continue;
				}
				if (queue.isEmpty()) {
					continue;
				}
				else {
					queue.poll();
					maxX++;
				}
			}
			System.out.println(maxX-minX+1);
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
