import java.io.*;
import java.util.*;

public class TrafficLights {
	static int x, n;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		x = in.nextInt();
		n = in.nextInt();
		TreeSet<Integer> street = new TreeSet<Integer>();
		street.add(0);
		street.add(x);
		Distance best = new Distance(0, x);
		for (int i=0; i<n; i++) {
			int curr = in.nextInt();
			street.add(curr);
			if (best.equals(new Distance(street.lower(curr), street.higher(curr)))) {
				if (street.higher(curr)-curr>curr-street.lower(curr)) {
					best = new Distance(curr, street.higher(curr));
				}
				else {
					best = new Distance(street.lower(curr), curr);
				}
			}
			System.out.print(best.y-best.x + " ");
		}
	}
	
	static class Distance {
		int x, y;
		public Distance(int x,int y) {
			this.x=x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return 10*x+y;
		}
		@Override
		public boolean equals(Object other) {
			Distance o = (Distance) other;
			return x==o.x && y==o.y;
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
