import java.io.*;
import java.util.*;
public class TwoLetter {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			String[] a = new String[n];
			String[] b = new String[n];
			for (int i=0; i<n; i++) {
				a[i] = in.next();
				b[i] = a[i].substring(1)+a[i].substring(0, 1);
			}
			Arrays.parallelSort(a);
			Arrays.parallelSort(b);
			System.out.println(solve(a)+solve(b));
		}
	}
	public static long solve(String[] s) {
		long ans = 0;
		ArrayList<String>[] arr = new ArrayList[26];
		for (int i=0; i<26; i++) {
			arr[i] = new ArrayList<String>();
		}
		for (String str: s) {
			arr[str.charAt(0)-'a'].add(str);
		}
		for (int i=0; i<26; i++) {
			if (arr[i].size()==0) continue;
			long streak = 1;
			String prev = arr[i].get(0);
			long thisAns = 0;
			for (int j=1; j<arr[i].size(); j++) {
				if (arr[i].get(j).equals(prev)) {
					streak++;
				}
				else {
					thisAns+=streak*((long)arr[i].size()-streak);
					streak = 1;
				}
				prev = arr[i].get(j);
			}
			thisAns+=streak*(arr[i].size()-streak);
			ans+=thisAns/2;
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
