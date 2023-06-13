import java.io.*;
import java.util.*;
public class StringTransformation {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int tcs = in.nextInt();
		for (int tc=0; tc<tcs; tc++) {
			String t = in.next();
			HashMap<Character, Integer> lastIndex = new HashMap<Character, Integer>();
			HashMap<Character, Integer> occurences = new HashMap<Character, Integer>();
			for (int i=0; i<t.length(); i++) {
				char c = t.charAt(i);
				lastIndex.put(c, i);
				occurences.putIfAbsent(c, 0);
				occurences.put(c, occurences.get(c)+1);
			}
			Set<Character> chars = lastIndex.keySet();
			CharData[] chardata = new CharData[chars.size()];
			int index = 0;
			for (Character key: chars) {
				chardata[index] = new CharData(key, lastIndex.get(key));
				index++;
			}
			Arrays.sort(chardata, (o1, o2) -> Integer.compare(o1.lastIndex, o2.lastIndex));
			boolean works = true;
			int totalCount = 0;
			for (int i=0; i<chardata.length; i++) {
				int occ = occurences.get(chardata[i].value);
				int step = i+1;
				if (occ%step!=0) {
					works = false;
					break;
				}
				totalCount+=(occ/step);
			}
			if (!works) {
				System.out.println(-1);
				continue;
			}
			String original = t.substring(0, totalCount);
			works = check(original, t, chardata);
			if (!works) {
				System.out.println(-1);
				continue;
			}
			System.out.print(original+" ");
			for (int i=0; i<chardata.length; i++) {
				System.out.print(chardata[i].value);
			}
			System.out.println();
		}
	}
	public static boolean check(String s, String t, CharData[] order) {
		StringBuilder newT = new StringBuilder();
		int index = 0;
		while (index<order.length) {
			newT.append(s);
			StringBuilder newS = new StringBuilder();
			for (int i=0; i<s.length(); i++) {
				if (s.charAt(i)!=order[index].value) newS.append(s.charAt(i));
				
			}
			s = newS.toString();
			index++;
		}
		if (newT.toString().equals(t)) return true;
		return false;
	}
	static class CharData {
		char value;
		int lastIndex;
		public CharData(char value, int lastIndex) {
			this.value = value;
			this.lastIndex = lastIndex;
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
