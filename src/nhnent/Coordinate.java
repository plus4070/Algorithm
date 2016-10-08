package nhnent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Coordinate {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            String[] numStrList = input.split(" ");
            for (String numStr : numStrList) {
                numberList.add(Integer.parseInt(numStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        numberList.sort(new DigitComparatorASC());

        // 다음과 같은 방식으로 numberList와 number 변수를 사용할 수 있음
        String bigNumber = "";
        String smallNumber = "";
        for (Integer number : numberList) {
        	System.out.println(number);
            bigNumber += number;
        }
        System.out.println(bigNumber);
        numberList.sort(new DigitComparatorDESC());
        
        for (Integer number : numberList) {
        	smallNumber += number;
        }
        
        int total = Integer.parseInt(bigNumber) + Integer.parseInt(smallNumber);
        
//        System.out.println(total);
    }
    
    static class DigitComparatorASC implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			int number = Integer.parseInt(o1.toString()+o2.toString());
			int numberReversed = Integer.parseInt(o2.toString() + o1.toString());
			
			return (number > numberReversed) ? -1 : 1;
		}
    }
    
    static class DigitComparatorDESC implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			int number = Integer.parseInt(o1.toString()+o2.toString());
			int numberReversed = Integer.parseInt(o2.toString() + o1.toString());
			
			return (number < numberReversed) ? -1 : 1;
		}
    }
}