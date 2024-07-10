import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException {
		StreamTokenizer st =new StreamTokenizer(System.in);
		st.nextToken();
		int N =(int)st.nval;
		st.nextToken();
		int m =(int)st.nval;
		
		boolean[][] graph= new boolean[N][N];
		boolean[] visited=new boolean[N];
		
		for(int i=0; i<m; i++) {
			st.nextToken();
			int v=(int)st.nval;
			st.nextToken();
			int u=(int)st.nval;
			
			graph[v-1][u-1]=true;
			graph[u-1][v-1]=true;
			
		}
		
		int result=dfs(0,graph,visited);
		System.out.println(result);
		
	}
	private static int dfs(int node,boolean[][] graph,boolean[] visited) {
		visited[node]=true;
		int infectedCount=0;
		
		for(int i=0; i<graph.length; i++) {
			
			if(graph[node][i]&&!visited[i]) {
				infectedCount+=1+dfs(i,graph,visited);
			}
		}
		return infectedCount;
	}

}
