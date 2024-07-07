import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	private static int count=0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		int N =Integer.parseInt(input.readLine());
		
		String[] words= new String[N];
		for(int i=0; i<N; i++) {
			words[i]=input.readLine();
		}
		
		for(int i=0; i<N; i++) {
			output.write(isPalindrome(words[i].toCharArray())+" ");
			output.write(String.valueOf(count));
			output.newLine();
			output.flush();
			count=0;
		}
		input.close();
		output.close();
	}
	
	private static int isPalindrome(char[]words) {
		return recursion(words,0,words.length-1);
	}
	
	private static int recursion(char[] words,int l,int r) {
		count++;
		if(l>=r) {
			return 1;
		}else if(words[l]!=words[r]) return 0;
		else return recursion(words,l+1,r-1);
	}
}
