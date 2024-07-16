import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;;


public class Main {
	private static int[][][]boards;
	private static int N,M,H;
	
	private static int[] dx= {0,0,-1,1,0,0};
	private static int[]dy= {1,-1,0,0,0,0};
	private static int[]dz= {0,0,0,0,1,-1};

	public static void main(String[] args)throws IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=null;
		
		st=new StringTokenizer(input.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		boards=new int[H][N][M];
		Queue<int[]> queue =new LinkedList<>();
		
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st=new StringTokenizer(input.readLine());
				while(st.hasMoreElements()) {
					for(int m=0; m<M; m++) {
						boards[h][n][m]=Integer.parseInt(st.nextToken());
						if(boards[h][n][m]==1) {
							queue.add(new int[]{m,n,h,0});
						}
					}
				
				}
				
			}
			
		}
		   
		 int days = bfs(queue);
		
		for (int h = 0; h < H; h++) {
	            for (int n = 0; n < N; n++) {
	                for (int m = 0; m < M; m++) {
	                    if (boards[h][n][m] == 0) {//토마토가 모두 익지 못하는 경우
	                        output.write("-1\n");
	                        output.flush();
	                        return;
	                    }
	                }
	            }
	        }
		  output.write(days + "\n");
	      output.flush();
	}
	
	private static int bfs(Queue<int[]>queue) {
		
		int maxDay=0;
		
		while(!queue.isEmpty()) {
			int[]t=queue.poll();
			int x=t[0];
			int y=t[1];
			int z=t[2];
			int day=t[3];
			maxDay=day;
			
			for(int i=0; i<6; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				int nz=z+dz[i];
				
				if(nx>=0&&ny>=0&&nz>=0&&nx<M&& ny<N&&nz<H&& boards[nz][ny][nx]==0) {
					boards[nz][ny][nx]=1;
					queue.add(new int[] {nx,ny,nz,day+1});
				}
				
			}
		}
		return maxDay;
	}
	

}

