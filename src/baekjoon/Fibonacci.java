package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *문제
 * fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
 * fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
 * 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
 * fibonacci(0)은 0을 출력하고, 0을 리턴한다.
 * fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
 * 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
 * 이 때, 1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이
 * 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 *
 *입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 구성되어있다.
 * 첫째 줄에 N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 * 
 * 3
 * 0
 * 1
 * 3
 * 
 *출력
 * 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 * 
 * 1 0
 * 0 1
 * 1 2
 * 
 */
public class Fibonacci {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int[] testCases;
		int numOfTestCase, biggestNumber = 0;

		numOfTestCase = scan.nextInt();
		testCases = new int[numOfTestCase];

		for (int i = 0; i < numOfTestCase; i++) {
			testCases[i] = scan.nextInt();
			if (testCases[i] > biggestNumber)
				biggestNumber = testCases[i];
		}
		int[][] fibonacciArray = makeFibonacciArray(biggestNumber + 1);

		for (int i = 0; i < numOfTestCase; i++) {
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

		for (int i = 2; i < size; i++) {
			for (int j = 0; j < 2; j++) {
				fibo[i][j] = fibo[i - 1][j] + fibo[i - 2][j];
			}
		}

		return fibo;
	}
}
