import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Singers {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long[] arr = new long[n];
			long sum = 0;
			for (int i=0; i<n; i++) {
				arr[i] = in.nextLong();
				sum+=arr[i];
			}
			long ansSum = sum/(n*(n+1)/2);
			long[] ans = new long[n];
			ans[0] = (ansSum-(arr[0]-arr[n-1]))/n;
			if (ans[0]<=0) {
				System.out.println("NO");
				continue;
			}
			boolean works = true;
			for (int i=1; i<n; i++) {
				ans[i] = (ansSum-(arr[i]-arr[i-1]))/n;
				
			}
			
			long first = 0;
			first+=ans[0];
			long count = 2;
			for (int i=n-1; i>0; i--) {
				first+=ans[i]*count;
				count++;
			}
//			System.out.println("First: "+first);
			if (first!=arr[0]) {
				System.out.println("NO");
			}
			else {
				long previous = first;
				for (int i=1; i<n; i++) {
					if (ans[i]<=0) {
						works = false;
						break;
					}
					long diff = ansSum-n*ans[i];
					if (previous+diff!=arr[i]) {
						works = false;
						break;
					}
					previous = arr[i];
				}
				
				if (!works) System.out.println("NO");
				else {
					System.out.println("YES");
					for (int i=0; i<n; i++) {
						System.out.print(ans[i]+" ");
					}
					System.out.println();
				}
			}
			
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
