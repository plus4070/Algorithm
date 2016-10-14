package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *         ����
 *          ������ �׸��� ���� �ﰢ���� ���� ������� ������ �ִ�. ù �ﰢ���� ���ﰢ������ ���� ���̴� 1�̴�. �� ��������
 *          ������ ���� �������� ���ﰢ���� ��� �߰��Ѵ�. �������� ���� �� ���� ���̸� k�� ���� ��, �� ���� ���̰� k��
 *          ���ﰢ���� �߰��Ѵ�.
 * 
 *          �ĵ��� ���� P(N)�� ������ �ִ� ���ﰢ���� ���� �����̴�. P(1)���� P(10)���� ù 10�� ���ڴ� 1, 1, 1,
 *          2, 2, 3, 4, 5, 7, 9�̴�.
 * 
 *          N�� �־����� ��, P(N)�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 *         �Է�
 *          ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, N�� �־�����. (1 ��  N �� 100)
 *          
 *          2
 *          6
 *          12 
 * 
 *         ���
 *          �� �׽�Ʈ ���̽� ���� P(N)�� ����Ѵ�.
 *          
 *          3
 *          16
 *          
 */
public class PadobanNumber {
	static final int ARRAY_MAX_SIZE = 100;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		int[] lenOfTriangle = new int[testCase];

		for (int i = 0; i < testCase; i++) {
			lenOfTriangle[i] = scan.nextInt();
		}

		long[] numOfPadoban = makePadobanArray(testCase);

		for (int i = 0; i < testCase; i++) {
			System.out.println(numOfPadoban[lenOfTriangle[i]]);
		}

		scan.close();
	}

	private static long[] makePadobanArray(int testCase) {
		long[] array = new long[ARRAY_MAX_SIZE + 1];

		array[1] = 1;
		array[2] = 1;
		array[3] = 1;
		array[4] = 2;
		array[5] = 2;

		for (int i = 6; i <= ARRAY_MAX_SIZE; i++) {
			array[i] = array[i - 1] + array[i - 5];
		}

		return array;
	}

}
