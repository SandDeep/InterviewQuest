package com.prac.bt;

public class SameTree {

	public static void main(String[] args) {
		Node Aroot = new Node("1");

		Node Anode2 = new Node("2");
		Node Anode3 = new Node("3");
		Node Anode4 = new Node("4");
		Node Anode5 = new Node("5");
		Aroot.setlChild(Anode2);
		Aroot.setrChild(Anode3);
		Anode2.setlChild(Anode4);
		Anode2.setrChild(Anode5);
		
		Node Broot = new Node("1");

		Node Bnode2 = new Node("2");
		Node Bnode3 = new Node("3");
		Node Bnode4 = new Node("4");
		Node Bnode5 = new Node("5");

		Broot.setlChild(Bnode2);
		Broot.setrChild(Bnode3);

		Bnode2.setlChild(Bnode4);
		Bnode2.setrChild(Bnode5);
		
		inorder(Aroot);
		System.out.println();
		inorder(Broot);
		
		System.out.println("\nTree Similarity : " + sameTree(Aroot, Broot));
	}
	
	public static boolean sameTree(Node node1,Node node2){
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 != null && node2 != null) {
			return (node1.data == node2.data)
					&& (sameTree(node1.lChild, node2.lChild))
					&& (sameTree(node1.rChild, node2.rChild));
		} else {
			System.out.println(node1 + " != " + node2);
			return false;
		}
		
	}
	
	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.lChild);
			System.out.print(root.data + " ");
			inorder(root.rChild);
		} else {
			return;
		}
	}
}
