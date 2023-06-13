import java.io.*;
import java.util.*;
public class DSU {
	static int[] p;
	static int[] min, max, size;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		
		min = new int[n+1];
		max = new int[n+1];
		size = new int[n+1];
		for (int i=1; i<n+1; i++) {
			p[i] = i;
			min[i] = i;
			max[i] = i;
			size[i] = 1;
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("get")) {
				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				if (get(a)==get(b)) System.out.println("YES");
//				else System.out.println("NO");
				get2(a);
			}
			else {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union2(a, b);
			}
		}
	}
	
	public static void get2(int node) {		
		int parent = get(node);
		System.out.print(min[parent]+" ");
		System.out.print(max[parent]+" ");
		System.out.println(size[parent]);
		
	}
	
	public static int get(int x) {
		if (p[x]!=x) {
			p[x] = get(p[x]);
		}
		return p[x];
	}
	
	public static void union2(int a, int b) {
		int xroot = get(a), yroot = get(b);
		
		if (xroot==yroot) return;
		if (size[xroot]<size[yroot]) {
			p[xroot] = yroot;
			if (min[xroot]<min[yroot]) min[yroot] = min[xroot];
			if (max[xroot]>max[yroot]) max[yroot] = max[xroot];
			size[yroot]+=size[xroot];
		}
		else if (size[yroot]<size[xroot]) {
			p[yroot] = xroot;
			if (min[yroot]<min[xroot]) min[xroot] = min[yroot];
			if (max[yroot]>max[xroot]) max[xroot] = max[yroot];
			size[xroot]+=size[yroot];
		}
		else {
			p[yroot] = xroot;
			if (min[yroot]<min[xroot]) min[xroot] = min[yroot];
			if (max[yroot]>max[xroot]) max[xroot] = max[yroot];
			
			size[xroot]+=size[yroot];
					
		}
		
	}

}
