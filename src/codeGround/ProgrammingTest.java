package codeGround;

import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

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
        /* 아래 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
           만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 추가하면,
           그 아래에서 입력을 수행할 때 표준 입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
           따라서 본인의 PC 에서 테스트 할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 됩니다.
           단, 이 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다. */
      //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
      Scanner sc = new Scanner(System.in);
        
      T = sc.nextInt();        
      for(test_case = 1; test_case <= T; test_case++) {
         //   이 부분에서 알고리즘 프로그램을 작성하십시오.
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

         //   이 부분에서 정답을 출력하십시오.
         System.out.println("Case #" + test_case);
         System.out.println(answer);
         
      }
   }
}