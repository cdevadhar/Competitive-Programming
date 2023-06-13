import java.io.*;
import java.util.*;

public class Teleportation {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("teleport.in", "teleport.out");
		int n = in.nextInt();
		ArrayList<Breakpoint> breakpoints = new ArrayList<Breakpoint>();
		ArrayList<Pile> piles = new ArrayList<Pile>();
		for (int i=0; i<n; i++) {
			long a = in.nextInt();
			long b = in.nextInt();
			piles.add(new Pile(a, b));
			if (a<0 && a<b) {
				if (b-a<=Math.abs(a)) {
					// No breakpoints, always constant
				}
				else {
					// 3 breakpoints
					long min = b;
					long left = min-((b-a)-Math.abs(a));
					long right = min+((b-a)-Math.abs(a));
					breakpoints.add(new Breakpoint(min, 2));
					breakpoints.add(new Breakpoint(left, -1));
					breakpoints.add(new Breakpoint(right, -1));
				}
			}
			else if (a<0 && a>b) {
				if (a-b<=Math.abs(a)) {
					// No breakpoints
				}
				else {
					long min = b;
					long left = min-((a-b)-Math.abs(a));
					long right = min+((a-b)-Math.abs(a));
					breakpoints.add(new Breakpoint(min, 2));
					breakpoints.add(new Breakpoint(left, -1));
					breakpoints.add(new Breakpoint(right, -1));
				}
			}
			else if (a>=0 && a>b) {
				if (a-b<=Math.abs(a)) {
					// No breakpoints
				}
				else {
					long min = b;
					long left = min-((a-b)-Math.abs(a));
					long right = min+((a-b)-Math.abs(a));
					breakpoints.add(new Breakpoint(min, 2));
					breakpoints.add(new Breakpoint(left, -1));
					breakpoints.add(new Breakpoint(right, -1));
				}
			}
			else {
				if (b-a<=Math.abs(a)) {
					// No breakpoints, always constant
				}
				else {
					// 3 breakpoints
					long min = b;
					long left = min-((b-a)-Math.abs(a));
					long right = min+((b-a)-Math.abs(a));
					breakpoints.add(new Breakpoint(min, 2));
					breakpoints.add(new Breakpoint(left, -1));
					breakpoints.add(new Breakpoint(right, -1));
				}
			}
		}
		Collections.sort(breakpoints, (o1, o2) -> Long.compare(o1.x, o2.x));
		if (breakpoints.size()==0) {
			int distance = 0;
			for (Pile p: piles) distance+=Math.abs(p.b-p.a);
			in.pr.println(distance);
			in.pr.close();
			return;
		}
		long minX = 0;
		long minVal = 0;
		long slope = 0;
		long currX = breakpoints.get(0).x;
		long currVal = 0;
		for (int i=0; i<breakpoints.size(); i++) {
		
			currVal+=slope*(breakpoints.get(i).x-currX);
//			in.pr.println(breakpoints.get(i).x+" "+slope+" "+currVal);
			slope+=breakpoints.get(i).slopeChange;
			
			currX = breakpoints.get(i).x;
			if (currVal<minVal) {
				minVal = currVal;
				minX = currX;
			}
			
		}
		long distance = 0;
		for (Pile p: piles) {
			long o1 = Math.abs(p.a-p.b);
			long o2 = Math.abs(p.a)+Math.abs(p.b-minX);
			distance+=Math.min(o1, o2);
		}
		in.pr.println(distance);
		in.pr.close();
	}
	static class Pile {
		long a, b;
		public Pile(long a, long b) {
			this.a = a;
			this.b = b;
		}
	}
	static class Breakpoint {
		long x, slopeChange;
		public Breakpoint(long x, long slopeChange) {
			this.x = x;
			this.slopeChange = slopeChange;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
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
