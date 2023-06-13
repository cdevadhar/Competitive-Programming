import java.io.*;
import java.util.*;
public class Chats {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int d = in.nextInt();
		int m = in.nextInt();
		long[] a = new long[n];
		// Messages that do and do not cause bans
		
		ArrayList<Long> big = new ArrayList<Long>();
		ArrayList<Long> small = new ArrayList<Long>();
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
			if (a[i]>m) big.add(a[i]);
			else small.add(a[i]);
		}
		// Sort them from biggest to smallest
		Collections.sort(big, (o1, o2) -> Long.compare(o2, o1));
		Collections.sort(small, (o1, o2) -> Long.compare(o2, o1));
		Long[] bigArray = new Long[big.size()];
		for (int i=0; i<big.size(); i++) bigArray[i] = big.get(i);
		Long[] smallArray = new Long[small.size()];
		for (int i=0; i<small.size(); i++) smallArray[i] = small.get(i);
		long[] bigPrefix = new long[bigArray.length+1];
		long[] smallPrefix = new long[smallArray.length+1];
		// Fill prefix sum arrays
		for (int i=0; i<bigArray.length; i++) {
			bigPrefix[i+1] = bigPrefix[i]+bigArray[i];
		}
		for (int i=0; i<smallArray.length; i++) {
			smallPrefix[i+1] = smallArray[i]+smallPrefix[i];
		}
		long ans=0;
		// Checking the answer if we have i number of bans
		int daysUsed = 0;
		boolean change = false;
		for (int i=0; i<bigArray.length+1; i++) {
			
//			System.out.println(i+" "+daysUsed);
			if (daysUsed>n) break;
			if (bigArray.length-i>daysUsed-i) {
				if (daysUsed+d<=n && daysUsed+d>=bigArray.length) {
					daysUsed+=d;
					change = true;
				}
				else {
					if (i==0) daysUsed++;
					else daysUsed+=d+1;
					continue;
				}
				
			}
			int smallNeeded = (daysUsed)-(bigArray.length);
//			System.out.println("Small needed: " + smallNeeded);
			int smallLeft = smallArray.length-smallNeeded;
			long bigAns = bigPrefix[i];
			long smallAns = smallPrefix[smallLeft];
//			System.out.println(bigAns+" "+smallAns);
			ans = Math.max(ans, bigAns+smallAns);
			if (i==0) daysUsed++;
			else daysUsed+=d+1;
			if (change) {
				daysUsed-=d;
				change = false;
			}
			
		}
		System.out.println(ans);
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
