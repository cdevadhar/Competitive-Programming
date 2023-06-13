import java.io.*;
import java.util.*;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = { 12, 11, 13, 5, 6, 7 };
		mergeSort2(arr);
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
//	public static void sort(int arr[], int l, int r)
//    {
//        if (l < r) {
//            int m =l+ (r-l)/2;
//            sort(arr, l, m);
//            sort(arr, m + 1, r);
//            merge(arr, l, m, r);
//        }
//    }
	
	public static void merge(int[] leftSide, int[] rightSide, int[] arr) {
		int i=0, j=0, k=0;
		while (i<leftSide.length && j<rightSide.length) {
			if (rightSide[j]>=leftSide[i]) {
				arr[k] = rightSide[j];
				k++;
				j++;
			}
			else {
				arr[k] = leftSide[i];
				k++;
				i++;
			}
		}
		while (i <leftSide.length) {
            arr[k] = leftSide[i];
            i++;
            k++;
        }
        while (j <rightSide.length) {
            arr[k] = rightSide[j];
            j++;
            k++;
        }
	}
	
	public static void mergeSort2(int[] nums) {
		if (nums.length>1) {
			int mid = nums.length/2;
			int[] leftSide = Arrays.copyOfRange(nums, 0, mid+1);
			int[] rightSide = Arrays.copyOfRange(nums, mid+1, nums.length+1);
			mergeSort2(leftSide);
			mergeSort2(rightSide);
			merge(leftSide, rightSide, nums);
		}
	}
}
