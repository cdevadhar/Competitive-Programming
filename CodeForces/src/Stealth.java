import java.io.*;
import java.util.*;
public class Stealth {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		long k = in.nextLong();
		Long[] nums = new Long[n];
		for (int i=0; i<n; i++) {
			nums[i] = in.nextLong();
		}
		Arrays.parallelSort(nums);
		if (k==1) {
			System.out.println(2*nums[n-1]);
		}
		
		else {
			int len = 1;
			while ((len+1)*(len+1)<=k) len++;
			int index = n-len;
			long sum = 0;
			for (int i=index; i<n; i++) {
				sum+=nums[i];
			}
			if (len==n) {
				System.out.println(sum*2*n);
			}
			else {
				long ans = sum*2*len;
				long leftover = k-len*len;
				int start = index-1;
				ArrayList<Long> choices = new ArrayList<Long>();
				choices.add(2*nums[start]);
				for (int i=index; i<n; i++) {
					choices.add(nums[i]+nums[start]);
					choices.add(nums[i]+nums[start]);
				}
				Collections.sort(choices, (o1, o2) -> Long.compare(o2, o1));
				for (int i=0; i<leftover; i++) {
					ans+=choices.get(i);
				}
				System.out.println(ans);
			}
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
