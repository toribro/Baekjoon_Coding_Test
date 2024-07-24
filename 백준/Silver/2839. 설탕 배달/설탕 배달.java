import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
	

	public static void main(String[] args)throws IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =null;
		
		st=new StringTokenizer(input.readLine());
		int N=Integer.parseInt(st.nextToken());
		
		output.write(grid(N)+"");
		output.flush();
		output.close();
		input.close();
		

	}
	private static int grid(int n) {
		//큰봉지를 최대한 많이 사용
		int remain=0;
		for(int i=n/5; i>=0; i--) {
			remain=n-(5*i);
			
			if(remain%3==0) {
				return i+(remain/3);
			}
			
		}
		return -1;
	}

}
