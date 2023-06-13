import java.io.*;
import java.util.*;

public class BessieGoesMoo {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "bgm.out");
		int n = in.nextInt();
		HashMap<String, Integer> varValues = new HashMap<String, Integer>();
		varValues.put("B", 0);
		varValues.put("E", 1);
		varValues.put("S", 2);
		varValues.put("I", 3);
		varValues.put("G", 4);
		varValues.put("O", 5);
		varValues.put("M", 6);

		long[][] possibilities = new long[7][7];
		for (int i=0; i<n; i++) {
			String s = in.next();
			possibilities[varValues.get(s)][Math.abs(in.nextInt()%7)]++;
		}
		long ans = 0;
		for (int b=0; b<7; b++) {
			for (int e=0; e<7; e++) {
				for (int s=0; s<7; s++) {
					for (int i=0; i<7; i++) {
						for (int g=0; g<7; g++) {
							for (int o=0; o<7; o++) {
								for (int m=0; m<7; m++) {
									if ((b+e+s+s+i+e)*(g+o+e+s)*(m+o+o)%7==0) {
										ans+=possibilities[0][b]*possibilities[1][e]*possibilities[2][s]*possibilities[3][i]*possibilities[4][g]*possibilities[5][o]*possibilities[6][m];
									}
								}
							}
						}
					}
				}
			}
		}
		in.pr.println(ans);
		in.pr.close();
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
