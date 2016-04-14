// https://www.hackerrank.com/challenges/cut-the-tree

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CutTheTree {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Node[] nodes = new Node[N];
		int totalSum = 0;
		for(int i=0;i<N;i++){
			Node node = new Node(i+1, in.nextInt());
			nodes[i] = node;
			totalSum += node.value;
		}
		
		for(int i=0;i<N-1;i++){
			int firstNodeIndex = in.nextInt();
			int secondNodeIndex = in.nextInt();
			
			nodes[firstNodeIndex - 1].addNeighbor(nodes[secondNodeIndex-1]);
			nodes[secondNodeIndex - 1].addNeighbor(nodes[firstNodeIndex-1]);
		}
		int x = dfs(nodes[0], totalSum);
		System.out.println(x);
	}
	
	private static int dfs(Node root, int totalSum){
		int leftTreeSum = 0, rightTreeSum = totalSum;
		int min = Integer.MAX_VALUE;
		root.setVisited(true);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node x = q.remove();
			leftTreeSum += x.value;
			rightTreeSum -= x.value;
			int diff = Math.abs(leftTreeSum - rightTreeSum);
			if(diff< min){
				min = diff;
			}
			for(Node neighbor: x.neighbors){
				if(!neighbor.isVisited){
					neighbor.setVisited(true);
					q.add(neighbor);
				}
			}
		}
		
		return min;
	}
	
	static class Node {
		private List<Node> neighbors;
		private int index;
		private int value;
		private boolean isVisited;
		
		public Node(int index, int value){
			this.index = index;
			this.value = value;
			
			neighbors = new ArrayList<Node>();
		}
		
		public void addNeighbor(Node n){
			neighbors.add(n);
		}
		
		public void setVisited(boolean visited){
			isVisited = visited;
		}
	}

}