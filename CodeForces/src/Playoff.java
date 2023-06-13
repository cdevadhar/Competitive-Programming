import java.io.*;
import java.util.*;
public class Playoff {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int k = in.nextInt();
		char[] s = in.next().toCharArray();
		int[] p = new int[s.length];
		int[] possWinners = new int[s.length];
		ArrayList<ArrayList<Integer>> children = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<s.length; i++) children.add(new ArrayList<Integer>());
		fillP(p.length-1, -1, p, 0, children);
		for (int i=s.length-1; i>=0; i--) {
			if (possWinners[i]==0) getWinners(i, 0, s, children, possWinners);
		}
//		for (int i: possWinners) {
//			System.out.println(i);
//		}
		int q = in.nextInt();
		for (int i=0; i<q; i++) {
			int index = in.nextInt()-1;
			char c = in.next().charAt(0);
			s[index] = c;
			while (index!=-1) {
				
				if (index<=s.length/2) {
					if (s[index]=='?') possWinners[index] = 2;
					else possWinners[index] = 1;
				}
				else {
					if (s[index]=='?') possWinners[index] = possWinners[children.get(index).get(0)]+possWinners[children.get(index).get(1)];
					else if (s[index]=='0') possWinners[index] = possWinners[children.get(index).get(0)];
					else possWinners[index] = possWinners[children.get(index).get(1)];
				}
//				System.out.println("Check: " + index + " has " + possWinners[index]+" possible winners");
				index = p[index];
			}
			System.out.println(possWinners[s.length-1]);
		}
		
	}
	public static int getWinners(int game, int winners, char[] s, ArrayList<ArrayList<Integer>> children, int[] possWinners) {
//		System.out.println("current game: " + game);
		if (game<=s.length/2) {
			if (s[game]=='?') {
				possWinners[game] = 2;
				return 2;
			}
			possWinners[game] = 1;
			return 1;
		}
		if (possWinners[game]>0) return possWinners[game];
		if (s[game]=='0') {
			winners+=getWinners(children.get(game).get(0), winners, s, children, possWinners);
		}
		else if (s[game]=='1') {
			winners+=getWinners(children.get(game).get(1), winners, s, children, possWinners);
		}
		else {
			winners+=getWinners(children.get(game).get(0), winners, s, children, possWinners)+getWinners(children.get(game).get(1), winners, s, children, possWinners);
		}
		possWinners[game] = winners;
		return winners;
	}
	public static void fillP(int game, int parent, int[] p, int side, ArrayList<ArrayList<Integer>> children) {
		p[game] = parent;
//		System.out.println(game);
		if (parent==-1) {
			if (game<=p.length/2) return;
			fillP(game-2, game, p, 0, children);
			fillP(game-1, game, p, 1, children);
		}
		else {
			children.get(parent).add(game);
			if (game<=p.length/2) return;
			if (side==0) {
				fillP(game-(p[game]-game)*2, game, p, 0, children);
				fillP(game-(p[game]-game)*2+1, game, p, 1, children);
			}
			else {
				fillP(game-(p[game]-game)*2-1, game, p, 0, children);
				fillP(game-(p[game]-game)*2, game, p, 1, children);
			}
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
