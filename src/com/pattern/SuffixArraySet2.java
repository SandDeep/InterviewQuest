package com.pattern;

import java.util.Arrays;

/**
 * algorithm uses standard sort function and therefore time complexity is
 * O(nLognLogn). We can use Radix Sort here to reduce the time complexity to
 * O(nLogn).
 * 
 * @author Deepesh
 * 
 */
public class SuffixArraySet2 {

	public static void main(String[] args) {
		char txt[] = "banana".toCharArray();

		SuffixArraySet2 suffixArray = new SuffixArraySet2();
		Suffix[] suffixes = suffixArray.createSuffixArray(txt);

		// char[] pat = "nan".toCharArray();

		System.out.println(Arrays.toString(suffixes));
	}

	private Suffix[] createSuffixArray(char[] txt) {
		Suffix[] suffixes = new Suffix[txt.length];

		for (int i = 0; i < suffixes.length; i++) {
			int rank = txt[i] - 'a';
			int nextRank = -1;

			if (i < suffixes.length - 1) {
				nextRank = txt[i + 1] - 'a';
			}
			suffixes[i] = new Suffix(i, txt, rank, nextRank);
		}

		// Sorting according to first 2pow(1) i.e. first two characters.
		Arrays.sort(suffixes);

		int N = suffixes.length;
		int ind[] = new int[N];

		for (int k = 4; k < 2 * N; k = 2 * k) {
			// Assigning rank and index values to first suffix
			int rank = 0;
			int prevRank = suffixes[0].getRank();
			suffixes[0].setRank(rank);

			ind[suffixes[0].getIndex()] = 0;

			// Assigning rank to suffixes
			for (int i = 1; i < N; i++) {

				if (prevRank == suffixes[i].getRank()
						&& suffixes[i - 1].getNextRank() == suffixes[i]
								.getNextRank()) {
					prevRank = suffixes[i].getRank();
					suffixes[i].setRank(rank);
				} else {
					prevRank = suffixes[i].getRank();
					rank++;
					suffixes[i].setRank(rank);
				}
				ind[suffixes[i].getIndex()] = i;
			}

			// Assign next rank to every suffix
			for (int i = 0; i < N; i++) {
				int nextIndex = suffixes[i].getIndex() + k / 2;
				if (nextIndex >= N) {
					suffixes[i].setNextRank(-1);
				} else {
					int nextRank = suffixes[ind[nextIndex]].getRank();
					suffixes[i].setNextRank(nextRank);
				}
			}

			Arrays.sort(suffixes);
		}

		return suffixes;
	}

}

class Suffix implements Comparable<Suffix> {
	int index;
	char[] arr;
	int rank;
	int nextRank;

	public Suffix(int index, char[] arr, int rank, int nextRank) {
		this.index = index;
		this.arr = arr;
		this.rank = rank;
		this.nextRank = nextRank;
	}

	public int getNextRank() {
		return nextRank;
	}

	public void setNextRank(int nextRank) {
		this.nextRank = nextRank;
	}

	public int getIndex() {
		return index;
	}

	public char[] getArr() {
		return arr;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Suffix o) {
		int iRank = this.rank;
		int jRank = o.rank;

		if (iRank == jRank) {
			return this.nextRank - o.nextRank;
		} else {
			return iRank - jRank;
		}
	}

	@Override
	public String toString() {
		return "Suffix [index=" + index + ", arr=" + Arrays.toString(arr)
				+ ", rank=" + rank + ", nextRank=" + nextRank + "]";
	}

}