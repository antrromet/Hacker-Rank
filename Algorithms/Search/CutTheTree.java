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
		int x = findMinDiff(nodes, totalSum);
		System.out.println(x);
	}
	
	private static int findMinDiff(Node[] nodes, int totalSum){
		int min = Integer.MAX_VALUE;
		dfs(nodes[0]);
		for(Node n: nodes){
			min = Math.min(min, Math.abs(totalSum - 2*n.dfsValue));
		}
		return min;
	}
	
	private static int dfs(Node n){
		n.setVisited(true);
		for(Node neighbor: n.neighbors){
			if(!neighbor.isVisited){
				n.dfsValue += dfs(neighbor);
			}
		}
		return n.dfsValue;
	}
	
	static class Node {
		private List<Node> neighbors;
		private int index;
		private int value;
		private boolean isVisited;
		private int dfsValue;
		
		public Node(int index, int value){
			this.index = index;
			this.value = value;
			dfsValue = value;
			
			neighbors = new ArrayList<Node>();
		}
		
		public void addNeighbor(Node n){
			neighbors.add(n);
		}
		
		public void removeNeighbor(Node n){
			neighbors.remove(n);
		}
		
		public void setVisited(boolean visited){
			isVisited = visited;
		}
	}

}