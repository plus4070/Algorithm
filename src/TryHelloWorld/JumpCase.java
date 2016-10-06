package TryHelloWorld;

public class JumpCase {
	public int jumpCase(int num) {
		int answer = step(num);
		return answer;
	}
	
	private static int step(int num) {
		if(num <= 1) return 1;
		else	return step(num-1)+step(num-2);
	}
	
	public static void main(String[] args) {
		JumpCase c = new JumpCase();
		int testCase = 4;
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(c.jumpCase(testCase));
	}
}
