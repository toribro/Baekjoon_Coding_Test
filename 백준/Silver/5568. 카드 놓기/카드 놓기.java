import java.io.StreamTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	static int N,k=0;
	static boolean[] visited;
	static int[] cards;
	static ArrayList<String>list;
	
	public static void main(String[] args)throws IOException {
		StreamTokenizer st= new StreamTokenizer(System.in);

		st.nextToken();
		N=(int)st.nval;
		st.nextToken();
		k=(int)st.nval;
		cards=new int[N];
		visited=new boolean[N];
		list=new ArrayList<>();
		
	
		int length=cards.length;
		for(int i=0; i<length; i++) {
			st.nextToken();
			cards[i]=(int)st.nval;
		}
		
		dfs(0,"");
		System.out.println(list.size());
		
	}
	
	private static void dfs(int count,String temp) {
		
		if(count==k) {
			if(!list.contains(temp)) {
				list.add(temp);
			}
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(count+1,temp+(String.valueOf(cards[i])));
				visited[i]=false;
			}
		}
	}

}
