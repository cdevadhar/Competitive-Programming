import java.io.*;
import java.util.*;
public class ManhattanSubarrays {
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			for (int i=0; i<n; i++) {
				nums[i] = in.nextInt();
			}
			int ans = n+n-1;
			for (int i=0; i<n-2; i++) {
				boolean x = check(nums[i], i, nums[i+1], i+1, nums[i+2], i+2);
				if (!x) ans++;
			}
			for (int i=0; i<n-3; i++) {
				boolean one = check(nums[i], i, nums[i+1], i+1, nums[i+2], i+2);
				boolean two = check(nums[i], i, nums[i+1], i+1, nums[i+3], i+3);
				boolean three = check(nums[i], i, nums[i+2], i+2, nums[i+3], i+3);
				boolean four = check(nums[i+1], i+1, nums[i+2], i+2, nums[i+3], i+3);
				if (!one && !two && !three && !four) ans++;
			}
			System.out.println(ans);
		}
	}
	public static boolean check(int x1, int y1, int x2, int y2, int x3, int y3) {
		if (x2>=x1 && x2<=x3) return true;
		if (x2<=x1 && x2>=x3) return true;
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
