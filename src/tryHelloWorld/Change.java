package tryHelloWorld;

class Change {
	// public int change(int total, int[] coins) {
	// int map[][] = new int[coins.length][total + 1];
	//
	// for (int i = 0; i < total + 1; i++) {
	// if (i == 0)
	// map[0][i] = 1;
	// else {
	// if (i - coins[0] < 0)
	// map[0][i] = 0;
	// else
	// map[0][i] = map[0][i - coins[0]];
	// }
	// }
	//
	// for (int i = 1; i < coins.length; i++) {
	// for (int j = 0; j < total + 1; j++) {
	// if (j == 0)
	// map[i][j] = 1;
	// else {
	// int k = j - coins[i];
	// if (k < 0)
	// map[i][j] = map[i - 1][j];
	// else
	// map[i][j] = map[i - 1][j] + map[i][k];
	//
	// }
	// }
	// }
	//
	// return map[coins.length - 1][total];
	// }

	public int counting(int remain, int[] coins, int index) {
		if (remain < 0)
			return 0;
		if (remain == 0)
			return 1;
		if (index == coins.length && remain > 0)
			return 0;
		return counting(remain - coins[index], coins, index) + counting(remain, coins, index + 1);
	}

	public int change(int total, int[] coin) {
		return counting(total, coin, 0);
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Change c = new Change();
		int[] coins = { 1, 2, 5 };
		System.out.println(c.change(5, coins));
	}
}
