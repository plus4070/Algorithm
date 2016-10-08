package TryHelloWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Hanoi {
	List<Integer> list = new ArrayList<Integer>();
	int count = 0;
	public int[][] hanoi(int n) {
		final int LEFT_BAR = 1;
		final int MID_BAR = 2;
		final int RIGHT_BAR = 3;
		
		move(LEFT_BAR, MID_BAR, RIGHT_BAR, n);
		
		// 2차원 배열을 완성해 주세요.
		int size = list.size()/2;
		int[][] answer = new int[size][2];
		
		for(int i =0; i<size;  i++) {
			answer[i][0] = list.get(i).intValue();
			answer[i][1] = list.get(i+1).intValue();
		}
		return answer;
	}
	
	private void move(int left, int mid, int right, int n) {
		if( n == 1) {
			count++;
			list.add(left);
			list.add(right);
		} else {
			move(left, right, mid, n-1);
			list.add(left);
			list.add(right);
			count++;
			move(mid, left, right, n-1);
		}
	}
	
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Hanoi h = new Hanoi();
		System.out.println(Arrays.deepToString(h.hanoi(2)));
	}
}
