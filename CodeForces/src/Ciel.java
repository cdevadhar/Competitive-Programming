import java.io.*;
import java.util.*;
public class Ciel {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<Integer> attack = new ArrayList<Integer>();
		ArrayList<Integer> defense = new ArrayList<Integer>();
		ArrayList<Integer> ciel = new ArrayList<Integer>();
		TreeMap<Integer, Integer> cielMap = new TreeMap<Integer, Integer>();
		for (int i=0; i<n; i++) {
			String s = in.next();
			if (s.equals("ATK")) {
				attack.add(in.nextInt());
			}
			else {
				defense.add(in.nextInt());
			}
		}
		for (int i=0; i<m; i++) {
			int x = in.nextInt();
			ciel.add(x);
			cielMap.putIfAbsent(x, 0);
			cielMap.put(x, cielMap.get(x)+1);
		}
		Collections.sort(ciel, (o1, o2) -> Integer.compare(o2, o1));
		Collections.sort(attack);
		Collections.sort(defense);
		
		System.out.println(Math.max(beatAttack(ciel, attack), beatDefense(cielMap, defense, attack)));
		
	}
	public static int beatAttack(ArrayList<Integer> ciel, ArrayList<Integer> attacks) {
		int attackIndex = 0;
		int ans = 0;
		for (int i: attacks) {
			if (attackIndex == ciel.size()-1) {
				return ans;
			}
			int currAttack = ciel.get(attackIndex);
			if (currAttack<i) {
				return ans;
			}
			ans+=(currAttack-i);
			attackIndex++;
		}
		return ans;
	}
	// To beat the defense, go with the lowest card 
	public static int beatDefense(TreeMap<Integer, Integer> cielMap, ArrayList<Integer> defense, ArrayList<Integer> attack) {
		for (int i: defense) {
			if (cielMap.higherKey(i)==null) {
				return 0;
			}
			int key = cielMap.higherKey(i);
			if (cielMap.get(key)>1) {
				cielMap.put(key, cielMap.get(key)-1);
			}
			else {
				cielMap.remove(key);
			}
		}
		int ans = 0;
		for (int i: attack) {
			if (cielMap.higherKey(i)==null) {
				return ans;
			}
			int key = cielMap.higherKey(i);
			if (cielMap.get(key)>1) {
				cielMap.put(key, cielMap.get(key)-1);
			}
			else {
				cielMap.remove(key);
			}
			ans+=key-i;
		}
		Set<Integer> keys = cielMap.keySet();
		for (Integer key: keys) {
			ans+=key*cielMap.get(key);
		}
		return ans;
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	            new InputStreamReader(System.in));
	    }
	    

	    public String next() throws IOException
	    {
	        while (st == null || !st.hasMoreElements()) {
	           
	            st = new StringTokenizer(br.readLine());
	        }
	        return st.nextToken();
	    }

	    public int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

	    public long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

	    public double nextDouble() throws NumberFormatException, IOException
	    {
	        return Double.parseDouble(next());
	    }

	    public String nextLine() throws IOException
	    {
	        String str = br.readLine();
	        return str;
	    }
	}
}
