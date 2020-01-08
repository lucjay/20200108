package co.lucjay.sort;

public class Sort {
	private int[] arr;

	public int[] selectionSort(int[] num, int n) { // 내림차순 소트
		int min, temp;
		arr = num;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i; // arr[i]의 요소값이 가장 작다고 전재한다.
			for (int j = i + 1; j < arr.length; j++) {
				if (n == 0) {
					if (arr[min] > arr[j]) // n=0이면 오름차순
						min = j;
				} else {
					if (arr[min] < arr[j]) // 아니면 내림차순
						min = j;
				}
			}
			if (min != i) {
				temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		return arr;
	}

	public int[] bubbleSort(int[] num, int n) { // 버블소트
		int temp = 0;
		arr = num;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (n == 0) {
					if (arr[j] > arr[j + 1]) {
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					} else {
						if (arr[i] > arr[i + 1]) {
							temp = arr[i];
							arr[i] = arr[i + 1];
							arr[i + 1] = temp;

						}
					}
				}
			}

		}
		return arr;
	}

	public int[] quickSort(int[] num) { // 퀵소트
		return arr;
	}
}
