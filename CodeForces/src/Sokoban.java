import java.io.*;
import java.util.*;
public class Sokoban {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<Integer> negBoxes = new ArrayList<Integer>();
			ArrayList<Integer> negSpecial = new ArrayList<Integer>();
			ArrayList<Integer> posBoxes = new ArrayList<Integer>();
			ArrayList<Integer> posSpecial = new ArrayList<Integer>();
			for (int i=0; i<n; i++) {
				int b = in.nextInt();
				if (b<0) negBoxes.add((-1)*b);
				else posBoxes.add(b);
			}
			for (int i=0; i<m; i++) {
				int s = in.nextInt();
				if (s<0) negSpecial.add((-1)*s);
				else posSpecial.add(s);
			}
			Collections.reverse(negBoxes);
			Collections.reverse(negSpecial);
			System.out.println(solvePos(posBoxes, posSpecial)+solvePos(negBoxes, negSpecial));
		}
	}
	public static int solvePos(ArrayList<Integer> posBoxes, ArrayList<Integer> posSpecial) {
		if (posBoxes.size()==0 || posSpecial.size()==0) return 0;
		int[] suffix = new int[posSpecial.size()+1];
		for (int i=suffix.length-2; i>=0; i--) {
			suffix[i] = suffix[i+1];
			if (Collections.binarySearch(posBoxes, posSpecial.get(i))>=0) {
				suffix[i]++;
			}
		}
//		System.out.println(suffix[0]);
		int maxBoxes = suffix[0];
		for (int i=0; i<posSpecial.size(); i++) {
			
			int stop = posSpecial.get(i)-1;
//			System.out.println("Stop "+stop);
			if (stop+1<=posBoxes.get(0)) continue;
			int hi = posBoxes.size()-1;
			int lo = 0;
			while (hi>lo) {
				int mid = (hi+lo+1)/2;
				if (stop+mid+1>=posBoxes.get(mid)) {
					lo = mid;
				}
				else hi = mid-1;
			}
			int boxesPushed = hi+1;
//			System.out.println(stop+boxesPushed);
			int latestSpecial = Collections.binarySearch(posSpecial, stop+boxesPushed);
			if (latestSpecial<0) {
				latestSpecial*=-1;
				latestSpecial-=2;
			}
//			System.out.println("Latest special: " + latestSpecial);
			maxBoxes = Math.max((latestSpecial-i)+1+suffix[latestSpecial+1], maxBoxes);
//			System.out.println(maxBoxes);
		}
		return maxBoxes;
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
