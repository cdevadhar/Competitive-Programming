import java.io.*;
import java.util.*;
public class SnowBoots2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("snowboots.in", "snowboots.out");
		int n = in.nextInt();
		int b = in.nextInt();
		Tile[] tiles = new Tile[n];
		Boot[] boots = new Boot[b];
		for (int i=0; i<n; i++) {
			tiles[i] = new Tile(in.nextInt(), i);
		}
		for (int i=0; i<b; i++) {
			boots[i] = new Boot(in.nextInt(), in.nextInt(), i);
		}
		Arrays.parallelSort(tiles, (o1, o2) -> Integer.compare(o1.size, o2.size));
		Arrays.parallelSort(boots, (o1, o2) -> Integer.compare(o1.depth, o2.depth));
		TreeSet<Tile> tilesLeft = new TreeSet<Tile>((o1, o2) -> Integer.compare(o1.position, o2.position));
		for (Tile t: tiles) tilesLeft.add(t);
		int maxGap = 0;
		int tileIndex = n-1;
		int[] ans = new int[b];
		for (int i=b-1; i>=0; i--) {
			while (tileIndex>=0 && tiles[tileIndex].size>boots[i].depth) {
//				System.out.println(tiles[tileIndex].size);
				int newGap = 0;
				if (tilesLeft.higher(tiles[tileIndex])==null && tilesLeft.lower(tiles[tileIndex])==null) {
					newGap = n-2;
				}
				else if (tilesLeft.higher(tiles[tileIndex])==null) {
					newGap = (n-1)-tilesLeft.lower(tiles[tileIndex]).position;
				}
				else if (tilesLeft.lower(tiles[tileIndex])==null) {
					newGap = tilesLeft.higher(tiles[tileIndex]).position;
				}
				else {
					newGap = tilesLeft.higher(tiles[tileIndex]).position-tilesLeft.lower(tiles[tileIndex]).position-1;
				}
				maxGap = Math.max(maxGap, newGap);
				tilesLeft.remove(tiles[tileIndex]);
				tileIndex--;
				
			}
//			System.out.println(boots[i].depth + " " + boots[i].jump + " " + maxGap);
			if (maxGap<boots[i].jump) ans[boots[i].id] = 1;
		}
		for (int i: ans) in.pr.println(i);
		in.pr.close();
	}
	static class Boot {
		int depth, jump, id;
		public Boot(int depth, int jump, int id) {
			this.depth = depth;
			this.jump = jump;
			this.id = id;
		}
	}
	static class Tile {
		int size, position;
		public Tile(int size, int position) {
			this.position = position;
			this.size = size;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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
