// https://www.hackerrank.com/challenges/connected-cell-in-a-grid

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class ConnectedCellGrid {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		Point[][] grid = new Point[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				grid[i][j] = new Point(i, j, in.nextInt());
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j].value > 0 && !grid[i][j].isVisited){
					grid[i][j].setVisited(true);
					System.err.println("Calling DFS for point: "+i+","+j);
					max = Math.max(max, dfs(grid[i][j], grid));
				}
			}
		}
		
		System.out.println(max);
	}
	
	private static int dfs(Point first, Point[][] grid){
		int size = 0;
		Queue<Point> q = new LinkedList<Point>();
		q.add(first);
		while(!q.isEmpty()){
			Point p = q.remove();
			size++;
			int x = p.x;
			int y = p.y;
			System.err.println("Visiting: "+x+","+y);
			// If neighbors are not covered then add them in the queue
			for(int i=x-1;i<x+2;i++){
				for(int j=y-1;j<y+2;j++){
					if(i >= 0 && j >= 0 && i<grid.length && j<grid[0].length){
						if(!grid[i][j].isVisited && grid[i][j].value > 0){
							grid[i][j].setVisited(true);
							q.add(grid[i][j]);
						}
					}
				}
			}
		}
		return size;
	}
	
	static class Point {
		private int x;
		private int y;
		private int value;
		private boolean isVisited;
		
		public Point(int x, int y, int value){
			this.x = x;
			this.y = y;
			this.value = value;
		}
		
		public void setVisited(boolean visited){
			this.isVisited = visited;
		}
	}
	
}