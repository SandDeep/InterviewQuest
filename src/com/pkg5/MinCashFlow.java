package com.pkg5;

/**
 * http://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-
 * borrowed-money/
 * 
 * @author Deepesh
 * 
 */
public class MinCashFlow {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int graph[][] = { { 0, 1000, 2000 }, { 0, 0, 5000 }, { 0, 0, 0 } };

		int graph1[][] = { { 0, 18, 25, 34, 14, 21, 40 },
				{ 44, 0, 64, 0, 11, 5, 24 }, { 11, 35, 0, 23, 17, 26, 23 },
				{ 19, 50, 20, 0, 16, 7, 0 }, { 0, 14, 9, 0, 0, 27, 18 },
				{ 42, 5, 17, 8, 3, 0, 17 }, { 36, 26, 0, 47, 7, 6, 0 } };

		MinCashFlow cashFlow = new MinCashFlow();
		cashFlow.minCashFlow(graph1);
	}

	private void minCashFlow(int[][] graph) {
		int[] amount = new int[graph.length];

		calculateMoney(amount, graph);
		minCashFlowRec(amount, graph);
	}

	private void minCashFlowRec(int[] amount, int[][] graph) {
		int maxCredit = findMax(amount);
		int minDebit = findMin(amount);

		if (amount[maxCredit] == 0 && amount[minDebit] == 0) {
			return;
		}

		int x = Math.min(amount[maxCredit], -amount[minDebit]);

		amount[maxCredit] = amount[maxCredit] - x;
		amount[minDebit] = amount[minDebit] + x;

		System.out.println("Person MinDebit " + minDebit + " pays --> Rs." + x
				+ " --> Person MaxCredit " + maxCredit);

		minCashFlowRec(amount, graph);
	}

	private int findMin(int[] person) {
		int min = 0;
		int index = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i] < 0 && person[i] < min) {
				min = person[i];
				index = i;
			}
		}
		return index;
	}

	private int findMax(int[] person) {
		int max = 0;
		int index = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i] > 0 && person[i] > max) {
				max = person[i];
				index = i;
			}
		}
		return index;
	}

	private void calculateMoney(int[] person, int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			int debit = 0;
			int credit = 0;

			for (int j = 0; j < graph.length; j++) {
				debit += graph[i][j];
				credit += graph[j][i];
			}

			person[i] = credit - debit;
		}
	}
}
