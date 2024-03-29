import java.io.*;
import java.util.*;

public class Swaps {
	
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			Position[] odds = new Position[n];
			Position[] evens = new Position[n];
			for (int j=0; j<n; j++) {
				int odd = in.nextInt();
				Position p = new Position(odd, j);
				odds[j] = p;
			}
			for (int j=0; j<n; j++) {
				int even = in.nextInt();
				Position p = new Position(even, j);
				evens[j] = p;
			}
			Arrays.sort(evens);
			Arrays.sort(odds);
			Position bestEven = evens[0];
			int leastSwaps = n;
			int index = 0;
			while (index<n) {
				if (evens[index].index<bestEven.index) bestEven = evens[index];
				if (odds[index].index+bestEven.index<leastSwaps) leastSwaps = odds[index].index+bestEven.index;
				index++;
				
			}
			System.out.println(leastSwaps);
		}
	}
	
	static class Position implements Comparable<Position>{
		int value, index;
		public Position(int value, int index) {
			this.value = value;
			this.index = index;
		}
		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.value, value);
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
