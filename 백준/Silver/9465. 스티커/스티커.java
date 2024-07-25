import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
	private static int[][]sticker;
	private static int[][]dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter write=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =null;
		
		
		int T=Integer.parseInt(read.readLine());
		
	
		while(T-->0) {
			int n=Integer.parseInt(read.readLine());
			sticker=new int[2][n];
			dp=new int[2][n];
			for(int i=0; i<2; i++) {
				st=new StringTokenizer(read.readLine());
				for(int k=0; k<n; k++) {
					sticker[i][k]=Integer.parseInt(st.nextToken());
				}
			}
			if (n == 1) {
                write.write(Math.max(sticker[0][0], sticker[1][0])+"\n");
                continue;
            }
			
			//초기값 설정이 매우 중요
			dp[0][0]=sticker[0][0];
			dp[1][0]=sticker[1][0];
			dp[0][1]=sticker[0][1]+dp[1][0];
			dp[1][1]=sticker[1][1]+dp[0][0];
			
			for(int i=2; i<n; i++) {
				dp[0][i]=sticker[0][i]+Math.max(dp[1][i-1], dp[1][i-2]);
				dp[1][i]=sticker[1][i]+Math.max(dp[0][i-1], dp[0][i-2]);
			}
			write.write(Math.max(dp[0][n-1], dp[1][n-1])+"\n");
		   
			
		}
		write.flush();
		write.close();
		read.close();
		
	}

}
