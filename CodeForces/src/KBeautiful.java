import java.io.*;
import java.util.StringTokenizer;
import java.io.*;
public class KBeautiful {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			String s = in.next();
			if (n%k!=0) {
				in.pr.println(-1);
				continue;
			}
			int[][] prefix = new int[n+1][26];
			for (int i=0; i<n; i++) {
				for (int j=0; j<26; j++) {
					prefix[i+1][j] = prefix[i][j];
				}
				prefix[i+1][s.charAt(i)-'a']++;
			}
			boolean works = true;
			for (int i=0; i<26; i++) {
				if (prefix[n][i]%k!=0) works = false;
			}
			if (works) {
				in.pr.println(s);
				continue;
			}
			boolean done = false;
			for (int samePrefix = n-2; samePrefix>=-1; samePrefix--) {
				if (done) break;
				for (int next = 1; next<='z'-s.charAt(samePrefix+1); next++) {
					prefix[samePrefix+2][s.charAt(samePrefix+1)-'a']--;
					prefix[samePrefix+2][s.charAt(samePrefix+1)-'a'+next]++;
					int totalNeeded = 0;
					int[] needed = new int[26];
					for (int i=0; i<26; i++) {
//						System.out.print(prefix[samePrefix+2][i]+" ");
						int diff = (k-prefix[samePrefix+2][i]%k)%k;
						totalNeeded+=diff;
						needed[i] = diff;
					}
//					System.out.println();
//					if (next==1 && samePrefix ==0) {
//						System.out.println(totalNeeded);
//						for (int i=0; i<26; i++) {
//							System.out.print(needed[i]+" ");
//						}
//					}
					if (totalNeeded>(n-1)-samePrefix-1) {
						prefix[samePrefix+2][s.charAt(samePrefix+1)-'a']++;
						prefix[samePrefix+2][s.charAt(samePrefix+1)-'a'+next]--;
						continue;
					}
//					
					StringBuilder ans = new StringBuilder();
					ans.append(s.substring(0, samePrefix+1));
					ans.append((char) (s.charAt(samePrefix+1)+next));
					int leftover = (n-1)-(samePrefix+1)-totalNeeded;
//					in.pr.println(samePrefix);
//					in.pr.println(next);
//					in.pr.println(totalNeeded);
					for (int i=0; i<leftover; i++) {
						ans.append('a');
					}
					for (int i=0; i<26; i++) {
						for (int j=0; j<needed[i]; j++) {
							ans.append((char)('a'+i));
//							in.pr.println((char)('a'+i));
						}
					}
					in.pr.println(ans.toString());
					done = true;
					break;
				}
			}
			
		}
		in.pr.close();
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
