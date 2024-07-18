import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	private static int[][]word;
	private static boolean[][]visitied;
	private static int[]dx= {0,0,-1,1};
	private static int[]dy= {1,-1,0,0};
	private static int N,L,R;

	public static void main(String[] args)throws IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=null;
		
		st=new StringTokenizer(input.readLine());
		N=Integer.parseInt(st.nextToken());
	    L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		word=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(input.readLine());
			for(int k=0; k<N; k++) {
				word[i][k]=Integer.parseInt(st.nextToken());
			}
		}
		
		int days=0;
		while(true) {
			boolean moved=false;
			visitied=new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int k=0; k<N; k++) {
					if(!visitied[i][k]) {
						if(bfs(i,k)) {
							moved=true;
						}
					}
					
				}
			}
			if(!moved)break;
			days++;
		
		}
				
		output.write(days+"");
		output.flush();
		output.close();
		input.close();
	
		
	
	}
	private static boolean bfs(int startX, int startY) {
		
	
		Queue<int[]>queue=new LinkedList<>();
		Queue<int[]>union=new LinkedList<>();
		queue.add(new int[]{startX,startY});
		union.add(new int[]{startX,startY});
		visitied[startX][startY]=true;
		
		
		int unionPopulation=word[startX][startY];
		int unionCount=1;
		
		while(!queue.isEmpty()) {
			int[] t= queue.poll();
			int x=t[0];
			int y=t[1];
			
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				
				if(nx>=0&&ny>=0&&nx<N&&ny<N&&!visitied[nx][ny]) {
					
					int gap=Math.abs(word[x][y]-word[nx][ny]);
					if(L<=gap&&gap<=R) {
						visitied[nx][ny]=true;
						union.add(new int[]{nx,ny});
						queue.add(new int[]{nx,ny});
						unionPopulation+=word[nx][ny];
						unionCount++;
					}
					
					
				}
				
				
			}
			
		}
		
		 if(unionCount>1) {
			 int newPopulation=unionPopulation/unionCount;
			 while(!union.isEmpty()) {
				 int[]t=union.poll();
				 word[t[0]][t[1]]=newPopulation;
			 }
			 return true;
		 }
		
		return false;
	}

}
