import java.io.*;
import java.util.*;
public class MooParticle {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("moop.in", "moop.out");
		int n = in.nextInt();
		Particle[] particles = new Particle[n];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			particles[i] = new Particle(x, y);
		}
		Arrays.parallelSort(particles, (o1, o2)-> {
			if (o1.x==o2.x) return Integer.compare(o1.y, o2.y);
			return Integer.compare(o1.x, o2.x);
		});
		int ans = 1;
		int minY = particles[0].y;
		int[] maxY = new int[n];
		maxY[n-1] = particles[n-1].y;
		for (int i=n-2; i>=0; i--) {
			maxY[i] = Math.max(particles[i].y, maxY[i+1]);
		}
		for (int i=0; i<n-1; i++) {
//			System.out.println(particles[i].x+" "+particles[i].y);
			minY = Math.min(minY, particles[i].y);
//			System.out.println(minY+" "+maxY[i+1]);
			if (minY>maxY[i+1]) ans++;
			
		}
		in.pr.println(ans);
		in.pr.close();
	}
	static class Particle {
		int x, y;
		public Particle(int x, int y) {
			this.x = x;
			this.y = y;
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
