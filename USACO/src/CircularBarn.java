import java.io.*;
import java.util.*;

public class CircularBarn {
	static int n;
	static int[] positions;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "cbarn.out");
		n = in.nextInt();
		positions = new int[n];
		for (int i=0; i<n; i++ ) {
			positions[i] = in.nextInt();
		}
		int min=Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			min = Math.min(min, getEnergy(i));
		}
		System.out.println(min);
	}
	
	public static int getEnergy(int startPos) {
		if (positions[startPos]==0) return Integer.MAX_VALUE;
		int energy=0;
		Queue<Integer> queue = new LinkedList<Integer>();
		int cowsPlaced=0;
		boolean[] placed = new boolean[n];
//		for (int i=0; i<positions[startPos]; i++) {
//			queue.add(startPos);
//		}
		int index=startPos;
		while (cowsPlaced<n) {
			for (int i=0; i<positions[index]; i++) {
				queue.add(index);
			}
			if (queue.isEmpty() || placed[index]) {
				index = (index+1)%n;
				continue;
			}
			int nextCow = queue.poll();
//			System.out.println(nextCow);
			if (nextCow<=index) {
				energy+=(index-nextCow)*(index-nextCow);
				placed[index] = true;
				index = (index+1)%n;
				cowsPlaced++;
			}
			else {
				energy+=(n-nextCow + index)*(n-nextCow+index);
				placed[index] = true;
				index = (index+1)%n;
				cowsPlaced++;
			}
		}
		return energy;
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
