//import java.io.*;
//import java.util.*;
//public class Interactive {
//	static Scanner in;
//	public static void main(String[] args) {
//		in = new Scanner(System.in);
//		int t = in.nextInt();
//		for (int i=0; i<t; i++) {
//			int a = in.nextInt();
//			int b = in.nextInt();
//			int n = in.nextInt();
//			search(a, b);
//		}
//	}
//	
//	public static void search(int x, int y) {
//		int a = x;
//		int b = y;
//		while (b>=a) {
//			int mid = (a+b)/2;
//			System.out.println(mid);
//			String s = "";
//			if (in.hasNext()) {
//				s = in.next();
//			}
//			
//			if (s.equals("TOO_SMALL")) {
//				
//				a = mid;
//			}
//			if (s.equals("TOO_BIG")) {
//				b = mid +1;
//			}
//			if (s.equals("CORRECT")) {
//				return;
//			}
//			if (s.equals("WRONG_ANSWER")) {
//				return;
//			}
//		}
//		
//	}
//}

import java.util.Scanner;

public class Interactive {
	public static void search(Scanner in, int x, int y) {
		int a = x;
		int b = y;
		while (b>=a) {
			int mid = (a+b)/2;
			System.out.println(mid);
			String s = "";
			
			s = in.next();
			
			
			if (s.equals("TOO_SMALL")) {
				
				a = mid+1;
			}
			if (s.equals("TOO_BIG")) {
				b = mid -1;
			}
			if (s.equals("CORRECT")) {
				return;
			}
			if (s.equals("WRONG_ANSWER")) {
				return;
			}
		}
		
	}

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int a = input.nextInt();
      int b = input.nextInt();
      int n = input.nextInt();
      search(input, a + 1, b);
    }
  }
}
