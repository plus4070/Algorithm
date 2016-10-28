package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class DivisionSector {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int numOfSector = scan.nextInt();
		int[] number = new int[size];

		for (int i = 0; i < size; i++) {
			number[i] = scan.nextInt();
		}

		System.out.println(sumOfSectors(number, numOfSector));

		scan.close();
	}

	private static int sumOfSectors(int[] number, int numOfSector) {
		int size = number.length;
		int[] orderedNumber = Arrays.copyOf(number, size);
		int[] sumOfNumber = Arrays.copyOf(number, size);

		Arrays.sort(orderedNumber);

		for (int i = 0; i < size || numOfSector ==0; i++) {
			if (numOfSector != 1) {
				// 양끝이 아닌 경우
				int min = orderedNumber[i];
				int minIndex = Arrays.binarySearch(sumOfNumber, min);
				if (minIndex != 0 && minIndex != size - 1) {
					sumOfNumber[minIndex] = 0;
					numOfSector--;
				} else {
					// 양끝에 있는 음수일 경우
					if (orderedNumber[minIndex] < 0) {
						sumOfNumber[minIndex] = 0;
					}
				}
			}
		}

		return 0;
	}

}
