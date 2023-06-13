import java.io.*;
import java.util.*;
public class Revegetation {
	static int n, m;
	static ArrayList<Integer>[] same;
	static ArrayList<Integer> [] different;
	static boolean[] visited;
	static int[] types;
	static boolean impossible;
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new FileReader(new File("USACOinput1")));
		StringTokenizer st = new StringTokenizer(bi.readLine());
		n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    same = new ArrayList[n];
	    different = new ArrayList[n];
	    visited = new boolean[n];
	    types = new int[n];
	    impossible = false;
	    for (int i=0; i<n; i++) {
	    	same[i] = new ArrayList<Integer>();
	    	different[i] = new ArrayList<Integer>();
	    }
	    for (int i=0; i<m; i++) {
	    	st = new StringTokenizer(bi.readLine());
	    	char s = st.nextToken().charAt(0);
	    	int a = Integer.parseInt(st.nextToken())-1;
	    	int b = Integer.parseInt(st.nextToken())-1;
	    	if (s =='S') {
	    		same[a].add(b);
	    		same[b].add(a);
	    	}
	    	else {
	    		different[a].add(b);
	    		different[b].add(a);
	    	}
	    }
	    int count=0;
	    for (int i=0; i<n; i++) {
	    	if (!visited[i]) {
	    		bfs(i);
				count ++;
	    	}
	    }
	    if (impossible) {
	    	System.out.println(0);
	    }
	    else {
	    	System.out.print(1);
	    	for (int i=0; i<count; i++) {
	    		System.out.print(0);
	    	}
	    }
	}
	
	public static void bfs(int farm) {
		Stack<Integer> queue = new Stack<Integer>();
		visited[farm] = true;
		queue.add(farm);
		types[farm]=1;
		while (!queue.isEmpty()) {
			int current = queue.pop();
			int currentVal = types[current];
			System.out.println(currentVal);
			for (int i=0; i<n; i++) {
				if (same[current].contains(i) && !visited[i]) {
					visited[i]=true;
					queue.add(i);
					types[i]=currentVal;
				}
				if (same[current].contains(i) && visited[i]) {
					if (types[i]!=currentVal) impossible = true;
				}
				if (different[current].contains(i) && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					types[i] = 3-currentVal;
				}
				if (different[current].contains(i) && visited[i]) {
					if (types[i]==currentVal) impossible = true;
				}
			}
		}
	}
}
