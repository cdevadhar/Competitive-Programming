import java.io.*;
import java.util.*;
public class Task {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] arr = new int[n];
		HashSet<Integer> values = new HashSet<Integer>();
		
		for (int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			values.add(arr[i]);
		}
		int ans=0;
		for (int value: values) {
			int[] temp = new int[n];
			for (int i=0; i<n; i++) {
				if (arr[i]>value) temp[i] = -1000;
				else temp[i] = arr[i];
				
			}
			int[] prefix = new int[n+1];
			for (int i=0; i<n; i++) {
				prefix[i+1] = prefix[i]+temp[i];
			}
			int min=0;
			int currAns=Integer.MIN_VALUE;
			for (int i=0; i<n; i++) {
//				System.out.println("Check: "+min+" "+currAns);
				
				currAns = Math.max(currAns, prefix[i+1]-min);
				min = Math.min(prefix[i+1], min);
			}
//			System.out.println(currAns+" "+value);
			ans = Math.max(currAns-value, ans);
		}
		System.out.println(ans);
		
		
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
