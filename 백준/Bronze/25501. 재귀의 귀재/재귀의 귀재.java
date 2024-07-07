import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	private static int count=0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		int N =Integer.parseInt(input.readLine());
	
		StringBuilder words =new StringBuilder();
		for(int i=0; i<N; i++) {
			
			words.append(isPalindrome(input.readLine())).append(" ");
			words.append(count).append("\n");
			count=0;
		}
	
		output.write(words.toString());
		input.close();
		output.close();
		
	}
	
	private static int isPalindrome(String words) {
		return recursion(words,0,words.length()-1);
	}
	
	private static int recursion(String words,int l,int r) {
		count++;
		if(l>=r) {
			return 1;
		}else if(words.charAt(l)!=words.charAt(r)) return 0;
		else return recursion(words,l+1,r-1);
	}

}
