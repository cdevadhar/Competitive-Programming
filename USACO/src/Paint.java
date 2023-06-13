import java.io.*;
import java.util.*;
public class Paint {

	static ArrayList<Integer> paintNeeded;
	static int N;
	public static void main(String[] args) {
		char a = 'a';
		char b = 'b';
		if(a < b) {
			System.out.println("A is less than b");
		}
//		Scanner input = new Scanner(System.in);
//		N = input.nextInt();
//		int Q = input.nextInt();
//		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String wall = input.next();
//		paintNeeded = new ArrayList<Integer>();
//		for (int i=0; i<wall.length(); i++) {
//			int a = alphabet.indexOf(wall.charAt(i))+1;
//			paintNeeded.add(a);
////			System.out.print(a);
//		}
////		System.out.println();
//		for (int i=0; i<Q; i++) {
//			int a = input.nextInt()-1;
//			int b = input.nextInt()-1;
////			System.out.println(a + " " + b);
//			System.out.println(paintWall(a, b));
//		}
	}
	
	public static int paintWall(int a, int b) {
		List<Integer> paintA = paintNeeded.subList(0, a);
		List<Integer> paintB = paintNeeded.subList(b+1, N);
		return paintSection(paintA) + paintSection(paintB);
		
	}
	
	public static int paintSection(List<Integer> paint) {
		List<List<Integer>> sections = new ArrayList<List<Integer>>();
		int list=0;
		sections.add(new ArrayList<Integer>());
		for (int i=0; i<paint.size(); i++) {
			
		}
		return list;
	}
}
