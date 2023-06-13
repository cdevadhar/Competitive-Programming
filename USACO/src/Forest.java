import java.util.*;
import java.io.*;
public class Forest {
	static int N, Q;
	static char[][] forest;
	static int[][] prefixRows;
	static int[][] prefix;
	static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		N = in.nextInt();
		Q  =in.nextInt();
		forest = new char[N][N];
		prefixRows = new int[N+1][N+1];
		prefix = new int[N+1][N+1];
		for (int i=0; i<N; i++) {
			String a = (in.next());
			for (int j=0; j<a.length(); j++) {
				char b = a.charAt(j);
				forest[i][j] = b;
				System.out.print(forest[i][j]);
				prefixRows[i][j] = 0;
				prefix[i][j]=0;
			}
			System.out.println();
		}
		fillPrefix2();
		for (int i=0; i<N+1; i++) {
			for (int j=0; j<N+1; j++) {
				System.out.print(prefix[i][j] + " ");
			}
			System.out.println();
		}
		countTrees();
	}
	
	public static void fillPrefix() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				prefixRows[i][j+1] = prefixRows[i][j];
				if (forest[i][j]=='*') prefixRows[i][j+1]++;
			}
			
		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<N+1; j++) {
				prefix[i+1][j] = prefix[i][j];
				prefix[i+1][j]+= prefixRows[i][j];
			}
		}
	}
	
	public static void fillPrefix2() {
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<N+1; j++) {
				int a = 0;
				if (forest[i-1][j-1] =='*') a=1;
				prefix[i][j] = prefix[i-1][j] + prefix [i][j-1] - prefix[i-1][j-1] + a;
			}
		}
	}
	
	public static void countTrees() {
		for (int i=0; i<Q; i++) {
			int y1 = in.nextInt();
			int x1 = in.nextInt();
			int y2 = in.nextInt();
			int x2 = in.nextInt();
			int trees = prefix[y2][x2]-prefix[y1-1][x2]-prefix[y2][x1-1]+prefix[y1-1][x1-1];
			System.out.println(trees);
		}
	}
}
