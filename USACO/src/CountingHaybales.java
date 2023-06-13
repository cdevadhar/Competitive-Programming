import java.io.*;
import java.util.*;
public class CountingHaybales {
	static int n, q;
	static ArrayList<Integer> haybales;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("haybales.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		haybales = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			haybales.add(a);
		}
		Collections.sort(haybales);
		for (int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			int a = countHaybales2(low);
			//System.out.println("low "+ a);
			int b = countHaybales(high);
			//System.out.println("high " +b);
			out.println(b-(a));
		}
		br.close();
		out.close();
		
	}
	
	public static int countHaybales(int point) {
		int low = 0;
		int high = haybales.size();
		while (high>low) {
			int mid = (high+low)/2;
			if (haybales.get(mid)<=point) {
				low=mid+1;
			}
			else high = mid;
		}
		return low;
	}
	public static int countHaybales2(int point) {
		int low = 0;
		int high = haybales.size();
		while (high>low) {
			int mid = (high+low)/2;
			if (haybales.get(mid)<point) {
				low=mid+1;
			}
			else high = mid;
		}
		return low;
	}
}
