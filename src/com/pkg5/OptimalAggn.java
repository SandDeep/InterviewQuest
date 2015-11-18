package com.pkg5;

public class OptimalAggn {

	int CHAPTERS = 4;
	int DAYS = 3;
	int optimal_path[] = new int[DAYS + 1];
	int graph[][] = new int[CHAPTERS + 1][CHAPTERS + 1];

	public static void main(String[] args) {
		int pages[] = { 7, 5, 6, 12 };

		OptimalAggn aggn = new OptimalAggn();

		// Get read list for given days
		aggn.minAssignment(pages);
	}

	private void minAssignment(int[] pages) {
		int avgPage = 0;
		int sum = 0;
		int S[] = new int[CHAPTERS + 1];
		S[0] = 0;
		int path[] = new int[DAYS + 1];

		for (int i = 0; i < pages.length; i++) {
			sum += pages[i];
			S[i + 1] = sum;
		}

		avgPage = sum / DAYS;

		for (int i = 0; i < CHAPTERS; i++) {
			for (int j = 0; j < CHAPTERS; j++) {
				if (j <= i) {
					graph[i][j] = -1;
				} else {
					sum = Math.abs(avgPage - (S[j] - S[i]));
					graph[i][j] = sum;
				}
			}
		}

		assignChapters(0, path, 0, 0, DAYS);

		System.out.println("Optimal Chapter Assignment :");
		int ch;
		for (int i = 0; i < DAYS; i++) {
			ch = optimal_path[i];
			System.out.println("Day" + i + 1 + ": " + ch);
			ch++;
			while ((i < DAYS - 1 && ch < optimal_path[i + 1])
					|| (i == DAYS - 1 && ch <= CHAPTERS)) {
				System.out.println(ch + " ");
				ch++;
			}

		}
	}

	private void assignChapters(int u, int[] path, int path_len, int sum, int k) {
		int min = Integer.MIN_VALUE;

		// Ignore the assignment which requires more than required days
		if (k < 0)
			return;

		// Current assignment of chapters to days
		path[path_len] = u;
		path_len++;

		// Update the optimal assignment if necessary
		if (k == 0 && u == CHAPTERS) {
			if (sum < min) {
				updateAssignment(path, path_len);
				min = sum;
			}
		}

		// DFS - Depth First Search for sink
		for (int v = u + 1; v <= CHAPTERS; v++) {
			sum += graph[u][v];
			assignChapters(v, path, path_len, sum, k - 1);
			sum -= graph[u][v];
		}
	}

	private void updateAssignment(int[] path, int path_len) {
		for (int i = 0; i < path_len; i++)
			optimal_path[i] = path[i] + 1;
	}
}
