import java.io.*;
import java.util.*;
public class FixedPoints {
	public static void main(String[] args) throws Exception {
		// Another dp problem...
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			
			int[] nums = new int[n];
			for (int i=0; i<n; i++) {
				nums[i] = in.nextInt()-1;
			}
			int[] closestRight = new int[n];
			Arrays.fill(closestRight, Integer.MAX_VALUE);
			for (int i=0; i<n; i++) {
				if (nums[i]<=i) closestRight[nums[i]] = Math.min(closestRight[nums[i]], i);
			}
//			for (int i=0; i<n; i++) {
//				System.out.print(closestRight[i]+" ");
//			}
//			System.out.println();
			int ans = Integer.MAX_VALUE;
			for (int i=0; i<n; i++) {
				if (closestRight[i]==Integer.MAX_VALUE) continue;
				int currIndex = i;
				int deletions = 0;
				int numEqual = 0;
				while (currIndex<n) {
					
					if (closestRight[currIndex]==Integer.MAX_VALUE) {
						currIndex++;
						continue;
					}
//					System.out.println(numEqual+" "+deletions+" "+currIndex);
					deletions+=(closestRight[currIndex]-currIndex);
//					System.out.println(closestRight[currIndex]);
					currIndex = closestRight[currIndex]+1;
//					System.out.println("Updated index to " + currIndex);
					numEqual++;
					
					if (numEqual==k) break;
				}
				System.out.println(numEqual);
				if (numEqual==k) {
					ans = Math.min(ans, deletions);
				}
				
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
