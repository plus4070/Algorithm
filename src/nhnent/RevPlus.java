package nhnent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevPlus {
	public static void main(String[] args) {
		int number = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine();
			number = Integer.parseInt(line);
		} catch (IOException e) {
			e.printStackTrace();
		}

		printRotateNumber(number);
		// write your code here
	}

	private static int reverseNumber(int num) {
		String strNum = num + "";
		char[] charArray = strNum.toCharArray();
		int len = charArray.length;
		String reversedNumber = "";

		for (int i = len - 1; i >= 0; i--) {
			reversedNumber += charArray[i];
		}
		return Integer.parseInt(reversedNumber);
	}
	
	private static boolean isRotatedNumber(int n) {
		boolean isRotated = true;
		String strNum = n + "";
		char[] charArray = strNum.toCharArray();
		int len = charArray.length;

		for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
			if (charArray[i] != charArray[j]) {
				isRotated = false;
			}
		}

		return isRotated;
	}
	
	private static void printRotateNumber(int n) {
		final int LIMIT = 3;
		final int NOT_REVERSED = -1;
		int times = 1;
		int num = n + reverseNumber(n);

		while (!isRotatedNumber(num) && times < LIMIT) {
			num += reverseNumber(num);
			times++;
		}
		if(times == LIMIT) {
			times = NOT_REVERSED;
		} 
		System.out.println(times);
	}
}