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

		System.out.println("���İ��");
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
		pivot = array[left]; // �Ǻ��� �������� �ϴ� �Ŀ� ���� ���� �ӵ��� �޶��� �� ���� ������?

		while (low < high) {

			// �տ������� �Ǻ����� ū �͵��� �ִ� �� �˻��Ѵ�.
			low++;
			while (low <= right && array[low] < pivot) {
				low++;
			}

			// �ڿ������� �Ǻ����� ���� �͵��� �ִ� �� �˻��Ѵ�.
			while (high >= left && array[high] > pivot) {
				high--;
			}

			// �տ��� �Ǻ����� ū �Ͱ� �ڿ��� �Ǻ����� ���� ���� ��ȯ�Ѵ�.
			if (low < high) {
				temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}

		// �տ������� �˻��� �Ͱ� �ڿ������� �˻��ϴ� �ε����� �����ϴ� �κп� �־��ش�.
		temp = array[left];
		array[left] = array[high];
		array[high] = temp;

		return high;
	}
}
