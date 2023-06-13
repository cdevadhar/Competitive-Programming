import java.io.*;
import java.util.*;
public class Maze {
	static int t;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int[][] maze = new int[n][n];
			boolean[][][][] path = new boolean[n][n][n][n];
		}
	}
	
	public static void path1(boolean[][][][] path) {
		String s = in.next();
		int currentX = 0;
		int currentY = 0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)=='E') {
				path[currentX][currentY][currentX + 1][currentY]=true;
				path[currentX+1][currentY][currentX][currentY]=true;
			}
			if (s.charAt(i)=='S') {
				path[currentX][currentY][currentX][currentY+1]=true;
				path[currentX][currentY+1][currentX][currentY]=true;
			}
		}
	}
	
	public static void getPath(int[][]maze) {
		
	}
}
