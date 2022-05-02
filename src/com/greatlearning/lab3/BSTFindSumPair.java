package com.greatlearning.lab3;

import java.util.HashSet;

public class BSTFindSumPair {


	public static void main(String[] args) {
		
		BSTFindSumPair bstFindSumPair = new BSTFindSumPair();
		Node rootNode = null;
		rootNode = bstFindSumPair.insert(rootNode,40);
		rootNode = bstFindSumPair.insert(rootNode,20);
		rootNode = bstFindSumPair.insert(rootNode,60);
		rootNode = bstFindSumPair.insert(rootNode,10);
		rootNode = bstFindSumPair.insert(rootNode,30);
		rootNode = bstFindSumPair.insert(rootNode,50);
		rootNode = bstFindSumPair.insert(rootNode,70);
		int inputSum = 1001;
		bstFindSumPair.findPairWithGivenSum(rootNode, inputSum);

	}

	static class Node{
		int nodeData;
		Node leftNode, rightNode;

	};

	static Node newNode(int nodeData) {

		Node tempNode = new Node();
		
		tempNode.nodeData = nodeData;
		tempNode.leftNode = null;
		return tempNode;

	} 

	public Node insert(Node root, int key) {

		if(root==null) {

			return newNode(key);
		}
		if(key < root.nodeData) {

			root.leftNode = insert(root.leftNode, key);


		}else {


			root.rightNode = insert(root.rightNode, key);
		}

		return root;


	}

	public boolean findPair(Node root, int sum, HashSet<Integer> set) {

		if(root==null) {

			return false;
		}

		if(findPair(root.leftNode,sum,set)) {

			return true;
		}
		if(set.contains(sum - root.nodeData)) {

			System.out.println("\n Pair is Found: (" + (sum - root.nodeData) + "," + root.nodeData + ")");
			return true;
			
		}else {
			
			set.add(root.nodeData);
		}
		return findPair(root.rightNode, sum, set);

	}

	public void findPairWithGivenSum(Node root, int sum) {

		HashSet<Integer> set = new HashSet<>();

		if(!findPair(root, sum , set)) {

			System.out.println("\n Pair Doesnot Exist");
		}


	}

}
