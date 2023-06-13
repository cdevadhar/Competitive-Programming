import java.io.*;
import java.util.*;
public class ComboHW {
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		int[] nums = new int[3];
		for (int i=0; i<t; i++) {
			nums[0] = in.nextInt();
			nums[1] = in.nextInt();
			nums[2] = in.nextInt();
			int m = in.nextInt();
			if (m>(nums[0]+nums[1]+nums[2]-3)) {
				System.out.println("NO");
				continue;
			}
			Arrays.parallelSort(nums);
			if (m<(nums[2]-1-(nums[0]+nums[1]))) {
				System.out.println("NO");
				continue;
			}
			System.out.println("YES");
			
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
