package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *����
 * fibonacci(3)�� ȣ���ϸ� ������ ���� ���� �Ͼ��.
 * fibonacci(3)�� fibonacci(2)�� fibonacci(1) (ù ��° ȣ��)�� ȣ���Ѵ�.
 * fibonacci(2)�� fibonacci(1) (�� ��° ȣ��)�� fibonacci(0)�� ȣ���Ѵ�.
 * �� ��° ȣ���� fibonacci(1)�� 1�� ����ϰ� 1�� �����Ѵ�.
 * fibonacci(0)�� 0�� ����ϰ�, 0�� �����Ѵ�.
 * fibonacci(2)�� fibonacci(1)�� fibonacci(0)�� ����� ���, 1�� �����Ѵ�.
 * ù ��° ȣ���� fibonacci(1)�� 1�� ����ϰ�, 1�� �����Ѵ�.
 * fibonacci(3)�� fibonacci(2)�� fibonacci(1)�� ����� ���, 2�� �����Ѵ�.
 * �� ��, 1�� 2�� ��µǰ�, 0�� 1�� ��µȴ�. N�� �־����� ��, fibonacci(N)�� ȣ������ ��, 0�� 1��
 * ���� �� �� ��µǴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *
 *�Է�
 * ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� ������ ���� �����Ǿ��ִ�.
 * ù° �ٿ� N�� �־�����. N�� 40���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
 * 
 * 3
 * 0
 * 1
 * 3
 * 
 *���
 * �� �׽�Ʈ ���̽����� 0�� ��µǴ� Ƚ���� 1�� ��µǴ� Ƚ���� �������� �����ؼ� ����Ѵ�.
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
