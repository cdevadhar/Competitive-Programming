import java.io.*;
import java.util.*;
public class Education {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int c = in.nextInt();
			long[] a = new long[n];
			long[] b = new long[n-1];
			long[] bPrefix = new long[n];
			long[] reachTime = new long[n];
			long[] spare = new long[n];
			for (int i=0; i<n; i++) {
				a[i] = in.nextInt();
				
			}
			for (int i=0; i<n-1; i++) {
				b[i] = in.nextInt();
				bPrefix[i+1] = bPrefix[i]+b[i];
			}
			int index=1;
			int bestIndex=0;
			long bestJob = a[0];
			while (index<n) {
				long workingTime = (long) Math.ceil((double)(bPrefix[index]-bPrefix[bestIndex]-spare[bestIndex])/bestJob);
				long currSpare = workingTime*bestJob-(bPrefix[index]-bPrefix[bestIndex]);
				long workWithoutSpare = (long) Math.ceil((double)(bPrefix[index]-bPrefix[bestIndex])/bestJob);
				if (workingTime == workWithoutSpare) currSpare+=spare[bestIndex];
				spare[index] = currSpare;
				reachTime[index] = reachTime[bestIndex]+workingTime+(index-bestIndex);
				if (a[index]>=bestJob) {
					bestJob = a[index];
					bestIndex = index;
				}
//				System.out.println(reachTime[index]+" "+spare[index]);
				index++;
			}
			long ans = Integer.MAX_VALUE;
			for (int i=0; i<n; i++) {
				int computerWork = (int) Math.ceil((double)(c-spare[i])/a[i]);
				ans = Math.min(ans, reachTime[i]+computerWork);
			}
			System.out.println(ans);
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
