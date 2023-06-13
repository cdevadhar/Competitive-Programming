import java.io.*;
import java.util.*;
public class BadMilk {
	
	
	public boolean canMilkBeBad(int milkType, ArrayList<Drink> drinks, ArrayList<Sick> sicks) {
		for (int i=0; i<sicks.size(); i++)  {
			for (int j=0; j<drinks.size(); j++) {
				if (new BadMilk().personDrankMilkBefore(sicks.get(i).person, milkType, sicks.get(i).time, drinks, sicks)){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean personDrankMilkBefore(int person, int milkType, int time, ArrayList<Drink> drinks, ArrayList<Sick> sicks) {
		for (int i=0; i<drinks.size(); i++) {
			if (drinks.get(i).person==person && drinks.get(i).time<time) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		ArrayList<Sick> sicks = new ArrayList<Sick>();
		for (int i=0; i<D; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(line.nextToken());
			int m = Integer.parseInt(line.nextToken());
			int t = Integer.parseInt(line.nextToken());
			
			Drink drink = new Drink(p, m, t);
			drinks.add(drink);
		}
		for (int i=0; i<S; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(line.nextToken());
			int t = Integer.parseInt(line.nextToken());
			
			Sick sick = new Sick(p, t);
			sicks.add(sick);
		}
		for (int i=1; i<51; i++) {
			if (new BadMilk().canMilkBeBad(i, drinks, sicks)==true) {
				System.out.println(i);
			}
		}
		
	}
}

class Drink {
	int person;
	int milkType;
	int time;
	public Drink(int person, int milkType, int time) {
		this.person = person;
		this.milkType = milkType;
		this.time = time;
	}
}

class Sick {
	int person;
	int time;
	public Sick(int person, int time) {
		this.person = person;
		this.time = time;
	}
}