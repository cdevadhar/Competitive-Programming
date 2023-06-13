import java.io.*;
import java.util.*;
public class ABCs {

	public void findABCs(ArrayList<Integer> numbers) {
		int max = Collections.max(numbers);
		
		ArrayList<ABC> possibleABCs = new ArrayList<ABC>();
		for (int i=0; i<numbers.size(); i++) {
			for (int j=i+1; j<numbers.size(); j++) {
				for (int k=j+1; k<numbers.size(); k++) {
					if (numbers.get(i) + numbers.get(j)+ numbers.get(k)==max) {
						ABC possibleABC = new ABC(numbers.get(i), numbers.get(j), numbers.get(k));
						possibleABCs.add(possibleABC);
					}
				}
			}
		}
		for (int i=0; i<possibleABCs.size(); i++) {
			if (numbers.contains(possibleABCs.get(i).AB) &&numbers.contains(possibleABCs.get(i).AC) && numbers.contains(possibleABCs.get(i).BC)) {
				System.out.println(possibleABCs.get(i).A + " " + possibleABCs.get(i).B + " " + possibleABCs.get(i).C);
			}
		}
	}
	
	public void findABCs2(ArrayList<Integer> numbers) {
		Collections.sort(numbers);
		int A = numbers.get(0);
		int B = numbers.get(1);
		int max = Collections.max(numbers);
		int C = max - A - B;
		System.out.println(A + " " + B + " " + C); 
	}
	


	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i=0; i<7; i++) {
			int a = scan.nextInt();
			
			numbers.add(a);
		}
		new ABCs().findABCs2(numbers);
		
		
	}
}
class ABC {
	int A;
	int B;
	int C;
	int AB;
	int AC;
	int BC;
	
	
	public ABC(int A, int B, int C) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.AB = A+B;
		this.AC = A+C;
		this.BC = B+C;
	}
}
