// https://www.hackerrank.com/challenges/pairs

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pairs {
    static int pairs(int[] a,int k) {
    	int count = 0;
    	Arrays.sort(a);
    	for(int i=0;i<a.length;i++){
    		if(find(a, a[i] + k, i+1)){
    			count++;
    		}
    	}
        return count;
    }
    
    static boolean find(int[] a, int x, int startPos){
    	int pos = find(a, x, startPos, a.length-1);
    	if(pos>=0){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    static int find(int[] a, int x, int low, int high){
    	if(high >= low){
    		int mid = (high+low)/2;
    		if(a[mid] == x){
    			return mid;
    		} else if(a[mid] > x){
	    		return find(a, x, low, mid-1);
    		} else {
    			return find(a, x, mid+1, high);
    		}
    	}
    	return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}