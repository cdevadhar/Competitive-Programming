import java.io.*;
import java.util.*;
public class ExactChange {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			int max = 0;
			for (int i=0; i<n; i++) {
				nums[i] = in.nextInt();
				max = Math.max(max, nums[i]);
			}
			int ans = Integer.MAX_VALUE;
			for (int ones=0; ones<=3; ones++) {
				for (int twos=0; twos<=3; twos++) {
					int threes = (max-(ones+twos*2)+2)/3;
					if (threes<0) continue;
					boolean doesWork = true;
					for (int i=0; i<n; i++) {
//						System.out.println(ones+" " + twos+ " " + threes);
//						System.out.println(possible(nums[i], ones, twos, threes));
						if (!possible(nums[i], ones, twos, threes)) doesWork = false;
					}
					if (doesWork) {
						ans = Math.min(ans, ones+twos+threes);
//						
					}
				}
			}
			System.out.println(ans);
		}
	}
	public static boolean possible(int value, int ones, int twos, int threes) {
		if (threes*3 + twos*2 + ones*1<value) return false;
		for (int i=0; i<=ones; i++) {
			for (int j=0; j<=twos; j++) {
				int remaining = value-i-2*j;
				if (remaining<0) continue;
				if (remaining%3==0) {
					if (remaining/3<=threes) return true;
				}
			}
		}
		return false;
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
