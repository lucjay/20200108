package co.lucjay.sort;

public class MainApp {

	public static void main(String[] args) {

		Rank rank = new Rank();
		int[] result;
		int[] sungjuk = { 90, 40, 100, 100, 80, 70, 90 };
		rank.run(sungjuk);

		Sort sort = new Sort();
		result = sort.selectionSort(sungjuk, 0);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		System.out.println("버블버블팝팝");
		result = sort.bubbleSort(sungjuk, 1);
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[j] + " ");
		}

	}

}
