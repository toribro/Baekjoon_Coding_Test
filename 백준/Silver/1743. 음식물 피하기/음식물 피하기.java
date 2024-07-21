import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][]garbage;
	private static boolean[][]visitied;
	private static int[]dx= {0,0,1,-1};
	private static int[]dy= {1,-1,0,0};
	private static int M,N,K;

	public static void main(String[] args) throws IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =null;
		
		String inputs=input.readLine();
		st=new StringTokenizer(inputs);
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		garbage=new int[M][N];
		visitied=new boolean[M][N];
		
		
		int i=0;
		while(i<K) {
			st=new StringTokenizer(input.readLine());
			int m=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			garbage[m-1][n-1]=1;
			i++;
		}
		
		int count=0;
		int max=-1;
		for(int m=0; m<M; m++) {
			for(int n=0; n<N; n++) {
				if(garbage[m][n]==1&&!visitied[m][n]) {
					count=bfs(m,n);
					if(max<count) {
						max=count;
					}
				}
			
			}
		}
		output.write(max+" ");
		output.flush();
		output.close();
		
		

	}
	private static int bfs(int indexX,int indexY) {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {indexX,indexY});
		visitied[indexX][indexY]=true;
		
		int count=0;
		while(!queue.isEmpty()) {
			int []t=queue.poll();
			int x=t[0];
			int y=t[1];
			count++;
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx>=0&&ny>=0&&nx<M&&ny<N&&!visitied[nx][ny]&&garbage[nx][ny]==1) {
					visitied[nx][ny]=true;
					queue.add(new int[]{nx,ny});
					
				}
				
			}
		
		}
		
		
		return count;
		
	}

}
