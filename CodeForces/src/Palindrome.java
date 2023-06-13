import java.io.*;
import java.util.*;
public class Palindrome {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			String s = in.next();
			int[] occurences = new int[26];
			for (int i=0; i<n; i++) {
				occurences[s.charAt(i)-'a']++;
			}
			int pairs=0, numOdd=0;
			for (int i=0; i<26; i++) {
				pairs+=occurences[i]/2;
				numOdd+=occurences[i]%2;
			}
			int ans = 2*(pairs/k);
			numOdd+=2*(pairs%k);
			if (numOdd>=k) ans++;
			System.out.println(ans);
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
