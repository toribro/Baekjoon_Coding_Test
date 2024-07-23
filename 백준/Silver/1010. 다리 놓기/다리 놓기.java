import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static long[][] check;
	
	public static void main(String[] args) throws IOException {
	   BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	   StringTokenizer st= null;
	   int T=Integer.parseInt(input.readLine());
	   
	 
	   int i=0;
	   while(i<T) {
		   st=new StringTokenizer(input.readLine());
		   int N =Integer.parseInt(st.nextToken());
		   int M=Integer.parseInt(st.nextToken());
		   check=new long[M+1][N+1];
		   output.write(combination(M,N)+"\n");
		   i++;
	   }
	   
	
	   output.flush();
	   output.close();
	   input.close();
	   
	}
	
	private static long combination(int N, int R) {
		
		if(R==N||R==0) {
			return 1;
		}
		
		if(check[N][R]==0) {
			return check[N][R]=combination(N-1,R-1)+combination(N-1,R);
		}
		
		return check[N][R];
		
	}

}
