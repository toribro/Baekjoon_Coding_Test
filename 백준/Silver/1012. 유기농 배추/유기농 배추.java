import java.io.StreamTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	
	 private static int[] dx= {0,0,1,-1};
	 private static int[] dy= {1,-1,0,0};
	 
	 private static boolean[][] graph;
	 private static boolean[][] visited;
	 private static int M,N,K;

	public static void main(String[] args)throws IOException {
	   StreamTokenizer st =new StreamTokenizer(System.in);
	   BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
	   st.nextToken();
	   int T=(int)st.nval;
	   
	   for(int t=0; t<T; t++) {
		   
		   st.nextToken();
		   M=(int)st.nval;
		   st.nextToken();
		   N=(int)st.nval;
		   st.nextToken();
		   K=(int)st.nval;
		 
		   graph=new boolean[N][M];
		   visited=new boolean[N][M];

		   for(int k=0; k<K; k++) {
			   
			   st.nextToken();
			   int v=(int)st.nval;
			   st.nextToken();
			   int u=(int)st.nval;
			   graph[u][v]=true;
		  }
		   
		   int wormCount=0;
		   for(int i=0; i<N; i++) {
			  for(int j=0; j<M; j++) {
				  if(graph[i][j] && !visited[i][j]) {
					  dfs(i,j);
					  wormCount++;
				  }
			  }
		   }
		   
		   output.write(wormCount+"");
		   output.newLine();
		   
	   }
	   
	   output.flush();
	   output.close();
	   
	}
	private static void dfs(int x,int y) {
		visited[x][y]=true;
		for(int i=0; i<4; i++){
			
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx>=0&&ny>=0&&nx<N&&ny<M) {
				if(graph[nx][ny]&&!visited[nx][ny]) {
					dfs(nx,ny);	
				}
			}
		}
		
	}

}
