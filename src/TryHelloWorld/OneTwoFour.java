package TryHelloWorld;

class OneTwoFour {
	public String change124(int k){
		if(k<=3)
			return change(k);
		else 
			return change124(k/3) + change(k%3);
	}
	
	public String change(int k){
		if(k%3 == 0){
			return "4";
		} else {
			return String.valueOf(k);
		}
	}

	// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
	public static void main(String[] args) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		System.out.println(oneTwoFour.change124(28));
	}
}
