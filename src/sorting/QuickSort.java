package sorting;

import java.util.Random;

public class QuickSort {
	public static void main(String args[]) {
		final int ARRAY_SIZE = 10;

		int[] array = new int[ARRAY_SIZE];
		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
		quickSorting(array, 0, array.length - 1);

		System.out.println("정렬결과");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void quickSorting(int[] array, int head, int tail) {
		if (head < tail) {
			int pivotIndex = partition(array, head, tail);

			quickSorting(array, head, pivotIndex - 1);
			quickSorting(array, pivotIndex + 1, tail);
		}
	}

	public static int partition(int[] array, int left, int right) {
		int pivot, temp;
		int low, high;

		low = left;
		high = right;
		pivot = array[left]; // 피봇을 무엇으로 하는 냐에 따라 정렬 속도가 달라질 수 있지 않을까?

		while (low < high) {

			// 앞에서부터 피봇보다 큰 것들이 있는 지 검사한다.
			low++;
			while (low <= right && array[low] < pivot) {
				low++;
			}

			// 뒤에서부터 피봇보다 작은 것들이 있는 지 검사한다.
			while (high >= left && array[high] > pivot) {
				high--;
			}

			// 앞에서 피봇보다 큰 것과 뒤에서 피봇보다 작은 것을 교환한다.
			if (low < high) {
				temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}

		// 앞에서부터 검사한 것과 뒤에서부터 검사하는 인덱스가 교차하는 부분에 넣어준다.
		temp = array[left];
		array[left] = array[high];
		array[high] = temp;

		return high;
	}
}
