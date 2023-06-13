import java.io.*;
import java.util.*;

public class PrefixSum {
	static int[] cows;
	static int n;
	static PrintWriter pw;
	static int[] holsteins;
	static int[] guernseys;
	static int[] jerseys;

	public static void main(String[] args) throws IOException {
//		
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		cows = new int[n];
		holsteins = new int[n+1];
		guernseys = new int[n+1];
		jerseys = new int[n+1];
		for (int i=0; i<n; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(line.nextToken());
			cows[i] = a;
			
		}
		countBreeds();
		for (int i=0; i<q; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(line.nextToken())-1;
			int b = Integer.parseInt(line.nextToken());
			
			int Holsteins = holsteins[b]-holsteins[a];
			int Guernseys = guernseys[b]-guernseys[a];
			int Jerseys = jerseys[b]-jerseys[a];
			pw.println(Holsteins+ " " + Guernseys + " " + Jerseys);
		}
		br.close();
		
		pw.close();
		
	}
	
	public static void countBreeds() {
		
		
		holsteins[0] = 0;
		guernseys[0] = 0;
		jerseys[0] = 0;
		for (int i=1; i<cows.length+1; i++) {
			holsteins[i] = holsteins[i-1];
			guernseys[i] = guernseys[i-1];
			jerseys[i] = jerseys[i-1];
			if (cows[i-1]==1) {
				holsteins[i]++;
			}
			if (cows[i-1]==2) {
				guernseys[i]++;
			}
			if (cows[i-1]==3) {
				jerseys[i]++;
			}
			
		}
		
		
	}

}


