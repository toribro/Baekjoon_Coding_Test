import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String nTemp=input.readLine();
		int N=Integer.parseInt(nTemp);
		
		int result=0;
		for(int i=0; i<N; i++) {
			int sum=0;
			
			int check=i;
			char[] value=String.valueOf(check).toCharArray();
			
			for(int k=0; k<value.length; k++) {
				sum+=Integer.parseInt(value[k]+"");
			}
			sum+=check;
			if(sum==N) {
				result=check;
				break;
			}
		}
	   output.write(String.valueOf(result));
	   output.flush();
	   output.close();
	
   }

}
