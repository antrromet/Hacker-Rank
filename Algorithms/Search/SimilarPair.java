import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class SimilarPair {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int T = in.nextInt();
		Map<Integer, Node> nodes = new HashMap<Integer, Node>(); 
		int rootValue = -1;
		for(int i=1;i<n;i++){
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			
			Node parent = null;
			Node child = null;
			
			if(nodes.containsKey(num1)){
				parent = nodes.get(num1);
			} else {
				parent = new Node(num1);
				nodes.put(num1, parent);
				if(rootValue < 0){
					rootValue = num1;
				}
			}
			
			if(nodes.containsKey(num2)){
				child = nodes.get(num2);
			} else {
				child = new Node(num2);
				nodes.put(num2, child);
			}
			
			parent.addChild(child);
		}
		
		int count = 0;
		for(Node node:nodes.values()){
			resetNodesVisited(nodes);
			count += findPair(node, T);
		}
		System.out.println(count);
	}
	
	private static void resetNodesVisited(Map<Integer, Node> nodes){
		for(Node node: nodes.values()){
			node.setVisited(false);
		}
	}
	
	private static int findPair(Node root, int T){
		dfs(root, root, T);
		return root.pairs;
	}
	
	private static void dfs(Node ancestor, Node root, int T){
		root.setVisited(true);
		int diff = root.value - ancestor.value;
		if(diff!=0 && Math.abs(diff) <= T){
			ancestor.pairs+=1;
		}
		for(Node child: root.children){
			if(!child.isVisited){
				dfs(ancestor, child, T);
			}
		}
	}
	
	static class Node {
		int value;
		List<Node> children;
		boolean isVisited;
		int pairs;
		
		public Node(int value){
			this.value = value;
			children = new ArrayList<Node>();
		}
		
		public void addChild(Node child){
			children.add(child);
		}
		
		public void setVisited(boolean visited){
			isVisited = visited;
		}
	}

}