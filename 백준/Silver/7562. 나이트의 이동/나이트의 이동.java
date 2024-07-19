import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	private static int[][] boards;
	private static boolean[][] visitied;
	private static int []dx= {-2,-1,1,2,-2,-1,1,2};
	private static int []dy= {1,2,2,1,-1,-2,-2,-1};
	private static int l;

	public static void main(String[] args)throws IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =null;
		
		st=new StringTokenizer(input.readLine());
		int N=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			
			st=new StringTokenizer(input.readLine());
			l=Integer.parseInt(st.nextToken());
			boards=new int[l][l];
			visitied=new boolean[l][l];
			st=new StringTokenizer(input.readLine());
			int[] start= {Integer.parseInt(st.nextToken()),
						   Integer.parseInt(st.nextToken())};
			st=new StringTokenizer(input.readLine());
			int[] end= {Integer.parseInt(st.nextToken()),
					       Integer.parseInt(st.nextToken())};
			
			
			int count=bfs(start,end);
			output.write(count+"\n");
		
		}
		output.flush();
		output.close();
		input.close();
		
	}
	private static int bfs(int[]start,int end[]) {
		
		Queue<int[]> queue =new LinkedList<>();
		queue.add(new int[]{start[0],start[1],0});
		visitied[start[0]][start[1]]=true;
	
		while(!queue.isEmpty()) {
			int[]t =queue.poll();
			int x=t[0];
			int y=t[1];
			int d=t[2];
			if(x==end[0]&&y==end[1]) {
				 return d;
			}
			
			for(int i=0; i<8; i++) {
				
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx>=0&&ny>=0&&nx<l&&ny<l&&!visitied[nx][ny]) {
					
					visitied[nx][ny]=true;
					queue.add(new int[]{nx,ny,d+1});
					
					 
				}
			}
			
		}
		
		return -1;
		
	}

}
