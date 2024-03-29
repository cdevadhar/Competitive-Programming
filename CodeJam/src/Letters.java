import java.util.*;
import java.io.*;

public class Letters {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			String[] words = new String[n];
			boolean works = true;
			for (int i=0; i<n; i++) {
				words[i] = in.next();
				if (!check(words[i])) {
					works = false;
				}
			}
			if (!works) System.out.println("IMPOSSIBLE");
			else {
				ArrayList<String> wild = new ArrayList<String>();
				ArrayList<String> endpoints = new ArrayList<String>();
				boolean[] start = new boolean[26];
				boolean[] end = new boolean[26];
				for (String word: words) {
					if (countChars(word)==1) wild.add(word);
					else {
						if (start[word.charAt(0)-'A']) {
							works = false;
							break;
						}
						if (end[word.charAt(word.length()-1)-'A']) {
							works = false;
							break;
						}
						
						start[word.charAt(0)-'A'] = true;
						end[word.charAt(word.length()-1)-'A'] = true;
						endpoints.add(word);
					}
				}
				for (int i=0; i<endpoints.size(); i++) {
					for (int j=i+1; j<endpoints.size(); j++) {
						if (endpoints.get(i).charAt(0)==endpoints.get(j).charAt(endpoints.get(j).length()-1) && endpoints.get(j).charAt(0)==endpoints.get(i).charAt(endpoints.get(i).length()-1)) {
							works = false;
							break;
						}
					}
				}
				if (!works) {
					System.out.println("IMPOSSIBLE1");
				}
				else {
					if (endpoints.size()==0) {
						String tower = "";
						Collections.sort(wild);
						for (String s: wild) tower+=s;
						System.out.println(tower);
					}
					else {
						String tower = endpoints.get(0);
						endpoints.remove(0);
						while (!wild.isEmpty() || !endpoints.isEmpty()) {
							char right = tower.charAt(tower.length()-1);
							char left = tower.charAt(0);
							boolean added = false;
							for (int i=0; i<wild.size(); i++) {
								if (wild.get(i).charAt(0)==right) {
									tower+=wild.get(i);
									wild.remove(i);
									added = true;
									i--;
								}
							}
							for (int i=0; i<wild.size(); i++) {
								if (wild.get(i).charAt(0)==left) {
									tower = wild.get(i)+tower;
									wild.remove(i);
									added = true;
									i--;
								}
							}
							for (int i=0; i<endpoints.size(); i++) {
								if (endpoints.get(i).charAt(0)==right) {
									tower+=endpoints.get(i);
									added = true;
								}
								else if (endpoints.get(i).charAt(endpoints.get(i).length()-1)==left) {
									tower = endpoints.get(i)+tower;
									added = true;
								}
							}
							if (!added) {
								
							}
						}
						if (!works) {
							System.out.println("IMPOSSIBLE2 " + tower);
						}
						else {
							System.out.println(tower+" "+wild.size()+" "+endpoints.size());
						}
					}
				}
			}
		}
	}
	public static int countChars(String s) {
		boolean[] occ = new boolean[26];
		for (int i=0; i<s.length(); i++) {
			
			occ[s.charAt(i)-'A'] = true;
		}
		int count = 0;
		for (int i=0; i<26; i++) {
			if (occ[i]) count++;
		}
		return count;
	}
	public static boolean check(String s) {
		boolean[] occ = new boolean[26];
		for (int i=0; i<s.length(); i++) {
			if (occ[s.charAt(i)-'A'] && i>0 && s.charAt(i-1)!=s.charAt(i)) {
				return false;
			}
			occ[s.charAt(i)-'A'] = true;
		}
		return true;
	}
	public int search(int[] a, int v) {
		for (int i=0; i<10; i++) {
			if (i==v) return i;
			else return -1;
		}
		return v;
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
