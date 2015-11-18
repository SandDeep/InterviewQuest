package com.pkgG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * In a flow network, an s-t cut is a cut that requires the source ‘s’ and the
 * sink ‘t’ to be in different subsets, and it consists of edges going from the
 * source’s side to the sink’s side. The capacity of an s-t cut is defined by
 * the sum of capacity of each edge in the cut-set
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class MinimumCutSet {

	public static void main(String[] args) {
		 int[][] graph = 
			 { 
				 {0, 16, 13, 0, 0, 0},
                 {0, 0, 10, 12, 0, 0},
                 {0, 4, 0, 0, 14, 0},
                 {0, 0, 9, 0, 0, 20},
                 {0, 0, 0, 7, 0, 4},
                 {0, 0, 0, 0, 0, 0}
             };
		 
		 MinimumCutSet cutSet=new MinimumCutSet();
		 cutSet.findCutSet(graph);
	}

	private void findCutSet(int[][] graph) {

		int V = graph.length;

		int[][] residual = new int[V][V];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				residual[i][j] = graph[i][j];
			}
		}

		int[] parent = new int[V];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}

		int maxFlow = 0;

		while (bfs(residual, parent, 0, V - 1)) {
			int pathFlow = Integer.MAX_VALUE;
			int t = residual.length - 1;

			System.out.print(t+" ");
			// Find Min Edge Weight in a Path
			for (int v = t; v > 0; v = parent[v]) {
				int u = parent[v];
				System.out.print(u+" ");
				pathFlow = Math.min(pathFlow, residual[u][v]);
			}
			
			System.out.print("\n");
			// Modifying Residual Graph
			for (int v = t; v > 0; v = parent[v]) {
				int u = parent[v];
				residual[u][v]-=pathFlow;
				residual[v][u]+=pathFlow;
			}
			
			maxFlow += pathFlow;
		}
		
		System.out.println("MaxFlow : " + maxFlow);
	
		Set<ArrayList<Integer>> cutSet=new HashSet<ArrayList<Integer>>();
		int capacity =0;
		
		for (int z = 0; z < residual.length; z++) {
			for (int y = 0; y < residual.length; y++) {
				if (residual[z][y] == 0 && graph[z][y] != 0) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(z);
					list.add(y);
					cutSet.add(list);
					capacity+=graph[z][y];
				}
			}
		}
		
		System.out.println("Minimum Cut Set : " + cutSet+ " has capacity :"+capacity );
	}
	
	private boolean bfs(int[][] residual, int[] parent, int s, int t) {

		boolean[] visited = new boolean[residual.length];

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(s);
		visited[s] = true;

		while (!queue.isEmpty()) {
			int u = queue.poll();

			for (int v = 0; v < visited.length; v++) {
				if (visited[v] == false && residual[u][v] > 0) {
					parent[v] = u;
					visited[v] = true;
					queue.add(v);
				}
			}
		}

		return (visited[t] == true);
	}
}
