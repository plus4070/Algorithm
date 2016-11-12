package baekjoon;

import java.util.Scanner;

public class NTiling2 {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		
		System.out.println(findTilingSize(size));
		
		scan.close();
	}

	private static int findTilingSize(int size) {
		final int MOD = 10007;
		int[] dp = new int[size+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=size; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%MOD;
		}
		
		return dp[size];
	}
}
