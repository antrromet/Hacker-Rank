// https://www.hackerrank.com/challenges/maximise-sum
// https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem

import java.util.Scanner;

public class MaximiseSum {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0;i<T;i++){
			int N = in.nextInt();
			int M = in.nextInt();
			int[] a = new int[N];
			for(int j=0;j<N;j++){
				 a[j] = in.nextInt();
			}
			
			int[] prefix = new int[N];
			int curr = 0;
			for(int j=0;j<N;j++){
				curr = (a[j]%M + curr)%M;
				prefix[j] = curr;
			}
			
			int ret = 0;
			for(int x=0;x<N;x++){
				for(int y=x-1;y>=0;y--){
					ret = Math.max(ret, (prefix[x]-prefix[y]+M)%M);
				}
				ret = Math.max(ret, prefix[x]);
			}
			
			System.out.println(ret);
		}
	}

}