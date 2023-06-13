import java.io.*;
import java.util.*;
public class Lemonade {
	static int n;
	static ArrayList<Integer> waitTimes;
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new FileReader(new File("USACOinput1")));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		StringTokenizer st = new StringTokenizer(bi.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bi.readLine());
		waitTimes = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			waitTimes.add(Integer.parseInt(st.nextToken()));
//			System.out.println(waitTimes.get(i));
		}
		bi.close();
		Collections.sort(waitTimes);
		Collections.reverse(waitTimes);
		int count=0;
		for (int i=0; i<n; i++) {
			if (waitTimes.get(i)>=i) {
				count++;
			}
			else break;
		}
		System.out.println(count);
		pw.close();
	}
}
