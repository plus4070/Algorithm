package tryHelloWorld;

import java.util.Arrays;

class LineCombination {
	public int[] setAlign(int n, long k) {
		k--;
		int[] answer = new int[n];
		int[] factorial = getFactorialArray(n);
		int portion;
		for(int i=0; i<n; i++) {
			answer[i] = (i+1);
		}
		
		if(k != 0) {
			for(int i=n-1, j = 0; i>=0; i--, j++){
				portion = (int)k/factorial[i];
				k = (int)k%factorial[i];
				if(portion > 0) {
					int temp = answer[j];
					answer[j] = answer[j+portion];
					answer[j+portion] = temp;
				}
			}
		}
		
		return answer;
	}
	
	private int[] getFactorialArray(int n) {
		int[] array = new int[n+1];
		
		array[0] = 1;
		array[1] = 1;
		array[2] = 2;
		
		if(n >= 3) {
			for(int i=3; i<=n; i++) {
				array[i] = array[i-1] * i;
			}
		}
		return array;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(3, 5)));
	}
}
