package com.prac.bt;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNode {

	public static Queue<NLevel> queue = new LinkedList<NLevel>();

	public static void main(String[] args) {
		NodeC root = getTree1();

		connect(root);
		//connectIter(root);
		System.out.println();
		levelOrder(root, 1);
	}

	public static void connectIter(NodeC node) {
		if (node == null) {
			return;
		}
		node.setNextRight(null);

		while (node != null) {
			NodeC qNode = node;

			while (qNode != null) {

				if (qNode.lChild != null) {

					if (qNode.rChild != null) {
						qNode.lChild.setNextRight(qNode.rChild);
					} else {
						qNode.lChild.setNextRight(getNextNode(qNode));
					}

				}
				
				if (qNode.rChild != null) {
					qNode.rChild.setNextRight(getNextNode(qNode));
				}
				qNode = qNode.nextRight;
			}

			if (node.lChild != null) {
				node = node.lChild;
			} else if (node.rChild != null) {
				node = node.rChild;
			} else {
				node = getNextNode(node);
			}

		}
	}

	public static void connect(NodeC node) {
		if (node == null) {
			return;
		}
		node.setNextRight(null);
		connectRecur(node);
	}

	public static void connectRecur(NodeC node) {
		if (node == null) {
			return;
		}

		if (node.nextRight != null) {
			connectRecur(node.nextRight);
		}

		if (node.lChild != null) {

			if (node.rChild != null) {
				node.lChild.setNextRight(node.rChild);
				node.rChild.setNextRight(getNextNode(node));
			} else {
				node.lChild.setNextRight(getNextNode(node));
			}

			connectRecur(node.lChild);
		} else if (node.rChild != null) {
			node.rChild.setNextRight(getNextNode(node));
			connectRecur(node.rChild);
		} else {
			connectRecur(getNextNode(node));
		}
	}

	public static NodeC getNextNode(NodeC node) {

		node = node.nextRight;

		while (node != null) {
			if (node.lChild != null) {
				return node.lChild;
			} else if (node.rChild != null) {
				return node.rChild;
			}
			node = node.nextRight;
		}
		return null;
	}

	public static void connectNodes(NodeC node, int level) {
		if (node == null) {
			return;
		}

		queue.add(new NLevel(node, level));

		while (!queue.isEmpty()) {

			NLevel tmp = queue.remove();
			NodeC tempNode = tmp.getNode();
			// System.out.println(tmp);

			if (queue.size() >= 1) {
				NLevel nextNode = queue.peek();
				if (nextNode.getLevel() == tmp.getLevel()) {
					tempNode.setNextRight(nextNode.getNode());
				} else {
					tempNode.setNextRight(null);
				}
			} else {
				tempNode.setNextRight(null);
			}

			if (tempNode.lChild != null) {
				queue.add(new NLevel(tempNode.lChild, tmp.getLevel() + 1));
			}

			if (tempNode.rChild != null) {
				queue.add(new NLevel(tempNode.rChild, tmp.getLevel() + 1));
			}

		}

	}

	public static void levelOrder(NodeC node, int level) {
		if (node == null) {
			return;
		}

		queue.add(new NLevel(node, level));

		while (!queue.isEmpty()) {

			NLevel tmp = queue.remove();
			NodeC tempNode = tmp.getNode();
			System.out.println(tmp);

			if (tempNode.lChild != null) {
				queue.add(new NLevel(tempNode.lChild, tmp.getLevel() + 1));
			}

			if (tempNode.rChild != null) {
				queue.add(new NLevel(tempNode.rChild, tmp.getLevel() + 1));
			}

		}

	}

	public static NodeC getTree() {

		NodeC root = new NodeC("A");

		NodeC node2 = new NodeC("B");
		NodeC node3 = new NodeC("C");
		NodeC node4 = new NodeC("D");
		NodeC node5 = new NodeC("E");
		NodeC node6 = new NodeC("F");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setrChild(node6);
		return root;
	}

	public static NodeC getTree1() {

		NodeC root = new NodeC("1");

		NodeC node2 = new NodeC("2");
		NodeC node3 = new NodeC("3");
		NodeC node4 = new NodeC("4");
		NodeC node5 = new NodeC("5");
		NodeC node6 = new NodeC("6");
		NodeC node7 = new NodeC("7");
		NodeC node8 = new NodeC("8");
		NodeC node9 = new NodeC("9");
		NodeC node10 = new NodeC("10");
		NodeC node11 = new NodeC("11");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		node4.setlChild(node8);
		node4.setrChild(node9);

		node7.setlChild(node10);
		node7.setrChild(node11);

		return root;
	}

	public static int getHeight(NodeC node) {
		if (node == null) {
			return 0;
		} else {
			int l = getHeight(node.lChild);
			int r = getHeight(node.rChild);
			if (l > r)
				return l + 1;
			else
				return r + 1;
		}
	}
}

class NLevel {

	NodeC node;
	int level;

	public NLevel() {
	}

	public NLevel(NodeC node, int level) {
		this.node = node;
		this.level = level;
	}

	public NodeC getNode() {
		return node;
	}

	public void setNode(NodeC node) {
		this.node = node;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "NLevel [node=" + node + ", level=" + level + "]";
	}
}