package sample;

public class Fibonacci {
	public long fibonacci(int n) {
		final int FIRST_INDEX = 0;
		final int SECOND_INDEX = 1;
		long result;
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		long[] fibonacciArray = new long[n+1];
		
		fibonacciArray[FIRST_INDEX] = 0;
		fibonacciArray[SECOND_INDEX] = 1;
		
		for(int i=2; i<=n; i++) {
			fibonacciArray[i] = fibonacciArray[i-1] + fibonacciArray[i-2];
		}
		
		result = fibonacciArray[n];
		
		return result;
	}
	
	public static void main(String args[]) {
		Fibonacci fibo = new Fibonacci();
		
		System.out.println(fibo.fibonacci(46));
	}
}
