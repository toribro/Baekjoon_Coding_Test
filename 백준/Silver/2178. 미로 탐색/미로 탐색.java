import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	private static int[][] maze;
	private static boolean[][] visited;
	private static int[]dx= {0,0,-1,1};
	private static int[]dy= {1,-1,0,0};
	private static int N,M;

	public static void main(String[] args)throws IOException {
		
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output= new BufferedWriter(new OutputStreamWriter(System.out));
        
		StringTokenizer st =new StringTokenizer(input.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		
		maze=new int[N][M];
		visited=new boolean[N][M];
	
		for(int n=0; n<N; n++) {
			String inputNum=input.readLine();
			for(int m=0; m<M; m++) {
				maze[n][m]=inputNum.charAt(m)-48;
			}
			
		}
		
		int result=bfs(0,0);
		output.write(result+"\n");
		output.flush();
		
	}
	private static int bfs(int indexX,int intdexY) {
		
		Queue<int[]> queue =new LinkedList<>();
		queue.add(new int[]{indexX,intdexY});
		visited[indexX][intdexY]=true;
		
		while(!queue.isEmpty()) {
			int[]current=queue.poll();
			int x=current[0];
			int y=current[1];
			
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				   if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1 && !visited[nx][ny]) {
					queue.add(new int[]{nx,ny});
					visited[nx][ny]=true;
					maze[nx][ny]=maze[x][y]+1;
				}
				
			}
			
		}
		return maze[N-1][M-1];
		
	}

}
