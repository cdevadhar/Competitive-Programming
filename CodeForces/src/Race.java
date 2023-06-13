import java.io.*;
import java.util.*;
public class Race {
	static int r, n, b;
	static Orb[] orbs;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		r = in.nextInt();
		n = in.nextInt();
		b = in.nextInt();
		orbs = new Orb[n];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			orbs[i] = new Orb(x, y);
		}
		Arrays.parallelSort(orbs, (o1, o2) -> Integer.compare(o1.position, o2.position));
		PriorityQueue<Orb> available = new PriorityQueue<Orb>((o1, o2) -> Integer.compare(o2.size, o1.size));
		int rightBound = b;
		int orbsUsed = 0;
		int index = 0;
		while (rightBound<r) {
			while (index<n && orbs[index].position<=rightBound) {
				available.add(orbs[index]);
				index++;
			}
			if (available.isEmpty()) {
				System.out.println(-1);
				return;
			}
//			System.out.println(available.peek().position+" "+available.peek().size);
			rightBound+=available.poll().size;
			orbsUsed++;
		}
		System.out.println(orbsUsed);
	}
	static class Orb {
		int position, size;
		public Orb(int position, int size) {
			this.position = position;
			this.size = size;
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
