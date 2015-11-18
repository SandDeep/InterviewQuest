package com.prac.bt;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

	public static void main(String[] args) {

		Node root = getTree();

		TopView view = new TopView();
		view.printTopViewBT(root);
	}

	private void printTopViewBT(Node node) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Queue<QueueData> queue = new LinkedList<QueueData>();

		queue.add(new QueueData(node, 0));

		while (!queue.isEmpty()) {
			QueueData temp = queue.poll();

			Node tempNode = temp.node;

			if (!map.containsKey(temp.distance)) {
				map.put(temp.distance, Integer.parseInt(tempNode.getData()));
			}

			if (tempNode.lChild != null) {
				queue.add(new QueueData(tempNode.lChild, temp.distance - 1));
			}

			if (tempNode.rChild != null) {
				queue.add(new QueueData(tempNode.rChild, temp.distance + 1));
			}
		}

		for (Integer key : map.keySet()) {
			System.out.print(map.get(key) + " ");
		}
	}

	public static Node getTree() {
		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setrChild(node4);
		node4.setrChild(node5);
		node5.setrChild(node6);

		return root;
	}
}

class QueueData {
	Node node;
	int distance;

	public QueueData(Node node, int distance) {
		this.node = node;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "QueueData [node=" + node.getData() + ", distance=" + distance
				+ "]";
	}

}
