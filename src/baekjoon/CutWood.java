package baekjoon;

import java.util.Scanner;

public class CutWood {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		long num = scan.nextLong();
		long max = 0;
		long[] wood = new long[size];
		
		for(int i=0; i<size; i++) {
			long temp = scan.nextLong();
			if(max < temp) max = temp;
			wood[i] = temp;
		}
		
		findMaxHeightWood(wood, num, max);
		
		scan.close();
	}

	private static void findMaxHeightWood(long[] wood, long target, long max) {
		int len = wood.length;
		long low = 0, high = max;
		
		while(low+1<high) {
			long mid = (low+max) / 2;
			long sum = 0;
			
			for(int i=0; i<len; i++) {
				sum+=wood[i]-mid;
			}
			
			if(sum == target) {
				break;
			} else if(sum < target) {
				low = mid;
			}
		}
	}
}
