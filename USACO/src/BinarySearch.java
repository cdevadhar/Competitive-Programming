//import java.util.*;
//import java.io.*;
//public class BinarySearch {
//	
//	public int getHaybales(ArrayList<Integer> haybales, Query query) {
//		Collections.sort(haybales);
//		int B = Collections.binarySearch(haybales, query.B);
//		int A = Collections.binarySearch(haybales, query.A);
//		return A;
//		
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
//		StringTokenizer str = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(str.nextToken());
//		int Q = Integer.parseInt(str.nextToken());
//		StringTokenizer line2 = new StringTokenizer(br.readLine());
//		ArrayList<Integer> haybales = new ArrayList<Integer>();
//		ArrayList<Query> queries = new ArrayList<Query>();
//		for (int i=0; i<N; i++) {
//			int a = Integer.parseInt(line2.nextToken());
//			haybales.add(a);
//		}
//		for (int i=0; i<Q; i++) {
//			StringTokenizer line = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(line.nextToken());
//			int b = Integer.parseInt(line.nextToken());
//			Query query = new Query(a, b);
//			queries.add(query);
//		}
//	}
//}
//class Query {
//	int A;
//	int B;
//	public Query(int A, int B) {
//		this.A = A;
//		this.B = B;
//	}
//}
//
import java.io.*; 
import java.util.*; 

public class BinarySearch{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new FileReader(new File("USACOinput1")));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());
      ArrayList<Integer> haybales = new ArrayList<Integer>();
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++){
          haybales.add(Integer.parseInt(st.nextToken()));
      }
      Collections.sort(haybales);
      for(int i = 0; i < Q; i++){
         st = new StringTokenizer(br.readLine());
         int low = Integer.parseInt(st.nextToken());
         int high = Integer.parseInt(st.nextToken());
         int bi = Collections.binarySearch(haybales, low);
         if(bi < 0){
        	
            bi = Math.abs(bi+1);
         }
         int ti = Collections.binarySearch(haybales, high);
         if(ti < 0){
            ti = Math.abs(ti+2);
         }
        System.out.println(ti-bi+1);
      }
      
   }
}

