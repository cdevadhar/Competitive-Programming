import java.io.*;
import java.util.*;

public class BerryPicking {
	static int n, k;
	static int[] trees;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("USACOinput1", "berries.out");
		n = in.nextInt();
		k = in.nextInt();
		trees = new int[n];
		for (int i=0; i<n; i++) {
			trees[i] = in.nextInt();
		}
		Arrays.parallelSort(trees);
		int maxBerries = 0;

		for (int b=1; b<trees[n-1]; b++) {
			int[] leftovers = new int[n];
			int fullBaskets = 0;
			int bessieBerries = 0;
			for (int i=0; i<n; i++) {
				fullBaskets+=trees[i]/b;
				leftovers[i] = trees[i]%b;
			}
			if (fullBaskets>=k) {
				bessieBerries = k/2;
			}
			else {
				int fullBessieBaskets = fullBaskets-k/2;
				Arrays.parallelSort(leftovers);
				int index = n-1;
				int basketsFilled = fullBessieBaskets;
				bessieBerries = fullBessieBaskets*b;
				while (basketsFilled<k/2 && index>=0) {
					bessieBerries+=leftovers[index];
					basketsFilled++;
					index--;
				}
			}
			if (bessieBerries>maxBerries) maxBerries = bessieBerries;
		}
		System.out.println(maxBerries);
		in.pr.close();
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
