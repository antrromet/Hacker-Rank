import java.util.Scanner;

public class GridSearch {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            
            System.out.println((find(G, R, C, P, r, c))?"YES":"NO");
        }
	}
	
	private static boolean find(String[] G, int R, int C, String [] P, int r, int c){
		for(int i=0;i<=R-r;i++){
			for(int j=0;j<=C-c;j++){
				if(G[i].charAt(j) == P[0].charAt(0) && G[i+1].charAt(j) == P[1].charAt(0) && G[i].charAt(j+1) == P[0].charAt(1)){
					if(findGrid(G, P, r, c, i, j)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean findGrid(String[] G, String [] P, int r, int c, int i, int j){
		System.out.println("Searching in subgrid");
		for(int x=0;x<r;x++){
			for(int y=0;y<c;y++){
				if(G[i+x].charAt(y+j) != P[x].charAt(y)){
					return false;
				}
			}
		}
		return true;
	}

}