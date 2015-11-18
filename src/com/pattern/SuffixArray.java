package com.pattern;

import java.util.Arrays;

public class SuffixArray {

	public static void main(String[] args) {
		char txt[] = "banana".toCharArray();

		SuffixArray suffixArray = new SuffixArray();
		Suffix[] suffixes = suffixArray.createSuffixArray(txt);

		char[] pat = "nan".toCharArray();

		suffixArray.search(pat, suffixes);
	}

	private void search(char[] pat, Suffix[] suffixes) {
		int low = 0;
		int high = suffixes.length;
		int mid;

		while (low <= high) {
			mid = low + (high - low) / 2;

			int i = 0;
			int j = suffixes[mid].index;
			while (i < pat.length && j < suffixes[mid].arr.length) {
				if (pat[i] != suffixes[mid].arr[j]) {
					break;
				}
				i++;
				j++;
			}
			if (i == pat.length ) {
				System.out.println("Pattern Found : " + mid);
				break;
			} else if (i < j) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
	}

	private Suffix[] createSuffixArray(char[] txt) {
		Suffix[] suffixes = new Suffix[txt.length];

		for (int i = 0; i < suffixes.length; i++) {
			suffixes[i] = new Suffix(i, txt);
		}

		Arrays.sort(suffixes);
		return suffixes;
	}

	class Suffix implements Comparable<Suffix> {
		int index;
		char[] arr;

		public Suffix(int index, char[] arr) {
			this.index = index;
			this.arr = arr;
		}

		public int getIndex() {
			return index;
		}

		public char[] getArr() {
			return arr;
		}

		@Override
		public int compareTo(Suffix o) {
			int i = this.index;
			int j = o.index;
			int size = this.arr.length;
			int len1 = this.arr.length - i;
			int len2 = this.arr.length - j;

			while (i < size && j < size) {
				if (this.arr[i] != o.arr[j]) {
					return arr[i] - arr[j];
				}
				i++;
				j++;
			}
			return len1 - len2;
		}

		@Override
		public String toString() {
			return "Suffix [index=" + index + ", arr=" + Arrays.toString(arr)
					+ "]";
		}

	}
}