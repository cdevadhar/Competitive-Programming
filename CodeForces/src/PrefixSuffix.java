import java.io.*;
import java.util.*;
// Come back to this in a long time when you learn KMP algorithm
public class PrefixSuffix {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			String s = in.next();
			int front= 0;
			int back = s.length()-1;
			while (back>front) {
				if (s.charAt(front)==s.charAt(back)) {
					front++;
					back--;
				}
				else break;
			}
			if (front<back) {
				String left = s.substring(front, back+1);
				StringBuilder reversed = new StringBuilder();
				for (int i=left.length()-1; i>=0; i--) {
					reversed.append(left.charAt(i));
				}
				String reversedLeft = reversed.toString();
				String first = longestPalindromicPrefix(left);;
				String second = longestPalindromicPrefix(reversedLeft);
				reversed = new StringBuilder();
				for (int i=second.length()-1; i>=0; i--) {
					reversed.append(second.charAt(i));
				}
				second = reversed.toString();
				if (first.length()>second.length()) System.out.println(s.substring(0, front)+first+s.substring(back+1));
				else System.out.println(s.substring(0, front)+second+s.substring(back+1));
			}
			else System.out.println(s);
		}
	}
	public static String longestPalindromicPrefix(String s) {
		for (int i=s.length(); i>0; i--) {
			if (isPalindrome(s.substring(0, i))) return s.substring(0, i);
		}
		return "";
	}
	public static boolean isPalindrome(String s) {
		for (int i=0; i<s.length()/2; i++) {
			if (s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
