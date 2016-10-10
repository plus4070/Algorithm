package tryHelloWorld;

class GetMinSum {
	public int getMinSum(int[] A, int[] B) {
		int r = A.length, c = B.length;
		int answer = 0;
		
		for(int i=0, j=c-1; i<r; i++, j--) {
			answer += A[i] * B[j];
		}
		
		return answer;
	}

	public static void main(String[] args) {
		GetMinSum test = new GetMinSum();
		int[] A = { 1, 2 };
		int[] B = { 3, 4 };
		System.out.println(test.getMinSum(A, B));
	}
}