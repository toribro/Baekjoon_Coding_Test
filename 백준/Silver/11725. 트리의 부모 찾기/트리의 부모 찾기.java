import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	private static List<List<Integer>>graph =new ArrayList<>();
	private static boolean[] visited;
	
	//부모노드 저장배열
	private static int[] parents;

	public static void main(String[] args)throws IOException {
		StreamTokenizer st = new StreamTokenizer(System.in);
		BufferedWriter output= new BufferedWriter(new OutputStreamWriter(System.out));
		
		st.nextToken();
		int N = (int)st.nval;
		
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		visited=new boolean[N];
		parents=new int[N];
		
		for(int i=0; i<N-1; i++) {
			st.nextToken();
			int v=(int)st.nval;
			st.nextToken();
			int u=(int)st.nval;

			graph.get(u-1).add(v);
			graph.get(v-1).add(u);
		}
		bfs(0,N);
		
		//2번째 노드부터 부모노드 구하기
		for(int i=1; i<N; i++) {
			output.write(parents[i]+1+"");
			output.newLine();
		}
		output.flush();
		output.close();
		
	}
	private static void bfs(int node,int n) {
		Queue<Integer> queue =new LinkedList<>();
		
		queue.add(node);
		visited[node]=true;
	
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
	
			for(int neighbor:graph.get(current)) {
				if(!visited[neighbor-1]) {
					visited[neighbor-1]=true;
					parents[neighbor-1]=current;
					queue.add(neighbor-1);
				}
			}
		}
	}

}
