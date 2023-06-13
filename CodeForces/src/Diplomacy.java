import java.io.*;
import java.util.*;
public class Diplomacy {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int max = (m+1)/2;
			int[] occurences = new int[n];
			int[] aloneOccurences = new int[n];
			boolean works = true;
			boolean case1 = false;
			int chosenFriend = -1;
			ArrayList<Integer>[] days = new ArrayList[m];
			for (int i=0; i<m; i++) {
				days[i] = new ArrayList<Integer>();
			}
			for (int i=0; i<m; i++) {
				int k = in.nextInt();
				for (int j=0; j<k; j++) {
					int friend = in.nextInt()-1;
					days[i].add(friend);
					occurences[friend]++;
					if (k==1) aloneOccurences[friend]++;
					if (aloneOccurences[friend]>max) works = false;
					if (occurences[friend]>max) {
						case1 = true;
						chosenFriend = friend;
					}
				}
			}
			if (!works) in.pr.println("NO");
			else {
				in.pr.println("YES");
				if (!case1) {
					for (int i=0; i<m; i++) {
						in.pr.print(days[i].get(0)+1);
					}
					in.pr.println();
				}
				else {
					int alone = aloneOccurences[chosenFriend];
					int count = 0;
					for (int i=0; i<m; i++) {
						if (days[i].size()==1) in.pr.print(days[i].get(0)+1+" ");
						else {
							if (!days[i].contains(chosenFriend)) in.pr.print(days[i].get(0)+1+" ");
							else {
								if (count<max-alone) {
									in.pr.print(chosenFriend+1+" ");
									count++;
								}
								else {
									if (days[i].get(0)!=chosenFriend) in.pr.print(days[i].get(0)+1+" ");
									else in.pr.print(days[i].get(1)+1+" ");
								}
							}
						}
					}
					in.pr.println();
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
