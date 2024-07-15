import java.io.StreamTokenizer;
import java.io.IOException;

public class Main {
	private static int[][] flowerBoard;
	private static boolean[][] visited;
	private static int N;
	private static int[]dx= {0,0,-1,1};
	private static int[]dy= {-1,1,0,0};
	private static int minCost=Integer.MAX_VALUE;
	
	
	public static void main(String[] args)throws IOException {
		StreamTokenizer st =new StreamTokenizer(System.in);
		
		st.nextToken();
	    N =(int)st.nval;
	    flowerBoard=new int[N][N];
	    visited=new boolean[N][N];
	    
	    for(int i=0; i<N; i++) {
	    	for(int j=0; j<N; j++) {
	    		st.nextToken();
	    		flowerBoard[i][j]=(int)st.nval;
	    	}
	    }
	 
	    findMinCost(0,0);
		System.out.println(minCost);
	 }
	
	private static void findMinCost(int count,int totalCost) {
		
		if(count==3) {
			if(minCost>totalCost) {
				minCost=totalCost;
			}
			return;
		}
		
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				if(isVaild(i,j)) {
					int cost=getCost(i,j);
					setFlower(i,j,true);
					findMinCost(count+1,totalCost+cost);
					setFlower(i,j,false);
				}
			}
		}
		
		
		
	}
	private static boolean isVaild(int x, int y) {
		if(visited[x][y]) return false;
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(visited[nx][ny]) return false;
		}
		return true;
	}
	private static int getCost(int x,int y) {
		int cost=flowerBoard[x][y];
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			cost+=flowerBoard[nx][ny];
		}
		return cost;
	}
	private static void setFlower(int x, int y, boolean value) {
		visited[x][y]=value;
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			visited[nx][ny]=value;
		}
	}

}
