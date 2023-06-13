import java.io.*;
import java.util.*;
public class Deck {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] deck = new int[n];
		for (int i=0; i<n; i++) {
			deck[i] = in.nextInt();
		}
		int state = 0;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (int i=1; i<n; i++) {
			
			int index = indexOf(deck, i);
			int target = 0;
			if (i%2==1) target = n-i;
			else target = i-1;
			if (index==0 && i==1) continue;
//			System.out.println(index+" "+target);
			ArrayList<Integer> curr = new ArrayList<Integer>();
			if (i%2==0) {
				int temp = 0;
				while (temp<n) {
					if (temp<target) {
						curr.add(1);
						temp++;
					}
					else if (temp>index) {
						curr.add(1);
						temp++;
					}
					else {
						curr.add(index-temp+1);
						temp = index+1;
					}
				}
				reverse(deck, target, index);
			}
			else {
				int temp = 0;
				while (temp<n) {
					if (temp<index) {
						curr.add(1);
						temp++;
					}
					else if (temp>target) {
						curr.add(1);
						temp++;
					}
					else {
						curr.add(target-temp+1);
						temp = target+1;
					}
				}
				reverse(deck, index, target);
			}
			
			reverse(deck, 0, n-1);
			ans.add(curr);
//			for (int x: deck) System.out.print(x+" ");
//			System.out.println();
			
		}
		if (n%2==1 && n>1) {
			ArrayList<Integer> last = new ArrayList<Integer>(n);
			for (int i=0; i<n; i++) last.add(1);
			ans.add(last);
			reverse(deck, 0, n-1);
		}
		System.out.println(ans.size());
		for (int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i).size()+" ");
			for (int j=0; j<ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
	}
	public static void reverse(int[] a, int s, int f) {
		for (int i=s; i<=(s+f)/2; i++) {
			int temp = a[i];
			a[i] = a[f-(i-s)];
			a[f-(i-s)] = temp;
		}
	}
	public static int indexOf(int[] a, int m) {
		for (int i=0; i<a.length; i++) {
			if (a[i]==m) return i;
		}
		return -1;
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
