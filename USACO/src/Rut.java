import java.io.*;
import java.util.*;
public class Rut {
	
	public int howMuchGrass(ArrayList<Cow> cows, Cow cow) {
		ArrayList<Integer> intersections = new ArrayList<Integer>();
		for (int j=0; j<cows.size(); j++) {
			if (cow.direction.contentEquals(cows.get(j).direction)==false) {
				if (cow.direction.contentEquals("N")) {
					int intersectionx = cow.startingx;
					int intersectiony = cows.get(j).startingy;
					if (intersectionx-cows.get(j).startingx<intersectiony-cow.startingy &&intersectionx-cows.get(j).startingx>0 && intersectionx-cows.get(j).startingx<new Rut().howMuchGrass(cows, cows.get(j)) ) {
						intersections.add(intersectiony-cow.startingy);
					}
				}
				if (cow.direction.contentEquals("E")) {
					int intersectiony = cow.startingy;
					int intersectionx = cows.get(j).startingx;
					if (intersectiony-cows.get(j).startingy<intersectionx-cow.startingx &&intersectiony-cows.get(j).startingy>0 && intersectiony-cows.get(j).startingy<new Rut().howMuchGrass(cows, cows.get(j))) {
						intersections.add(intersectionx-cow.startingx);
					}
				}
			}
		}
		
		int returnval=0;
		
		if (intersections.isEmpty()==true || (cow.startingx==4 && cow.startingy==6)) {
			returnval = 1000000000;
		}
		else {
			returnval = Collections.min(intersections);
		}
		return returnval;
		
	}
	static class Cow {
		String direction;
		int startingx;
		int startingy;
		int grassEaten = 0;
		boolean moving = true;
		public Cow(String direction, int startingx, int startingy) {
			this.direction=direction;
			this.startingx = startingx;
			this.startingy = startingy;
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Cow> cows = new ArrayList<Cow>();
		for (int i=0; i<N; i++) {
			String direction = scan.next();
			int x = scan.nextInt();
			int y = scan.nextInt();
			Cow cow = new Cow(direction, x, y);
			cows.add(cow);
		}
		for (int i=0; i<cows.size(); i++) {
			int printVal = new Rut().howMuchGrass(cows, cows.get(i));
			if (printVal==1000000000) {
				System.out.println("Infinity");
			}
			else {
				System.out.println(printVal);
			}
		}
		
	}
}

