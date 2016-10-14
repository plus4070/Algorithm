package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 * 
 * 문제
 *  정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 
 * X가 3으로 나누어 떨어지면, 3으로 나눈다. X가 2로 나누어 떨어지면, 2로 나눈다. 1을 뺀다. 정수 N이 주어졌을 때, 위와 같은
 * 연산 세 개를 적절히 사용해서 1을 만드려고 한다. 연산을 사용하는 횟수의 최소값을 출력하시오.
 * 
 * 입력
 *  첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 자연수 N이 주어진다. 2 10
 * 
 * 출력
 *  첫째 줄에 연산을 하는 횟수의 최소값을 출력한다. 1 3
 *****/

public class MakeAsOne {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();

		int[] xArray = makeXArray(testCases);

		System.out.println(xArray[testCases]);

		scan.close();
	}

	private static int[] makeXArray(int size) {
		int[] array;
		if (size < 4) {
			array = new int[4];
		} else {
			array = new int[size + 1];
		}

		array[0] = 0;
		array[1] = 0;
		array[2] = 1;
		array[3] = 1;

		for (int i = 4; i <= size; i++) {
			if (i % 3 == 0) {
				array[i] = 1 + Math.min(array[i / 3], array[i-1]);
			} else if (i % 2 == 0) {
				array[i] = 1 + Math.min(array[i / 2], array[i-1]);
			} else {
				array[i] = 1 + array[i - 1];
			}
		}

		return array;
	}
}
