package com.rough;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/sort-elements-by-frequency-set-2/
 * 
 * @author Deepesh
 * 
 */
public class P29 {

	static int countIndex = 0;

	public static void main(String[] args) {
		int arr[] = { 2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12 };
		P29 test = new P29();
		test.sortByFrequency(arr, arr.length);
	}

	private void sortByFrequency(int[] arr, int n) {
		SNode root = null;

		for (int i = 0; i < n; i++) {
			root = insert(root, i, arr[i]);
		}
		Frequency countArr[] = new Frequency[n];
		inorder(root, countArr, 0);
		Arrays.sort(countArr, 0, countIndex);

		int index = 0;
		for (int i = countIndex - 1; i >= 0; i--) {
			int temp = countArr[i].count;
			while (temp > 0) {
				arr[index++] = countArr[i].data;
				temp--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private void inorder(SNode node, Frequency[] countArr, int index) {
		if (node != null) {
			inorder(node.lChild, countArr, index);
			countArr[index++] = node.getFrequency();
			countIndex = index;
			inorder(node.rChild, countArr, index);
		}
	}

	private SNode insert(SNode node, int index, int data) {
		if (node == null) {
			Frequency fTemp = new Frequency(index, data, 1);
			return new SNode(fTemp);
		}

		if (node.getFrequency().getData() == data) {
			Frequency fTemp = node.getFrequency();
			fTemp.setCount(fTemp.getCount() + 1);
			node.setFrequency(fTemp);
			return node;
		} else if (data < node.getFrequency().getData()) {
			node.setlChild(insert(node.lChild, index, data));
		} else {
			node.setrChild(insert(node.rChild, index, data));
		}
		return node;
	}
}

class Frequency implements Comparable<Frequency> {
	int index;
	int data;
	int count;

	public Frequency(int index, int data, int count) {
		this.index = index;
		this.data = data;
		this.count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Frequency [index=" + index + ", data=" + data + ", count="
				+ count + "]";
	}

	@Override
	public int compareTo(Frequency o) {
		Frequency f1 = this;
		Frequency f2 = o;

		if (f1.count == f2.count) {
			return (f1.index > f2.index) ? 1 : -1;
		}
		return (f1.count > f2.count) ? 1 : -1;
	}

}

class SNode {

	Frequency frequency;
	SNode lChild;
	SNode rChild;

	public SNode(Frequency frequency) {
		this.frequency = frequency;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public SNode getlChild() {
		return lChild;
	}

	public void setlChild(SNode lChild) {
		this.lChild = lChild;
	}

	public SNode getrChild() {
		return rChild;
	}

	public void setrChild(SNode rChild) {
		this.rChild = rChild;
	}

	@Override
	public String toString() {
		return "SNode [frequency=" + frequency + "]";
	}

}