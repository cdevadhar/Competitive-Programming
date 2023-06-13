import java.io.*;
import java.util.*;

public class Flowers {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			Flower[] types = new Flower[m];
			long[] aPrefix = new long[m+1];
			for (int i=0; i<m; i++) {
				long a = in.nextLong();
				long b = in.nextLong();
				types[i] = new Flower(a, b);
			}
			Arrays.sort(types, (o1, o2) -> Long.compare(o2.a, o1.a));
			for (int i=0; i<m; i++) {
				aPrefix[i+1] = aPrefix[i]+types[i].a;
			}
			long ans = 0;
			for (int i=0; i<m; i++) {
				//numA is the number of flowers whose a values are greater than this one's b value
				int numA = binarySearch(types, types[i].b);
//				System.out.println(numA);
				if (numA>=n) {
//					System.out.println("Chose all as");
					ans = Math.max(ans, aPrefix[n]);
					continue;
				}
				long total = aPrefix[numA];
				if (i>=numA) {
					total+=types[i].a;
					total+=(types[i].b)*(n-numA-1);
				}
				else {
					total+=(types[i].b)*(n-numA);
				}
//				System.out.println(i + " " + total);
				ans = Math.max(ans, total);
			}
			System.out.println(ans);
		}
	}
	// Returns the first index at which flowers[index]<=target
	public static int binarySearch(Flower[] flowers, long target) {
		int hi = flowers.length-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo)/2;
			if (flowers[mid].a<=target) {
				hi=mid;
			}
			else lo = mid+1;
		}
		if (flowers[hi].a>target) return hi+1;
		return hi;
	}
	static class Flower {
		long a, b;
		public Flower(long a, long b) {
			this.a = a;
			this.b = b;
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
