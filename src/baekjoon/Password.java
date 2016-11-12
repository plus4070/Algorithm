package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 * ����
 * Vigenere cipher�̶�� ��ȣȭ ����� ��ȣȭ�Ϸ��� ���� (��)�� �ܾ�� ��ȣȭ Ű�� ���ڷ� �ٲ� ����, 
 * ���� �ܾ �ش��ϴ� ���ڿ� ��ȣ Ű�� �ش��ϴ� ���ڸ� ���ϴ� ����̴�. �� ����� �����Ͽ� ���� �ܾ 
 * ��ȣȭ Ű�� �ش��ϴ� ���ڸ� ���� ��ȣȭ�ϴ� ����� ������ ����.
 * 
 * ���� ��� ��ȣȭ Ű�� love�̰�, ��ȣȭ�� ������ ��nice day�� ��� ������ ���� ��ȣȭ�� �̷������.
 * 
 * 
 * 
 * ���õ� ���� ù ��° ������ ��n���� �ش� ��ȣȭ Ű ��l���� ���ĺ� ������ 12 �̹Ƿ� ���ĺ����� 
 * �������� ��n������ 12���� ������ ��b���� �����ȴ�.
 * 
 * ������ ���ڰ� ��a' ������ ���ڰ� �Ǹ� ���ĺ� �󿡼� �� �ڷ� ������ ������. ���� ��� ���� 
 * �� ��° �����Ρ�c���� ���ĺ� �󿡼� 3 ��°�̰� �����ϴ� ��ȣȭŰ ��v'�� ���ĺ� ���� 22�� ��c'���� 
 * 22 ������ ���� ��a'���� �ξ� ���� �����̾�� �ϴµ�, ��a������ ���ڰ� �����Ƿ� ��z���� ���ư� �ݺ��Ǿ�
 * ��g���� �ȴ�. �� ���� ���ڸ� ��ȣȭŰ�� ���ڰ� ���ĺ� �󿡼� �����ϴ� ������ŭ ������ �� ������ ��ȣȭ�Ѵ�.
 * 
 * ���� ���ڰ� ���� ������ ���� �� ���� ���ڸ� �״�� ����Ѵ�.
 * 
 * �̿� ���� ��ȣȭ�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� ����, ��° �ٿ� ��ȣȭ Ű�� �־�����.
 * 
 * ���� ���ĺ� �ҹ��ڿ� ���鹮��(space)�� ��  �����Ǹ�, ��ȣȭ Ű�� ���ĺ� �ҹ��ڸ����� �����ȴ�. 
 * ���� ���̴� ������� �����ؼ� 30000�� �����̴�.
 *
 * nice day
 * love
 * 
 * ���
 * ù ��° �ٿ� ��ȣ���� ����Ѵ�.
 * 
 * btgz oet 
 */
public class Password {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String normalWord = scan.nextLine();
		String secretWord = scan.nextLine();
		
		printSecretWord(normalWord, secretWord);
		
		scan.close();
	}

	private static void printSecretWord(String normalWord, String secretWord) {
		char[] normalArray = normalWord.toCharArray();
		char[] secretArray = secretWord.toCharArray();
		int len = normalArray.length;
		int sLen = secretArray.length;
		char[] changedArray = new char[len];
		
		for(int i=0; i<len; i++) {
			if(normalArray[i] == ' ') {
				changedArray[i] = normalArray[i];
			}else if(normalArray[i] > secretArray[i%sLen]) {
				changedArray[i] = (char) (normalArray[i] - secretArray[i%sLen] + 96);
			} else {
				changedArray[i] = (char) (normalArray[i] - secretArray[i%sLen] + 122);
			}
			System.out.print(changedArray[i]);
		}
	}
}
