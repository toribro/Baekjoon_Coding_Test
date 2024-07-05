import java.io.BufferedWriter;
import java.io.StreamTokenizer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args)throws IOException {
		StreamTokenizer st =new StreamTokenizer(System.in);
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		//long타입도 overflow발생
		//매우 큰정수를 담기위해 자바의 BigInteger 객체 이용
		BigInteger fn_1=BigInteger.ONE,fn_2=BigInteger.ZERO,fn=BigInteger.ZERO;
		st.nextToken();
		int n=(int)st.nval;
		if(n==1) {
			fn=BigInteger.ONE;
		}
		
		for(int i=2; i<=n ; i++) {
			fn=fn_1.add(fn_2);
			fn_2=fn_1;
			fn_1=fn;
		}//O(N)
		output.write(String.valueOf(fn));
		output.flush();
		output.close();
	
	}
}
