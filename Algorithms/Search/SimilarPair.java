import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SimilarPair {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int T = in.nextInt();
		Map<Integer, Node> nodes = new HashMap<Integer, Node>(); 
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
			}
			
			if(nodes.containsKey(num2)){
				child = nodes.get(num2);
			} else {
				child = new Node(num2);
				nodes.put(num2, child);
			}
			
			parent.addChild(child);
			
		}
	}
	
	static class Node {
		int value;
		List<Node> children;
		
		public Node(int value){
			this.value = value;
			children = new ArrayList<Node>();
		}
		
		public void addChild(Node child){
			children.add(child);
		}
	}

}