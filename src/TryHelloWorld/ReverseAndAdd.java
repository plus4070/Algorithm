package TryHelloWorld;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReverseAndAdd {
	public static void main(String args[]) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			int num = Integer.parseInt(br.readLine());
			int[] numberArray = new int[num];

			for (int i = 0; i < num; i++) {
				numberArray[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 0; i < num; i++) {
				printRotateNumber(numberArray[i]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int reverseNumber(int num) {
		String strNum = num + "";
		char[] charArray = strNum.toCharArray();
		int len = charArray.length;
		String reversedNumber = "";

		for (int i = len - 1; i >= 0; i--) {
			reversedNumber += charArray[i];
		}
		return Integer.parseInt(reversedNumber);
	}

	public static void printRotateNumber(int n) {
		int times = 1;
		int num = n + reverseNumber(n);

		while (!isRotatedNumber(num)) {
			num += reverseNumber(num);
			times++;
		}
		System.out.println(times + " " + num);
	}

	public static boolean isRotatedNumber(int n) {
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
}
