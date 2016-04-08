// https://www.hackerrank.com/challenges/the-grid-search

import java.util.Scanner;

public class Workbook {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] t = new int[n];
        for(int i=0;i<n;i++){
        	t[i] = in.nextInt();
        }
        
        int pageNum = 0;
        int magicCount = 0;
        
        for(int i=0;i<n;i++){
        	int x=1;
        	int j=1;
        	pageNum++;
        	while(x<=t[i]){
        		if(x == pageNum){
        			magicCount++;
        		}
        		if(j == k && x<t[i]){
        			j=0;
        			pageNum++;
        		}
        		j++;
        		x++;
        	}
        }
        
        System.out.println(magicCount);
    }

}