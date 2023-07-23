package day0811;

import java.util.Scanner;


class Tree
{
	class Node
	{
		String value;
		Node leftChild;
		Node rightChild;
		
		Node(String value)
		{
			this.value = value;
		}
		
	}
	
	Node root;

	public void createNode(String value, String leftValue, String rightValue)
	{
		if(root == null)
		{
			root = new Node(value); // 루트가 null이면 초기상태로 루트노드를 생성해준다

			if(!leftValue.equals(".")) root.leftChild = new Node(leftValue); // 왼쪽에 자식노드가 있으면 노드 추가
			if(!rightValue.equals(".")) root.rightChild = new Node(rightValue); // 오른쪽에 자식노드가
		}
		else searchNode(root, value, leftValue, rightValue);
	}
	
	
	public void searchNode(Node node, String value, String leftValue, String rightValue)
	{
		if(node == null) return; //도착한 노드가 null이면 재귀 종료
		else if(node.value.equals(value)) // 들어갈 위치 찾음
		{
			if(!leftValue.equals(".")) node.leftChild = new Node(leftValue); // 왼쪽에 자식노드 추가
			if(!rightValue.equals(".")) node.rightChild = new Node(rightValue); // 오른쪽에 자식노드 추가
		}
		else // 아직 발견 못했고 탐색할 노드가 남아있음
		{
			searchNode(node.leftChild, value, leftValue, rightValue); // 왼쪽 탐색
			searchNode(node.rightChild, value, leftValue, rightValue); // 오른쪽 탐색
		}
	}


	public void preOrder(Node node)
	{
		System.out.print(node.value); // 현재 노드 출력
		if(node.leftChild != null) preOrder(node.leftChild); // 왼쪽 탐색
		if(node.rightChild != null) preOrder(node.rightChild); // 오른쪽 탐색
		
	}
	
	public void inOrder(Node node)
	{
		if(node.leftChild != null) inOrder(node.leftChild); // 왼쪽 탐색
		System.out.print(node.value); // 현재 노드 출력
		if(node.rightChild != null) inOrder(node.rightChild); // 오른쪽 탐색
	}
	
	public void postOrder(Node node)
	{
		if(node.leftChild != null) postOrder(node.leftChild); // 왼쪽 탐색
		if(node.rightChild != null) postOrder(node.rightChild); // 오른쪽 탐색
		System.out.print(node.value); // 현재 노드 출력
	}
}


public class BOJ_1991_트리순회 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 노드의 갯수
		
		String root, leftChild, rightChild; // 입력받을 변수 생성
		Tree tree = new Tree(); // 이진트리 생성
		
		for(int i = 0; i < N; i++)
		{
			// 변수 입력
			root = sc.next();
			leftChild = sc.next();
			rightChild = sc.next();

			tree.createNode(root, leftChild, rightChild); // 이진트리에 추가
		}
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		
	}
}
