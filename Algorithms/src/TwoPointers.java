import java.io.*;
import java.util.*;
public class TwoPointers {
	static int n, m;
	static int[] arr1, arr2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr1 = new int[n];
		arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr1[i] = a;
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr2[i] = a;
		}
		int[] result = merge();
//		for (int i=0; i<n+m-1; i++) {
//			System.out.print(result[i]+" ");
//		}
//		System.out.print(result[n+m-1]);
		
	}
	
	public static int[] merge() {
		int[] result = new int[n+m];
		int i=0;
		int j=0;
		int k=0;
		while (i<n || j<m) {
			if (i>=n) {
				result[k] = arr2[j];
				j++;
				k++;
				System.out.print(i+" ");
			}
			else if (j>=m) {
				result[k] = arr1[i];
				i++;
				k++;
			}
			else {
				if (arr1[i]<arr2[j]) {
					result[k] = arr1[i];
					i++;
					k++;
				}
				else if (arr1[i]>=arr2[j]) {
					result[k] = arr2[j];
					j++;
					k++;
					System.out.print(i+" ");
				}
			}
		}
		return result;
	}
	
	
}
