package codeGround;

import java.util.Scanner;
import java.io.FileInputStream;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class ProgrammingTest {
   
   private static int setGrade(int len, int[] array){
      int answer;
      
      quickSort(array, 0, len-1);
      
      answer = findWinableAppliers(len, array);
      
      return answer;      
   }
   
   private static int findWinableAppliers(int len, int[] array){
      int count = 1, max = array[len-1];
      
      for(int i=len-2; i>=0; i--){
         if(array[i]+len >= max){
            count++;
            max = (max > array[i]+len-i)?max:array[i]+len-i;
         }
         else
            return count;
      }
      
      return count;
   }
   
   private static void quickSort(int[] array, int start, int end){
      if(start == end)
         return ;
      int pivot = start, i, j;
      
      
      for(i=start, j=i+1; j<end; ){
         if(array[pivot] > array[j]){
            i++;
            array = swap(array, i, j);
            j++;
         }else 
            j++;
      }
      
      if(array[pivot] > array[j])
         array = swap(array, j, pivot);
      
      array = swap(array, i, pivot);
      
      quickSort(array, pivot, i);
      quickSort(array, i+1, j);
   }
   
   private static int[] swap(int[] array, int i, int j){
      int temp;
      temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      
      return array;
   }
   
   public static void main(String args[]) throws Exception   {
      int T, num, answer;
        int test_case;
        /* �Ʒ� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
           ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� �߰��ϸ�,
           �� �Ʒ����� �Է��� ������ �� ǥ�� �Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
           ���� ������ PC ���� �׽�Ʈ �� ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �˴ϴ�.
           ��, �� �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�. */
      //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
      Scanner sc = new Scanner(System.in);
        
      T = sc.nextInt();        
      for(test_case = 1; test_case <= T; test_case++) {
         //   �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
         num = sc.nextInt();
         
         if(num > 300000)
            System.exit(1);
         
         int[] applier = new int[num];
         
         for(int i=0; i<num; i++){
            applier[i] = sc.nextInt();
            if(applier[i] > 2000000)
               System.exit(1);
         }
         
         answer = setGrade(num, applier);

         //   �� �κп��� ������ ����Ͻʽÿ�.
         System.out.println("Case #" + test_case);
         System.out.println(answer);
         
      }
   }
}