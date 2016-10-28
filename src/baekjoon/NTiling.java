package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *����
 *2��n ���簢���� 2��1�� 2��2 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *
 *�Ʒ� �׸��� 2��17 ���簢���� ä�� �Ѱ��� ���̴�.
 *
 *
 *�Է�
 *ù° �ٿ� n�� �־�����. (1 �� n �� 1,000)
 *
 *2
 *
 *8
 *
 *12
 *
 *���
 *ù° �ٿ� 2��n ũ���� ���簢���� ä��� ����� ���� 10,007�� ���� �������� ����Ѵ�.
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
