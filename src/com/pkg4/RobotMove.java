package com.pkg4;

public class RobotMove {

	int N = 0;
	int E = 1;
	int S = 2;
	int W = 3;

	public static void main(String[] args) {
		String path = "GLLG";
		RobotMove robot = new RobotMove();

		if (robot.isCircular(path.toCharArray())) {
			System.out.println("Given sequence of moves is circular");
		} else {
			System.out.println("Given sequence of moves is NOT circular");
		}
	}

	private boolean isCircular(char[] path) {
		int x = 0;
		int y = 0;

		int dir = N;

		for (int i = 0; i < path.length; i++) {
			char val = path[i];

			if (val == 'R') {
				dir = (dir + 1) % 4;
			} else if (val == 'L') {
				dir = (4 + dir - 1) % 4;
			} else {

				if (dir == N) {
					y++;
				} else if (dir == E) {
					x++;
				} else if (dir == W) {
					x--;
				} else {
					y--;
				}
			}
		}

		return (x == 0 && y == 0);
	}
}
