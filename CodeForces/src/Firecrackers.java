import java.io.*;
import java.util.*;

public class Firecrackers {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int[] firecrackers = new int[m];
			for (int j=0; j<m; j++) firecrackers[j] = in.nextInt();
			Arrays.sort(firecrackers);
			int high = m;
			int low =0;
			while (high>low) {
				int mid = (high+low+1)/2;
				if (canExplode(n, m, a, b, firecrackers, mid)) {
					low = mid;
				}
				else {
					high = mid-1;
				}
			}
			System.out.println(high);
		}
	}
	
	public static boolean canExplode(int n, int m, int a, int b, int[] firecrackers, int num) {
		if (num>=Math.abs((b-a))) return false;
		int timeLeft = b-1;
		int index = num-1;
		int distance = Math.abs(b-a);
		int explosions = 0;
		while (index>=0) {
			if (firecrackers[index]<=timeLeft && distance>1) {
				index--;
				timeLeft--;
				explosions++;
				distance--;
			}
			else {
				return false;
			}
		}
		return true;
		
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
