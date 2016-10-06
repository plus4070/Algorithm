package TryHelloWorld;

public class Caesar {
	public String caesar(String s, int n) {
		String result = "";
		int len = s.length();
		// �Լ��� �ϼ��ϼ���.
		
		for(int i=0; i<len; i++) {
			char asciiChar = s.charAt(i);
			if(asciiChar != ' ') {
				asciiChar = charToCaesarChar(asciiChar);
			}
			result += asciiChar;
		}

		return result;
	}
	
	private char charToCaesarChar(char c) {
		if(65 <= (int)c && 90 >= (int)c) {
			return (char)(((int)c + 4)%90+64);
		} else if(97 <= (int)c && 122 >= c) {
			return (char)(((int)c + 4)%122+96);
		} else {
			return ' ';
		}
	}

	public static void main(String[] args) {
		Caesar c = new Caesar();
		System.out.println("s�� 'a B z', n�� 4�� ���: " + c.caesar("a B z", 4));
	}
}