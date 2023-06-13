import java.io.*;
import java.util.*;

public class Taming {
	
	public int countBreakouts(ArrayList<Integer> counter) {
		ArrayList<Integer> knownBreakouts = new ArrayList<Integer>();
		ArrayList<Integer> cantBeBreakouts = new ArrayList<Integer>();
		knownBreakouts.add(0);
		for (int i=0; i<counter.size(); i++) {
			if (counter.get(i) != -1) {
				int j = i-counter.get(i);
				if (knownBreakouts.contains(j) == false) {
					knownBreakouts.add(j);
				}
				
				if (counter.get(i)>0) {
					cantBeBreakouts.add(i);
					for (int m=j; m<i; m++) {
						cantBeBreakouts.add(m);
					}
				}
				
			}
		}
		int known = knownBreakouts.size() + cantBeBreakouts.size();
		return known;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		StringTokenizer line2 = new StringTokenizer(br.readLine());
		ArrayList<Integer> counter = new ArrayList<Integer>();
		for (int i=0; i<N; i++) {
			int a = Integer.parseInt(line2.nextToken());
			counter.add(a);
		}
		
		System.out.println(new Taming().countBreakouts(counter));
	}
}
