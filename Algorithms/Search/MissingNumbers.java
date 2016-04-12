// https://www.hackerrank.com/challenges/missing-numbers
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MissingNumbers {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++){
			int x = in.nextInt();
			int val = 0;
			if(map.containsKey(x)){
				val = map.get(x);
			}
			val += 1;
			map.put(x, val);
		}
		
		int m = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<m;i++){
			int x = in.nextInt();
			if(map.containsKey(x)){
				int val = map.get(x);
				val--;
				if(val == 0){
					map.remove(x);
				} else {
					map.put(x, val);
				}
			} else {
				if(!list.contains(x)){
					list.add(x);
				}
			}
		}
		
		Collections.sort(list);
		for(Integer i: list){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}