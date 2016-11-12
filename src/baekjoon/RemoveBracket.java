package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class RemoveBracket {
	static final char OPEN_BRACET = '(';
	static final char CLOSE_BRACKET = ')';
	
	static Set<String> set;
	static List<IntPair<Integer, Integer>> bracketList;
	static int[] bracketApply;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String question = scan.nextLine();
		set = new TreeSet<String>();
		bracketList = makePairList(question);
		bracketApply = new int[bracketList.size()];

		printQuestion(question, 0);
		set.remove(question);
		
		set.forEach(string->{
			System.out.println(string.toString());
		});
		
		scan.close();
	}

	private static void printQuestion(String question, int depth) {
		int size = bracketList.size();
		if(depth == size) {
			makeString(question);
			return ;
		}
		
		bracketApply[depth] = 0;
		printQuestion(question, depth+1);
		
		bracketApply[depth] = 1;
		printQuestion(question, depth+1);
	}
	
	//주어진 문자열에서 괄호의 인덱스를 찾고  List에 시작과 끝의 인덱스를 Pair로 저장
	private static List<IntPair<Integer, Integer>> makePairList(String question) {
		List<IntPair<Integer, Integer>> list = new ArrayList<IntPair<Integer, Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		int len = question.length();
		
		for(int i=0; i<len; i++) {
			char temp = question.charAt(i);
			if(temp == OPEN_BRACET) {
				stack.push(i);
			} else if(temp == CLOSE_BRACKET) {
				int start = stack.pop();
				int end = i;
				
				list.add(new IntPair<Integer, Integer>(start, end));
			}
		}
		
		return list;
	}
	
	//제약조건을 적용시켜 괄호를 제거한 문자열을 만듦
	private static void makeString(String question) {
		int size = bracketApply.length;
		char[] arr = question.toCharArray();
		int len = arr.length;
		
		for(int i=0; i<size; i++) {
			if(bracketApply[i] == 0) {
				for(int j=0; j<len; j++) {
					if(j == bracketList.get(i).start || j == bracketList.get(i).end) {
						arr[j] = '_';
						continue;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<len; i++) {
			if(arr[i] != '_') {
				sb.append(arr[i]);
			}
		}
		
		set.add(sb.toString());
	}
}

class IntPair<T1, T2> {
	T1 start;
	T2 end;
	
	public IntPair(T1 start, T2 end) {
		this.start = start;
		this.end = end;
	}
}
