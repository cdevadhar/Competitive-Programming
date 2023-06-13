import java.io.*;
import java.util.*;
public class Berserk {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		long x = in.nextLong();
		long k = in.nextLong();
		long y = in.nextLong();
		long[] a = new long[n];
		long[] b = new long[m];
		int filled = 0;
		for (int i=0; i<n; i++) {
			a[i] = in.nextLong();
		}
		int prev=-1;
		int[] aIndexes = new int[m];
		for (int i=0; i<m; i++) {
			b[i] = in.nextLong();
		}
		int currB = 0;
		int currA = 0;
		while (currB<m && currA<n) {
			if (a[currA]==b[currB]) {
				filled++;
				aIndexes[currB] = currA;
				currB++;
				currA++;
			}
			else currA++;
		}
		if (filled<m) System.out.println(-1);
		else {
			boolean works = true;
			long ans = 0;
			int index1 = aIndexes[0];
			long max = 0;
			for (int i=0; i<index1; i++) {
				max = Math.max(max, a[i]);
			}
			if (index1<k) {
				if (max<b[0]) {
					ans+=index1*y;
				}
				else works=false;
			}
			else {
				long minBerserk = index1%k;
				long fireballCost = (index1/k)*x;
				long berserkCost = y*index1;
				if (y*k>=x) {
					ans+=(minBerserk*y)+fireballCost;
				}
				else {
					if (max<b[0]) {
						ans+=index1*y;
					}
					else {
						ans+=(index1-k)*y + fireballCost;
					}
				}
			}
			int previous = index1;
//			System.out.println(ans);
			for (int i=1; i<m; i++) {
//				System.out.println(ans);
				int currIndex = aIndexes[i];
				long maxEdge = Math.max(a[previous], a[currIndex]);
//				System.out.println("Distance:  " + (currIndex-previous-1));
				max = 0;
				for (int j=previous+1; j<currIndex; j++) {
					max = Math.max(max, a[j]);
				}
				if ((currIndex-previous-1)<k) {
					if (max<maxEdge) {
						ans+=(currIndex-previous-1)*y;
//						System.out.println("A");
					}
					else {
						works=false;
//						System.out.println("Failed " + max);
					}
				}
				else {
					long minBerserk = (currIndex-previous-1)%k;
					long fireballCost = ((currIndex-previous-1)/k)*x;
					long berserkCost = y*(currIndex-previous-1);
					if (y*k>=x) {
						ans+=(minBerserk*y)+fireballCost;
//						System.out.println("B");
					}
					else {
						if (max<maxEdge) {
							ans+=berserkCost;
//							System.out.println("C");
						}
						else {
							ans+=((currIndex-previous-1)-k)*y + fireballCost;
//							System.out.println("D");
						}
					}
				}
				previous = currIndex;
				
			}
			max = 0;
			for (int i=previous+1; i<n; i++) {
				max = Math.max(max, a[i]);
			}
			if ((n-previous-1)<k) {
				if (max<b[m-1]) {
					ans+=(n-previous-1)*y;
				}
				else works=false;
			}
			else {
				long minBerserk = (n-previous-1)%k;
				long fireballCost = ((n-previous-1)/k)*x;
				long berserkCost = y*(n-previous-1);
				if (y*k>=x) {
					ans+=(minBerserk*y)+fireballCost;
				}
				else {
					if (max<b[m-1]) {
						ans+=berserkCost;
					}
					else {
						ans+=((n-previous-1)-k)*y + fireballCost;
					}
				}
			}
			if (!works) System.out.println(-1);
			else System.out.println(ans);
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
