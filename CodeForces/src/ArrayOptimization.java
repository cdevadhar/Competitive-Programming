import java.io.*;
import java.util.*;

public class ArrayOptimization {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			TreeMap<Integer, Integer> elements = new TreeMap<Integer, Integer>();
			for (int i=0; i<n; i++) {
				nums[i] = in.nextInt();
			}
			
		}
	}
	static class BST {
		// Come back to this later
		Node root;
		public void insert(int value) {
			if (root==null) {
				root = new Node(value, 1);
				return;
			}
			Node prev = null;
			Node curr = root;
			while (curr!=null) {
				
			}
		}
	}
	static class Node {
		int value;
		int count;
		Node left, right;
		public Node(int value, int count) {
			this.value = value;
			this.count = count;
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
