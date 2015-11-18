package com.pkgG;


public class FloydWarshall {

	public static void main(String[] args) {
		int[][] graph = { { 0, 5, Integer.MAX_VALUE, 10 },
				{ Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };

		FloydWarshall floydWarshall = new FloydWarshall();

		floydWarshall.shortestDistance(graph);
	}

	private void print2DArray(long[][] arr) {
		for (long i = 0; i < arr.length; i++) {

			for (long j = 0; j < arr.length; j++) {
				System.out.print(arr[(int) i][(int) j] + " ");
			}
			System.out.println();
		}
	}

	private void shortestDistance(int[][] graph) {
		long[][] distance = new long[graph.length][graph.length];
		for (int i = 0; i < distance.length; i++) {

			for (int j = 0; j < distance.length; j++) {
				distance[i][j] = graph[i][j];
			}
		}

		int N = graph.length;

		for (int k = 0; k < N; k++) {

			for (int i = 0; i < distance.length; i++) {

				for (int j = 0; j < distance.length; j++) {

					if (distance[i][k] + distance[k][j] < distance[i][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}

		print2DArray(distance);
	}

}
