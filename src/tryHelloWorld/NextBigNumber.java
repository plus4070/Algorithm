package tryHelloWorld;

public class NextBigNumber {
	public int nextBigNumber(int n) {
		int target = n;
//		int answer = countNumOfOnes(target);
		int answer = Integer.bitCount(target);
		
		while(true) {
//			if(answer == countNumOfOnes(++n)) return n;
			if(answer == Integer.bitCount(++n)) return n;
		}
	}
	
//	private static int countNumOfOnes(int n) {
//		final int BI_NUMBER = 2;
//		int remain, temp, numOfOnes = 0;
//		
//		while(n != 0) {
//			temp = n/BI_NUMBER;
//			remain = n%BI_NUMBER;
//			
//			if(remain == 1){
//				numOfOnes++;
//			}
//			n = temp;
//		}
//		
//		return numOfOnes;
//	}

	public static void main(String[] args) {
		NextBigNumber test = new NextBigNumber();
		int n = 78;
		System.out.println(test.nextBigNumber(n));
	}
}
