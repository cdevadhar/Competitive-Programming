import java.io.*;
import java.util.*;
public class FloppyDrive {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			long[] a = new long[n];
			long[] prefix = new long[n+1];
			long maxPrefix = Integer.MIN_VALUE;
			Index[] sortedPrefixes = new Index[n];
			for (int i=0; i<n; i++) {
				a[i] = in.nextLong();
				prefix[i+1] = prefix[i]+a[i];
				maxPrefix = Math.max(maxPrefix, prefix[i+1]);
				sortedPrefixes[i] = new Index(i, prefix[i+1]);
			}
			Arrays.parallelSort(sortedPrefixes, (o1, o2) -> Long.compare(o1.prefix, o2.prefix));
			int[] suffixMin = new int[n];
			int minIndex = Integer.MAX_VALUE;
			for (int i=n-1; i>=0; i--) {
				minIndex = Math.min(minIndex, sortedPrefixes[i].index);
				suffixMin[i] = minIndex;
			}
	
			for (int i=0; i<m; i++) {
				int x = in.nextInt();
				if (x<=maxPrefix) {
					int hi=n-1;
					int lo = 0;
					while (hi>lo) {
						int mid = (hi+lo)/2;
						if (sortedPrefixes[mid].prefix>=x) hi=mid;
						else lo = mid+1;
					}
					int ans = suffixMin[hi];
					System.out.print(ans+" ");
					continue;
				}
				if (prefix[n]<=0) {
					System.out.print(-1+" ");
					continue;
				}
				long target = x-maxPrefix;
				long cycles = (int)Math.ceil((double)target/(prefix[n]));
				long minNeeded = x-(cycles*prefix[n]);
				int hi=n-1;
				int lo = 0;
				while (hi>lo) {
					int mid = (hi+lo)/2;
					if (sortedPrefixes[mid].prefix>=minNeeded) hi=mid;
					else lo = mid+1;
				}
				long ans = suffixMin[hi]+cycles*n;
				System.out.print(ans+" ");
			}
			System.out.println();
		}
	}
	static class Index {
		int index;
		long prefix;
		public Index(int index, long prefix) {
			this.index = index;
			this.prefix = prefix;
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
