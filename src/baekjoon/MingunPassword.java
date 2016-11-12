package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *����
 *â���̴� �α����� ��ǻ�͸� ��ŷ�� �ؽ�Ʈ ���� �ϳ��� �ڽ��� ���Ϸ� �����ߴ�. 
 *���Ͽ��� �ܾ �� �ٿ� �ϳ��� �����־���, �� �� �ϳ��� �α��̰� �¶��� �������� ����ϴ� ��й�ȣ�̴�.
 *
 *������ ���캸�� â���̴� ��� �ܾ��� ���̰� Ȧ����� ����� �˾Ƴ�����. �׸��� ������ �α��̰�
 * �� ��Ͽ� ���ؼ� ����ߴ� ���� �����س´�. �α����� ��й�ȣ�� ��Ͽ� ���ԵǾ� ������, ��й�ȣ�� ����� �� ���ڿ��� ���ԵǾ� �ִ�.
 * 
 * ���� ���, �α����� ��й�ȣ�� "tulipan"�� ��쿡 ��Ͽ��� "napilut"�� �����ؾ� �Ѵ�.
 * �� �� ���� ������ ���� ��� ��й�ȣ�� ��� �����ϴٰ� �Ѵ�.
 * 
 * �α����� ���Ͽ� �����ִ� �ܾ ��� �־����� ��, ��й�ȣ�� ���̿� ��� ���ڸ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� �ܾ��� �� N (1 �� N �� 100)�� �־�����. ���� N�� �ٿ��� ���Ͽ� �����ִ� �ܾ �� �ٿ� �ϳ��� �־�����.
 * �ܾ�� ���ĺ� �ҹ��ڷθ� �̷���� ������, ���̴� 2���� ũ�� 14���� ���� Ȧ���̴�.
 * 
 * 4
 * las
 * god
 * psala
 * sal
 * 
 * ���
 * ù° �ٿ� ��й�ȣ�� ���̿� ��� ���ڸ� ����Ѵ�. �׻� ���� ������ ��츸 �Է����� �־�����.
 * 
 * 3 a
 */
public class MingunPassword {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String[] array = new String[num];

		for (int i = 0; i < num; i++) {
			array[i] = scan.nextLine();
		}

		findPassword(array);

		scan.close();
	}

	private static void findPassword(String[] array) {
		int len = array.length;
		
		if (len == 1) {
			System.out.println(array[0].length() + " " + array[0].charAt(array[0].length() / 2));
		} else {
			StringBuffer sb;
			for (int i = 0; i < len; i++) {
				for (int j = i; j < len; j++) {
					if (array[i].length() == array[j].length()) {
						sb = new StringBuffer(array[i]);
						if (array[j].equals(sb.reverse().toString())) {
							System.out.println(array[i].length() + " " + array[i].charAt(array[i].length() / 2));
							return ;
						}
					}
				}
			}
		}
	}
}
