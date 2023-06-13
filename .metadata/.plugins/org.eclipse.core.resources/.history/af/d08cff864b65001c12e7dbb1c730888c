import java.io.*;
import java.util.*;
public class Mex {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int testcase = 0; testcase<t; testcase++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			int[] occurences = new int[n+1];
			
			int[] gapFilling = new int[n+1];
			int[] fillingPrefix = new int[n+1];
			for (int i=0; i<n; i++) {
				int x = in.nextInt();
				nums[i] = x;
				occurences[x]++;
			}
			
			Stack<Integer> currExtras = new Stack<Integer>();
			for (int i=0; i<n+1; i++) {
				if (occurences[i]>1) {
					for (int j=0; j<occurences[i]-1; j++) {
						currExtras.add(i);
					}
					continue;
				}
				if (occurences[i]==0) {
					if (currExtras.isEmpty()) gapFilling[i] = -1;
					else {
						gapFilling[i] = i-currExtras.pop();
					}
				}
			}
			fillingPrefix[0] = gapFilling[0];
			for (int i=1; i<n+1; i++) {
				fillingPrefix[i] = fillingPrefix[i-1];
				if (fillingPrefix[i]==-1) continue;
				if (gapFilling[i]==-1) {
					fillingPrefix[i] = -1;
					continue;
				}
				fillingPrefix[i]+=gapFilling[i];
				
			}
			int first = findMex(nums);
			boolean isOver = false;
			for (int i=0; i<n+1; i++) {
				if (i<first) {
					System.out.print(occurences[i]+" ");
					continue;
				}
				if (i==first) {
					System.out.print(0 + " ");
					continue;
				}
				System.out.print(fillingPrefix[i-1]+ " ");
				
			}
			System.out.println();
		}
	}
	public static int findMex(int[] nums) {
		HashSet<Integer> positive = new HashSet<Integer>();
		for (int i=0; i<nums.length; i++) {
			if (nums[i]>=0) positive.add(nums[i]);
		}
		for (int i=0; i<positive.size()+1; i++) {
			if (!positive.contains(i)) return i;
		}
		return positive.size()+1;
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
