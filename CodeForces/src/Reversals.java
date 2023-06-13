import java.io.*;
import java.util.*;
public class Reversals {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] a = new int[n];
			boolean works = true;
			for (int i=0; i<n; i++) {
				a[i] = in.nextInt();
				if (a[i]%2==i%2) works = false;
				
			}
			if (!works) System.out.println(-1);
			
			else {
				ArrayList<Integer> ans = new ArrayList<Integer>();
				for (int i=0; i<n/2; i++) {
					int curr = n-2*i;
					int pos = indexOf(a, curr);
					reverse(a, pos);
					ans.add(pos);
					pos = indexOf(a, curr-1);
					reverse(a, pos-1);
					ans.add(pos-1);
					reverse(a, pos+1);
					ans.add(pos+1);
					reverse(a, 2);
					ans.add(2);
					reverse(a, curr-1);
					ans.add(curr-1);
				}
				System.out.println(ans.size());
				for (int i: ans) System.out.print(i+1+" ");
				System.out.println();
			}
		}
	}
	public static void reverse(int[] a, int m) {
		for (int i=0; i<m/2; i++) {
			int temp = a[i];
			a[i] = a[m-i];
			a[m-i] = temp;
		}
	}
	public static int indexOf(int[] a, int m) {
		for (int i=0; i<a.length; i++) {
			if (a[i]==m) return i;
		}
		return -1;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
