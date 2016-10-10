package tryHelloWorld;

import java.util.Arrays; //테스트로 출력해 보기 위한 코드입니다.

public class BestSet {

	/*
	public int[] bestSet(float n, float s) {
		int[] answer;

		if (s < n) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			float average = Math.round(s / n);
			int index = (int) n;
			float remain = s;

			answer = new int[index];

			for (int i = 0; i < index; i++) {
				answer[i] = (int) average;
				remain -= average;
				average = Math.round(remain / ((index - 1) - i));
			}
		}
		Arrays.sort(answer);
		return answer;
	}
	*/

	public int[] bestSet(int n, int s) {
		int[] answer = null;
		if (n > s) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[n];
			int i = 0;
			while (s > 0) {
				answer[(i % n)]++;
				i++;
				s--;
			}
		}
		Arrays.sort(answer);
		return answer;
	}

	public static void main(String[] args) {
		BestSet c = new BestSet();
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(Arrays.toString(c.bestSet(6, 16)));
	}

}