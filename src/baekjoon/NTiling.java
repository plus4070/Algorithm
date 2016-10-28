package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *문제
 *2×n 직사각형을 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 *아래 그림은 2×17 직사각형을 채운 한가지 예이다.
 *
 *
 *입력
 *첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 *
 *2
 *
 *8
 *
 *12
 *
 *출력
 *첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *
 *3
 *
 *171
 *
 *2731
 *
 */
public class NTiling {
	static final int MOD = 10007;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int targetNum = scan.nextInt();
		
		System.out.println(make2NTiling(targetNum));
		
		
		scan.close();
	}

	private static int make2NTiling(int targetNum) {
		int[] dp = new int[targetNum+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=targetNum; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2) % MOD;
		}
		
		return dp[targetNum];
	}

}
