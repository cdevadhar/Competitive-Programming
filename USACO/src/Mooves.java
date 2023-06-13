import java.util.*;
import java.io.*;
public class Mooves {
	static int N;
	static int K;
	static ArrayList<Swap> adjacent;
	static ArrayList<Integer> cows;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		adjacent=new ArrayList<Swap>();
		cows=new ArrayList<Integer>();
		for (int i=0; i<N; i++) {
			cows.add(i);
		}
		for (int i=0; i<K; i++) {
			int a = input.nextInt()-1;
			int b = input.nextInt()-1;
			Swap swap=new Swap(a, b);
			adjacent.add(swap);
		}
	}
	
	public void simulate() {
		boolean[] Done = new boolean[N];
		boolean notDone=true;
		ArrayList<Integer> numVisited = new ArrayList<Integer>();
		for (int i=0; i<N; i++) {
			numVisited.add(0);
		}
		while (notDone) {
			for (int i=0; i<adjacent.size(); i++) {
				cows.set(adjacent.get(i).a, adjacent.get(i).b);
				numVisited.get(adjacent.get(i).b);
				cows.set(adjacent.get(i).b, adjacent.get(i).a);
			}
			boolean Check=true;
			for (int i=0; i<N; i++) {
				if (cows.get(i)==i) {
					Done[i]=true;
				}
				if (Done[i]==false) {
					Check=false;
				}
			}
			if (Check==true) {
				notDone=false;
			}
			
		}
	}
	
}
class Swap {
	int a;
	int b;
	public Swap(int a, int b) {
		this.a = a;
		this.b=b;
	}
}
