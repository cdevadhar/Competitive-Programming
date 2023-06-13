import java.io.*;
import java.util.*;
public class ArrayDestruction {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] arr = new int[2*n];
			for (int i=0; i<2*n; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.parallelSort(arr);
			boolean works = false;
			for (int i=0; i<2*n-1; i++) {
				int x = arr[i]+arr[2*n-1];
				ArrayList<Integer> ans = check(n, arr, x);
				if (ans.size()>0) {
					System.out.println(ans);
					works = true;
					break;
				}
			}
			if (!works) System.out.println("NO");
		}
	}
	public static ArrayList<Integer> check(int n, int[] arr, int x) {
		HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
		for (int i=0; i<n; i++) {
			occurences.putIfAbsent(arr[i], 0);
			occurences.put(arr[i], occurences.get(arr[i]));
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int maxIndex = n-1;
		int currX = x;
		while (ans.size()<2*n) {
			if (!occurences.containsKey(currX-arr[maxIndex])) {
				return new ArrayList<Integer>();
			}
			if (occurences.get(currX-arr[maxIndex])==1) {
				occurences.remove(currX-arr[maxIndex]);
			}
			else {
				occurences.put(currX-arr[maxIndex], occurences.get(currX-arr[maxIndex]-1));
			}

			ans.add(arr[maxIndex]);
			ans.add(currX-arr[maxIndex]);
			currX = arr[maxIndex];
			maxIndex--;
		}
		return ans;
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
