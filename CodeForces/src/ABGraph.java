import java.io.*;
import java.util.*;
public class ABGraph {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			char[][] edges = new char[n][m];
			for (int i=0; i<n; i++) {
				edges[i] = in.next().toCharArray();
			}
			if (m%2==1) {
				System.out.println("YES");
				for (int i=0; i<(m+1)/2; i++) {
					System.out.print(1+" "+2+" ");
				}
				System.out.println();
			}
			else {
				boolean same = false;
				for (int i=0; i<n; i++) {
					if (same) break;
					for (int j=i+1; j<n; j++) {
						if (edges[i][j]==edges[j][i]) {
							same = true;
							System.out.println("YES");
							for (int x=0; x<m/2; x++) {
								System.out.print((i+1)+" "+(j+1)+" ");
							}
							System.out.println(i+1);
							break;
						}
					}
				}
				if (!same) {
					boolean works = false;
					for (int i=0; i<n; i++) {
						int inA = -1;
						int outA = -1;
						int inB = -1;
						int outB = -1;
						
						for (int j=0; j<n; j++) {
							if (j==i) continue;
							if (edges[i][j]=='a') outA = j;
							else outB = j;
							if (edges[j][i]=='a') inA = j;
							else inB = j;
						}
						if (inA>=0 && outA>=0) {
							System.out.println("YES");
							inA++;
							outA++;
							i++;
							if ((m/2)%2==0) {
								for (int j=0; j<m/2; j++) {
									if (j%2==0) System.out.print(i+" ");
									else System.out.print(inA+" ");
								}
								System.out.print(i+" ");
								for (int j=0; j<m/2; j++) {
									if (j%2==0) System.out.print(outA+" ");
									else System.out.print(i+" ");
								}
								System.out.println();
							}
							else {
//								System.out.println("YES");
								for (int j=0; j<m+1; j++) {
									if (j%2==1) System.out.print(i+" ");
									else if (j%4==0) System.out.print(inA+" ");
									else System.out.print(outA+" ");
								}
								System.out.println();
							}
							works = true;
							break;
						}
						else if (inB>=0 && outB>=0) {
							System.out.println("YES");
							inB++;
							outB++;
							i++;
							if ((m/2)%2==0) {
								for (int j=0; j<m/2; j++) {
									if (j%2==0) System.out.print(i+" ");
									else System.out.print(inB+" ");
								}
								System.out.print(i+" ");
								for (int j=0; j<m/2; j++) {
									if (j%2==0) System.out.print(outB+" ");
									else System.out.print(i+" ");
								}
								System.out.println();
							}
							else {
								for (int j=0; j<m+1; j++) {
									if (j%2==1) System.out.print(i+" ");
									else if (j%4==0) System.out.print(inB+" ");
									else System.out.print(outB+" ");
								}
								System.out.println();
							}
							works = true;
							break;
						}
						
					}
					if (!works) System.out.println("NO");
				}
			}
		}
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
