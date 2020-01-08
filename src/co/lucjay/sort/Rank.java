package co.lucjay.sort;

public class Rank {
	private int[] score;
	private int[] rank;

	private void arrayInit(int[] num) { // 순위를 구하기 위한배열 초기화
		score = new int[num.length];
		rank = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			score[i] = num[i];
			rank[i] = 1;
		}
	}

	private void rankAlgorithm() {
		for (int i = 0; i < score.length; i++) {
			for (int j = i + 1; j < score.length; j++) { // 실제순위 결정 시작
				if (score[i] < score[j])
					rank[i]++;
				else if (score[i] > score[j])
					rank[j]++;
			} // 순위 결정 끝
		}
	}

	private void toPrint() {
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i] + " " + rank[i]);
		}
	}

	public void run(int[] outNum) {
		arrayInit(outNum);
		rankAlgorithm();
		toPrint();

	}
}
