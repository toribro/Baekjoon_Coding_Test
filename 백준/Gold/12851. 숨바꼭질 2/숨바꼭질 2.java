import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int MAX=100000;
	private static int times[]=new int[MAX + 1];
	private static int ways[]= new int[MAX + 1];
   
   public static void main(String[]args)throws IOException {
	   BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
	   StringTokenizer st =null;
	   st=new StringTokenizer(input.readLine());
	   int N=Integer.parseInt(st.nextToken());
	   int K=Integer.parseInt(st.nextToken());
	   
	   if(N==K) {
		   output.write(0+"\n");
		   output.write(1+"");
		   output.flush();
		   output.close();
		   return;
	   }
	   bfs(N);
	   output.write(times[K]+"\n");
	   output.write(ways[K]+"");
	   output.flush();
	   output.close();
   }
   
   private static void bfs(int start) {
	   Queue<Integer> queue =new LinkedList<>();
	   queue.add(start);
	   times[start]=0;
	   ways[start]=1;
	   
	   
	   while(!queue.isEmpty()) {
		   int current=queue.poll();
		   int[] nextPostion= {current-1,current+1,current*2};
		   
		   for(int next:nextPostion) {
			   if(next<0||next>MAX)continue;
			   
			   if(times[next]==0 && next!=start) {//처음방문할때
				   queue.add(next);
				   times[next]=times[current]+1;
				   ways[next]=ways[current];
			   }
			   else if(times[next]==times[current]+1) {//최단시간으로 도달하는 또다른 방법
				   ways[next]+=ways[current];
			   }
		   }
	   }
	   
   }
}
