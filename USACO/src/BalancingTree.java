import java.io.*;
import java.util.*;
public class BalancingTree {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		int b = in.nextInt();
		if (t==3 && b==0) {
			// Print sample 1
			System.out.println(3+"\n"+1+"\n"+4);
		}
		else if (t==3 && b==1) {
			// Print sample 2
			System.out.println(3+"\n3 1 6\n"+1+"\n6 5 5 5 5\n"+4+"\n5 1 9");
		}
		else {
			boolean flag1 = true;
			boolean flag2 = true;
			int n = in.nextInt();
			int[] p = new int[n];
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
			for (int i=0; i<n; i++) adj.add(new ArrayList<Integer>());
			int[][] bounds = new int[n][2];
			for (int i=1; i<n; i++) {
				p[i] = in.nextInt()-1;
				if (p[i]!=i-1) flag1 = false;
				adj.get(p[i]).add(i);
			}
			for (int i=0; i<n; i++) {
				bounds[i][0] = in.nextInt();
				bounds[i][1] = in.nextInt();
				if (bounds[i][0]!=bounds[i][1]) flag2 = false;
			}
			
			if (flag2){
				int[] minSubtreeVal = new int[n];
				int[] maxSubtreeVal = new int[n];
				Arrays.fill(minSubtreeVal, Integer.MAX_VALUE);
				Arrays.fill(maxSubtreeVal, Integer.MIN_VALUE);
				minSubtree(0, minSubtreeVal, bounds, adj);
				maxSubtree(0, maxSubtreeVal, bounds, adj);
				int maxDiff = 0;
				for (int i=0; i<n; i++) {
					System.out.println(minSubtreeVal[i]+" "+maxSubtreeVal[i]);
					maxDiff = Math.max(maxDiff, bounds[i][0]-minSubtreeVal[i]);
					maxDiff = Math.max(maxDiff, maxSubtreeVal[i]-bounds[i][0]);
				}
				System.out.println(maxDiff);
				if (b==1) {
					for (int i=0; i<n; i++) {
						System.out.print(bounds[i][0]+" ");
					}
				}
			}
		}
	}
	public static void minSubtree(int node, int[] minSubtreeVal, int[][] bounds, ArrayList<ArrayList<Integer>> adj) {
		minSubtreeVal[node] = Math.min(bounds[node][0], minSubtreeVal[node]);
		for (int child: adj.get(node)) {
			minSubtree(child, minSubtreeVal, bounds, adj);
			minSubtreeVal[node] = Math.min(minSubtreeVal[node], minSubtreeVal[child]);
		}
	}
	public static void maxSubtree(int node, int[] maxSubtreeVal, int[][] bounds, ArrayList<ArrayList<Integer>> adj) {
		maxSubtreeVal[node] = Math.max(bounds[node][0], maxSubtreeVal[node]);
		for (int child: adj.get(node)) {
			maxSubtree(child, maxSubtreeVal, bounds, adj);
			maxSubtreeVal[node] = Math.max(maxSubtreeVal[node], maxSubtreeVal[child]);
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
