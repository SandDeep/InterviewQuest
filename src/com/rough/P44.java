package com.rough;

public class P44 {

	public static void main(String[] args) {
		char symbols[] = "TTFT".toCharArray();
		char operators[] = "|&^".toCharArray();

		P44 test = new P44();
		test.countParenth(symbols, operators, symbols.length);
	}

	private void countParenth(char[] symbols, char[] operators, int n) {
		int[][] T = new int[n][n];
		int[][] F = new int[n][n];

		for (int i = 0; i < F.length; i++) {
			F[i][i] = (symbols[i] == 'F') ? 1 : 0;
			T[i][i] = (symbols[i] == 'T') ? 1 : 0;
		}

		for (int gap =1; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; i++, j++) {
				T[i][j] = F[i][j] = 0;

				for (int g = 0; g < gap; g++) {
					int k = i + g;

					int tik = T[i][k] + F[i][k];
					int tkj = T[k+1][j] + F[k+1][j];

					if (operators[k] == '&') {
						T[i][j] += T[i][k] * T[k + 1][j];
						F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
					}
					if (operators[k] == '|') {
						T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
						F[i][j] += F[i][k] * F[k + 1][j];
					}
					if (operators[k] == '^') {
						T[i][j] += (T[i][k] * F[k + 1][j] + F[i][k]
								* T[k + 1][j]);
						F[i][j] += (F[i][k] * F[k + 1][j] + T[i][k]
								* T[k + 1][j]);

					}
				}
			}
		}
		System.out.println(T[0][n - 1]);
	}
}
