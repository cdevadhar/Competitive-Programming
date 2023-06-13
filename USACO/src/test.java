/* Use the slash-star style comments or the system won't see your

   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
	
	public int BinarySearch(ArrayList<Integer> numbers, int key, int high, int low) {
		if (low<=high) {
			int mid = low + (high-low)/2;
			if (numbers.get(mid)==key) {
				return mid;
			}
			if (numbers.get(mid)<key) {
				return new test().BinarySearch(numbers, key, high, mid+1);
			}
			else {
				return new test().BinarySearch(numbers, key, mid-1, low);
			}
		}
		else {
			return -1;
		}
	}
	
	public int naiveSearch (ArrayList<Integer> numbers, int key) {
		int thingToReturn = -1;
		for (int i=0; i<numbers.size(); i++) {
			if (numbers.get(i)==key) {
				thingToReturn = i;
			}
		}
		return thingToReturn;
	}
	public static void main (String [] args) throws IOException {
		int[] arr = new int[1];
		for(int i=0; i<10;) {
			
		}

  }
}