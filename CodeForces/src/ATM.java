import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int[] prefix = new int[n+2];
			int[] nums = new int[n];
			prefix[1] = s;
			for (int j=0; j<n; j++) {
				int x = in.nextInt();
				
				nums[j] = x;
			}
			long currSum = s;
			int startPointer=0, endPointer=0;
			int bestStart=-1, bestEnd=-1;
			boolean add = true;
			while (endPointer<n && startPointer<n) {
				if (add) currSum+=nums[endPointer];
//				System.out.println(startPointer+" "+endPointer+" "+currSum);
				if (currSum<0) {
					currSum-=nums[startPointer];
//					System.out.println(currSum);
					startPointer++;
					add = false;
					if (startPointer>endPointer) {
						endPointer++;
						add = true;
					}
					continue;
					// The bug is that you are adding nums[endPointer] even when you are only changing startPointer
				}
				if (endPointer-startPointer>=bestEnd-bestStart) {
					bestEnd = endPointer;
					bestStart = startPointer;
				}
				add = true;
				endPointer++;
			}
			if (bestStart==-1) {
				System.out.println(-1);
			}
			else System.out.println((bestStart+1)+" "+(bestEnd+1));
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
