package baekjoon;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int[] testCases;
		int numOfTestCase, biggestNumber = 0;
		
		numOfTestCase = scan.nextInt();
		testCases = new int[numOfTestCase];
		
		for(int i=0; i<numOfTestCase; i++) {
			testCases[i] = scan.nextInt();
			if(testCases[i] > biggestNumber) biggestNumber = testCases[i];
		}
		int[][] fibonacciArray = makeFibonacciArray(biggestNumber+1);
		
		for(int i=0; i<numOfTestCase; i++) {
			System.out.println(fibonacciArray[testCases[i]][0] + " " + fibonacciArray[testCases[i]][1]);
		}
		scan.close();
	}

	private static int[][] makeFibonacciArray(int size) {
		int[][] fibo = new int[size][2];
		
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		
		for(int i=2; i<size; i++) {
			for(int j=0; j<2; j++) {
				fibo[i][j] = fibo[i-1][j] + fibo[i-2][j];
			}
		}
		
		return fibo;
	}
}
