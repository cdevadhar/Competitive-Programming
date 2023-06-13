import java.io.*;
import java.util.*;

public class Experience {
	static int[] p, experience, rank;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		experience = new int[n+1];
		rank = new int[n+1];
		for (int i=1; i<n+1; i++) {
			p[i] = i;
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int a, b;
			if (s.equals("join")) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				join(a, b);
			}
			else if (s.equals("get")) {
				a = Integer.parseInt(st.nextToken());
				System.out.println(experience[get(a)]);
			}
			else {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				System.out.println("experience " + b);
				experience[get(a)]+=b;
			}
		}
	}
	
	public static int get(int x) {
		if (p[x]!=x) {
			p[x] = get(p[x]);
		}
		return p[x];
	}
	
	public static void join(int x, int y) {
		int xroot = get(x), yroot = get(y);
		if (xroot==yroot) return;
		if (rank[xroot]>rank[yroot]) {
			p[yroot] = xroot;
		}
		else if (rank[yroot]>rank[xroot]) {
			p[xroot] = yroot;
		}
		else {
			p[xroot] = yroot;
		}
	}
}
