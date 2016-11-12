package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Octal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String binaryString = scan.nextLine();
		
		System.out.println(changeBinaryToOctal(binaryString));
		
		
		scan.close();
	}

	private static String changeBinaryToOctal(String binaryString) {
		String fullBinaryString = appendZero(binaryString);
		StringBuffer sb = new StringBuffer();
		Map<String, String> changeMap = makeChangeMap();
		int len = fullBinaryString.length();
		
		for(int i=3; i<=len; i+=3) {
			String temp = fullBinaryString.substring(i-3, i);
			sb.append(changeMap.get(temp));
		}
		
		return sb.toString();
	}

	private static Map<String, String> makeChangeMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("000", "0");
		map.put("001", "1");
		map.put("010", "2");
		map.put("011", "3");
		map.put("100", "4");
		map.put("101", "5");
		map.put("110", "6");
		map.put("111", "7");
		
		return map;
	}

	private static String appendZero(String binaryString) {
		int len = binaryString.length();
		
		if(len % 3 == 0) {
			return binaryString;
		} else if(len % 3 == 1) {
			return "00"+binaryString;
		} else {
			return "0"+binaryString;
		}
	}

}
