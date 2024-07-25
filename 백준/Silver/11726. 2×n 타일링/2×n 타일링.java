import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
	private static int[]dp;
	private static final int MOD=10007;


	public static void main(String[] args)throws IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(input.readLine());
		dp=new int[N+1];
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		System.out.println(num(N));
		


	}
	private static int num(int n) {
		if(n==2) {
			return 2;
		}
		dp[1]=1;
		dp[2]=2;
		for(int i=3; i<=n; i++) {
			dp[i]=(dp[i-1]+dp[i-2])%MOD;
		}
		return dp[n];
	}

}
