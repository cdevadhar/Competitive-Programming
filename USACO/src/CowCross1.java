import java.io.*;
import java.util.*;

public class CowCross1 {
	static int c, n;
	static Cow[] cows;
	static int[] chickens;
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO("helpcross.in", "helpcross.out");
		c = in.nextInt();
		n = in.nextInt();
		chickens = new int[c];
		cows = new Cow[n];
		for (int i=0; i<c; i++) {
			chickens[i] = in.nextInt();
		}
		for (int i=0; i<n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			cows[i] = new Cow(start, end);
		}
		Arrays.parallelSort(cows);
		Arrays.parallelSort(chickens);
		int currChicken = 0;
		int pairs = 0;
		for (int i=0; i<n; i++) {
			while (currChicken<cows[i].start) {
				
			}
		}
		in.pr.println(pairs);
		in.pr.close();
	}
	static class Cow implements Comparable<Cow>{
		int start, end;
		public Cow(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Cow o) {
			// TODO Auto-generated method stub
			return Integer.compare(end, o.end);
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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