import java.io.*;
import java.util.*;

public class SocialDistancing {
	static int n, m;
	static GrassPatch[] patches;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("socdist.in", "socdist.out");
		n = in.nextInt();
		m = in.nextInt();
		patches = new GrassPatch[m];
		for (int i=0; i<m; i++) {
			long start = in.nextLong();
			long end = in.nextLong();
			GrassPatch patch = new GrassPatch(start, end);
			patches[i] = patch;
		}
		Arrays.parallelSort(patches);
		//System.out.println(canFit(4));
		long high = patches[m-1].end;
		long low = 0;
		while (high>low) {
			long mid = (high+low)/2;
			if (canFit(mid)) {
				low = mid+1;
			}
			else {
				high = mid;
			}
		}
		in.pr.println(low-1);
		in.pr.close();
	}
	
	public static boolean canFit(long distance) {
		int cowsPlaced = 1;
		long currPosition = patches[0].start;
		int index = 0;
		while (cowsPlaced<n) {
			//System.out.println(currPosition);
			if (index==m) return false;
			if (patches[index].end-distance>=currPosition) {
				cowsPlaced++;
				currPosition+=distance;
			}
			else {
				long idealPosition = currPosition+distance;
				while (index<m && patches[index].end<idealPosition) {
					index++;
				}
				//System.out.println("Index is " + index);
				if (index==m) return false;
				currPosition = Math.max(patches[index].start, idealPosition);
				cowsPlaced++;
			}
		}
		return true;
	}
	static class GrassPatch implements Comparable<GrassPatch>{
		long start, end;
		public GrassPatch(long start, long end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(GrassPatch o) {
			// TODO Auto-generated method stub
			return Long.compare(start, o.start);
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