package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 * 
 *���� 
 * n���� ������ ������ �ִ�. ������ ������ ��Ÿ���� ��ġ�� �ٸ���. �� �������� ������ ����ؼ�, �� ��ġ�� ����
 * k���� �ǵ��� �ϰ� �ʹ�. �� ����� ���� ���Ͻÿ�. (������ ������ �� ���� ����� �� �ִ�.)
 * 
 *�Է�
 * ù°�ٿ� n, k�� �־�����. (1 �� n �� 100, 1 �� k �� 10,000) ���� n���� �ٿ��� ������ ������
 * ��ġ�� �־�����.
 *          
 * 3 10
 * 1
 * 2
 * 5
 * 
 *���
 * ù° �ٿ� ����� ���� ����Ѵ�. ����� ���� 2^31���� �۴�.
 * 
 * 10
 *          
 */

public class Change {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int numOfCoins = scan.nextInt();
		int price = scan.nextInt();
		int[] coins = new int[numOfCoins];

		for (int i = 0; i < numOfCoins; i++) {
			coins[i] = scan.nextInt();
		}

		System.out.println(getWaysToPrice(coins, price));

		scan.close();
	}

	private static int getWaysToPrice(int[] coins, int price) {
		int len = coins.length;
		int[][] dp = new int[len][price + 1];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < price + 1; j++) {
				if (i != 0) {
					if (j < coins[i]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
					}
				} else {
					if (j % coins[i] == 0) {
						dp[i][j] = 1;
					}
				}
			}
		}

		return dp[len - 1][price];
	}
}
