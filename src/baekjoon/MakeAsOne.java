package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 * 
 * ����
 *  ���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.
 * 
 * X�� 3���� ������ ��������, 3���� ������. X�� 2�� ������ ��������, 2�� ������. 1�� ����. ���� N�� �־����� ��, ���� ����
 * ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּҰ��� ����Ͻÿ�.
 * 
 * �Է�
 *  ù° �ٿ� 1���� ũ�ų� ����, 106���� �۰ų� ���� �ڿ��� N�� �־�����. 2 10
 * 
 * ���
 *  ù° �ٿ� ������ �ϴ� Ƚ���� �ּҰ��� ����Ѵ�. 1 3
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
