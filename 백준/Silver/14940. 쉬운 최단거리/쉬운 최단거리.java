import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][]ground;
	private static boolean [][]visitied;
	private static int[][] distances;
	private static int[] dx= {0,0,-1,1};
	private static int[] dy= {1,-1,0,0};
	private static int N,M;
	private static Point goal;
	

	public static void main(String[] args)throws IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =null;
		
		
		st=new StringTokenizer(input.readLine());
		N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
		ground=new int[N][M];
		distances=new int[N][M];
		visitied=new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(input.readLine());
			for(int k=0; k<M; k++) {
				ground[i][k]=Integer.parseInt(st.nextToken());
				
				//목표좌포를 저장해놓아야한다.
				if(ground[i][k]==2) {
					goal=new Point(i,k);
				}
			}
		}
		
		//목표좌표일때만 bfs실행
	   if(goal!=null) {
		   bfs(goal.x,goal.y);
	   }
	    
	    for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (ground[i][k] == 0) {
                    output.write(0 + " ");
                } else if (!visitied[i][k]) {
                    output.write(-1 + " ");
                } else {
                    output.write(distances[i][k] + " ");
                }
            }
            output.newLine();
        }
	    output.flush();
	    output.close();
		
	}
	private static void bfs(int indexX, int indexY) {
		visitied[indexX][indexY]=true;
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(indexX,indexY));
		
		while(!queue.isEmpty()) {
			Point current=queue.poll();
			int x=current.x;
			int y=current.y;
			
			for(int i=0; i<4; i++) {
	
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx>=0&&ny>=0&&nx<N&&ny<M&&ground[nx][ny]==1&&!visitied[nx][ny]) {
					distances[nx][ny]=distances[x][y]+1;
					queue.add(new Point(nx,ny));
					visitied[nx][ny]=true;	
				}
			}
		}
	
	}
	
	static class Point{
	  int x;
	  int y;
	  Point(int x, int y){
		  this.x=x;
		  this.y=y;
	  }
	}

}
