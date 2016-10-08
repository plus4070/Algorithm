package nhnent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {
    public static void main(String[] args) {
        String[] words = null;
        Pattern vowelPattern = Pattern.compile("[aeiou]{2}");
        Pattern consonantPattern = Pattern.compile("[a-z&&[^aeiou]]{3}");
        Matcher matcher;
        int vowelNumber = 0;
        int consonantNumber = 0;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 다음과 같은 방식으로 words와 word 변수를 사용할 수 있음
        for (String word : words) {
        	matcher = vowelPattern.matcher(word);
        	if(matcher.find()) {
        		vowelNumber++;
        	}
        	matcher = consonantPattern.matcher(word);
        	if(matcher.find()) {
        		consonantNumber++;
        	}
        }
        
        System.out.println(vowelNumber);
        System.out.println(consonantNumber);
    }
}