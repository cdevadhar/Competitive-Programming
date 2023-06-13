import java.util.*;
import java.io.*;
//	Input parsing is too slow apparently
//		BufferedReader br = new BufferedReader(new FileReader(new File("highcard.in")));  
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
//	    StringTokenizer st = new StringTokenizer(br.readLine());
//	    int n = Integer.parseInt(st.nextToken());
//	    ArrayList<Integer> elsie = new ArrayList<Integer>();
//	    ArrayList<Integer> bessie = new ArrayList<Integer>();
//	    for (int i=0; i<n; i++) {
//	    	StringTokenizer line = new StringTokenizer(br.readLine());
//	    	int e = Integer.parseInt(line.nextToken());
//	    	elsie.add(e);
//	    	
//	    }
//	    br.close();
//	    for (int i=1; i<2*n+1; i++) {
//	    	if (!elsie.contains(i)) {
//	    		bessie.add(i);
//	    		
//	    	}
//	    }



public class CardGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		int n = Integer.parseInt(br.readLine());
		boolean[] elsieOwns = new boolean[2*n+1];
		for(int i = 0; i < n; i++) {
			elsieOwns[Integer.parseInt(br.readLine())] = true;
		}
		ArrayList<Integer> bessie = new ArrayList<Integer>();
		ArrayList<Integer> elsie = new ArrayList<Integer>();
		int points = 0;
		// because we loop over the values in increasing order, the two lists will be in sorted order
		for(int i = 1; i <= 2*n; i++) {
			if(elsieOwns[i]) {
				elsie.add(i);
			}
			else {
				bessie.add(i);
			}
		}
		pw.println(calculate(bessie, elsie));
	    pw.close();
	}
	
	public static int calculate(ArrayList<Integer> bessie, ArrayList<Integer> elsie) {
//		Collections.sort(elsie);
		Collections.sort(bessie);
		int result=0;
		for (int i=0; i<elsie.size(); i++) {
			int a = smallestWinning(elsie.get(i), bessie);
			if (a>0) {
				result+=1;
			}
		}
		return result;
	}
	
	public static int smallestWinning(int e, ArrayList<Integer> bessie) {
		
		int smallestWinning=0;
		for (int i=0; i<bessie.size(); i++) {
			if (bessie.get(i)>e) {
				smallestWinning=bessie.get(i);
				bessie.remove(i);
				break;
			}
		}
//		System.out.println(smallestWinning);
		return smallestWinning;
	}
}
