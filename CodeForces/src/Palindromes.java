import java.io.*;
import java.util.*;
public class Palindromes {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
//			System.out.println(n);
			HashSet<String> scenes = new HashSet<String>();
			boolean found = false;
			for (int i=0; i<n; i++) {
				String s = in.next();
				if (s.length()==1) {
					found=true;
					continue;
//					break;
				}
				if (s.charAt(0)==s.charAt(s.length()-1)) {
					found = true;
					continue;
//					break;
				}
				scenes.add(s);
				if (s.length()==3) {
					String reverse2 = ""+s.charAt(2)+s.charAt(1);
					String reverse3 = ""+s.charAt(2)+s.charAt(1)+s.charAt(0);
					if (scenes.contains(reverse2) || scenes.contains(reverse3)) {
						found = true;
//						break;
					}
				}
				else {
					String reverse = ""+s.charAt(1)+s.charAt(0);
					for (int c=0; c<26; c++) {
						char curr = (char) ('a'+c);
//						System.out.println(curr);
						String temp = reverse+curr;
						if (scenes.contains(temp)) {
							found = true;
//							break;
						}
					}
//					if (found==true) break;
					if (scenes.contains(reverse)) {
						found = true;
//						break;
					}
				}
			}
			if (found) System.out.println("YES");
			else System.out.println("NO");
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
