import java.io.*;
import java.util.*;
public class ABCs2 {
	static HashSet<List<Integer>> ans;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			ans = new HashSet<List<Integer>>();
			int n = in.nextInt();
			int[] arr = new int[n+1];
			for (int i=0; i<n; i++) {
				arr[i+1] = in.nextInt();
			}
			for (int i=0; i<n; i++) {
				for (int j=i+1; j<n; j++) {
					checkSum(arr[i]+arr[j], arr);
				}
			}
			System.out.println(ans.size());
		}
	}
	public static void checkSum(int sum, int[] arr) {
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		for (int i=0; i<arr.length; i++) {
			if (arr[i]>sum) return;
			if (arr[i]==0 || arr[i]==sum) continue;
			candidates.add(Math.min(arr[i], sum-arr[i]));
			
		}
		Collections.sort(candidates);
		checkSol(sum, candidates.get(0), candidates.get(1), arr);
		checkSol(sum, candidates.get(0), sum-candidates.get(1), arr);
	}
	public static void checkSol(int sum, int b, int c, int[] arr) {
		int a = sum-b-c;
		if (a<=0 || b<=0 || c<=0) return;
		List<Integer> full = Arrays.asList(a, b, c, a+b, a+c, b+c, a+b+c);
		for (int i: arr) {
			if (!full.contains(i)) return;
		}
		ans.add(Arrays.asList(a, b, c));
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
