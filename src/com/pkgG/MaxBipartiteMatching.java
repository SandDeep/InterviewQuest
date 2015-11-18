package com.pkgG;

/**
 * A matching in a Bipartite Graph is a set of the edges chosen in such a way
 * that no two edges share an endpoint.There can be more than one maximum
 * matchings for a given Bipartite Graph.
 * 
 * @author Deepesh
 * 
 */
public class MaxBipartiteMatching {

	public static void main(String[] args) {
		 int[][] graph = {  
				 {0, 1, 1, 0, 0, 0},
                 {1, 0, 0, 1, 0, 0},
                 {0, 0, 1, 0, 0, 0},
                 {0, 0, 1, 1, 0, 0},
                 {0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 1}
               };
		 
		 MaxBipartiteMatching matching=new MaxBipartiteMatching();
		 int res=matching.maxBPM(graph);
		 System.out.println("Max BPM : " + res);
	}

	private int maxBPM(int[][] graph) {
		int M=graph.length;
		int N=graph[0].length;
		
		int[] matchR=new int[N];
		for (int i = 0; i < matchR.length; i++) {
			matchR[i]=-1;
		}
		int result=0;
		
		for (int i = 0; i < M; i++) {
			boolean[] seen=new boolean[N];
			
			if(bpm(graph,matchR,seen,i)){
				result++;
			}
		}
		
		for (int i = 0; i < matchR.length; i++) {
			if(matchR[i]!=-1)
			System.out.println(matchR[i] + " --> " + i);
		}
		return result;
	}

	// DFS
	private boolean bpm(int[][] graph, int[] matchR, boolean[] seen, int u) {
		int N = graph[0].length;

		for (int v = 0; v < N; v++) {
			if (graph[u][v] > 0 && !seen[v]) {
				seen[v] = true;

				if (matchR[v] < 0 || bpm(graph, matchR, seen, matchR[v])) {
					matchR[v] = u;
					return true;
				}
			}
		}

		return false;
	}

}
