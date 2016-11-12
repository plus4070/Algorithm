package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author JunYoung
 *
 *문제
 *어떤 수식이 주어졌을 때, 괄호를 제거해서 나올 수 있는 서로 다른 식의 개수를 계산하는 프로그램을 작성하시오.
 *
 *이 수식은 괄호가 올바르게 쳐져 있다. 예를 들면, 1+2, (3+4), (3+4*(5+6))와 같은 식은 괄호가 서로 쌍이 맞으므로 올바른 식이다.
 *
 *하지만, 1+(2*3, ((2+3)*4 와 같은 식은 쌍이 맞지 않는 괄호가 있으므로 올바른 식이 아니다.
 *
 *괄호를 제거할 때는, 항상 쌍이 되는 괄호끼리 제거해야 한다.
 *
 *예를들어 (2+(2*2)+2)에서 괄호를 제거하면, (2+2*2+2), 2+(2*2)+2, 2+2*2+2를 만들 수 있다. 하지만, 
 *(2+2*2)+2와 2+(2*2+2)는 만들 수 없다. 그 이유는 쌍이 되지 않는 괄호를 제거했기 때문이다.
 *
 *어떤 식을 여러 쌍의 괄호가 감쌀 수 있다.
 *
 *입력
 *첫째 줄에 음이 아닌 정수로 이루어진 수식이 주어진다. 이 수식은 괄호가 올바르게 쳐져있다. 
 *숫자, '+', '*', '-', '/', '(', ')'로만 이루어져 있다. 수식의 길이는 최대 200이고, 괄호 쌍은 적어도 1개, 많아야 10개이다.
 *
 *(0/(0))
 *
 *출력
 *올바른 괄호 쌍을 제거해서 나올 수 있는 서로 다른 식을 사전 순으로 출력한다.
 *
 *(0/0)
 *0/(0)
 *0/0
 */
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
