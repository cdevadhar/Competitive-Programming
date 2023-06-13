import java.io.*;
import java.util.*;


public class Gates {
	static boolean[][] fence;
	static boolean[][] visited;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("USACOinput1")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		n = Integer.parseInt(br.readLine());
		String directions = br.readLine();
		fence = new boolean[4005][4005];
		visited = new boolean[4005][4005];
		int currX = 2001, currY = 2001;
		for (int i=0; i<directions.length(); i++) {
			
		}
	}
	
	static class Cell {
		int x, y;
	}
}