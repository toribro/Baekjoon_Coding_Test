import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
public class Main {
	private static StringBuilder words = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=-1;
		int length=0;
		String input="";
		while((input=br.readLine())!=null && !input.isEmpty() ) {//EOF 처리
		
			N=Integer.parseInt(input);
			length=(int)Math.pow(3,N);
			for(int i=0; i<length; i++)
				words.append("-");
			divided(0,length);
			output.write(words.toString());
			output.newLine();
			words.setLength(0);

		}
		output.flush();
		output.close();
	}
	
	 private static void divided(int start,int end) {
		
		if(end==1) {
			return;
		}
		for(int i=start+(end/3); i<start+(end/3)*2; i++) {
			words.setCharAt(i,' ');
		}
		divided(start,end/3);
		divided(start+(end/3)*2,end/3);
		
	}
}
