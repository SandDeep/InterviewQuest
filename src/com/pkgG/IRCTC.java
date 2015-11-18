package com.pkgG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IRCTC {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		IRCTC irctc = new IRCTC();

		for (int i = 0; i < t; i++) {
			String[] arr = br.readLine().split("\\s+");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);

			int[][] graph = new int[N + 1][N + 1];
			for (int j = 0; j < K; j++) {
				String[] path = br.readLine().split("\\s+");
				irctc.addNode(graph, path, j);
			}
			String[] dest = br.readLine().split("\\s+");
			int A = Integer.parseInt(dest[0]);
			int B = Integer.parseInt(dest[1]);
			int C = Integer.parseInt(dest[2]);

			int[] sptSet = new int[N + 1];
			int[] parent = new int[N + 1];
			int[] distance = new int[N + 1];

			for (int j = 0; j <= N; j++) {
				sptSet[j] = 0;
				parent[j] = -1;
				distance[j] = Integer.MAX_VALUE;
			}

			boolean status = false;
			status = irctc.solveDijkstra(graph, sptSet, parent, distance, A, B);

			if (!status) {
				System.out.println("No Train Found.");
				continue;
			}
			int[] temp = new int[parent.length];
			int[] pathArr = new int[parent.length];

			int start = 0;
			int end = 0;
			int totalDistance = 0;

			int pathLength = irctc.storePath(parent, A, B, temp);
			totalDistance += distance[B];

			end = pathLength;
			irctc.trackPath(pathArr, temp, start, end);

			start = end - 1;

			for (int j = 0; j <= N; j++) {
				sptSet[j] = 0;
				parent[j] = -1;
				distance[j] = Integer.MAX_VALUE;
			}

			status = irctc.solveDijkstra(graph, sptSet, parent, distance, B, C);

			if (!status) {
				System.out.println("No Train Found.");
				continue;
			}
			totalDistance += distance[C];
			pathLength = irctc.storePath(parent, B, C, temp);
			end = pathLength;
			irctc.trackPath(pathArr, temp, start, end);

			System.out.println(totalDistance);
			printArray(pathArr);
		}
	}

	private static void printArray(int[] pathArr) {
		for (int i = 0; i < pathArr.length; i++) {
			if (pathArr[i] == 0) {
				break;
			}
			System.out.print(pathArr[i] + " ");
		}
	}

	private void trackPath(int[] pathArr, int[] temp, int start, int end) {

		for (int i = 0; i < end; i++) {
			pathArr[start++] = temp[i];
		}
	}

	private int storePath(int[] parent, int a, int b, int[] temp) {
		int count = 0;
		temp[count++] = b;

		int node = b;
		while (node != -1) {
			temp[count++] = parent[node];
			node = parent[node];
		}
		reverse(temp, count - 1);
		return count - 1;
	}

	private void reverse(int[] temp, int length) {
		int mid = 0 + (length - 0) / 2;

		for (int i = 0; i < mid; i++) {
			swap(temp, i, length - 1 - i);
		}
	}

	private void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	private boolean solveDijkstra(int[][] graph, int[] sptSet, int[] parent,
			int[] distance, int source, int dest) {

		distance[source] = 0;

		while (sptSet[dest] != 1) {
			int u = findMinDistanceNode(graph, sptSet, distance);

			if (u == -1) {
				return false;
			}
			for (int v = 1; v < graph.length; v++) {
				if (sptSet[v] != 1 && graph[u][v] != 0
						&& (distance[u] + graph[u][v]) < distance[v]) {
					distance[v] = distance[u] + graph[u][v];
					parent[v] = u;
				}
			}
			sptSet[u] = 1;
		}
		return true;
	}

	private int findMinDistanceNode(int[][] graph, int[] sptSet, int[] distance) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 1; i < distance.length; i++) {
			if ((distance[i] < min) && sptSet[i] != 1) {
				min = distance[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private void addNode(int[][] graph, String[] path, int index) {
		int u = Integer.parseInt(path[0]);
		int v = Integer.parseInt(path[1]);
		int weight = Integer.parseInt(path[2]);

		graph[u][v] = weight;
		graph[v][u] = weight;

	}
}
