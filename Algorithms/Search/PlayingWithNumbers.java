import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PlayingWithNumbers {

	public static void main(String[] args){
		try{
			BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
			int N = Integer.parseInt(in.readLine());
			int[] a = new int[N];
			String[] s1 = in.readLine().split(" ");
			for(int i=0;i<N;i++){
				a[i] = Integer.parseInt(s1[i]);
			}
			int Q = Integer.parseInt(in.readLine());
			String[] s2 = in.readLine().split(" ");
			for(int i=0;i<Q;i++){
				add(a, Integer.parseInt(s2[i]));
			}
		} catch(IOException e){
		
		}
	}
	
	static void add(int[] a, int x){
		long sum = 0;
		for(int i=0;i<a.length;i++){
			a[i]+=x;
			sum += (a[i]>0?a[i]:-a[i]);
		}
		System.out.println(sum);
	}

}