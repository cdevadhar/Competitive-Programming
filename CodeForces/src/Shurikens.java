import java.io.*;
import java.util.*;
public class Shurikens {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		ArrayList<Event> events = new ArrayList<Event>();
		for (int i=0; i<2*n; i++) {
			char c = in.next().charAt(0);
			if (c=='+') {
				events.add(new Event(c, 0));
			}
			else {
				int num = in.nextInt();
				events.add(new Event(c, num));
			}
		}
		Collections.reverse(events);
		Stack<Integer> removedShurikens = new Stack<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		boolean doesWork = true;
		for (int i=0; i<2*n; i++) {
			if (events.get(i).shuriken==0) {
				if (removedShurikens.isEmpty()) {
					doesWork = false;
					break;
					
				}
				ans.add(removedShurikens.pop());
			}
			else {
				if (!removedShurikens.isEmpty() && removedShurikens.peek()<events.get(i).shuriken) {
					doesWork = false;
					break;
				}
				removedShurikens.add(events.get(i).shuriken);
			}
		}
		if (doesWork) {
			Collections.reverse(ans);
			System.out.println("YES");
			for (int x: ans) System.out.print(x+" ");
		}
		else System.out.println("NO");
	}
	static class Event {
		char val;
		int shuriken;
		public Event(char val, int shuriken) {
			this.shuriken = shuriken;
			this.val = val;
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
