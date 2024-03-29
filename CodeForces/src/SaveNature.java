import java.io.*;
import java.util.*;
public class SaveNature {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long[] tickets = new long[n];
			for (int i=0; i<n; i++) {
				tickets[i] = in.nextLong();
			}
			long x = in.nextLong();
			long a = in.nextLong();
			long y = in.nextLong();
			long b = in.nextLong();
			long k = in.nextLong();
			int[] both = new int[n+1];
			int[] onlyA = new int[n+1];
			int[] onlyB = new int[n+1];
			Arrays.sort(tickets);
			for (int i=0; i<n/2; i++) {
				long temp = tickets[i];
				tickets[i] = tickets[n-i-1];
				tickets[n-i-1] = temp;
			}
			long[] ticketPrefix = new long[n+1];
			for (int i=1; i<=n; i++) {
				ticketPrefix[i] = ticketPrefix[i-1]+tickets[i-1];
				both[i] = both[i-1];
				onlyA[i] = onlyA[i-1];
				onlyB[i] = onlyB[i-1];
				if (i%a==0 && i%b==0) {
					both[i]++;
				}
				else if (i%a==0) {
					onlyA[i]++;
				}
				else if (i%b==0) {
					onlyB[i]++;
				}
			}
			if (!doesWork(n, ticketPrefix, both, onlyA, onlyB, x, y, k)) {
				System.out.println(-1);
			}
			else {
				int lo = 1;
				int hi = n;
				while (hi>lo) {
					int mid = (hi+lo)/2;
					if (doesWork(mid, ticketPrefix, both, onlyA, onlyB, x, y, k)) {
						hi=mid;
					}
					else lo = mid+1;
				}
				System.out.println(hi);
			}
			
//			System.out.println(doesWork(1, ticketPrefix, both, onlyA, onlyB, x, y, k));
		}
	}
	public static boolean doesWork(int w, long[] ticketPrefix, int[] both, int[] onlyA, int[] onlyB, long x, long y, long k) {
		int numBoth = both[w];
		long bothValue = (x+y)*ticketPrefix[numBoth]/100;
//		System.out.println(bothValue);
		if (x>y) {
			int numA = onlyA[w];
			long aValue = (x)*(ticketPrefix[numBoth+numA]-ticketPrefix[numBoth])/100;
			int numB = onlyB[w];
			long bValue = y*(ticketPrefix[numBoth+numA+numB]-ticketPrefix[numBoth+numA])/100;
//			System.out.println(aValue);
//			System.out.println(bValue);
			if (bothValue+aValue+bValue>=k) return true;
			return false;
		}
		else {
			int numB = onlyB[w];
			long bValue = (y)*(ticketPrefix[numBoth+numB]-ticketPrefix[numBoth])/100;
			int numA = onlyA[w];
			long aValue = x*(ticketPrefix[numBoth+numA+numB]-ticketPrefix[numBoth+numB])/100;
//			System.out.println(aValue);
//			System.out.println(bValue);
			if (bothValue+aValue+bValue>=k) return true;
			return false;
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
