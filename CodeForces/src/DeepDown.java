import java.io.*;
import java.util.*;
public class DeepDown {
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			Cave[] caves = new Cave[n];
			for (int j=0; j<n; j++) {
				int k = in.nextInt();

				int first = in.nextInt();
				int max = first;
				for (int m=1; m<k; m++) {
					int monster = in.nextInt();
					if (monster-m>max) max = monster-m;
				}
				caves[j] = new Cave(max, k);
			}
			Arrays.parallelSort(caves);
			int high = 1000000000;
			int low = 0;
			while (high>low) {
				int mid = (high+low)/2;
				if (doesWork(mid, caves)) {
					high = mid;
				}
				else {
					low = mid+1;
				}
			}
			System.out.println(low);
		}
	}
	public static boolean doesWork(int power, Cave[] caves) {
		int temp = power;
		for (int i=0; i<caves.length; i++) {
			if (temp<=caves[i].max) return false;
			temp+=caves[i].size;
		}
		return true;
	}
	
	static class Cave implements Comparable<Cave>{
		int max, size;
		public Cave(int max, int size) {
			this.max = max;
			this.size = size;
		}
		@Override
		public int compareTo(Cave o) {
			// TODO Auto-generated method stub
			return Integer.compare(max, o.max);
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
