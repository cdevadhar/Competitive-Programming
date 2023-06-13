import java.io.*;
import java.util.*;

public class Garland2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] a = new int[n];
		int intervalSize = 0;
		int left = -1;
		ArrayList<Interval> sameInt = new ArrayList<Interval>();
		ArrayList<Interval> diffInt = new ArrayList<Interval>();
		ArrayList<Interval> oneSide = new ArrayList<Interval>();
		int odd = 0;
		int even = 0;
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
			if (a[i]==0) {
				intervalSize++;
			}
			else {
				int parity = a[i]%2;
				if (parity==0) even++;
				else odd++;
				if (left==-1) {
					Interval x = new Interval(left, parity, intervalSize);
					if (intervalSize>0) oneSide.add(x);
					
				}
				else {
					Interval x = new Interval(left, parity, intervalSize);
					if (parity==left) sameInt.add(x);
					else diffInt.add(x);
				}
				left = parity;
				intervalSize = 0;
			}
		}
		if (intervalSize>0) {
			oneSide.add(new Interval(left, -1, intervalSize));
		}
		if (n%2==0) {
			odd = n/2 - odd;
			even = n/2 - even;
		}
		else {
			odd = n/2 + 1 - odd;
			even = n/2 - even;
		}
		int complexity = 0;
		Collections.sort(sameInt, (o1, o2) -> Integer.compare(o1.spaces, o2.spaces));
		for (Interval i: sameInt) {
			int parity = i.left;
			if (parity==0) {
				if (i.spaces<=even) {
					even-=i.spaces;
				}
				else {
					odd-=(i.spaces-even);
					even = 0;
					
					complexity+=2;
				}
			}
			else {
				if (i.spaces<=odd) {
					odd-=i.spaces;
				}
				else {
					even-=(i.spaces-odd);
					odd = 0;
					
					complexity+=2;
				}
			}
		}
		Collections.sort(oneSide, (o1, o2) -> Integer.compare(o1.spaces, o2.spaces));
		for (Interval i: oneSide) {
			int parity = 0;
			if (i.left>=0) parity = i.left;
			else parity = i.right;
			if (parity==0) {
				if (i.spaces<=even) {
					even-=i.spaces;
				}
				else {
					odd-=(i.spaces-even);
					even = 0;
					
					complexity+=1;
					System.out.println("added1");
				}
			}
			else {
				if (i.spaces<=odd) {
					odd-=i.spaces;
				}
				else {
					System.out.println(odd);
					even-=(i.spaces-odd);
					odd = 0;
					
					complexity+=1;
					System.out.println("added2");
				}
			}
		}
		complexity+=diffInt.size();
		System.out.println(complexity);
	}
	static class Interval {
		int left, right;
		int spaces;
		public Interval(int left, int right, int spaces) {
			this.left = left;
			this.right = right;
			this.spaces = spaces;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
	        pr = new PrintWriter(System.out);
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
