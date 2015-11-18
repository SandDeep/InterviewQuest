package com.prac.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	public static Queue<Node> queue = new LinkedList<Node>();

	public static void main(String[] args) {
		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		// root = treeListRecursion(root);

		// System.out.println("BFS using Function.");
		// printLevelorder(root);

		// System.out.println("BFS using Queue.");
		// printLevelorderQ(root);

		// int count=getLeafCount(root);
		// System.out.println("Number of Leaves : " + count);

		// printSpiralOrder(root);

		printSpiralOrderQ(root);

	}

	public static void printSpiralOrderQ(Node node) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();

		if (node == null) {
			return;
		} else {
			stack1.push(node);
			
			while(!stack1.isEmpty() || !stack2.isEmpty()){
				
				System.out.println("");
				
				while(!stack1.isEmpty()){

					//Pop one by one
					Node tmpNode=stack1.pop();
					
					//Print Node data
					System.out.print(tmpNode.data +" ");
					
					//Push Node onto stack2
					if(tmpNode.rChild!=null){
						stack2.push(tmpNode.rChild);
					}
					
					if(tmpNode.lChild!=null){
						stack2.push(tmpNode.lChild);
					}
				}
				
				System.out.println("");
				
				while(!stack2.isEmpty()){

					//Pop one by one
					Node tmpNode=stack2.pop();
					
					//Print Node Data
					System.out.print(tmpNode.data +" ");
					
					//Push elements on stack1
					if(tmpNode.lChild!=null){
						stack1.push(tmpNode.lChild);
					}
					
					if(tmpNode.rChild!=null){
						stack1.push(tmpNode.rChild);
					}
				}
			}
			
		}
	}

	public static void printSpiralOrder(Node root) {
		int height = BTreeUtil.getHeight(root);
		int flag = -1;
		for (int i = 1; i <= height; i++) {
			printSpiralLevel(root, i, flag);
			flag = flag * (-1);
			System.out.println();
		}
	}

	public static void printSpiralLevel(Node node, int level, int flag) {
		if (node == null) {
			return;
		} else if (level == 1) {
			System.out.print(node.data + " ");
		} else {
			if (flag == 1) {
				printSpiralLevel(node.lChild, level - 1, flag);
				printSpiralLevel(node.rChild, level - 1, flag);
			} else if (flag == -1) {
				printSpiralLevel(node.rChild, level - 1, flag);
				printSpiralLevel(node.lChild, level - 1, flag);
			}
		}
	}

	/**
	 * Time Complexity: O(n) where n is number of nodes in the binary tree
	 * 
	 * @param node
	 */
	public static void printLevelorderQ(Node node) {
		if (node == null) {
			return;
		}

		Node tempNode = node;

		/* Print Node Data */
		System.out.print(tempNode.data + " ");

		/* Enqueue Node left and right child */
		if (tempNode.lChild != null)
			queue.add(tempNode.lChild);

		if (tempNode.rChild != null)
			queue.add(tempNode.rChild);

		/* Dequeue first element. */
		if (!queue.isEmpty()) {
			Node queueNode = queue.remove();
			printLevelorderQ(queueNode);
		} else {
			return;
		}

	}

	/**
	 * Time Complexity: O(n^2) in worst case. For a skewed tree,
	 * printGivenLevel() takes O(n) time where n is the number of nodes in the
	 * skewed tree. So time complexity of printLevelOrder() is O(n) + O(n-1) +
	 * O(n-2) + .. + O(1) which is O(n^2).
	 * 
	 * @param root
	 */
	public static void printLevelorder(Node root) {
		int height = BTreeUtil.getHeight(root);
		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
	}

	public static void printGivenLevel(Node node, int level) {
		if (node == null) {
			return;
		} else if (level == 1) {
			System.out.print(node.data + " ");
			return;
		} else {
			printGivenLevel(node.lChild, level - 1);
			printGivenLevel(node.rChild, level - 1);
		}
	}

	public static Node treeListRecursion(Node node) {
		if (node == null) {
			return node;
		} else {

			Node leftHead = treeListRecursion(node.lChild);
			Node rightHead = treeListRecursion(node.rChild);

			Node lNode = leftHead;
			Node rNode = rightHead;

			/* RightMost Node for Left Child */
			while (lNode != null
					&& (lNode.rChild != null && lNode.rChild != leftHead)) {
				lNode = lNode.rChild;
			}

			// now, lnode => tail of left list

			if (lNode != null) {
				lNode.rChild = node;
				node.lChild = lNode;
			}

			if (rightHead != null) {
				rightHead.lChild = node;
				node.rChild = rightHead;
			}

			while (rNode != null
					&& (rNode.rChild != null && rNode.rChild != rightHead)) {
				rNode = rNode.rChild;
			}

			if (leftHead != null && rightHead != null) {
				leftHead.lChild = rNode;
				rNode.rChild = leftHead;
			}

			return leftHead != null ? leftHead : node;
		}
	}

	public static int getLeafCount(Node node) {
		if (node == null) {
			return 0;
		} else if (node.lChild == null && node.rChild == null) {
			return 1;
		} else {
			return (getLeafCount(node.lChild)) + (getLeafCount(node.rChild));
		}

	}
}
