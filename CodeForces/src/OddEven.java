import java.io.*;
import java.util.*;
public class OddEven {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int k = in.nextInt();
		HashMap<Integer, Integer> firstOcc = new HashMap<Integer, Integer>();
		int[] a = new int[n];
		int[] sortedA = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
			sortedA[i] = a[i];
			
			firstOcc.putIfAbsent(a[i], i);
		}
		Arrays.parallelSort(sortedA);
		int hi = a.length-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo)/2;
//			System.out.println(sortedA[mid]);
			int cost = sortedA[mid];
			if (check(cost, firstOcc, a, k)) {
				hi = mid;
			}
			else lo = mid+1;
		}
//		System.out.println(check(56309, firstOcc, a, k));
		System.out.println(sortedA[hi]);
	}
	public static boolean check(int cost, HashMap<Integer, Integer> firstOcc, int[] a, int k) {
		int index = firstOcc.get(cost);
		int rightCount = 0;
		int leftCount = 0;
		int prev = index;
		for (int i=index+2; i<a.length; i++) {
			if (i == prev+1) continue;
			if (a[i]<=cost) {
				rightCount++;
				prev = i;
			}
		}
		prev = index;
		for (int i=index-2; i>=0; i--) {
			if (i==prev-1) continue;
			if (a[i]<=cost) {
//				System.out.println(i);
				leftCount++;
				prev = i;
			}
		}
//		System.out.println(rightCount+" "+leftCount);
		int total = rightCount+leftCount+1;
//		System.out.println(total+" "+prev);
		if (k%2==1) {
			if (total==k/2) {
				if (prev>0) return true;
				return false;
			}
			if (total<k/2) return false;
			return true;
		}
		else {
			if (total>=k/2) return true;
			return false;
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
