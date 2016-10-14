package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung 
 * 
 *����
 * ȿ�ִ� ������ �ý�ȸ�� ����. �� ���� ������, ���̺� ���� �پ��� �����ְ� ����ִ� ������ ����
 * �Ϸķ� ���� �־���. ȿ�ִ� ������ �ý��� �Ϸ��� �ϴµ�, ���⿡�� ������ ���� �� ���� ��Ģ�� �ִ�.
 * 
 * ������ ���� �����ϸ� �� �ܿ� ����ִ� �����ִ� ��� ���ž� �ϰ�, ���� �Ŀ��� ���� ��ġ�� �ٽ� ���ƾ� �Ѵ�. ��������
 * ���� �ִ� 3���� ��� ���� ���� ����. ȿ�ִ� �� �� �ִ� ��� ���� ���� �����ָ� ������ ���ؼ� � ������ ����
 * �����ؾ� ���� ����ϰ� �ִ�. 1���� n������ ��ȣ�� �پ� �ִ� n���� ������ ���� ������� ���̺� ���� ���� �ְ�, ��
 * ������ �ܿ� ����ִ� �������� ���� �־����� ��, ȿ�ָ� ���� ���� ���� ���� �����ָ� ���� �� �ֵ��� �ϴ� ���α׷���
 * �ۼ��Ͻÿ�.
 * 
 * ���� ��� 6���� ������ ���� �ְ�, ������ �ܿ� ������� 6, 10, 13, 9, 8, 1 ��ŭ�� �����ְ� ��� ���� ��,
 * ù ��°, �� ��°, �� ��°, �ټ� ��° ������ ���� �����ϸ� �� ������ ���� 33���� �ִ�� ���� �� �ִ�.
 * 
 *�Է�
 * ù° �ٿ� ������ ���� ���� n�� �־�����. (1��n��10,000) ��° �ٺ��� n+1��° �ٱ��� ������ �ܿ� ����ִ�
 * �������� ���� ������� �־�����. �������� ���� 1,000 ������ �����̴�.
 * 
 * 6
 * 6
 * 10
 * 13
 * 9
 * 8
 * 1
 * 
 *���
 * ù° �ٿ� �ִ�� ���� �� �ִ� �������� ���� ����Ѵ�.
 * 
 * 33
 * 
 */
public class WineTaste {
	public static void main(String args[]) {
		Scanner scan =new Scanner(System.in);
		int numOfCups = scan.nextInt();
		int[] wines = new int[numOfCups+1];
		
		for(int i=1; i<=numOfCups; i++) {
			wines[i] = scan.nextInt();
		}
		
		System.out.println(drinkMuchWine(wines, numOfCups));
		
		scan.close();
		
	}

	private static int drinkMuchWine(int[] wines, int numOfCups) {
		int total = 0;
		if(numOfCups==1) {
			return wines[1];
		}
		int[] dp = new int[numOfCups+1];
		
		dp[1] = wines[1];
		dp[2] = wines[1]+wines[2];
		
		for (int i = 3; i <= numOfCups; i++) {
			total = Math.max(wines[i]+dp[i-2], dp[i-1]);
			dp[i] = Math.max(total, wines[i]+wines[i-1]+dp[i-3]);
		}

		return dp[numOfCups];
	}
}
