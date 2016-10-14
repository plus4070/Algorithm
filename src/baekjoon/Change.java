package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 * 
 *문제 
 * n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전들을 적당히 사용해서, 그 가치의 합이
 * k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. (각각의 동전은 몇 개라도 사용할 수 있다.)
 * 
 *입력
 * 첫째줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의
 * 가치가 주어진다.
 *          
 * 3 10
 * 1
 * 2
 * 5
 * 
 *출력
 * 첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.
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
