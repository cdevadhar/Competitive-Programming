import java.io.*;
import java.util.*;

public class Rut2 {
	static int n;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		ArrayList<Cow> eastCows = new ArrayList<Cow>();
		ArrayList<Cow> northCows = new ArrayList<Cow>();
		n = in.nextInt();
		for (int i=0; i<n; i++) {
			char dir = in.next().charAt(0);
			int x = in.nextInt();
			int y = in.nextInt();
			Cow cow = new Cow(x, y, dir, i);
			if (cow.direction=='E') eastCows.add(cow);
			else northCows.add(cow);
		}
		Collections.sort(eastCows);
		Collections.sort(northCows);
		boolean[] isStopped = new boolean[n];
		int[] numStopped = new int[n];
		for (Cow eastCow: eastCows) {
			for (Cow northCow: northCows) {
				if (!isStopped[eastCow.id] && !isStopped[northCow.id] && eastCow.x<northCow.x && northCow.y<eastCow.y ) {
					if ((northCow.x-eastCow.x)>(eastCow.y-northCow.y)) {
						isStopped[eastCow.id]=true;
						numStopped[northCow.id]+=numStopped[eastCow.id]+1;
					}
					if ((northCow.x-eastCow.x)<(eastCow.y-northCow.y)) {
						isStopped[northCow.id]=true;
						numStopped[eastCow.id]+=numStopped[northCow.id]+1;
					}
				}
			}
		}
		for (int i=0; i<n; i++) {
			System.out.println(numStopped[i]);
		}
	}
	
	static class Cow implements Comparable<Cow>{
		int x, y, id;
		char direction;
		public Cow(int x, int y, char direction, int id) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.id = id;
		}
		@Override
		public int compareTo(Cow o) {
			// TODO Auto-generated method stub
			if (direction=='E') {
				return Integer.compare(y, o.y);
			}
			else {
				return Integer.compare(x, o.x);
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
