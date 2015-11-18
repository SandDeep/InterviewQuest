package com.pkg5;

/**
 * http://www.seas.gwu.edu/~simhaweb/champalg/tsp/tsp.html
 * 
 * @author Deepesh
 * 
 */
public class TSP {

	public static void main(String[] args) {

		int[][] path = { { 0, 10, 15, 20 }, { 5, 0, 9, 10 }, { 6, 13, 0, 12 },
				{ 8, 8, 9, 0 } };

		TSP tsp = new TSP();
		tsp.solveTSP(path);
	}

	private void solveTSP(int[][] path) {

	}
}
