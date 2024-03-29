import java.io.*;
import java.util.*;
public class SubsetEquality {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		String s = in.next();
		String t = in.next();
		int[] occS = new int[26];
		int[] occT = new int[26];
		for (int i=0; i<s.length(); i++) {
			occS[s.charAt(i)-'a']++;
		}
		for (int i=0; i<t.length(); i++) {
			occT[t.charAt(i)-'a']++;
		}
		boolean[][] matrix = new boolean[26][26];
		for (int i=0; i<26; i++) {
			char a = (char) ('a'+i);
			for (int j=i+1; j<26; j++) {
				char b = (char) ('a'+j);
				if (occS[a-'a']!=occT[a-'a'] || occS[b-'a']!=occT[b-'a']) matrix[i][j] = false;
				else {
					matrix[i][j] = check(s, t, a, b);
				}
			}
		}
		int q = in.nextInt();
		for (int i=0; i<q; i++) {
			String set = in.next();
			boolean works = true;
			for (int j=0; j<set.length(); j++) {
				if (occS[set.charAt(j)-'a']!=occT[set.charAt(j)-'a']) {
					works = false;
					break;
				}
			}
			if (!works) {
				in.pr.print('N');
				continue;
			}
			else {
				for (int j=0; j<set.length(); j++) {
					for (int k=j+1; k<set.length(); k++) {
						if (!matrix[set.charAt(j)-'a'][set.charAt(k)-'a']) {
							works = false;
							break;
						}
					}
				}
				if (works) in.pr.print('Y');
				else in.pr.print('N');
			}
		}
//		in.pr.println(check(s, t, 'a', 'd')+" "+matrix[1][3]);
		in.pr.close();
	}
	public static boolean check(String s, String t, char a, char b) {
		StringBuilder alteredS = new StringBuilder();
		StringBuilder alteredT = new StringBuilder();
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)==a || s.charAt(i)==b) alteredS.append(s.charAt(i));
		}
		for (int i=0; i<t.length(); i++) {
			if (t.charAt(i)==a || t.charAt(i)==b) alteredT.append(t.charAt(i));
		}
		return alteredS.toString().equals(alteredT.toString());
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
