package com.pkgG;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

	public static void main(String[] args) {
		int N = 30;
		int[] moves = new int[N];

		for (int i = 0; i < moves.length; i++) {
			moves[i] = -1;
		}

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		SnakeLadder ladder = new SnakeLadder();
		ladder.findPath(moves);
	}

	private void findPath(int[] moves) {
		Queue<QueueEntry> queue = new LinkedList<QueueEntry>();

		int N = moves.length;
		int[] visited = new int[N];

		String tPath = "0";
		queue.add(new QueueEntry(0, 0, tPath));
		visited[0] = 1;

		while (!queue.isEmpty()) {
			QueueEntry temp = queue.poll();
			String pathStr = temp.line;

			// destination vertex
			if (temp.vertex == N - 1) {
				System.out.println(temp);
				break;
			}

			for (int i = 1; i <= 6 && (temp.vertex + i) < N; i++) {
				int v = temp.vertex;

				if (visited[v + i] != 1) {
					visited[v + i] = 1;

					if (moves[v + i] == -1) {
						pathStr = pathStr + " , " + String.valueOf(v + i);
						queue.add(new QueueEntry(temp.distance + 1, v + i,
								pathStr));
					} else {
						pathStr = pathStr + " , "
								+ String.valueOf(moves[v + i]);
						queue.add(new QueueEntry(temp.distance + 1,
								moves[v + i], pathStr));
					}
				}
			}
		}
	}
}

class QueueEntry {
	public int distance;
	public int vertex;
	public String line = null;

	public QueueEntry(int distance, int vertex, String line) {
		this.distance = distance;
		this.vertex = vertex;
		this.line = line;
	}

	@Override
	public String toString() {
		return "QueueEntry [distance=" + distance + ", vertex=" + vertex
				+ ", line=" + line + "]";
	}

}