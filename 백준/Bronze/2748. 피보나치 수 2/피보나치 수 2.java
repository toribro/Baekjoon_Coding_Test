import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	private static long []check;
	
	public static void main(String[] args)throws IOException {
	    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(input.readLine());
		check=new long[N+1];
		System.out.println(fib_dp(N));

	}
	
	private static long fib_dp(int n) {
		if(n==1) {
			return 1;
		}
		if(n<=0) {
			return 0;
		}
		
		if(check[n]==0L) {
			check[n]=fib_dp(n-1)+fib_dp(n-2);
		}
		
		return check[n];
		
		
	}

}
