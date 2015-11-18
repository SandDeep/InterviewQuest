package com.rough;

/**
 * http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
 * https://leetcode.com/problems/the-skyline-problem/
 * http://allenlipeng47.com/PersonalPage/index/view/172/nkey
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P71 {

	public static void main(String[] args) {
		Building[] buildings = new Building[8];
		buildings[0] = new Building(1, 11, 5);
		buildings[1] = new Building(2, 6, 7);
		buildings[2] = new Building(3, 13, 9);
		buildings[3] = new Building(12, 7, 16);
		buildings[4] = new Building(14, 3, 25);
		buildings[5] = new Building(19, 18, 22);
		buildings[6] = new Building(23, 13, 29);
		buildings[7] = new Building(24, 4, 28);

		P71 test = new P71();
		Skyline skyline = test.findSkyline(buildings, 0, buildings.length - 1);
		skyline.printSkyline();
	}

	private Skyline findSkyline(Building[] buildings, int start, int end) {
		/*
		 * if (start > end) { return null; }
		 */

		if (start == end) {
			Skyline skyline = new Skyline(2);
			skyline.append(new Strip(buildings[start].left,
					buildings[start].height));
			skyline.append(new Strip(buildings[start].right, 0));
			return skyline;
		}

		int mid = start + (end - start) / 2;
		Skyline skyline1 = findSkyline(buildings, start, mid);
		Skyline skyline2 = findSkyline(buildings, mid + 1, end);

		Skyline skyline = mergeSkyline(skyline1, skyline2);
		return skyline;
	}

	private Skyline mergeSkyline(Skyline sky1, Skyline sky2) {
		Skyline res = new Skyline(sky1.n + sky2.n);

		int i = 0;
		int j = 0;

		int h1 = 0;
		int h2 = 0;

		while (i < sky1.n && j < sky2.n) {

			if (sky1.arr[i].left <= sky2.arr[j].left) {
				int x = sky1.arr[i].left;
				h1 = sky1.arr[i].height;

				Strip strip = new Strip(x, Math.max(h1, h2));
				res.append(strip);
				i++;
			} else {
				int x = sky2.arr[j].left;
				h2 = sky2.arr[j].height;

				Strip strip = new Strip(x, Math.max(h1, h2));
				res.append(strip);
				j++;
			}
		}

		while (i < sky1.n) {
			res.append(sky1.arr[i]);
			i++;
		}

		while (j < sky2.n) {
			res.append(sky2.arr[j]);
			j++;
		}
		return res;
	}
}

class Building {
	int left;
	int height;
	int right;

	public Building(int left, int height, int right) {
		this.left = left;
		this.height = height;
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Building [left=" + left + ", height=" + height + ", right="
				+ right + "]";
	}
}
