package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Tower {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		Stack<Pair<Long, Long>> stack = new Stack<Pair<Long, Long>>();
		StringBuffer sb = new StringBuffer();

		for(int i=1; i<=size; i++) {
			long nextNumber = scan.nextLong();
			if(stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new Pair<Long, Long>((long)i, nextNumber));
			} else if(stack.peek().height < nextNumber) {
				stack.pop();
				while(!stack.isEmpty()) {
					if(stack.peek().height < nextNumber) {
						stack.pop();
					} else if(stack.peek().height > nextNumber) {
						break;
					}
				}
				if(stack.isEmpty()) {
					sb.append("0 ");
				} else {
					sb.append(stack.peek().index+" ");
				}
				stack.push(new Pair<Long, Long>((long)i, nextNumber));
			} else {
				sb.append(stack.peek().index+" ");
				stack.push(new Pair<Long, Long>((long)i, nextNumber));
			}
		}
		
		System.out.println(sb.toString());
		scan.close();
	}
}

class Pair<T1, T2> {
	T1 index;
	T2 height;
	
	Pair(T1 index, T2 height) {
		this.index = index;
		this.height = height;
	}
}
