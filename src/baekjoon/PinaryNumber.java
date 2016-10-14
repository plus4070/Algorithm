package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *����
 * 0�� 1�θ� �̷���� ���� �������� �Ѵ�. �̷��� ������ �� Ư���� ������ ���� �͵��� �ִµ�, �̵���
 * ��ģ��(pinary number)�� �Ѵ�. ��ģ���� ������ ������ �����Ѵ�.
 * 
 * ��ģ���� 0���� �������� �ʴ´�. ��ģ�������� 1�� �� �� �������� ��Ÿ���� �ʴ´�. ��, 11�� �κ� ���ڿ��� ����
 * �ʴ´�. ���� ��� 1, 10, 100, 101, 1000, 1001 ���� ��ģ���� �ȴ�. ������ 0010101�̳�
 * 101101�� ���� 1, 2�� ��Ģ�� ����ǹǷ� ��ģ���� �ƴϴ�.
 * 
 * N(1��N��90)�� �־����� ��, N�ڸ� ��ģ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 *�Է� 
 * ù° �ٿ� N�� �־�����.
 * 
 * 3
 * 
 *��� 
 * ù° �ٿ� N�ڸ� ��ģ���� ������ ����Ѵ�.
 *          
 * 2
 */
public class PinaryNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		
		long[] pinaryArray = makePinaryArray(testCases);
		
		System.out.println(pinaryArray[testCases]);
		
		scan.close();
	}

	private static long[] makePinaryArray(int testCases) {
		long[] array;
		
		if(testCases < 3) {
			array = new long[3]; 
		} else {
			array = new long[testCases+1];
		}
		
		array[0] = 0;
		array[1] = 1;
		array[2] = 1;
		
		for(int i=3; i<=testCases; i++) {
			array[i] = array[i-1] + array[i-2]; 
		}
		return array;
	}
}
