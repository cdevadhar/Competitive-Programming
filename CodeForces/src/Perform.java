import java.io.*;
import java.util.*;
public class Perform {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int[] a = new int[6];
		for (int i=0; i<6; i++) {
			a[i] = in.nextInt();
		}
		int n = in.nextInt();
		Note[] notes = new Note[6*n];
		for (int i=0; i<n; i++) {
			int note = in.nextInt();
			for (int j=0; j<6; j++) {
				notes[i*6+j] = new Note(note-a[j], i);
			}
		}
		Arrays.parallelSort(notes, (o1, o2) -> Integer.compare(o1.fret, o2.fret));
		int left=0, ans = Integer.MAX_VALUE;
		int unique = 0;
		int[] occ = new int[n];
		for (int right=0; right<6*n; right++) {
//			System.out.println(notes[right].fret+" "+notes[right].index);
			occ[notes[right].index]++;
			if (occ[notes[right].index]==1) unique++;
			while (occ[notes[left].index]>1) {
				occ[notes[left].index]--;
				left++;
			}
			if (unique==n) {
				ans = Math.min(ans, notes[right].fret-notes[left].fret);
			}
		}
		System.out.println(ans);
	}
	static class Note {
		int fret, index;
		public Note(int fret, int index) {
			this.fret = fret;
			this.index = index;
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
