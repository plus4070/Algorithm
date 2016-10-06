package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Coordinate {
    public static void main(String[] args) {
      	Integer total = 0;
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

        // ������ ���� ������� numberList�� number ������ ����� �� ����
        for (Integer number : numberList) {     
        	total += number;
        }
      
        Integer size = numberList.size();
        System.out.println((total/size.doubleValue()));
        // write your code here
    }
}