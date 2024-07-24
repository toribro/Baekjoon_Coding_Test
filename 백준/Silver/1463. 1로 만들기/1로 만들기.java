import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
	private static int[]dp;

	public static void main(String[] args)throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		dp=new int[n+1];
		System.out.println(grid(n));
		
	}
	private static int grid(int n) {
		
		for(int i=2; i<=n; i++) {
			//dp[1]은 1이므로 연산이 필요없으므로 dp[1]==0 ,dp[2]부터 계산
			dp[i]=dp[i-1]+1;
			
			if(i%2==0) {
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			}
			if(i%3==0) {
				dp[i]=Math.min(dp[i], dp[i/3]+1);
			}
		}
		return dp[n];
	}

}
