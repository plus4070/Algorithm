package baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author JunYoung
 *
 *
 *����
 *KOI ��ſ����Ҵ� �������� �̿��� ���ο� ��� ��� �ý��� ������ ���� ������ �ϰ� �ִ�. 
 *������ ���Ͽ� ������ ���� N���� ���̰� ���� �ٸ� ž�� ���� ������ ���ʺ��� ������ �������� ���ʷ� �����, 
 *�� ž�� ����⿡ ������ �۽ű⸦ ��ġ�Ͽ���. ��� ž�� ������ �۽ű�� ������ ��ȣ�� ��ǥ��� �����ϰ� 
 *���� ������ ���� �������� �߻��ϰ�, ž�� ��� ��ο��� ������ ��ȣ�� �����ϴ� ��ġ�� ��ġ�Ǿ� �ִ�. 
 *�ϳ��� ž���� �߻�� ������ ��ȣ�� ���� ���� ������ �� �ϳ��� ž������ ������ �����ϴ�. 
 *
 *���� ��� ���̰� 6, 9, 5, 7, 4�� �ټ� ���� ž�� ���� ������ �Ϸķ� �� �ְ�, ��� ž������ �־��� ž 
 *������ �ݴ� ����(���� ����)���� ���ÿ� ������ ��ȣ�� �߻��Ѵٰ� ����. �׷���, ���̰� 4�� �ټ� ��°
 *ž���� �߻��� ������ ��ȣ�� ���̰� 7�� �� ��° ž�� ������ �ϰ�, ���̰� 7�� �� ��° ž�� ��ȣ�� ���̰�
 *9�� �� ��° ž��, ���̰� 5�� �� ��° ž�� ��ȣ�� ���̰� 9�� �� ��° ž�� ������ �Ѵ�. ���̰� 9�� �� ��° ž��
 *���̰� 6�� ù ��° ž�� ���� ������ ��ȣ�� � ž������ ������ ���� ���Ѵ�.
 *
 *ž���� ���� N�� ž���� ���̰� �־��� ��, �� ���� ž���� �߻��� ������ ��ȣ�� ��� ž���� �����ϴ����� �˾Ƴ��� ���α׷��� �ۼ��϶�. 
 *
 *�Է�
 *ù° �ٿ� ž�� ���� ��Ÿ���� ���� N�� �־�����. N�� 1 �̻� 500,000 �����̴�. 
 *��° �ٿ��� N���� ž���� ���̰� ������ ���� ������� �ϳ��� ��ĭ�� ���̿� �ΰ� �־�����. 
 *ž���� ���̴� 1 �̻� 100,000,000 ������ �����̴�.
 *
 *5
 *6 9 5 7 4
 *
 *���
 *ù° �ٿ� �־��� ž���� ������� ������ ž�鿡�� �߻��� ������ ��ȣ�� ������ ž���� ��ȣ�� 
 *�ϳ��� ��ĭ�� ���̿� �ΰ� ����Ѵ�. ���� ������ ��ȣ�� �����ϴ� ž�� �������� ������ 0�� ����Ѵ�.
 *
 *0 0 2 2 4
 *
 */
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
