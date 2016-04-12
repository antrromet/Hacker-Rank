// https://www.hackerrank.com/challenges/count-luck

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class CountLuck {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=0;t<T;t++){
			int N = in.nextInt();
			int M = in.nextInt();
			Point[][] grid = new Point[N][M];
			Point source = null;
			Point destination = null;
			for(int i=0;i<N;i++){
				String s = in.next();
				for(int j=0;j<M;j++){
					char ch = s.charAt(j);
					grid[i][j] = new Point(i, j, ch);
					
					if(ch == 'M'){
						source = grid[i][j];
					} else if(ch == '*'){
						destination = grid[i][j];
					}
				}
			}
			int K = in.nextInt();
			int x = countWandWaves(source, destination, grid, N, M);
			System.out.println((x == K)?"Impressed":"Oops!");
		}
	}
	
	private static int countWandWaves(Point source, Point destination, Point[][] grid, int N, int M){
		int count = 0;
		Queue<Point> q = new LinkedList<Point>();
		q.add(source);
		while(!q.isEmpty()){
			Point p = q.remove();
			if(p.equals(destination)){
				// System.out.println("Setting "+p.x+","+p.y);
// 				grid[destination.x][destination.y].setPreviousPoint(p);
				break;
			}
			int x = p.x;
			int y = p.y;
			
			// Check neighbors
			int optionsCount = 0;
			Point top = (x>0)?grid[x-1][y]:null;
			Point right = (y<M-1)?grid[x][y+1]:null;
			Point bottom = (x<N-1)?grid[x+1][y]:null;
			Point left = (y>0)?grid[x][y-1]:null;
			
			if(top!=null && top.isAccessible && !top.isVisited){
				top.setVisited(true);
				q.add(top);
				grid[x-1][y].setPreviousPoint(p);
				optionsCount++;
				// System.err.println("Setting "+p.x+","+p.y+" as previous of "+(x-1)+","+y);
			}
			
			if(right!=null && right.isAccessible && !right.isVisited){
				right.setVisited(true);
				q.add(right);
				grid[x][y+1].setPreviousPoint(p);
				optionsCount++;
				// System.err.println("Setting "+p.x+","+p.y+" as previous of "+x+","+(y+1));
			}
			
			if(bottom!=null && bottom.isAccessible && !bottom.isVisited){
				bottom.setVisited(true);
				q.add(bottom);
				grid[x+1][y].setPreviousPoint(p);
				optionsCount++;
				// System.err.println("Setting "+p.x+","+p.y+" as previous of "+(x+1)+","+y);
			}
			
			if(left!=null && left.isAccessible && !left.isVisited){
				left.setVisited(true);
				q.add(left);
				grid[x][y-1].setPreviousPoint(p);
				optionsCount++;
				// System.err.println("Setting "+p.x+","+p.y+" as previous of "+x+","+(y-1));
			}
			
			grid[p.x][p.y].setOptionsCount(optionsCount);
		}
		
		Point runner = grid[destination.x][destination.y].previousPoint;
		while(!runner.equals(source)){
			//System.out.println(runner.x+","+runner.y + " - "+runner.optionsCount);
			if(runner.optionsCount > 1){
				count++;
			}
			runner = grid[runner.x][runner.y].previousPoint;
		}
		// System.out.println(runner.x+","+runner.y + " - "+runner.optionsCount);
		if(runner.optionsCount > 1){
			count++;
		}
		return count;
	}
	
	static class Point {
	
		private int x;
		private int y;
		private char value;
		private boolean isAccessible;
		private boolean isVisited;
		private Point previousPoint;
		private int optionsCount;
		
		public Point(int x, int y, char value){
			this.x = x;
			this.y = y;
			this.value = value;
			
			if(value == '*' || value == 'M' || value == '.'){
				isAccessible = true;
			}
			
			if(value == 'M'){
				isVisited = true;
			}
		}
		
		public void setVisited(boolean visited){
			isVisited = visited;
		}
		
		public void setPreviousPoint(Point p){
			previousPoint = p;
		}
		
		public void setOptionsCount(int count){
			optionsCount = count;
		}
		
		@Override
		public boolean equals(Object o){
			if(o == this){
				return true;
			}
			if(!(o instanceof Point)){
				return false;
			}
			Point p = (Point) o;
			if(this.x == p.x && this.y == p.y){
				return true;
			}
			return false;
		}
	
	}

}