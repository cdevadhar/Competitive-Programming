import java.io.*;
import java.util.*;
public class StringDeletion {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			String s = in.next();
			Queue<Block> blocks = new LinkedList<Block>();
			int prev=s.charAt(0)-'0';
			int len=1;
			for (int i=1; i<n; i++) {
				int c = s.charAt(i)-'0';
				if (c!=prev) {
					Block b = new Block(prev, len);
					blocks.add(b);
					len=0;
				}
				len++;
				prev = c;
			}
			blocks.add(new Block(prev, len));
			int numOnes=0;
			int operations = 0;
			while (!blocks.isEmpty()) {
				if (blocks.peek().length==1) {
					blocks.poll();
					numOnes++;
					continue;
				}
				Block curr = blocks.peek();
				if (curr.length>numOnes) {
					operations+=numOnes;
					
					int leftOver = curr.length-numOnes;
					numOnes = 0;
//					System.out.println(leftOver);
					if (leftOver>1) {
						operations++;
					}
					else {
						numOnes++;
						
					}
					blocks.poll();
				}
				else if (curr.length<=numOnes) {
					int op = curr.length-1;
					operations+=op;
					numOnes-=op;
					numOnes++;
					blocks.poll();
				}
				
			}
			operations+=(numOnes+1)/2;
			System.out.println(operations);
		}
	}
	static class Block {
		int value, length;
		public Block(int value, int length) {
			this.value = value;
			this.length = length;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
