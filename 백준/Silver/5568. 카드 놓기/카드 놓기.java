import java.io.StreamTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
	static int N,k=0;
	static boolean[] visited;
	static String[] cards;
	static HashSet<String>list;

	public static void main(String[] args)throws IOException {
		StreamTokenizer st= new StreamTokenizer(System.in);
		st.nextToken();
		N=(int)st.nval;
		st.nextToken();
		k=(int)st.nval;
		cards=new String[N];
		visited=new boolean[N];
		list=new HashSet<>();
		int length=cards.length;
		for(int i=0; i<length; i++) {
			st.nextToken();
			cards[i]=(int)st.nval+"";
		}
		
		dfs(0,"");
		System.out.println(list.size());
		
	}
	
	private static void dfs(int count,String temp) {
		
		if(count==k) {
			list.add(temp);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(count+1,temp+(cards[i]));
				visited[i]=false;
			}
		}
	}

}
