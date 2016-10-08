package nhnent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
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
        int size = numberList.size();
        int smallestNumber = Integer.MAX_VALUE;
        int diff;
        int pointOne = 0, pointTwo = 0;
        
//        numberList.sort(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return (o1.intValue() < o2.intValue()) ? -1:(o1==o2)?0:1;
//			}
//		});
        
       List<Integer> list = numberList.stream()
        	.sorted((o1, o2) -> (o1 < o2) ? -1:(o1==o2)?0:1)
        	.collect(Collectors.toList());

        for(Integer number : list) {
        	System.out.println(number.intValue());
        }
        System.out.println();
        
//        for(int i=0; i<size-1; i++) {
//        	diff = numberList.get(i+1)-numberList.get(i);
//        	if(diff < smallestNumber) {
//        		smallestNumber = diff;
//        		pointOne = numberList.get(i);
//        		pointTwo = numberList.get(i+1);
//        	}
//        }
//        
//        System.out.println(pointOne + " " + pointTwo);
    }
    
}