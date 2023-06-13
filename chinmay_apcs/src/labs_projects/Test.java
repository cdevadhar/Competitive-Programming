package labs_projects;

public class Test {
	public static void main(String[]args) {
		int x = 25;
		char a = (char) ('a'+x);
		System.out.println(a);
	}
	public static int decimalToBinary(int x) {
		int y = 0;
		int num = 1;
		while (num*2<x) num*=2;
		while (x>0) {
			if (x>=num) {
				x-=num;
				y*=10;
				y+=1;
			}
			else y*=10;
			num/=2;
		}
		return y;
	}
	public static int decimalToBinary2(int x) {
		if (x==0) return 0;
		return (x%2 + 10*decimalToBinary2(x/2));
	}
}
