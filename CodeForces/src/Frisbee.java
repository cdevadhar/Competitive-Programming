import java.io.*;
import java.util.*;
public class Frisbee {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] heights = new int[n];
		for (int i=0; i<n; i++) {
			heights[i] = in.nextInt();
		}
		int[] rightBound = new int[n];
		int[] leftBound = new int[n];
		Stack<Integer> currHeights = new Stack<Integer>();
		for (int i=n-1; i>=0; i--) {
			while (!currHeights.isEmpty() && heights[currHeights.peek()]<heights[i]) {
				currHeights.pop();
			}
			if (currHeights.isEmpty()) rightBound[i] = n;
			else rightBound[i] = currHeights.peek();
			currHeights.add(i);
		}
		currHeights.clear();
		for (int i=0; i<n; i++) {
			while (!currHeights.isEmpty() && heights[currHeights.peek()]<heights[i]) {
				currHeights.pop();
			}
			if (currHeights.isEmpty()) leftBound[i] = -1;
			else leftBound[i] = currHeights.peek();
			currHeights.add(i);
		}
		long ans = 0;
		for (int i=0; i<n; i++) {
			if (rightBound[i]<n) ans+=(rightBound[i]-i+1);
			if (leftBound[i]>=0) ans+=(i-leftBound[i]+1);
			
		}
		System.out.println(ans);
	}
	static class Position {
		int index, leftBound;
		public Position(int index, int leftBound) {
			this.index = index;
			this.leftBound = leftBound;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
