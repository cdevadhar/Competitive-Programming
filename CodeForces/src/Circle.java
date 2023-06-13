import java.io.*;
import java.util.*;
public class Circle {
	static int q;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		q = in.nextInt();
		for (int i=0; i<q; i++) {
			int n = in.nextInt();
			int[] students = new int[n];
			boolean clockwise = true;
			boolean counterclockwise = true;
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j=0; j<n; j++) {
				int num = in.nextInt();
				students[j] = num;
				if (num<min) {
					min = num;
					minIndex = j;
				}
			}
			boolean done = false;
			int currIndex = minIndex;
			while (!done) {
				if (currIndex<n-1) {
					if (currIndex+1==minIndex) break;
					if (students[currIndex+1]!=students[currIndex]+1) clockwise = false;
					currIndex++;
				}
				else {
					if (minIndex==0) break;
					if (students[0]!=students[currIndex]+1) clockwise = false;
					currIndex = 0;
				}
				if (currIndex==minIndex) done = true;
			}
			done = false;
			while (!done) {
				if (currIndex>0) {
					if (currIndex-1==minIndex) break;
					if (students[currIndex-1]!=students[currIndex]+1) counterclockwise = false;
					currIndex--;
				}
				else {
					if (minIndex== n-1) break;
					if (students[n-1]!=students[currIndex]+1) counterclockwise = false;
					currIndex = n-1;
				}
				if (currIndex==minIndex) done = true;
			}
			if (clockwise || counterclockwise) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO()
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
