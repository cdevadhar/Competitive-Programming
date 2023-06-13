import java.io.*;
import java.util.*;
public class Mex2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = in.nextInt();
			}
			int count = 0;
			Queue<Integer> ans = new LinkedList<Integer>();
			while (!nonDecreasing(arr)) {
				int mex = mex(arr, n);
				if (mex==n) {
					for (int i=0; i<n; i++) {
						if (arr[i]!=i) {
							count++;
							ans.add(i);
							mex = arr[i];
							arr[i] = n;
							break;
						}
					}
				}
				arr[mex] = mex;
				ans.add(mex);
				count++;
			}
			System.out.println(count);
			while (!ans.isEmpty()) System.out.print(ans.poll()+1+" ");
			System.out.println();
		}
	}
	public static boolean nonDecreasing(int[] arr) {
		for (int i=1; i<arr.length; i++) if (arr[i]<arr[i-1]) return false;
		return true;
	}
	public static int mex(int[] arr, int n) {
		boolean[] contains = new boolean[n+1];
		for (int i=0; i<n; i++) contains[arr[i]] = true;
		for (int i=0; i<n+1; i++) if (!contains[i]) return i;
		return -1;
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
