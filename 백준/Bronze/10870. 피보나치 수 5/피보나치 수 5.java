import java.io.BufferedWriter;
import java.io.StreamTokenizer;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException {
		StreamTokenizer st =new StreamTokenizer(System.in);
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		int fn_1,fn_2,fn=0;
		
		st.nextToken();
		int n=(int)st.nval;
		if(n==1) {
			fn=1;
		}
		
		fn_2=0;
		fn_1=1;
		for(int i=2; i<=n ; i++) {
			fn=fn_1+fn_2;
			fn_2=fn_1;
			fn_1=fn;
		}
		output.write(String.valueOf(fn));
		output.flush();
		output.close();
	}

}
