package TryHelloWorld;

import java.util.Arrays;

class EatCookie {
    public int eatCookie(int []cookies){
        int[] dp = new int[cookies.length];
        int len = 0;

        for(int x : cookies) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            System.out.println(i);
            if(i < 0) {
            	i = -(i + 1);
            }
            dp[i] = x;
            if(i == len) {
            	len++;
            }
        }

        return len;
    }
	
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		EatCookie e = new EatCookie();
//		int[] cookies = {665, 930, 887, 246, 440, 131, 736, 397, 464, 709, 713, 894, 673, 618, 604, 431, 239, 867, 762, 528, 101, 240, 833, 879, 457, 717, 678, 82, 457, 192, 687, 663, 75, 926, 139, 564, 576, 941, 7, 906, 242, 475, 595, 133, 87, 429, 734, 402, 60, 734};
		int[] cookies = {1, 4, 2, 6, 3, 4, 1, 5};
		System.out.println(e.eatCookie(cookies));
	}
}
