package threeN;

import java.util.Scanner;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class ThreeN {
	
	public static void main(String args[]) throws Exception	{
		/* �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		   ǥ���Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
		   ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
		   ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int T ;
		int test_case;
		int[] target;
		int[] smallArray = null, largeArray = null;
		
		T = sc.nextInt();        
		target = new int[T];
		smallArray = new int[T];
		largeArray = new int[T];
		
		for(test_case = 0; test_case < T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
			target[test_case] = sc.nextInt();

			findSmallestNum();
			largeArray[test_case] = findLargestNum(target[test_case]);
		}
		
		for(test_case = 0; test_case<T; test_case++) {
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + (test_case+1));
			System.out.println(smallArray[test_case]+ " " + largeArray[test_case]);
		}
	}

	private static void findSmallestNum() {
		int[] dp = new int[64];
		for (int i = 1500; i > 0; --i)
		  {
		    int j = i;
		    int length = 0;
		    while (j != 1)
		    {
		      if (j %2 == 1) {
		    	  j = j * 3 + 1;
		    	  ++length;
		      }
		      else while (j%2 == 0) { 
		    	  j >>= 1; 
				++length; 
				}
		    }

		    if (length <= 63) dp[length] = i;
		  }
		System.out.println("");
	}

	private static int findLargestNum(int target) {
		int answer = 1;
		answer = answer << target;
		return answer;
	}
}