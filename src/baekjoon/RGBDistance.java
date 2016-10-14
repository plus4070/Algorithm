package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 * 
 * 문제
 *  RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는
 * 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이다. 처음 집과 마지막 집은 이웃이 아니다.
 * 
 * 각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠할 때 드는 비용의
 * 최솟값을 구하는 프로그램을 작성하시오.
 * 
 * 입력 
 *  첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로
 *  칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.
 * 
 * 3
 * 26 40 83
 * 49 60 57
 * 13 89 99
 * 
 * 출력 
 *  첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.
 * 
 * 96
 *
 */
public class RGBDistance {
	public static final int R = 0;
	public static final int G = 1;
	public static final int B = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N < 1 || N > 1000) {
			sc.close();
			return;
		}

		int[][] result = new int[3][N];
		int r, g, b;

		result[R][0] = sc.nextInt();
		result[G][0] = sc.nextInt();
		result[B][0] = sc.nextInt();

		for (int i = 1; i < N; i++) {
			r = sc.nextInt();
			g = sc.nextInt();
			b = sc.nextInt();

			result[R][i] = r + Math.min(result[G][i - 1], result[B][i - 1]);
			result[G][i] = g + Math.min(result[R][i - 1], result[B][i - 1]);
			result[B][i] = b + Math.min(result[R][i - 1], result[G][i - 1]);
		}

		int min = Math.min(Math.min(result[R][N - 1], result[G][N - 1]), result[B][N - 1]);
		System.out.println(min);

		sc.close();
	}
}
